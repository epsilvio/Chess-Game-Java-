package PvP;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

public class RecentMove {
    JPanel movePanel;
    JTextField moveField;
    boolean playerTurn;
    String name1;
    String name2;
    int space;
    public RecentMove(String p1name, String p2name){
        space = p1name.indexOf(" ");
        if (space > -1) {
            name1 = p1name.substring(0, space);
        }else {
            name1 = p1name;
        }
        space = p2name.indexOf(" ");
        if (space > -1) {
            name2 = p2name.substring(0, space);
        }else {
            name2 = p2name;
        }
        movePanel = new JPanel(null);
        moveField = new JTextField();
        moveField.setEditable(false);
        moveField.setForeground(Color.BLACK);
        moveField.setText(name1+"'s turn");
        moveField.setBackground(Color.WHITE);
        moveField.setHorizontalAlignment(0);
        moveField.setBounds(0,0, 180, 40);
        movePanel.add(moveField);
    }
}
