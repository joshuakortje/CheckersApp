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
        
        // Check if the destination square is valid
        if(validateMoveDest(acCurrMove))
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
     * It checks for a piece being at the square already as well as that the 
     * piece would be moving in a legal manner (diagonally).
     * 
     * @param acCurrMove the move to be validated
     * 
     * @return true if the move is valid
     */
    private boolean validateMoveDest(Move acCurrMove)
    {
        boolean isValidSquare;
        
        // Get the rows/columns associated with the Move
        int lnStartRow = acCurrMove.getStartRow();
        int lnStartCol = acCurrMove.getStartCol();
        int lnDestRow = acCurrMove.getDestRow();
        int lnDestCol = acCurrMove.getDestCol();
        
        // Check if the destination square is occupied
        if(getLocalPieceColor(lnDestRow, lnDestCol) != null)
        {
            isValidSquare = false;
        }
        else
        {
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
                lnStartRow = transformPerspective(lnStartRow);
                lnStartCol = transformPerspective(lnStartCol);
                lnDestRow = transformPerspective(lnDestRow);
                lnDestCol = transformPerspective(lnDestCol);
                
                // Use the black board
                laacBoard = maacSquaresBlack;
            }
            
            // Validate the Move
            isValidSquare = validateMove(lnStartRow, lnStartCol, lnDestRow, lnDestCol, laacBoard);
        }
        
        // Return the result
        return isValidSquare;
    }
    
    /**
     * This function will check if the squares indicate a valid move for the board
     * from White's perspective. Moves for black must be transformed to White's
     * perspective before using this function.
     * The only valid moves are those that are moving diagonally by one or jumping over
     * other pieces.
     * 
     * @param anStartRow the starting row
     * @param anStartCol the starting column
     * @param anDestRow the destination row
     * @param anDestCol the destination column
     * @param aaacBoard the board to be used. This board will be from the perspective
     *                  of the player whose turn it is
     * 
     * @return true if the move is valid
     */
    private boolean validateMove(int anStartRow, int anStartCol, int anDestRow, int anDestCol, Square[][] aaacBoard)
    {
        boolean isValid = false;
        
        if(isBasicMove(anStartRow, anStartCol, anDestRow, anDestCol, 1))
        {
            isValid = true;
        }
        else
        {
            // check if the move is a jumping move. If it is, this function will
            // return the locations of the jumped pieces. If not the arraylist
            // will be empty
            ArrayList<ArrayList<Integer>> laanJumpedPieces = checkJumpMove(anStartRow, anStartCol, anDestRow, anDestCol);
            
            // TODO: Need to actually return the jumped pieces list up the 
            // call stack or remove the jumped pieces now
            if(!laanJumpedPieces.isEmpty())
            {
                isValid = true;
            }
        }
        
        return isValid;
    }
    
    private ArrayList<ArrayList<Integer>> checkJumpMove(int anStartRow, int anStartCol, int  anDestRow, int anDestCol)
    {
        ArrayList<ArrayList<Integer>> laanJumpedPieces = new ArrayList<>();
        
        // Check if the diagonal distance is right
        if(isBasicMove(anStartRow, anStartCol, anDestRow, anDestCol, 2))
        {
            // Get the coordinates of the row and column between the start and 
            // destination
            int anMidRow = anStartRow + 1;
            int anMidCol = anStartCol + (anDestCol - anStartCol)/2; // Accounts for the direction of the move.
            
            //TODO: check for a piece and the midpoint
            //temp code to always pass
            laanJumpedPieces.add(new ArrayList<>(Arrays.asList(anMidRow, anMidCol)));
        }
        return laanJumpedPieces;
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
        maacSquaresWhite[anCurrMove.getStartRow()][anCurrMove.getStartCol()].setPiece(null);
        
        // Place the piece on the destination location
        maacSquaresWhite[anCurrMove.getDestRow()][anCurrMove.getDestCol()].setPiece(anCurrMove.getPlayerColor());
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
