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
 * Switch to checkers,      12/16/20
 * Added displayBoard,
 * Added movePlayed stub
 * 
 * Added getDisplayText    8/14/21
 * Removed dispayBoard (put in Board Controller),
 * Added initializeSquares,
 * Added BOARD_WIDTH constant,
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
     */
    public void movePlayed(Move acCurrMove)
    {
        System.out.println("A button was pressed...");
    }
    
    /**
    * This method returns the text to display on the square denoted by the
    * given row and column based on if there 
    * is a white piece, black piece, or no piece on it.
    * 
    * @param anRow the row of the square
    * @param anCol the column of the square
    * 
    * @return the text to display on the square
    */
   public String getDisplayText(int anRow, int anCol)
   {
       String lsText = "";
       Square lcSquare = maacSquares[anRow][anCol];
       
       if(!lcSquare.hasPiece())
       {
           // Return nothing if the square has no piece
           lsText = "";
       }
       else
       {
           // Display W or B depending on the piece color
           if(lcSquare.getPieceColor() == CheckersColor.eeWHITE)
           {
               lsText = "W";
           }
           else
           {
               lsText = "B";
           }
       }
       return lsText;
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
