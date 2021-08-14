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
 */
public class Board {
    
    private Square[][] maacSquares;
    private BoardController mcBoardController;
    
    
    public void setBoardController(BoardController acController)
    {
        mcBoardController = acController;
    }
    
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
    
    public void displayBoard()
    {
        javax.swing.JButton[][] lcSquares = mcBoardController.getSquareArray();
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                lcSquares[i][j].setText(maacSquares[i][j].getDisplayText());
            }
        }
    }
    
}
