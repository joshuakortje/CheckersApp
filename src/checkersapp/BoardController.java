/**
 * This class is the controller of the board GUI. It provides the basic
 * handlers for user interaction.
 * 
 * @author Joshua Kortje
 * @date 12/17/19
 * 
 * Edits:
 * Initial version          12/17/19
 * 
 * 12/16/20 Switch to checkers from chess and added button detection
 * 
 * 8/14/21 Condensed Button handlers and moved display function to this class
 * 
 * 8/20/21 Added getIconForColor, updated to use Images for pieces,
 * added processUserSelection, added validatePieceSelection, added attemptMove
 * 
 * Images Used: 
 * white.png used from public domain, 
 * found at https://commons.wikimedia.org/wiki/File:Color-white.JPG
 * on August 15th 2021
 * 
 * black.png used from wikipedia commons
 * found at https://commons.wikimedia.org/wiki/File:Black_Screen.jpg
 * on August 15th 2021
 * 
 * both images were resized but otherwise used in the original format
 * This work in no way represents an endorsement by the original
 * picture authors.
 */
package checkersapp;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author jkort
 */
public class BoardController extends javax.swing.JFrame {
    
    /**
     * Handler for the board class that does all of the implementation of the game
     */
    Board mcBoard;
        
    /**
     * A reference to the White Piece icon
     */
    final ImageIcon mcWhiteIcon;
    
    /**
     * A reference to the Black Piece icon
     */
    final ImageIcon mcBlackIcon;
    
    /**
     * A flag to indicate who's turn it is. (True if white)
     */
    boolean mbIsWhiteTurn;
    
    /**
     * The current move being played. This reference will be set to null
     * if the player has not selected a piece yet.
     */
    Move mcCurrentMove;
    
    /**
     * An array of buttons that handle events from the user
     */
    private JButton[][] maacSquareButtons;

