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
 * 
 * 9/1/25 Added start menu
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
            BoardController lcController = new BoardController(lcBoard);
            lcController.setVisible(true);
            lcController.startMenu(); // Safe place to interact with GUI
        });
    }
}
