package checkersapp;

/**
 * This enum defines the color of the square. 
 * 
 * @author Joshua Kortje
 * @date 12/17/19
 * 
 * Edits:
 * Initial version          12/17/19
 */
enum Color
{
    eeWHITE, eeBLACK;
}

/**
 * This class represents a single square of the checkers board and information about
 * where on the board it is and what piece is currently on it. 
 * 
 * @author Joshua Kortje
 * @date 12/17/19
 * 
 * Edits:
 * Initial version          12/17/19
 * 
 * Switch to checkers,      12/16/20
 * Added getDisplayText
 * 
 * Removed getDisplayText,   8/14/21
 * put in Board class
 */
public class Square {
    
    /**
     * A boolean indicating if there is a piece on the square.
     */
    private boolean mbHasPiece;
    
    /**
     * The Color of the piece (white or black)
     */
    private Color mePieceColor;
    
    /**
     * The Color of the square (white or black)
     */
    private Color meSquareColor;
    
    /**
     * The row of the square on the board from White's perspective (0-7).
     */
    private int mnRow;
    
    /**
     * The column of the square on the board from White's perspective (0-7).
     */
    private int mnCol;
    
    /**
     * Constructor for the square class.
     * 
     * @param abOccupied true if the square has a piece on it
     * @param aePieceColor the piece on the square (null if empty)
     * @param aeSquareColor the color of the square
     * @param anRow the row of the square
     * @param anCol the column of the square
     */
    public Square(boolean abOccupied, Color aePieceColor, Color aeSquareColor, int anRow, int anCol)
    {
        mbHasPiece = abOccupied;
        mePieceColor = aePieceColor;
        meSquareColor = aeSquareColor;
        mnRow = anRow;
        mnCol = anCol;
    }
    
    /**
     * This method will change the status of the piece currently on the square.
     * 
     * @param acNewResident the new piece on the square (null if empty square)
     */
    public void setPiece(Color aeNewPieceColor)
    {
        mePieceColor = aeNewPieceColor;
        
        // Determine if we just put a piece here or removed one
        if(mePieceColor == null)
        {
            mbHasPiece = false;
        }
        else
        {
            mbHasPiece = true;
        }
    }
    
    /**
     * This method returns true if there is a piece on the square
     * 
     * @return true if there is a piece on the square
     */
    public boolean hasPiece()
    {
        return mbHasPiece;
    }
    
    /**
     * This method returns the color of the piece currently on the square.
     * 
     * @return the color of the piece currently on the square. null if no piece 
     */
    public Color getPieceColor()
    {
        return mePieceColor;
    }
    
    /**
     * This method returns the color of the square as an enum.
     * 
     * @return an enum representing the color of the square (eeWHITE or eeBLACK)
     */
    public Color getSquareColor()
    {
        return meSquareColor;
    }
    
    /**
     * This method returns the row of the square.
     * 
     * @return the row of the square on the board from White's perspective
     */
   public int getRow()
   {
       return mnRow;
   }
   
   /**
    * This method returns the column of the square.
    * 
    * @return the column of the square on the board from White's perspective
    */
   public int getCol()
   {
       return mnCol;
   }
}
