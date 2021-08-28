package PvP;

import javax.swing.*;

public class InputFrame {
    JFrame inputFrame;
    JPanel textPanel;
    JPanel buttonPanel;
    JTextField p1Name;
    JTextField p2Name;
    JButton confirm;
    String name1;
    String name2;
    public InputFrame(){
        inputFrame = new JFrame("Player Details");
        inputFrame.setSize(400, 250);
        inputFrame.setLocation(300, 150);
        inputFrame.setLayout(null);
        inputFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        inputFrame.setVisible(true);
    }
}
