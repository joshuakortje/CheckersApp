package checkersapp;

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
     * An array of squares to represent the board
     */
    private Square[][] maacSquares;
    
    /**
     * Constructor for the board class
     */
    public Board()
    {
        // Initialize the square array
        maacSquares = new Square[BOARD_WIDTH][BOARD_WIDTH];
        
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
            }
            
            // Validate the Move
            isValidSquare = validateMove(lnStartRow, lnStartCol, lnDestRow, lnDestCol);
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
     * 
     * @return true if the move is valid
     */
    private boolean validateMove(int anStartRow, int anStartCol,int  anDestRow, int anDestCol)
    {
        boolean isValid = true;
        
        // The piece must be moving forward by 1 row
        if(anDestRow != (anStartRow + 1))
        {
            isValid = false;
        }
        
        // The piece must be moving to an adjacent column (+-1)
        if(Math.abs(anDestCol - anStartCol) != 1)
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
     * reached the end of the board.
     * 
     * @param anCurrMove the move to play
     */
    private void executeMove(Move anCurrMove)
    {
        // Remove the piece from the start square
        maacSquares[anCurrMove.getStartRow()][anCurrMove.getStartCol()].setPiece(null);
        
        // Place the piece on the destination location
        maacSquares[anCurrMove.getDestRow()][anCurrMove.getDestCol()].setPiece(anCurrMove.getPlayerColor());
    }
    
    /**
    * This method returns the color to display on the square denoted by the
    * given row and column based on if there 
    * is a white piece, black piece, or no piece on it.
    * 
    * @param anRow the row of the square
    * @param anCol the column of the square
    * 
    * @return the color of the piece if there is one, null if not
    */
   public CheckersColor getLocalPieceColor(int anRow, int anCol)
   {
       CheckersColor leColor = null; //default value if no piece is found
       Square lcSquare = maacSquares[anRow][anCol];
       
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
                maacSquares[lnRow][lnCol] = new Square(lbPiecePresent, lePieceColor, leSquareColor, lnRow, lnCol);
            }
        }
   }
}
