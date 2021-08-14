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
 * Switch to checkers,      12/16/20
 * Added button detection
 */
package checkersapp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jkort
 */
public class BoardController extends javax.swing.JFrame {
    
    //a handler for the board class that does all of the implementation of the game
    Board mcBoard;
    
    //a flag to indicate if a square has already been selected
    boolean mbIsSelected;
    //the row and column of the selected square
    int mnRowSel;
    int mnColSel;
    
    private javax.swing.JButton[][] maacSquares;

    /**
     * Creates new form BoardController
     */
    public BoardController(Board acNewBoard) {
        initComponents();
        mcBoard = acNewBoard;
        maacSquares = new javax.swing.JButton[8][8];
        maacSquares[0][0] = a1;
        maacSquares[0][1] = a2;
        maacSquares[0][2] = a3;
        maacSquares[0][3] = a4;
        maacSquares[0][4] = a5;
        maacSquares[0][5] = a6;
        maacSquares[0][6] = a7;
        maacSquares[0][7] = a8;
        
        maacSquares[1][0] = b1;
        maacSquares[1][1] = b2;
        maacSquares[1][2] = b3;
        maacSquares[1][3] = b4;
        maacSquares[1][4] = b5;
        maacSquares[1][5] = b6;
        maacSquares[1][6] = b7;
        maacSquares[1][7] = b8;
        
        maacSquares[2][0] = c1;
        maacSquares[2][1] = c2;
        maacSquares[2][2] = c3;
        maacSquares[2][3] = c4;
        maacSquares[2][4] = c5;
        maacSquares[2][5] = c6;
        maacSquares[2][6] = c7;
        maacSquares[2][7] = c8;
        
        maacSquares[3][0] = d1;
        maacSquares[3][1] = d2;
        maacSquares[3][2] = d3;
        maacSquares[3][3] = d4;
        maacSquares[3][4] = d5;
        maacSquares[3][5] = d6;
        maacSquares[3][6] = d7;
        maacSquares[3][7] = d8;
        
        maacSquares[4][0] = e1;
        maacSquares[4][1] = e2;
        maacSquares[4][2] = e3;
        maacSquares[4][3] = e4;
        maacSquares[4][4] = e5;
        maacSquares[4][5] = e6;
        maacSquares[4][6] = e7;
        maacSquares[4][7] = e8;
        
        maacSquares[5][0] = f1;
        maacSquares[5][1] = f2;
        maacSquares[5][2] = f3;
        maacSquares[5][3] = f4;
        maacSquares[5][4] = f5;
        maacSquares[5][5] = f6;
        maacSquares[5][6] = f7;
        maacSquares[5][7] = f8;
        
        maacSquares[6][0] = g1;
        maacSquares[6][1] = g2;
        maacSquares[6][2] = g3;
        maacSquares[6][3] = g4;
        maacSquares[6][4] = g5;
        maacSquares[6][5] = g6;
        maacSquares[6][6] = g7;
        maacSquares[6][7] = g8;
        
        maacSquares[7][0] = h1;
        maacSquares[7][1] = h2;
        maacSquares[7][2] = h3;
        maacSquares[7][3] = h4;
        maacSquares[7][4] = h5;
        maacSquares[7][5] = h6;
        maacSquares[7][6] = h7;
        maacSquares[7][7] = h8;
        mbIsSelected = false;
        mnRowSel = 0;
        mnColSel = 0;
        mcBoard.setBoardController(this);
        createActionHandlers();
    }
    
    public javax.swing.JButton[][] getSquareArray()
    {
        return maacSquares;
    }
    