    /**
     * Creates new BoardController
     * 
     * @param acNewBoard the Board for the game
     */
    public BoardController(Board acNewBoard) {
        // Initialize the GUI components
        initComponents();
        
        // Assign the board to a handle
        mcBoard = acNewBoard;
        
        // Initialize the array of Buttons
        maacSquareButtons = new javax.swing.JButton[8][8];
        maacSquareButtons[0][0] = a1;
        maacSquareButtons[0][1] = a2;
        maacSquareButtons[0][2] = a3;
        maacSquareButtons[0][3] = a4;
        maacSquareButtons[0][4] = a5;
        maacSquareButtons[0][5] = a6;
        maacSquareButtons[0][6] = a7;
        maacSquareButtons[0][7] = a8;
        
        maacSquareButtons[1][0] = b1;
        maacSquareButtons[1][1] = b2;
        maacSquareButtons[1][2] = b3;
        maacSquareButtons[1][3] = b4;
        maacSquareButtons[1][4] = b5;
        maacSquareButtons[1][5] = b6;
        maacSquareButtons[1][6] = b7;
        maacSquareButtons[1][7] = b8;
        
        maacSquareButtons[2][0] = c1;
        maacSquareButtons[2][1] = c2;
        maacSquareButtons[2][2] = c3;
        maacSquareButtons[2][3] = c4;
        maacSquareButtons[2][4] = c5;
        maacSquareButtons[2][5] = c6;
        maacSquareButtons[2][6] = c7;
        maacSquareButtons[2][7] = c8;
        
        maacSquareButtons[3][0] = d1;
        maacSquareButtons[3][1] = d2;
        maacSquareButtons[3][2] = d3;
        maacSquareButtons[3][3] = d4;
        maacSquareButtons[3][4] = d5;
        maacSquareButtons[3][5] = d6;
        maacSquareButtons[3][6] = d7;
        maacSquareButtons[3][7] = d8;
        
        maacSquareButtons[4][0] = e1;
        maacSquareButtons[4][1] = e2;
        maacSquareButtons[4][2] = e3;
        maacSquareButtons[4][3] = e4;
        maacSquareButtons[4][4] = e5;
        maacSquareButtons[4][5] = e6;
        maacSquareButtons[4][6] = e7;
        maacSquareButtons[4][7] = e8;
        
        maacSquareButtons[5][0] = f1;
        maacSquareButtons[5][1] = f2;
        maacSquareButtons[5][2] = f3;
        maacSquareButtons[5][3] = f4;
        maacSquareButtons[5][4] = f5;
        maacSquareButtons[5][5] = f6;
        maacSquareButtons[5][6] = f7;
        maacSquareButtons[5][7] = f8;
        
        maacSquareButtons[6][0] = g1;
        maacSquareButtons[6][1] = g2;
        maacSquareButtons[6][2] = g3;
        maacSquareButtons[6][3] = g4;
        maacSquareButtons[6][4] = g5;
        maacSquareButtons[6][5] = g6;
        maacSquareButtons[6][6] = g7;
        maacSquareButtons[6][7] = g8;
        
        maacSquareButtons[7][0] = h1;
        maacSquareButtons[7][1] = h2;
        maacSquareButtons[7][2] = h3;
        maacSquareButtons[7][3] = h4;
        maacSquareButtons[7][4] = h5;
        maacSquareButtons[7][5] = h6;
        maacSquareButtons[7][6] = h7;
        maacSquareButtons[7][7] = h8;
        
        // Set variables that denote which square was previously selected
        mcCurrentMove = null;
        mbIsWhiteTurn = true;
        
        //Set up the white piece icon
        ImageIcon lcIcon = new ImageIcon("src/checkersapp/images/white.jpg");
        Image pic = lcIcon.getImage();
        mcWhiteIcon = new ImageIcon(pic.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
        a1.setIcon(mcWhiteIcon);
        
        //Set up the black piece icon
        ImageIcon lcIcon2 = new ImageIcon("src/checkersapp/images/black.jpg");
        Image pic2 = lcIcon2.getImage();
        mcBlackIcon = new ImageIcon(pic2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
        a3.setIcon(mcBlackIcon);
        
        Player1Tag.setText("White's Turn");
        Player2Tag.setText("");
        
        // Create the Action Handlers for the squares
        createActionHandlers();
        
        // Display the board
        updateDisplay();
    }
    
    /**
     * This function updates the board and display
     */
    private void updateDisplay()
    {
        /// Update the board
        for(int lnRow = 0; lnRow < Board.BOARD_WIDTH; lnRow++)
        {
            for(int lnCol = 0; lnCol < Board.BOARD_WIDTH; lnCol++)
            {
                //Get the color of the piece at the square (null if none)
                CheckersColor leLocalPieceColor = mcBoard.getLocalPieceColor(lnRow, lnCol);
                
                //Get the icon for the color of the piece (null if none)
                ImageIcon lcLocalIcon = getIconForColor(leLocalPieceColor);
                
                //Set the icon on the GUI
                maacSquareButtons[lnRow][lnCol].setIcon(lcLocalIcon);
            }
        }
        
        // Update the current player
        if(mbIsWhiteTurn)
        {
            updateDisplayWhitesTurn();
        }
        else
        {
            updateDisplayBlacksTurn();
        }
    }
    
    /**
     * This function will determine if the user is selecting a piece or the 
     * destination square and process the selection accordingly.
     * 
     * @param anRowSel the row selected
     * @param anColSel the column selected
     */
    private void processUserSelection(int anRowSel, int anColSel)
    {
        // See if we have already selected another square
        if(mcCurrentMove == null)
        {
            // If we have not, validate that the user selected one of 
            // their pieces
            validatePieceSelection(anRowSel, anColSel);
        }
        else
        {
            // If we have already selected a square, try to move
            attemptMove(anRowSel, anColSel);
        }
    }
    
    /**
     * This function makes sure the user selected a square with their piece on
     * it. If they did, then a move is constructed with the color, and square 
     * information to be used when the destination square is chosen.
     * 
     * @param anRow the row chosen
     * @param anCol the column chosen
     */
    private void validatePieceSelection(int anRow, int anCol)
    {
        //figure out the color of the player
        CheckersColor lePlayerColor = mbIsWhiteTurn ? CheckersColor.eeWHITE : CheckersColor.eeBLACK;
        
        //Validate that the player has a piece at this location
        if(lePlayerColor == mcBoard.getLocalPieceColor(anRow, anCol))
        {
            // If so, construct the move with the current information
            mcCurrentMove = new Move(lePlayerColor, anRow, anCol);
        }
    }
    
    /**
     * This function will set the destination square of the move and 
     * attempt to make the move on the board. If the move is made 
     * successfully, the current player will be switched and the 
     * board will be updated.
     * 
     * @param anDestRow the destination row
     * @param anDestCol the destination column
     */
    private void attemptMove(int anDestRow, int anDestCol)
    {
        // Update the move and try to make the move
        mcCurrentMove.setDestinationSquare(anDestRow, anDestCol);
        boolean lbSuccess = mcBoard.attemptMove(mcCurrentMove);

        // Change who's turn it is if the move was successful
        if(lbSuccess)
        {
            mbIsWhiteTurn = !mbIsWhiteTurn;
            updateDisplay();
        }
        
        // Always null the current move because even if the move failed the
        // player may want/need to select a different piece.
        mcCurrentMove = null;
    }
    
    /**
     * Create the Action Handlers for each of the squares on the board. 
     * This method only needs to be called once on startup.
     */
    private void createActionHandlers()
    {
        // Create the action handlers for each square
        for(int lnRow = 0; lnRow < Board.BOARD_WIDTH; lnRow++)
        {
            for(int lnCol = 0; lnCol < Board.BOARD_WIDTH; lnCol++)
            {
                // TODO - Need to change to addMouseListener and use the 
                // SwingUtilities.isRightMouseButton(e) function to check
                // if the right/left button is pressed
                maacSquareButtons[lnRow][lnCol].addActionListener((ActionEvent e) -> {
                    // The action command contains the location of the
                    // square that was selected. Parse it to get the
                    // row and column.
                    String lsLocation = e.getActionCommand();
                    int lnRowSel = Integer.parseInt(Character.toString(lsLocation.charAt(0)));
                    int lnColSel = Integer.parseInt(Character.toString(lsLocation.charAt(1)));
                    
                    // Process, validate, and carry out the user's selection
                    processUserSelection(lnRowSel, lnColSel);
                });
            }
        }
    }
    
    /**
     * This function will update the display items for when it is White's turn
     */
    private void updateDisplayWhitesTurn()
    {
        Player1Tag.setText("White's Turn");
        Player2Tag.setText("");
    }
    
    /**
     * This function will update the display items for when it is Black's turn
     */
    private void updateDisplayBlacksTurn()
    {
        Player1Tag.setText("");
        Player2Tag.setText("Black's Turn");
    }
    
    /**
     * The function will return the ImageIcon graphic for the color of the 
     * piece passed in. If null or some other non-color is passed in null is
     * returned.
     * 
     * @param aeColor the color of the piece
     * @return the ImageIcon associated with the color
     */
    private ImageIcon getIconForColor(CheckersColor aeColor)
    {
        //The icon to be returned
        ImageIcon lcReturnIcon;
        
        // Determine the color and match with the correct icon
        if(aeColor == null)
        {
            // No piece
            lcReturnIcon = null;
        }
        else
        {
            switch (aeColor)
            {
                case eeWHITE:
                    lcReturnIcon = mcWhiteIcon;
                    break;
                case eeBLACK:
                    lcReturnIcon = mcBlackIcon;
                    break;
                default: // Should never happen
                    lcReturnIcon = null;
                    break;
            }
        }
        
        
        return lcReturnIcon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        a1 = new javax.swing.JButton();
        a2 = new javax.swing.JButton();
        a3 = new javax.swing.JButton();
        a4 = new javax.swing.JButton();
        a5 = new javax.swing.JButton();
        a6 = new javax.swing.JButton();
        a7 = new javax.swing.JButton();
        a8 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        c1 = new javax.swing.JButton();
        c2 = new javax.swing.JButton();
        c3 = new javax.swing.JButton();
        c4 = new javax.swing.JButton();
        c5 = new javax.swing.JButton();
        c6 = new javax.swing.JButton();
        c7 = new javax.swing.JButton();
        c8 = new javax.swing.JButton();
        d1 = new javax.swing.JButton();
        d2 = new javax.swing.JButton();
        d3 = new javax.swing.JButton();
        d4 = new javax.swing.JButton();
        d5 = new javax.swing.JButton();
        d6 = new javax.swing.JButton();
        d7 = new javax.swing.JButton();
        d8 = new javax.swing.JButton();
        e1 = new javax.swing.JButton();
        e2 = new javax.swing.JButton();
        e3 = new javax.swing.JButton();
        e4 = new javax.swing.JButton();
        e5 = new javax.swing.JButton();
        e6 = new javax.swing.JButton();
        e7 = new javax.swing.JButton();
        e8 = new javax.swing.JButton();
        f1 = new javax.swing.JButton();
        f2 = new javax.swing.JButton();
        f3 = new javax.swing.JButton();
        f4 = new javax.swing.JButton();
        f5 = new javax.swing.JButton();
        f6 = new javax.swing.JButton();
        f7 = new javax.swing.JButton();
        f8 = new javax.swing.JButton();
        g1 = new javax.swing.JButton();
        g2 = new javax.swing.JButton();
        g3 = new javax.swing.JButton();
        g4 = new javax.swing.JButton();
        g5 = new javax.swing.JButton();
        g6 = new javax.swing.JButton();
        g7 = new javax.swing.JButton();
        g8 = new javax.swing.JButton();
        h1 = new javax.swing.JButton();
        h2 = new javax.swing.JButton();
        h3 = new javax.swing.JButton();
        h4 = new javax.swing.JButton();
        h5 = new javax.swing.JButton();
        h6 = new javax.swing.JButton();
        h7 = new javax.swing.JButton();
        h8 = new javax.swing.JButton();
        Player1Tag = new javax.swing.JLabel();
        Player2Tag = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        a1.setBackground(new java.awt.Color(153, 153, 153));
        a1.setActionCommand("00");

        a2.setBackground(new java.awt.Color(255, 255, 255));
        a2.setActionCommand("01");

        a3.setBackground(new java.awt.Color(153, 153, 153));
        a3.setActionCommand("02");

        a4.setBackground(new java.awt.Color(255, 255, 255));
        a4.setActionCommand("03");

        a5.setBackground(new java.awt.Color(153, 153, 153));
        a5.setActionCommand("04");

        a6.setBackground(new java.awt.Color(255, 255, 255));
        a6.setActionCommand("05");

        a7.setBackground(new java.awt.Color(153, 153, 153));
        a7.setActionCommand("06");

        a8.setBackground(new java.awt.Color(255, 255, 255));
        a8.setActionCommand("07");

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setActionCommand("10");

        b2.setBackground(new java.awt.Color(153, 153, 153));
        b2.setActionCommand("11");

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setActionCommand("12");

        b4.setBackground(new java.awt.Color(153, 153, 153));
        b4.setActionCommand("13");

        b5.setBackground(new java.awt.Color(255, 255, 255));
        b5.setActionCommand("14");

        b6.setBackground(new java.awt.Color(153, 153, 153));
        b6.setActionCommand("15");

        b7.setBackground(new java.awt.Color(255, 255, 255));
        b7.setActionCommand("16");

        b8.setBackground(new java.awt.Color(153, 153, 153));
        b8.setActionCommand("17");

        c1.setBackground(new java.awt.Color(153, 153, 153));
        c1.setActionCommand("20");

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setActionCommand("21");

        c3.setBackground(new java.awt.Color(153, 153, 153));
        c3.setActionCommand("22");

        c4.setBackground(new java.awt.Color(255, 255, 255));
        c4.setActionCommand("23");

        c5.setBackground(new java.awt.Color(153, 153, 153));
        c5.setActionCommand("24");

        c6.setBackground(new java.awt.Color(255, 255, 255));
        c6.setActionCommand("25");

        c7.setBackground(new java.awt.Color(153, 153, 153));
        c7.setActionCommand("26");

        c8.setBackground(new java.awt.Color(255, 255, 255));
        c8.setActionCommand("27");

        d1.setBackground(new java.awt.Color(255, 255, 255));
        d1.setActionCommand("30");

        d2.setBackground(new java.awt.Color(153, 153, 153));
        d2.setActionCommand("31");

        d3.setBackground(new java.awt.Color(255, 255, 255));
        d3.setActionCommand("32");

        d4.setBackground(new java.awt.Color(153, 153, 153));
        d4.setActionCommand("33");

        d5.setBackground(new java.awt.Color(255, 255, 255));
        d5.setActionCommand("34");

        d6.setBackground(new java.awt.Color(153, 153, 153));
        d6.setActionCommand("35");

        d7.setBackground(new java.awt.Color(255, 255, 255));
        d7.setActionCommand("36");

        d8.setBackground(new java.awt.Color(153, 153, 153));
        d8.setActionCommand("37");

        e1.setBackground(new java.awt.Color(153, 153, 153));
        e1.setActionCommand("40");

        e2.setBackground(new java.awt.Color(255, 255, 255));
        e2.setActionCommand("41");

        e3.setBackground(new java.awt.Color(153, 153, 153));
        e3.setActionCommand("42");

        e4.setBackground(new java.awt.Color(255, 255, 255));
        e4.setActionCommand("43");

        e5.setBackground(new java.awt.Color(153, 153, 153));
        e5.setActionCommand("44");

        e6.setBackground(new java.awt.Color(255, 255, 255));
        e6.setActionCommand("45");

        e7.setBackground(new java.awt.Color(153, 153, 153));
        e7.setActionCommand("46");

        e8.setBackground(new java.awt.Color(255, 255, 255));
        e8.setActionCommand("47");

        f1.setBackground(new java.awt.Color(255, 255, 255));
        f1.setActionCommand("50");

        f2.setBackground(new java.awt.Color(153, 153, 153));
        f2.setActionCommand("51");

        f3.setBackground(new java.awt.Color(255, 255, 255));
        f3.setActionCommand("52");

        f4.setBackground(new java.awt.Color(153, 153, 153));
        f4.setActionCommand("53");

        f5.setBackground(new java.awt.Color(255, 255, 255));
        f5.setActionCommand("54");

        f6.setBackground(new java.awt.Color(153, 153, 153));
        f6.setActionCommand("55");

        f7.setBackground(new java.awt.Color(255, 255, 255));
        f7.setActionCommand("56");

        f8.setBackground(new java.awt.Color(153, 153, 153));
        f8.setActionCommand("57");

        g1.setBackground(new java.awt.Color(153, 153, 153));
        g1.setActionCommand("60");

        g2.setBackground(new java.awt.Color(255, 255, 255));
        g2.setActionCommand("61");

        g3.setBackground(new java.awt.Color(153, 153, 153));
        g3.setActionCommand("62");

        g4.setBackground(new java.awt.Color(255, 255, 255));
        g4.setActionCommand("63");

        g5.setBackground(new java.awt.Color(153, 153, 153));
        g5.setActionCommand("64");

        g6.setBackground(new java.awt.Color(255, 255, 255));
        g6.setActionCommand("65");

        g7.setBackground(new java.awt.Color(153, 153, 153));
        g7.setActionCommand("66");

        g8.setBackground(new java.awt.Color(255, 255, 255));
        g8.setActionCommand("67");

        h1.setBackground(new java.awt.Color(255, 255, 255));
        h1.setActionCommand("70");

        h2.setBackground(new java.awt.Color(153, 153, 153));
        h2.setActionCommand("71");

        h3.setBackground(new java.awt.Color(255, 255, 255));
        h3.setActionCommand("72");

        h4.setBackground(new java.awt.Color(153, 153, 153));
        h4.setActionCommand("73");

        h5.setBackground(new java.awt.Color(255, 255, 255));
        h5.setActionCommand("74");

        h6.setBackground(new java.awt.Color(153, 153, 153));
        h6.setActionCommand("75");

        h7.setBackground(new java.awt.Color(255, 255, 255));
        h7.setActionCommand("76");

        h8.setBackground(new java.awt.Color(153, 153, 153));
        h8.setActionCommand("77");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(h1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        Player1Tag.setText("Player1");

        Player2Tag.setText("Player2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player1Tag, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Player2Tag, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Player2Tag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Player1Tag))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        Board lcBoard = new Board();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardController(lcBoard).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Player1Tag;
    private javax.swing.JLabel Player2Tag;
    private javax.swing.JButton a1;
    private javax.swing.JButton a2;
    private javax.swing.JButton a3;
    private javax.swing.JButton a4;
    private javax.swing.JButton a5;
    private javax.swing.JButton a6;
    private javax.swing.JButton a7;
    private javax.swing.JButton a8;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton c1;
    private javax.swing.JButton c2;
    private javax.swing.JButton c3;
    private javax.swing.JButton c4;
    private javax.swing.JButton c5;
    private javax.swing.JButton c6;
    private javax.swing.JButton c7;
    private javax.swing.JButton c8;
    private javax.swing.JButton d1;
    private javax.swing.JButton d2;
    private javax.swing.JButton d3;
    private javax.swing.JButton d4;
    private javax.swing.JButton d5;
    private javax.swing.JButton d6;
    private javax.swing.JButton d7;
    private javax.swing.JButton d8;
    private javax.swing.JButton e1;
    private javax.swing.JButton e2;
    private javax.swing.JButton e3;
    private javax.swing.JButton e4;
    private javax.swing.JButton e5;
    private javax.swing.JButton e6;
    private javax.swing.JButton e7;
    private javax.swing.JButton e8;
    private javax.swing.JButton f1;
    private javax.swing.JButton f2;
    private javax.swing.JButton f3;
    private javax.swing.JButton f4;
    private javax.swing.JButton f5;
    private javax.swing.JButton f6;
    private javax.swing.JButton f7;
    private javax.swing.JButton f8;
    private javax.swing.JButton g1;
    private javax.swing.JButton g2;
    private javax.swing.JButton g3;
    private javax.swing.JButton g4;
    private javax.swing.JButton g5;
    private javax.swing.JButton g6;
    private javax.swing.JButton g7;
    private javax.swing.JButton g8;
    private javax.swing.JButton h1;
    private javax.swing.JButton h2;
    private javax.swing.JButton h3;
    private javax.swing.JButton h4;
    private javax.swing.JButton h5;
    private javax.swing.JButton h6;
    private javax.swing.JButton h7;
    private javax.swing.JButton h8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
