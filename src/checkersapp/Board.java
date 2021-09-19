package checkersapp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the checkers board and handles the main board mechanics. 
 * 
 * @author Joshua Kortje
 * @date 12/17/19
 * 
 * Edits:
 * Initial version          12/17/19
 * 
 * 12/16/20 Switch to checkers, added displayBoard, and
 * added movePlayed stub
 * 
 * 8/14/21 Added getDisplayText, Removed dispayBoard (put in Board Controller),
 * Added initializeSquares, and added BOARD_WIDTH constant,
 * 
 * 8/20/21 Change getDisplayText to getLocalPieceColor
 * 
 * 8/22/21 Renamed movePlayed to attemptMove, added validation of the destination
 * for basic moves (non-jumping)
 * 
 * 9/11/21 Added class variable to keep track of jumped pieces. Implemented logic
 * to make sure a piece of the correct color was being jumped and to remove jumped
 * pieces.
 * 
 * 9/19/21 Adapted to handle arrays of rows and columns for multi-jump moves. 
 * Added the transformPerspective function for ArrayLists.
 */
public class Board {
    
    /**
     * Constant for the width and height of the board
     */
    public static final int BOARD_WIDTH = 8;
    
    /**
     * An array of squares to represent the board from white's perspective.
     * This array will contain references to the same square objects as the 
     * black squares array so that operations only have to be done on one array.
     */
    private Square[][] maacSquaresWhite;
    
    /**
     * An array of squares to represent the board from black's perspective.
     * This array will contain references to the same square objects as the 
     * white squares array so that operations only have to be done on one array.
     */
    private Square[][] maacSquaresBlack;
    
    /**
     * A list of coordinates with pieces that will need to be removed should the 
     * current move be played.
     */
    private ArrayList<ArrayList<Integer>> maanJumpedPieces;
    
    /**
     * Constructor for the board class
     */
    public Board()
    {
        // Initialize the square arrays
        maacSquaresWhite = new Square[BOARD_WIDTH][BOARD_WIDTH];
        maacSquaresBlack = new Square[BOARD_WIDTH][BOARD_WIDTH];
        
        initializeSquares();
    }
    
    /**
     * 
     * @param acCurrMove the move being played
     * 
     * @return true if the move was successful
     */
    public boolean attemptMove(Move acCurrMove)
    {
        boolean lbMoveExecuted = false;
        
        // Check if the move is valid
        if(validateMove(acCurrMove))
        {
            // If it is valid, play the move
            executeMove(acCurrMove);
            lbMoveExecuted = true;
        }
        else
        {
            System.out.println("Invalid Move");
        }
        
        return lbMoveExecuted;
    }
    
    /**
     * This subroutine checks if the destination square for the move is legal.
     * It checks for that the piece would be moving in a legal manner (diagonally).
     * 
     * @param acCurrMove the move to be validated
     * 
     * @return true if the move is valid
     */
    private boolean validateMove(Move acCurrMove)
    {
        boolean lbIsValidSquare;
        
        // Get the rows/columns associated with the Move
        ArrayList<Integer> lanRows = acCurrMove.getRows();
        ArrayList<Integer> lanCols = acCurrMove.getCols();
        
        // Assume White's turn
        Square[][] laacBoard = maacSquaresWhite;

        // The math for checking valid moves is different for white 
        // and black so check the player's color and if it is Black
        // transform to White's perspective
        if(acCurrMove.getPlayerColor() == CheckersColor.eeBLACK)
        {
            // Techniqually transforming the columns is not necessary 
            // because the math to check the validity of the move will
            // be the same but I still do it to avoid confusion
            lanRows = transformPerspective(lanRows);
            lanCols = transformPerspective(lanCols);

            // Use the black board
            laacBoard = maacSquaresBlack;
        }

        // Validate the Move
        lbIsValidSquare = validateMovePattern(lanRows, lanCols, laacBoard);
        
        // Return the result
        return lbIsValidSquare;
    }
    
