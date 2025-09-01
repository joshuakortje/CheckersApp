package checkersapp;

import java.util.ArrayList;
import java.util.Arrays;

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
 * 
 * 10/22/21 Added information about Kings and put the move validation logic in
 * this class instead of the Board class.
 * 
 * 9/1/25 Updated to allow kings to move backward.
 */
public class Move {
    
    /**
     * The Color of the player making the move.
     */
    final private CheckersColor mePlayerColor;
    
    /**
     * True if the jumping piece is a king.
     */
    final private boolean mbPieceIsKing;
    
    /**
     * A list of the rows selected in order from the start to the destination.
     */
    private ArrayList<Integer> manTrueRows;
    
    /**
     * A list of the columns selected in order from the start to the destination.
     */
    private ArrayList<Integer> manTrueCols;
    
    /**
     * A list of the rows after they have been transformed to the players perspective.
     */
    private ArrayList<Integer> manTransformedRows;
    
    /**
     * A list of the columns after they have been transformed to the players perspective.
     */
    private ArrayList<Integer> manTransformedCols;
    
    /**
     * A list of the locations of jumped pieces.
     */
    private ArrayList<ArrayList<Integer>> maanJumpedPieces;
    
    /**
     * The local copy of the board to use based on the player color
     */
    private Square[][] maacBoard;
    
    /**
     * Constructor for the Move class
     * 
     * @param anPlayerColor the color of the player
     * @param anRow the selected row
     * @param anCol the selected column
     * @param abPieceIsKing the selected piece is a king
     */
    public Move(CheckersColor anPlayerColor, int anRow, int anCol, boolean abPieceIsKing)
    {
        mePlayerColor = anPlayerColor;
        manTrueRows = new ArrayList<>();
        manTrueRows.add(anRow);
        manTrueCols = new ArrayList<>();
        manTrueCols.add(anCol);
        manTransformedRows = new ArrayList<>();
        manTransformedCols = new ArrayList<>();
        maanJumpedPieces = new ArrayList<>();
        maacBoard = null;
        mbPieceIsKing = abPieceIsKing;
    }
    
    /**
     * Add a destination square for the move
     * 
     * @param anRow the destination row
     * @param anCol the destination column
     */
    public void addDestinationSquare(int anRow, int anCol)
    {
        manTrueRows.add(anRow);
        manTrueCols.add(anCol);
    }
    
    /**
     * This function applies the transformed rows, columns, and board to be used 
     * for processing the move having taken the player's color into account.
     * 
     * @param aanUpdatedRows the transformed rows
     * @param aanUpdatedCols the transformed cols
     * @param aaacBoard the board in the players perspective
     */
    public void updateSquares(ArrayList<Integer> aanUpdatedRows, ArrayList<Integer> aanUpdatedCols, Square[][] aaacBoard)
    {
        manTransformedRows = aanUpdatedRows;
        manTransformedCols = aanUpdatedCols;
        maacBoard = aaacBoard;
    }
    
    /**
     * This function will loop over all steps of the move and check each one for a valid pattern.
     * This function will handle a move with multiple jumps due to jumping over 
     * other pieces.
     * 
     * @return true if the move sequence is valid
     */
    public boolean checkMove()
    {
        boolean lbValid = true;
        
        // check if this is not a multi-jump move
        if(manTransformedRows.size() == 2)
        {
            // Only one jump so check that
            int lnStartRow = manTransformedRows.get(0);
            int lnStartCol = manTransformedCols.get(0);
            int lnEndRow = manTransformedRows.get(1);
            int lnEndCol = manTransformedCols.get(1);
            
            lbValid = validateMovePattern(lnStartRow, lnStartCol, lnEndRow, lnEndCol);
        }
        else // handle multi-jump moves
        {
            for(int lnJump = 0; lnJump < (manTransformedRows.size() - 1); lnJump++)
            {
                // Get all of the locations for the given jump
                int lnStartRow = manTransformedRows.get(lnJump);
                int lnStartCol = manTransformedCols.get(lnJump);
                int lnEndRow = manTransformedRows.get(lnJump + 1);
                int lnEndCol = manTransformedCols.get(lnJump + 1);

                // check if each step of the move is a valid pattern
                // These moves must all be jump moves in order to be a valid multimove
                // play
                if(!checkJumpMove(lnStartRow, lnStartCol, lnEndRow, lnEndCol))
                {
                    lbValid = false;
                    break;
                }
            }
        }
        
        return lbValid;
    }
    
    /**
     * This function will check if the squares indicate a valid move pattern for the board
     * from White's perspective. Moves for black must be transformed to White's
     * perspective before using this function.
     * The only valid moves are those that are moving diagonally by one or jumping over
     * other pieces.
     * 
     * @param anStartRow the starting row
     * @param anStartCol the starting column
     * @param anEndRow the ending row
     * @param anEndCol the ending column
     * 
     * @return true if the move is valid
     */
    private boolean validateMovePattern(int anStartRow, int anStartCol, int anEndRow, int anEndCol)
    {
        boolean lbValid;
        
        // check if it is a non-capturing move first
        if(isBasicMove(anStartRow, anStartCol, anEndRow, anEndCol, 1))
        {
            lbValid = true;
        }
        else
        {
            // check if the move is a jumping move. If it is, this function will
            // return the locations of the jumped pieces. If not the arraylist
            // will be empty
            lbValid = checkJumpMove(anStartRow, anStartCol, anEndRow, anEndCol);
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
     * 
     * @return true if the move is valid
     */
    private boolean checkJumpMove(int anStartRow, int anStartCol, int  anDestRow, int anDestCol)
    {
        boolean lbValid = false;
        
        // Check if the diagonal distance is right
        if(isBasicMove(anStartRow, anStartCol, anDestRow, anDestCol, 2))
        {
            // Get the coordinates of the row and column between the start and 
            // destination
            int lnMidRow = anStartRow + (anDestRow - anStartRow)/2; // Allows for king moves
            int lnMidCol = anStartCol + (anDestCol - anStartCol)/2; // Accounts for the direction of the move.
            
            // Get the color of the piece being jumped over
            CheckersColor leMidColor = maacBoard[lnMidRow][lnMidCol].getPieceColor();
            
            // Make sure there is a piece and that it is of a different color
            if(leMidColor != null && leMidColor != maacBoard[anStartRow][anStartCol].getPieceColor())
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
        
        // If the piece is a king, then we check that the distance between the 
        // rows is anStep. If the piece is not a king, it must also be moving forward.
        if(mbPieceIsKing && (Math.abs(anDestRow - anStartRow) != anStep))
        {
            isValid = false;
        }
        else if(!mbPieceIsKing && ((anDestRow - anStartRow) != anStep))
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
        return manTrueRows;
    }
    
    /**
     * Getter for the columns of the move in order from start to destination
     * 
     * @return an ArrayList of the columns
     */
    public ArrayList<Integer> getCols()
    {
        return manTrueCols;
    }
    
    /**
     * Getter for the locations of jumped pieces.
     * 
     * @return The locations of the jumped pieces from the perspective of the 
     * player
     */
    public ArrayList<ArrayList<Integer>> getJumpedPieces()
    {
        return maanJumpedPieces;
    }
    
    /**
     * Tells if the moving piece is a king.
     * 
     * @return true if the moving piece is a king
     */
    public boolean isPieceKing()
    {
        return mbPieceIsKing;
    }
}
