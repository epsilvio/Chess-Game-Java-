package PvP;

import javax.swing.*;
import java.awt.*;

public class GameButtons {
    JPanel btnPanel;
    JButton wCastling;
    JButton bCastling;
    boolean bCastle;
    boolean wCastle;

    public GameButtons(){
        btnPanel = new JPanel(null);
        wCastling = new JButton("White Castling");
        bCastling = new JButton("Black Castling");
        bCastle = false;
        wCastle = false;
        wCastling.setBounds(5,5, 120, 40);
        bCastling.setBounds(130,5, 120, 40);
        wCastling.setEnabled(false);
        bCastling.setEnabled(false);
        btnPanel.add(wCastling);
        btnPanel.add(bCastling);


    }

}
