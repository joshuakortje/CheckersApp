package checkersapp;

/**
 * This class represents a single move. It contains the source and destination
 * square coordinates and the player who is making the move.
 * 
 * @author Joshua Kortje
 * @date 08/15/21
 * 
 * Edits:
 * Initial version          08/15/21
 */
public class Move {
    
    /**
     * The Color of the player making the move
     */
    CheckersColor mePlayerColor;
    
    /**
     * The 1st Row selected
     */
    int mnSelRow;
    
    /**
     * The 1st Column selected
     */
    int mnSelCol;
    
    /**
     * The Destination Row
     */
    int mnDestRow;
    
    /**
     * The Destination Column
     */
    int mnDestCol;
    
    /**
     * Constructor for the Move class
     * 
     * @param anPlayerColor the color of the player
     * @param anRow the selected row
     * @param anCol the selected column
     */
    public Move(CheckersColor anPlayerColor, int anRow, int anCol)
    {
        mePlayerColor = anPlayerColor;
        mnSelRow = anRow;
        mnSelCol = anCol;
        mnDestRow = -1;
        mnDestCol = -1;
    }
    
    /**
     * Set the destination square for the move
     * 
     * @param anRow the destination row
     * @param anCol the destination column
     */
    public void setDestinationSquare(int anRow, int anCol)
    {
        mnDestRow = anRow;
        mnDestCol = anCol;
    }
}
