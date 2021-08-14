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
 * Removed dispayBoard (put in Board Controller)
 * Added BOARD_WIDTH constant
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
     * 
     * @param anStartingRow the index of the starting row
     * @param anStartingCol the index of the starting column
     * @param anEndingRow the index of the ending row
     * @param anEndingCol  the index of the ending column
     */
    public void movePlayed(int anStartingRow, int anStartingCol, int anEndingRow, int anEndingCol)
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
           if(lcSquare.getPieceColor() == Color.eeWHITE)
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
}
