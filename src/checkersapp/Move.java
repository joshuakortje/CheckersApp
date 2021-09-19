package checkersapp;

import java.util.ArrayList;

/**
 * This class represents a single move. It contains the source and destination
 * square coordinates and the player who is making the move.
 * 
 * @author Joshua Kortje
 * @date 08/15/21
 * 
 * Edits:
 * Initial version          08/15/21
 * 
 * 8/22/21 Added getters for the row/column numbers and Color
 * 
 * 9/19/21 Switched to the ArrayList implementation of rows and columns to 
 * move towards accounting for multi-jump moves.
 */
public class Move {
    
    /**
     * The Color of the player making the move.
     */
    CheckersColor mePlayerColor;
    
    /**
     * A list of the rows selected in order from the start to the destination.
     */
    private ArrayList<Integer> manSelRow;
    
    /**
     * A list of the columns selected in order from the start to the destination.
     */
    private ArrayList<Integer> manSelCol;
    
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
        manSelRow = new ArrayList<>();
        manSelRow.add(anRow);
        manSelCol = new ArrayList<>();
        manSelCol.add(anCol);
    }
    
    /**
     * Add a destination square for the move
     * 
     * @param anRow the destination row
     * @param anCol the destination column
     */
    public void addDestinationSquare(int anRow, int anCol)
    {
        manSelRow.add(anRow);
        manSelCol.add(anCol);
    }
    
    /**
     * Getter for the player color
     * 
     * @return the player color
     */
    public CheckersColor getPlayerColor()
    {
        return mePlayerColor;
    }
    
    /**
     * Getter for the rows of the move in order from start to destination
     * 
     * @return an ArrayList of the rows
     */
    public ArrayList<Integer> getRows()
    {
        return manSelRow;
    }
    
    /**
     * Getter for the columns of the move in order from start to destination
     * 
     * @return an ArrayList of the columns
     */
    public ArrayList<Integer> getCols()
    {
        return manSelCol;
    }
}