    /**
     * This function will check if the squares indicate a valid move for the board
     * from White's perspective. Moves for black must be transformed to White's
     * perspective before using this function.
     * The only valid moves are those that are moving diagonally by one or jumping over
     * other pieces.
     * 
     * @param aanRows the rows in the move from start to destination
     * @param aanCols the columns in the move from start to destination
     * @param aaacBoard the board to be used. This board will be from the perspective
     *                  of the player whose turn it is
     * 
     * @return true if the move is valid
     */
    private boolean validateMovePattern(ArrayList<Integer> aanRows, ArrayList<Integer> aanCols, Square[][] aaacBoard)
    {
        boolean lbValid = false;
        
        // TODO: Need to handle the list implementation of squares to account
        // for multi-jumps
        if(isBasicMove(aanRows.get(0), aanCols.get(0), aanRows.get(1), aanCols.get(1), 1))
        {
            lbValid = true;
        }
        else
        {
            // check if the move is a jumping move. If it is, this function will
            // return the locations of the jumped pieces. If not the arraylist
            // will be empty
            lbValid = checkJumpMove(aanRows.get(0), aanCols.get(0), aanRows.get(1), aanCols.get(1), aaacBoard);
        }
        
        return lbValid;
    }
    
    /**
     * This function will check if the move is a valid move jumping over pieces.
     * Any pieces found will be added to the ArrayList of Squares with pieces that
     * have been jumped so they can be removed from the board in the execution 
     * phase of the move.
     * 
     * @param anStartRow the starting row
     * @param anStartCol the starting column
     * @param anDestRow the destination row
     * @param anDestCol the destination column
     * @param aaacBoard the board to be used from the current player's perspective
     * 
     * @return true if the move is valid
     */
    private boolean checkJumpMove(int anStartRow, int anStartCol, int  anDestRow, int anDestCol, Square[][] aaacBoard)
    {
        boolean lbValid = false;
        
        // Reset the Jumped Pieces array
        maanJumpedPieces = new ArrayList<>();
        
        // Check if the diagonal distance is right
        if(isBasicMove(anStartRow, anStartCol, anDestRow, anDestCol, 2))
        {
            // Get the coordinates of the row and column between the start and 
            // destination
            int lnMidRow = anStartRow + 1;
            int lnMidCol = anStartCol + (anDestCol - anStartCol)/2; // Accounts for the direction of the move.
            
            // Get the color of the piece being jumped over
            CheckersColor leMidColor = aaacBoard[lnMidRow][lnMidCol].getPieceColor();
            
            // Make sure there is a piece and that it is of a different color
            if(leMidColor != null && leMidColor != aaacBoard[anStartRow][anStartCol].getPieceColor())
            {
                maanJumpedPieces.add(new ArrayList<>(Arrays.asList(lnMidRow, lnMidCol)));
                lbValid = true;
            }
        }
        return lbValid;
    }
    
    /**
     * This function will check if the squares indicate a diagonal move has been 
     * taken. This function does not check for pieces in the way or jumped over.
     * 
     * @param anStartRow the starting row
     * @param anStartCol the starting column
     * @param anDestRow the destination row
     * @param anDestCol the destination column
     * @param anStep the number of steps taken
     * 
     * @return true if the move is a basic diagonal move
     */
    private boolean isBasicMove(int anStartRow, int anStartCol, int anDestRow, int anDestCol, int anStep)
    {
        boolean isValid = true;
        
        // The piece must be moving forward by anstep row(s)
        if(anDestRow != (anStartRow + anStep))
        {
            isValid = false;
        }
        
        // The piece must be moving to an adjacent column (+-anstep)
        if(Math.abs(anDestCol - anStartCol) != anStep)
        {
            isValid = false;
        }
        
        return isValid;
    }
    
    /**
     * This function will transform a list of rows or columns from White's point
     * of view to Blacks or vice versa.
     * 
     * @param aanRowOrCol a list of rows or columns to transform
     * 
     * @return the transformed list
     */
    private ArrayList<Integer> transformPerspective(ArrayList<Integer> aanRowOrCol)
    {
        ArrayList<Integer> lanTransformedRowOrCol = new ArrayList<>();
        
        // Loop through each number and transform it
        for(Integer lnRowOrCol : aanRowOrCol)
        {
            lanTransformedRowOrCol.add(transformPerspective(lnRowOrCol));
        }
        
        return lanTransformedRowOrCol;
    }
    
    /**
     * This function will transform a row or column number from White's point of
     * view to Black's or vice versa. 
     * 
     * @param anRowOrCol the row or column to be transformed
     * 
     * @return the transformed row or column
     */
    private int transformPerspective(int anRowOrCol)
    {
        return Math.abs(anRowOrCol - BOARD_WIDTH + 1);
    }
    
