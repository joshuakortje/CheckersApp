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
     * @return true if the move was successful
     */
    public boolean movePlayed(Move acCurrMove)
    {
        System.out.println("A button was pressed...");
        return true;
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