    private void createActionHandlers()
    {
        //action listeners
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 0, 0);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 0;
                    mnColSel = 0;
                }
            }
            });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 0, 1);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 0;
                    mnColSel = 1;
                }
            }
            });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 0, 2);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 0;
                    mnColSel = 2;
                }
            }
            });
        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 0, 3);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 0;
                    mnColSel = 3;
                }
            }
            });
        a5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 0, 4);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 0;
                    mnColSel = 4;
                }
            }
            });
        a6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 0, 5);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 0;
                    mnColSel = 5;
                }
            }
            });
        a7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 0, 6);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 0;
                    mnColSel = 6;
                }
            }
            });
        a8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 0, 7);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 0;
                    mnColSel = 7;
                }
            }
            });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 1, 0);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 1;
                    mnColSel = 0;
                }
            }
            });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 1, 1);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 1;
                    mnColSel = 1;
                }
            }
            });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 1, 2);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 1;
                    mnColSel = 2;
                }
            }
            });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 1, 3);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 1;
                    mnColSel = 3;
                }
            }
            });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 1, 4);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 1;
                    mnColSel = 4;
                }
            }
            });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 1, 5);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 1;
                    mnColSel = 5;
                }
            }
            });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 1, 6);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 1;
                    mnColSel = 6;
                }
            }
            });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 1, 7);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 1;
                    mnColSel = 7;
                }
            }
            });
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 2, 0);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 2;
                    mnColSel = 0;
                }
            }
            });
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 2, 1);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 2;
                    mnColSel = 1;
                }
            }
            });
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 2, 2);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 2;
                    mnColSel = 2;
                }
            }
            });
        c4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 2, 3);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 2;
                    mnColSel = 3;
                }
            }
            });
        c5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 2, 4);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 2;
                    mnColSel = 4;
                }
            }
            });
        c6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 2, 5);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 2;
                    mnColSel = 5;
                }
            }
            });
        c7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 2, 6);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 2;
                    mnColSel = 6;
                }
            }
            });
        c8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 2, 7);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 2;
                    mnColSel = 7;
                }
            }
            });
        d1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 3, 0);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 3;
                    mnColSel = 0;
                }
            }
            });
        d2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 3, 1);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 3;
                    mnColSel = 1;
                }
            }
            });
        d3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 3, 2);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 3;
                    mnColSel = 2;
                }
            }
            });
        d4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 3, 3);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 3;
                    mnColSel = 3;
                }
            }
            });
        d5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 3, 4);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 3;
                    mnColSel = 4;
                }
            }
            });
        d6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 3, 5);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 3;
                    mnColSel = 5;
                }
            }
            });
        d7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 3, 6);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 3;
                    mnColSel = 6;
                }
            }
            });
        d8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 3, 7);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 3;
                    mnColSel = 7;
                }
            }
            });
        e1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 4, 0);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 4;
                    mnColSel = 0;
                }
            }
            });
        e2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 4, 1);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 4;
                    mnColSel = 1;
                }
            }
            });
        e3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 4, 2);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 4;
                    mnColSel = 2;
                }
            }
            });
        e4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 4, 3);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 4;
                    mnColSel = 3;
                }
            }
            });
        e5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 4, 4);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 4;
                    mnColSel = 4;
                }
            }
            });
        e6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 4, 5);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 4;
                    mnColSel = 5;
                }
            }
            });
        e7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 4, 6);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 4;
                    mnColSel = 6;
                }
            }
            });
        e8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 4, 7);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 4;
                    mnColSel = 7;
                }
            }
            });
        f1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 5, 0);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 5;
                    mnColSel = 0;
                }
            }
            });
        f2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 5, 1);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 5;
                    mnColSel = 1;
                }
            }
            });
        f3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 5, 2);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 5;
                    mnColSel = 2;
                }
            }
            });
        f4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 5, 3);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 5;
                    mnColSel = 3;
                }
            }
            });
        f5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 5, 4);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 5;
                    mnColSel = 4;
                }
            }
            });
        f6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 5, 5);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 5;
                    mnColSel = 5;
                }
            }
            });
        f7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 5, 6);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 5;
                    mnColSel = 6;
                }
            }
            });
        f8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 5, 7);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 5;
                    mnColSel = 7;
                }
            }
            });
        g1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 6, 0);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 6;
                    mnColSel = 0;
                }
            }
            });
        g2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 6, 1);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 6;
                    mnColSel = 1;
                }
            }
            });
        g3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 6, 2);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 6;
                    mnColSel = 2;
                }
            }
            });
        g4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 6, 3);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 6;
                    mnColSel = 3;
                }
            }
            });
        g5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 6, 4);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 6;
                    mnColSel = 4;
                }
            }
            });
        g6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 6, 5);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 6;
                    mnColSel = 5;
                }
            }
            });
        g7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 6, 6);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 6;
                    mnColSel = 6;
                }
            }
            });
        g8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 6, 7);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 6;
                    mnColSel = 7;
                }
            }
            });
        h1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 7, 0);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 7;
                    mnColSel = 0;
                }
            }
            });
        h2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 7, 1);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 7;
                    mnColSel = 1;
                }
            }
            });
        h3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 7, 2);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 7;
                    mnColSel = 2;
                }
            }
            });
        h4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 7, 3);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 7;
                    mnColSel = 3;
                }
            }
            });
        h5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 7, 4);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 7;
                    mnColSel = 4;
                }
            }
            });
        h6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 7, 5);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 7;
                    mnColSel = 5;
                }
            }
            });
        h7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 7, 6);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 7;
                    mnColSel = 6;
                }
            }
            });
        h8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mbIsSelected)
                {
                    // if this is the 2nd square to select try to make a move
                    mcBoard.movePlayed(mnRowSel, mnColSel, 7, 7);
                    mbIsSelected = false;
                }
                else
                {
                    // if this is the 1st square to select, save the location
                    mbIsSelected = true;
                    mnRowSel = 7;
                    mnColSel = 7;
                }
            }
            });
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        a1.setBackground(new java.awt.Color(153, 153, 153));
        a1.setText("jButton1");

        a2.setBackground(new java.awt.Color(255, 255, 255));
        a2.setText("jButton2");

        a3.setBackground(new java.awt.Color(153, 153, 153));
        a3.setText("jButton3");

        a4.setBackground(new java.awt.Color(255, 255, 255));
        a4.setText("jButton4");

        a5.setBackground(new java.awt.Color(153, 153, 153));
        a5.setText("jButton5");

        a6.setBackground(new java.awt.Color(255, 255, 255));
        a6.setText("jButton6");

        a7.setBackground(new java.awt.Color(153, 153, 153));
        a7.setText("jButton7");

        a8.setBackground(new java.awt.Color(255, 255, 255));
        a8.setText("jButton8");

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setText("jButton9");

        b2.setBackground(new java.awt.Color(153, 153, 153));
        b2.setText("jButton10");

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setText("jButton11");

        b4.setBackground(new java.awt.Color(153, 153, 153));
        b4.setText("jButton12");

        b5.setBackground(new java.awt.Color(255, 255, 255));
        b5.setText("jButton1");

        b6.setBackground(new java.awt.Color(153, 153, 153));
        b6.setText("jButton1");

        b7.setBackground(new java.awt.Color(255, 255, 255));
        b7.setText("jButton1");

        b8.setBackground(new java.awt.Color(153, 153, 153));
        b8.setText("jButton1");

        c1.setBackground(new java.awt.Color(153, 153, 153));
        c1.setText("jButton1");

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setText("jButton2");

        c3.setBackground(new java.awt.Color(153, 153, 153));
        c3.setText("jButton3");

        c4.setBackground(new java.awt.Color(255, 255, 255));
        c4.setText("jButton4");

        c5.setBackground(new java.awt.Color(153, 153, 153));
        c5.setText("jButton5");

        c6.setBackground(new java.awt.Color(255, 255, 255));
        c6.setText("jButton6");

        c7.setBackground(new java.awt.Color(153, 153, 153));
        c7.setText("jButton7");

        c8.setBackground(new java.awt.Color(255, 255, 255));
        c8.setText("jButton8");

        d1.setBackground(new java.awt.Color(255, 255, 255));
        d1.setText("jButton1");

        d2.setBackground(new java.awt.Color(153, 153, 153));
        d2.setText("jButton2");

        d3.setBackground(new java.awt.Color(255, 255, 255));
        d3.setText("jButton3");

        d4.setBackground(new java.awt.Color(153, 153, 153));
        d4.setText("jButton4");

        d5.setBackground(new java.awt.Color(255, 255, 255));
        d5.setText("jButton5");

        d6.setBackground(new java.awt.Color(153, 153, 153));
        d6.setText("jButton6");

        d7.setBackground(new java.awt.Color(255, 255, 255));
        d7.setText("jButton7");

        d8.setBackground(new java.awt.Color(153, 153, 153));
        d8.setText("jButton8");

        e1.setBackground(new java.awt.Color(153, 153, 153));
        e1.setText("jButton1");

        e2.setBackground(new java.awt.Color(255, 255, 255));
        e2.setText("jButton2");

        e3.setBackground(new java.awt.Color(153, 153, 153));
        e3.setText("jButton3");

        e4.setBackground(new java.awt.Color(255, 255, 255));
        e4.setText("jButton4");

        e5.setBackground(new java.awt.Color(153, 153, 153));
        e5.setText("jButton5");

        e6.setBackground(new java.awt.Color(255, 255, 255));
        e6.setText("jButton6");

        e7.setBackground(new java.awt.Color(153, 153, 153));
        e7.setText("jButton7");

        e8.setBackground(new java.awt.Color(255, 255, 255));
        e8.setText("jButton8");

        f1.setBackground(new java.awt.Color(255, 255, 255));
        f1.setText("jButton1");

        f2.setBackground(new java.awt.Color(153, 153, 153));
        f2.setText("jButton2");

        f3.setBackground(new java.awt.Color(255, 255, 255));
        f3.setText("jButton3");

        f4.setBackground(new java.awt.Color(153, 153, 153));
        f4.setText("jButton4");

        f5.setBackground(new java.awt.Color(255, 255, 255));
        f5.setText("jButton5");

        f6.setBackground(new java.awt.Color(153, 153, 153));
        f6.setText("jButton6");

        f7.setBackground(new java.awt.Color(255, 255, 255));
        f7.setText("jButton7");

        f8.setBackground(new java.awt.Color(153, 153, 153));
        f8.setText("jButton8");

        g1.setBackground(new java.awt.Color(153, 153, 153));
        g1.setText("jButton1");

        g2.setBackground(new java.awt.Color(255, 255, 255));
        g2.setText("jButton2");

        g3.setBackground(new java.awt.Color(153, 153, 153));
        g3.setText("jButton3");

        g4.setBackground(new java.awt.Color(255, 255, 255));
        g4.setText("jButton4");

        g5.setBackground(new java.awt.Color(153, 153, 153));
        g5.setText("jButton5");

        g6.setBackground(new java.awt.Color(255, 255, 255));
        g6.setText("jButton6");

        g7.setBackground(new java.awt.Color(153, 153, 153));
        g7.setText("jButton7");

        g8.setBackground(new java.awt.Color(255, 255, 255));
        g8.setText("jButton8");

        h1.setBackground(new java.awt.Color(255, 255, 255));
        h1.setText("jButton1");

        h2.setBackground(new java.awt.Color(153, 153, 153));
        h2.setText("jButton2");

        h3.setBackground(new java.awt.Color(255, 255, 255));
        h3.setText("jButton3");

        h4.setBackground(new java.awt.Color(153, 153, 153));
        h4.setText("jButton4");

        h5.setBackground(new java.awt.Color(255, 255, 255));
        h5.setText("jButton5");

        h6.setBackground(new java.awt.Color(153, 153, 153));
        h6.setText("jButton6");

        h7.setBackground(new java.awt.Color(255, 255, 255));
        h7.setText("jButton7");

        h8.setBackground(new java.awt.Color(153, 153, 153));
        h8.setText("jButton8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(h1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(g1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(f1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(e1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(d1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(c1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(b1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(c8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(d8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(e8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(f8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(g8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(h8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(h1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(h2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(g1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(g2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(g3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(g4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(g5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(g6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(g7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(g8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(f1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(f2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(f3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(f4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(f5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(f6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(f7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(f8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(e1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(e2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(e3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(e4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(e5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(e6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(e7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(e8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(d1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(d2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(c2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