    /**
     * This function will actually perform the move. The function assumes that 
     * the move has already been verified as playable. It will move the piece on
     * the board, remove any captured pieces, and promote any piece that has 
     * reached the end of the board. This method will play the move on the white
     * board and the black board will automatically get the update because it
     * uses references to the same objects
     * 
     * @param anCurrMove the move to play
     */
    private void executeMove(Move anCurrMove)
    {
        // Remove the piece from the start square
        int lnStartRow = anCurrMove.getRows().get(0);
        int lnStartCol = anCurrMove.getCols().get(0);
        maacSquaresWhite[lnStartRow][lnStartCol].setPiece(null);
        
        // Place the piece on the destination location
        int lnDestRow = anCurrMove.getRows().get(anCurrMove.getRows().size() - 1);
        int lnDestCol = anCurrMove.getCols().get(anCurrMove.getCols().size() - 1);
        maacSquaresWhite[lnDestRow][lnDestCol].setPiece(anCurrMove.getPlayerColor());
        
        // Only if we have pieces to remove
        if(maanJumpedPieces != null)
        {
            Square[][] laacBoard;

            // Choose the correct board
            if(anCurrMove.getPlayerColor() == CheckersColor.eeWHITE)
            {
                laacBoard = maacSquaresWhite;
            }
            else
            {
                laacBoard = maacSquaresBlack;
            }

            // Remove any jumped pieces

            for(ArrayList<Integer> lanJumpedPieceLoc : maanJumpedPieces)
            {
                //  The format of the location is always (row, col)
                laacBoard[lanJumpedPieceLoc.get(0)][lanJumpedPieceLoc.get(1)].setPiece(null);
            }

            // Set the jumped pieces array to be null (clean slate for next move)
            maanJumpedPieces = null;
        }
    }
    
    /**
    * This method returns the color to display on the square denoted by the
    * given row and column based on if there 
    * is a white piece, black piece, or no piece on it. This method only uses
    * the white perspective board.
    * 
    * @param anRow the row of the square
    * @param anCol the column of the square
    * 
    * @return the color of the piece if there is one, null if not
    */
   public CheckersColor getLocalPieceColor(int anRow, int anCol)
   {
       CheckersColor leColor = null; //default value if no piece is found
       Square lcSquare = maacSquaresWhite[anRow][anCol];
       
       if(lcSquare.hasPiece())
       {
           // Display W or B depending on the piece color
           if(lcSquare.getPieceColor() == CheckersColor.eeWHITE)
           {
               leColor = CheckersColor.eeWHITE;
           }
           else
           {
               leColor = CheckersColor.eeBLACK;
           }
       }
       return leColor;
   }
   
   /**
    * This function initializes the squares to the starting state of the game
    */
   private void initializeSquares()
   {
       for(int lnRow = 0; lnRow < BOARD_WIDTH; lnRow++)
        {
            for(int lnCol = 0; lnCol < BOARD_WIDTH; lnCol++)
            {
                // Initialize all squares
                CheckersColor leSquareColor = CheckersColor.eeWHITE;
                CheckersColor lePieceColor = null;
                boolean lbPiecePresent = false;
                if((lnRow + lnCol) % 2 == 0)
                {
                    //Change the color if the sum of the row and column is even
                    leSquareColor = CheckersColor.eeBLACK;
                    
                    //Black squares have the pieces so check if there is a 
                    //piece on the square (based on the row)
                    if(lnRow < 3) // White rows
                    {
                        lePieceColor = CheckersColor.eeWHITE;
                        lbPiecePresent = true;
                    }
                    else if(lnRow > 4) // Black rows
                    {
                        lePieceColor = CheckersColor.eeBLACK;
                        lbPiecePresent = true;
                    }
                }
                
                // Set the square color, row, col, and piece info
                maacSquaresWhite[lnRow][lnCol] = new Square(lbPiecePresent, lePieceColor, leSquareColor, lnRow, lnCol);
                
                // Give the black square array the same square.
                // This assignment needs to give this array a reference to the 
                // same square object
                maacSquaresBlack[transformPerspective(lnRow)][transformPerspective(lnCol)] = maacSquaresWhite[lnRow][lnCol];
            }
        }
   }
}
