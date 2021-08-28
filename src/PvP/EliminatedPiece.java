package PvP;

import javax.swing.*;
import java.awt.*;

public class EliminatedPiece {
    JPanel p1Panel;
    JPanel p2Panel;
    JLabel p1Label;
    JLabel[] capturedP1;
    JLabel[] capturedP2;
    int xLoc = 5;
    int yLoc = 100;
    int p1Elim;
    int p2Elim;
    JLabel p2Label;
    Font labelFont = new Font("Arial", Font.BOLD, 12 );
    ImageIcon wPawn = new ImageIcon("src\\Pieces\\white\\pawn.png");
    ImageIcon bPawn = new ImageIcon("src\\Pieces\\black\\pawn.png");
    ImageIcon bRook = new ImageIcon("src\\Pieces\\black\\rook.png");
    ImageIcon bHorse = new ImageIcon("src\\Pieces\\black\\horse.png");
    ImageIcon bBishop = new ImageIcon("src\\Pieces\\black\\bishop.png");
    ImageIcon bKing = new ImageIcon("src\\Pieces\\black\\king.png");
    ImageIcon bQueen = new ImageIcon("src\\Pieces\\black\\queen.png");
    ImageIcon wRook = new ImageIcon("src\\Pieces\\white\\rook.png");
    ImageIcon wHorse = new ImageIcon("src\\Pieces\\white\\horse.png");
    ImageIcon wBishop = new ImageIcon("src\\Pieces\\white\\bishop.png");
    ImageIcon wKing = new ImageIcon("src\\Pieces\\white\\king.png");
    ImageIcon wQueen = new ImageIcon("src\\Pieces\\white\\queen.png");

    public EliminatedPiece(String name1, String name2){
        capturedP1 = new JLabel[16];
        capturedP2 = new JLabel[16];
        p1Elim = 0;
        p2Elim = 0;
        p1Panel = new JPanel(null);
        p2Panel = new JPanel(null);
        p1Label = new JLabel(name1+" Eliminated Pieces:");
        p2Label = new JLabel(name2+" Eliminated Pieces:");
        p1Label.setFont(labelFont);
        p2Label.setFont(labelFont);
        for(int a = 0; a < 16; a++){
            if (a == 8){
                yLoc += 70;
                xLoc = 5;
            }
            capturedP1[a] = new JLabel("*");
            capturedP2[a] = new JLabel("*");
            capturedP1[a].setBounds(xLoc, yLoc, 40, 40);
            capturedP2[a].setBounds(xLoc, yLoc, 40, 40);
            xLoc += 50;
            p1Panel.add(capturedP1[a]);
            p2Panel.add(capturedP2[a]);
        }
        p1Label.setBounds(5,5, 200, 80);
        p2Label.setBounds(5,5, 200, 80);
        p1Panel.add(p1Label);
        p2Panel.add(p2Label);
    }
    public void eliminated(int turn, int piece){
        if(turn == 0){
            switch(piece){
                case 1:
                        capturedP2[p2Elim-1].setIcon(bPawn);
                    break;
                case 2:
                        capturedP2[p2Elim-1].setIcon(bRook);
                    break;
                case 3:
                        capturedP2[p2Elim-1].setIcon(bHorse);
                    break;
                case 4:
                        capturedP2[p2Elim-1].setIcon(bBishop);
                    break;
                case 5:
                        capturedP2[p2Elim-1].setIcon(bQueen);
                    break;
                case 6:
                        capturedP2[p2Elim-1].setIcon(bKing);
                    break;
            }
        }else if(turn == 1){
            switch(piece){
                case 1:
                    capturedP1[p1Elim-1].setIcon(wPawn);
                    break;
                case 2:
                    capturedP1[p1Elim-1].setIcon(wRook);
                    break;
                case 3:
                    capturedP1[p1Elim-1].setIcon(wHorse);
                    break;
                case 4:
                    capturedP1[p1Elim-1].setIcon(wBishop);
                    break;
                case 5:
                    capturedP1[p1Elim-1].setIcon(wQueen);
                    break;
                case 6:
                    capturedP1[p1Elim-1].setIcon(wKing);
                    break;
            }
        }
    }
}
