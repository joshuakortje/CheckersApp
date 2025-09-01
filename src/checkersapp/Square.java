package checkersapp;

/**
 * This enum defines the color of the square. 
 * 
 * @author Joshua Kortje
 * @date 12/17/19
 * 
 * Edits:
 * Initial version          12/17/19
 * 
 * 10/22/21 Added tracking if a king is on the square.
 * 
 * 9/1/25 Added ability to return display name
 */
enum CheckersColor {
    eeWHITE("White"),
    eeBLACK("Black");

    private final String displayName;

    // Constructor
    private CheckersColor(String displayName) {
        this.displayName = displayName;
    }

    /**
     * This function returns the String name of the color.
     * 
     * @return String name of the color
     */
    public String getDisplayName() {
        return displayName;
    }
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
     * A boolean indicating if the piece on the square is a king. It is up to
     * the user of the class to set this variable to true when a king is moved 
     * here. It is set to false automatically when a piece is removed.
     */
    private boolean mbHasKing;
    
    /**
     * The Color of the piece (white or black)
     */
    private CheckersColor mePieceColor;
    
    /**
     * The Color of the square (white or black)
     */
    private final CheckersColor meSquareColor;
    
    /**
     * The row of the square on the board from White's perspective (0-7).
     */
    private final int mnRow;
    
    /**
     * The column of the square on the board from White's perspective (0-7).
     */
    private final int mnCol;
    
    /**
     * Constructor for the square class.
     * 
     * @param abOccupied true if the square has a piece on it
     * @param aePieceColor the piece on the square (null if empty)
     * @param aeSquareColor the color of the square
     * @param anRow the row of the square
     * @param anCol the column of the square
     */
    public Square(boolean abOccupied, CheckersColor aePieceColor, CheckersColor aeSquareColor, int anRow, int anCol)
    {
        mbHasPiece = abOccupied;
        mePieceColor = aePieceColor;
        meSquareColor = aeSquareColor;
        mnRow = anRow;
        mnCol = anCol;
        mbHasKing = false;
    }
    
    /**
     * This method will change the status of the piece currently on the square.
     * 
     * @param aeNewPieceColor the new piece on the square (null if empty square)
     */
    public void setPiece(CheckersColor aeNewPieceColor)
    {
        mePieceColor = aeNewPieceColor;
        
        // Determine if we just put a piece here or removed one
        if(mePieceColor == null)
        {
            mbHasPiece = false;
            setKing(false); // If there is no piece there can't be a king
        }
        else
        {
            mbHasPiece = true;
        }
    }
    
    public void setKing(boolean abIsKing)
    {
        mbHasKing = abIsKing;
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
     * This method returns true if the piece here is a king
     * 
     * @return true if there is a king on the square
     */
    public boolean hasKing()
    {
        return mbHasKing;
    }
    
    /**
     * This method returns the color of the piece currently on the square.
     * 
     * @return the color of the piece currently on the square. null if no piece 
     */
    public CheckersColor getPieceColor()
    {
        return mePieceColor;
    }
    
    /**
     * This method returns the color of the square as an enum.
     * 
     * @return an enum representing the color of the square (eeWHITE or eeBLACK)
     */
    public CheckersColor getSquareColor()
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
