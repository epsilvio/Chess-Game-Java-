package PvP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PvP {
    protected JFrame mainFrame;
//    private TileCoordinates MTC;
    private Chessboard MCB;
//    private GameButtons MGB;
//    private EliminatedPiece MEP;
//    private RecentMove MRM;
    private JFrame nameFrame;
    private String p1Name;
    private String p2Name;
    private boolean valid;

    public PvP(){
        p1Name = null;
        p2Name = null;
        valid  = false;
        nameFrame = new JFrame("Input Details");
        do {
            try {
                do {
                    p1Name = JOptionPane.showInputDialog(nameFrame, "Input Player 1 Name (White):");
                    p1Name = p1Name.trim();
                    valid = true;
                } while (p1Name.equals(""));
                do {
                    p2Name = JOptionPane.showInputDialog(nameFrame, "Input Player 2 Name (Black):");
                    p2Name = p2Name.trim();
                    valid = true;
                } while (p2Name.equals(""));
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid input");
                valid = false;
            }
        }while (valid == false);
        mainFrame = new JFrame("Chess (PvP Mode)");
        mainFrame.setSize(900, 600);
        mainFrame.setLocation(200,20);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MCB = new Chessboard(p1Name, p2Name);
        MCB.boardPanel.setBounds(0,0, 900,550);
        mainFrame.add(MCB.boardPanel);
//        MTC = new TileCoordinates();
//        MTC.xPanel.setBounds(0,0, 550, 30);
//        MTC.yPanel.setBounds(0,0, 30, 550);
//        MCB.boardPanel.add(MTC.xPanel);
//        MCB.boardPanel.add(MTC.yPanel);
//        MGB = new GameButtons();
//        MGB.btnPanel.setBounds(580, 225, 300, 45);
//        MCB.boardPanel.add(MGB.btnPanel);
//        MEP = new EliminatedPiece(p1Name, p2Name);
//        MEP.p1Panel.setBounds(550, -20, 210, 90);
//        MEP.p2Panel.setBounds(550, 250, 210, 90);
//        MCB.boardPanel.add(MEP.p1Panel);
//        MCB.boardPanel.add(MEP.p2Panel);
//        MRM = new RecentMove(p1Name, p2Name);
//        MRM.movePanel.setBounds(620,505, 200,40);
//        MCB.boardPanel.add(MRM.movePanel);

        mainFrame.setVisible(true);
    }


    public static void main(String[]args){
        PvP mainDisp = new PvP();
    }

}
