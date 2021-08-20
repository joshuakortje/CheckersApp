/**
 * This class is the entry point of the checkers application. 
 * 
 * @author Joshua Kortje
 * @date 12/17/19
 * 
 * Edits:
 * Initial version          12/17/19
 * 
 * 12/16/20 Switch to checkers
 */
package checkersapp;

public class CheckersApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create the board
        Board lcBoard = new Board();

        // Start the application
        java.awt.EventQueue.invokeLater(() -> {
            new BoardController(lcBoard).setVisible(true);
        });
    }
}
