package PvP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Promote extends JFrame implements ActionListener {
    JComboBox choices;
    JButton confirm;
    String[] option = {"Enter your choice", "Rook", "Horse", "Bishop", "Queen"};
    int choice;
    boolean valid;
    public Promote(){
        valid = false;
        this.setTitle("Promotion!");
        this.setLayout(new FlowLayout());
        this.setSize(250, 100);
        choices = new JComboBox(option);
        confirm = new JButton("Confirm");
        choices.setSize(200, 65);
        confirm.setSize(100, 65);
        this.add(choices);
        this.add(confirm);
        this.setVisible(true);
        this.confirm.addActionListener(this);
    }
    public void setChoice(){
        this.choice = choices.getSelectedIndex();
    }
    public int getChoice(){
        return this.choice;
    }
    public boolean isValid(){
        return this.valid;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setChoice();
        if(this.getChoice() != 0){
            valid = true;
        }else if(this.getChoice() == 0){
            valid = false;
            JOptionPane.showMessageDialog(null, "Please choose a valid option!");
        }
    }
}
