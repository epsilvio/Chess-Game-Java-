package PvP;

import javax.swing.*;
import java.awt.*;

public class TileCoordinates {
    JPanel xPanel;
    JPanel yPanel;
    JLabel[] xLabel;
    JLabel[] yLabel;
    String[] xCoord = {"a", "b", "c", "d", "e", "f", "g", "h"};
    String[] yCoord = {"8", "7", "6", "5", "4", "3", "2", "1"};
    int x = 60;
    int y = 10;

    public TileCoordinates(){
        xPanel = new JPanel(null);
        yPanel = new JPanel(null);
        xLabel = new JLabel[8];
        yLabel = new JLabel[8];
        xPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        yPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for(int a = 0; a < 8; a++){
            xLabel[a] = new JLabel(xCoord[a]);
            xLabel[a].setBounds(x, y, 15,15);
            x += 65;
            xPanel.add(xLabel[a]);
        }
        x = 10;
        y = 55;
        for(int a = 0; a < 8; a++){
            yLabel[a] = new JLabel(yCoord[a]);
            yLabel[a].setBounds(x, y, 15,15);
            y += 65;
            yPanel.add(yLabel[a]);
        }
    }
}
