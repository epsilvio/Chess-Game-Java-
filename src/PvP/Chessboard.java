package PvP;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class Chessboard implements ActionListener {
    JPanel boardPanel;
    private TileCoordinates MTC;
    private GameButtons MGB;
    private EliminatedPiece MEP;
    private RecentMove MRM;
    boolean BcheckMate;
    boolean WcheckMate;
    String name1;
    String name2;
    Tile[][] board;
    Tile[] checkingWhite;
    Tile[] checkingBlk;
    Tile selected;
    String[] xCoord = {"a", "b", "c", "d", "e", "f", "g", "h"};
    String[] yCoord = {"8", "7", "6", "5", "4", "3", "2", "1"};
    String[] option = {" ", "Rook", "Horse", "Bishop", "Queen"};
    String coord = null;
    int x = 0;
    int y = 0;
    int xLoc = 30;
    int yLoc = 30;
    int color = 1;
    int fX;
    int fY;
    String move;
    Tile captured;
    Color white = new Color(235, 243, 231);
    Color green = new Color(133, 253, 85);
    Color yellow = new Color(209, 251, 106);
    Color red = new Color(248, 100, 83);
    int clicks;
    int turn;
    String promoteChoice;
    boolean p1Win;
    boolean p2Win;

    public Chessboard(String p1, String p2) {
        checkingWhite = new Tile[8];
        checkingBlk = new Tile[8];
        for (int a = 0; a < 8; a++){
            checkingWhite[a] = new Tile();
            checkingBlk[a] = new Tile();
        }
        p1Win = false;
        p2Win = false;
        name1 = p1;
        name2 = p2;
        BcheckMate = false;
        WcheckMate = false;
        promoteChoice = " ";
        move = "'s turn";
        clicks = 0;
        turn = 0;
        boardPanel = new JPanel(null);
        selected = new Tile();
        captured = new Tile();
        boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        MTC = new TileCoordinates();
        MTC.xPanel.setBounds(0, 0, 550, 30);
        MTC.yPanel.setBounds(0, 0, 30, 550);
        boardPanel.add(MTC.xPanel);
        boardPanel.add(MTC.yPanel);
        MGB = new GameButtons();
        MGB.btnPanel.setBounds(580, 225, 300, 45);
        boardPanel.add(MGB.btnPanel);
        MEP = new EliminatedPiece(name1, name2);
        MEP.p1Panel.setBounds(550, -20, 400, 200);
        MEP.p2Panel.setBounds(550, 250, 400, 200);
        boardPanel.add(MEP.p1Panel);
        boardPanel.add(MEP.p2Panel);
        MRM = new RecentMove(name1, name2);
        MRM.movePanel.setBounds(620, 505, 200, 40);
        boardPanel.add(MRM.movePanel);
        board = new Tile[8][8];
        try {
            for (int a = 0; a < 64; a++) {
                if (y > 7) {
                    y = 0;
                    yLoc = 30;
                    xLoc += 65;
                    x++;
                }
                coord = xCoord[x] + yCoord[y];
                board[x][y] = new Tile();
                board[x][y].setCoordinate(coord);
                board[x][y].setEmpty(true);
                board[x][y].setPiece(0);
                board[x][y].setLocation(xLoc, yLoc);
                board[x][y].setEnabled(false);
                y++;
                yLoc += 65;
            }
            x = 0;
            y = 0;
            for (int a = 0; a < 64; a++) {
                if (x > 7) {
                    x = 0;
                    y++;
                }
                boardPanel.add(board[x][y]);
                x++;
            }
            int b = 0;
            for (int a = 0; a < 8; a++) {
                switch (color) {
                    case 1:
                        board[b][a].setBgColor(white);
                        color++;
                        break;
                    case 2:
                        board[b][a].setBgColor(green);
                        color--;
                        break;
                }
            }
            b++;
            color++;
            for (int a = 0; a < 8; a++) {
                switch (color) {
                    case 1:
                        board[b][a].setBgColor(white);
                        color++;
                        break;
                    case 2:
                        board[b][a].setBgColor(green);
                        color--;
                        break;
                }
            }
            b++;
            color--;
            for (int a = 0; a < 8; a++) {
                switch (color) {
                    case 1:
                        board[b][a].setBgColor(white);
                        color++;
                        break;
                    case 2:
                        board[b][a].setBgColor(green);
                        color--;
                        break;
                }
            }
            b++;
            color++;
            for (int a = 0; a < 8; a++) {
                switch (color) {
                    case 1:
                        board[b][a].setBgColor(white);
                        color++;
                        break;
                    case 2:
                        board[b][a].setBgColor(green);
                        color--;
                        break;
                }
            }
            b++;
            color--;
            for (int a = 0; a < 8; a++) {
                switch (color) {
                    case 1:
                        board[b][a].setBgColor(white);
                        color++;
                        break;
                    case 2:
                        board[b][a].setBgColor(green);
                        color--;
                        break;
                }
            }
            b++;
            color++;
            for (int a = 0; a < 8; a++) {
                switch (color) {
                    case 1:
                        board[b][a].setBgColor(white);
                        color++;
                        break;
                    case 2:
                        board[b][a].setBgColor(green);
                        color--;
                        break;
                }
            }
            b++;
            color--;
            for (int a = 0; a < 8; a++) {
                switch (color) {
                    case 1:
                        board[b][a].setBgColor(white);
                        color++;
                        break;
                    case 2:
                        board[b][a].setBgColor(green);
                        color--;
                        break;
                }
            }
            b++;
            color++;
            for (int a = 0; a < 8; a++) {
                switch (color) {
                    case 1:
                        board[b][a].setBgColor(white);
                        color++;
                        break;
                    case 2:
                        board[b][a].setBgColor(green);
                        color--;
                        break;
                }
            }
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (y == 0 || y == 1) {
                    board[x][y].setWhite(true);
                    board[x][y].setEmpty(false);
                    board[x][y].setChecked(false);
                }
                if (y == 6 || y == 7) {
                    board[x][y].setWhite(false);
                    board[x][y].setEmpty(false);
                    board[x][y].setChecked(false);
                }
                if (y == 1) {
                    board[x][y].setPiece(1);
                }
                if (y == 6) {
                    board[x][y].setPiece(1);
                }
                if ((y == 0 && x == 0) || (y == 0 && x == 7)) {
                    board[x][y].setPiece(2);
                }
                if ((y == 0 && x == 1) || (y == 0 && x == 6)) {
                    board[x][y].setPiece(3);
                }
                if ((y == 0 && x == 2) || (y == 0 && x == 5)) {
                    board[x][y].setPiece(4);
                }
                if (y == 0 && x == 3) {
                    board[x][y].setPiece(5);
                }
                if (y == 0 && x == 4) {
                    board[x][y].setPiece(6);
                }
                if ((y == 7 && x == 0) || (y == 7 && x == 7)) {
                    board[x][y].setPiece(2);
                }
                if ((y == 7 && x == 1) || (y == 7 && x == 6)) {
                    board[x][y].setPiece(3);
                }
                if ((y == 7 && x == 2) || (y == 7 && x == 5)) {
                    board[x][y].setPiece(4);
                }
                if (y == 7 && x == 3) {
                    board[x][y].setPiece(5);

                }
                if (y == 7 && x == 4) {
                    board[x][y].setPiece(6);
                }
            }
        }

        int q = 0;
        int w = 0;
        for (int a = 0; a < 64; a++) {
            if (q > 7) {
                q = 0;
                w++;
            }
            if ((!board[q][w].isEmpty()) && (board[q][w].isWhite())) {
                board[q][w].setEnabled(true);
            }
            q++;
        }
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                board[a][b].addActionListener(this);
            }
        }
        MGB.wCastling.addActionListener(this);
        MGB.bCastling.addActionListener(this);
    }

    public void move(Tile select, int x, int y, int turn) {
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                board[a][b].setEnabled(false);
            }
        }
        board[x][y].setEnabled(true);
        if (select.isWhite()) {
            switch (select.getPiece()) {
                case 1:
                    try {
                        if ((y == 1) && (board[x][y + 2].isEmpty() && board[x][y + 1].isEmpty())) {
                            board[x][y + 2].setBackground(yellow);
                            board[x][y + 2].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x][y + 1].isEmpty()) {
                            board[x][y + 1].setBackground(yellow);
                            board[x][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if ((!board[x + 1][y + 1].isEmpty()) && (!board[x + 1][y + 1].isWhite())) {
                            board[x + 1][y + 1].setBackground(red);
                            board[x + 1][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if ((!board[x - 1][y + 1].isEmpty()) && (!board[x - 1][y + 1].isWhite())) {
                            board[x - 1][y + 1].setBackground(red);
                            board[x - 1][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 2:
                    try {
                        for (int a = 1; a < 8; a++) {
                            if (board[x][y + a].isEmpty()) {
                                board[x][y + a].setBackground(yellow);
                                board[x][y + a].setEnabled(true);
                            } else if ((!board[x][y + a].isEmpty()) && (board[x][y + a].isWhite())) {
                                break;
                            } else if ((!board[x][y + a].isEmpty()) && (!board[x][y + a].isWhite())) {
                                board[x][y + a].setBackground(red);
                                board[x][y + a].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int a = 1; a < 8; a++) {
                            if (board[x + a][y].isEmpty()) {
                                board[x + a][y].setBackground(yellow);
                                board[x + a][y].setEnabled(true);
                            } else if ((!board[x + a][y].isEmpty()) && (board[x + a][y].isWhite())) {
                                break;
                            } else if ((!board[x + a][y].isEmpty()) && (!board[x + a][y].isWhite())) {
                                board[x + a][y].setBackground(red);
                                board[x + a][y].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int a = 1; a < 8; a++) {
                            if (board[x][y - a].isEmpty()) {
                                board[x][y - a].setBackground(yellow);
                                board[x][y - a].setEnabled(true);
                            } else if ((!board[x][y - a].isEmpty()) && (board[x][y - a].isWhite())) {
                                break;
                            } else if ((!board[x][y - a].isEmpty()) && (!board[x][y - a].isWhite())) {
                                board[x][y - a].setBackground(red);
                                board[x][y - a].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int a = 1; a < 8; a++) {
                            if (board[x - a][y].isEmpty()) {
                                board[x - a][y].setBackground(yellow);
                                board[x - a][y].setEnabled(true);
                            } else if ((!board[x - a][y].isEmpty()) && (board[x - a][y].isWhite())) {
                                break;
                            } else if ((!board[x - a][y].isEmpty()) && (!board[x - a][y].isWhite())) {
                                board[x - a][y].setBackground(red);
                                board[x - a][y].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 3:
                    try {
                        if (board[x + 1][y + 2].isEmpty()) {
                            board[x + 1][y + 2].setBackground(yellow);
                            board[x + 1][y + 2].setEnabled(true);
                        } else if ((!board[x + 1][y + 2].isEmpty()) && (!board[x + 1][y + 2].isWhite())) {
                            board[x + 1][y + 2].setBackground(red);
                            board[x + 1][y + 2].setEnabled(true);

                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y + 2].isEmpty()) {
                            board[x - 1][y + 2].setBackground(yellow);
                            board[x - 1][y + 2].setEnabled(true);
                        } else if ((!board[x - 1][y + 2].isEmpty()) && (!board[x - 1][y + 2].isWhite())) {
                            board[x - 1][y + 2].setBackground(red);
                            board[x - 1][y + 2].setEnabled(true);

                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y - 2].isEmpty()) {
                            board[x + 1][y - 2].setBackground(yellow);
                            board[x + 1][y - 2].setEnabled(true);
                        } else if ((!board[x + 1][y - 2].isEmpty()) && (!board[x + 1][y - 2].isWhite())) {
                            board[x + 1][y - 2].setBackground(red);
                            board[x + 1][y - 2].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y - 2].isEmpty()) {
                            board[x - 1][y - 2].setBackground(yellow);
                            board[x - 1][y - 2].setEnabled(true);
                        } else if ((!board[x - 1][y - 2].isEmpty()) && (!board[x - 1][y - 2].isWhite())) {
                            board[x - 1][y - 2].setBackground(red);
                            board[x - 1][y - 2].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 2][y + 1].isEmpty()) {
                            board[x + 2][y + 1].setBackground(yellow);
                            board[x + 2][y + 1].setEnabled(true);
                        } else if ((!board[x + 2][y + 1].isEmpty()) && (!board[x + 2][y + 1].isWhite())) {
                            board[x + 2][y + 1].setBackground(red);
                            board[x + 2][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 2][y + 1].isEmpty()) {
                            board[x - 2][y + 1].setBackground(yellow);
                            board[x - 2][y + 1].setEnabled(true);
                        } else if ((!board[x - 2][y + 1].isEmpty()) && (!board[x - 2][y + 1].isWhite())) {
                            board[x - 2][y + 1].setBackground(red);
                            board[x - 2][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 2][y - 1].isEmpty()) {
                            board[x + 2][y - 1].setBackground(yellow);
                            board[x + 2][y - 1].setEnabled(true);
                        } else if ((!board[x + 2][y - 1].isEmpty()) && (!board[x + 2][y - 1].isWhite())) {
                            board[x + 2][y - 1].setBackground(red);
                            board[x + 2][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 2][y - 1].isEmpty()) {
                            board[x - 2][y - 1].setBackground(yellow);
                            board[x - 2][y - 1].setEnabled(true);
                        } else if ((!board[x - 2][y - 1].isEmpty()) && (!board[x - 2][y - 1].isWhite())) {
                            board[x - 2][y - 1].setBackground(red);
                            board[x - 2][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 4:
                    try {
                        int a = 1, b = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a][y + b].isEmpty()) {
                                board[x + a][y + b].setBackground(yellow);
                                board[x + a][y + b].setEnabled(true);
                            } else if (!board[x + a][y + b].isEmpty() && board[x + a][y + b].isWhite()) {
                                break;
                            } else if (!board[x + a][y + b].isEmpty() && !board[x + a][y + b].isWhite()) {
                                board[x + a][y + b].setBackground(red);
                                board[x + a][y + b].setEnabled(true);
                                break;
                            }
                            a++;
                            b++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int c = -1, d = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + c][y + d].isEmpty()) {
                                board[x + c][y + d].setBackground(yellow);
                                board[x + c][y + d].setEnabled(true);
                            } else if (!board[x + c][y + d].isEmpty() && board[x + c][y + d].isWhite()) {
                                break;
                            } else if (!board[x + c][y + d].isEmpty() && !board[x + c][y + d].isWhite()) {
                                board[x + c][y + d].setBackground(red);
                                board[x + c][y + d].setEnabled(true);
                                break;
                            }
                            c--;
                            d++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int e = -1, f = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + e][y + f].isEmpty()) {
                                board[x + e][y + f].setBackground(yellow);
                                board[x + e][y + f].setEnabled(true);
                            } else if (!board[x + e][y + f].isEmpty() && board[x + e][y + f].isWhite()) {
                                break;
                            } else if (!board[x + e][y + f].isEmpty() && !board[x + e][y + f].isWhite()) {
                                board[x + e][y + f].setBackground(red);
                                board[x + e][y + f].setEnabled(true);
                                break;

                            }
                            e--;
                            f--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int g = 1, h = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + g][y + h].isEmpty()) {
                                board[x + g][y + h].setBackground(yellow);
                                board[x + g][y + h].setEnabled(true);
                            } else if (!board[x + g][y + h].isEmpty() && board[x + g][y + h].isWhite()) {
                                break;
                            } else if (!board[x + g][y + h].isEmpty() && !board[x + g][y + h].isWhite()) {
                                board[x + g][y + h].setBackground(red);
                                board[x + g][y + h].setEnabled(true);
                                break;
                            }
                            g++;
                            h--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 5:
                    int a1 = 1, a2 = 1;
                    int a3 = -1, a4 = 1;
                    int a5 = -1, a6 = -1;
                    int a7 = 1, a8 = -1;
                    try {
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a1][y + a2].isEmpty()) {
                                board[x + a1][y + a2].setBackground(yellow);
                                board[x + a1][y + a2].setEnabled(true);
                            } else if (!board[x + a1][y + a2].isEmpty() && board[x + a1][y + a2].isWhite()) {
                                break;
                            } else if (!board[x + a1][y + a2].isEmpty() && !board[x + a1][y + a2].isWhite()) {
                                board[x + a1][y + a2].setBackground(red);
                                board[x + a1][y + a2].setEnabled(true);
                            }
                            a1++;
                            a2++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a3][y + a4].isEmpty()) {
                                board[x + a3][y + a4].setBackground(yellow);
                                board[x + a3][y + a4].setEnabled(true);
                            } else if (!board[x + a3][y + a4].isEmpty() && board[x + a3][y + a4].isWhite()) {
                                break;
                            } else if (!board[x + a3][y + a4].isEmpty() && !board[x + a3][y + a4].isWhite()) {
                                board[x + a3][y + a4].setBackground(red);
                                board[x + a3][y + a4].setEnabled(true);
                            }
                            a3--;
                            a4++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a5][y + a6].isEmpty()) {
                                board[x + a5][y + a6].setBackground(yellow);
                                board[x + a5][y + a6].setEnabled(true);
                            } else if (!board[x + a5][y + a6].isEmpty() && board[x + a5][y + a6].isWhite()) {
                                break;
                            } else if (!board[x + a5][y + a6].isEmpty() && !board[x + a5][y + a6].isWhite()) {
                                board[x + a5][y + a6].setBackground(red);
                                board[x + a5][y + a6].setEnabled(true);
                            }
                            a5--;
                            a6--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a7][y + a8].isEmpty()) {
                                board[x + a7][y + a8].setBackground(yellow);
                                board[x + a7][y + a8].setEnabled(true);
                            } else if (!board[x + a7][y + a8].isEmpty() && board[x + a7][y + a8].isWhite()) {
                                break;
                            } else if (!board[x + a7][y + a8].isEmpty() && !board[x + a7][y + a8].isWhite()) {
                                board[x + a7][y + a8].setBackground(red);
                                board[x + a7][y + a8].setEnabled(true);
                            }
                            a7++;
                            a8--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int ct = 1; ct < 8; ct++) {
                            if (board[x + ct][y].isEmpty()) {
                                board[x + ct][y].setBackground(yellow);
                                board[x + ct][y].setEnabled(true);
                            } else if ((!board[x + ct][y].isEmpty()) && (board[x + ct][y].isWhite())) {
                                break;
                            } else if ((!board[x + ct][y].isEmpty()) && (!board[x + ct][y].isWhite())) {
                                board[x + ct][y].setBackground(red);
                                board[x + ct][y].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int ct = 1; ct < 8; ct++) {
                            if (board[x][y + ct].isEmpty()) {
                                board[x][y + ct].setBackground(yellow);
                                board[x][y + ct].setEnabled(true);
                            } else if ((!board[x][y + ct].isEmpty()) && (board[x][y + ct].isWhite())) {
                                break;
                            } else if ((!board[x][y + ct].isEmpty()) && (!board[x][y + ct].isWhite())) {
                                board[x][y + ct].setBackground(red);
                                board[x][y + ct].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int ct = 1; ct < 8; ct++) {
                            if (board[x][y - ct].isEmpty()) {
                                board[x][y - ct].setBackground(yellow);
                                board[x][y - ct].setEnabled(true);
                            } else if ((!board[x][y - ct].isEmpty()) && (board[x][y - ct].isWhite())) {
                                break;
                            } else if ((!board[x][y - ct].isEmpty()) && (!board[x][y - ct].isWhite())) {
                                board[x][y - ct].setBackground(red);
                                board[x][y - ct].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int ct = 1; ct < 8; ct++) {
                            if (board[x - ct][y].isEmpty()) {
                                board[x - ct][y].setBackground(yellow);
                                board[x - ct][y].setEnabled(true);
                            } else if ((!board[x - ct][y].isEmpty()) && (board[x - ct][y].isWhite())) {
                                break;
                            } else if ((!board[x - ct][y].isEmpty()) && (!board[x - ct][y].isWhite())) {
                                board[x - ct][y].setBackground(red);
                                board[x - ct][y].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 6:
                    try {
                        if (board[x][y + 1].isEmpty()) {
                            board[x][y + 1].setBackground(yellow);
                            board[x][y + 1].setEnabled(true);
                        } else if (!board[x][y + 1].isEmpty() && !board[x][y + 1].isWhite()) {
                            board[x][y + 1].setBackground(red);
                            board[x][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x][y - 1].isEmpty()) {
                            board[x][y - 1].setBackground(yellow);
                            board[x][y - 1].setEnabled(true);
                        } else if (!board[x][y - 1].isEmpty() && !board[x][y - 1].isWhite()) {
                            board[x][y - 1].setBackground(red);
                            board[x][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y].isEmpty()) {
                            board[x + 1][y].setBackground(yellow);
                            board[x + 1][y].setEnabled(true);
                        } else if (!board[x + 1][y].isEmpty() && !board[x + 1][y].isWhite()) {
                            board[x + 1][y].setBackground(red);
                            board[x + 1][y].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y].isEmpty()) {
                            board[x - 1][y].setBackground(yellow);
                            board[x - 1][y].setEnabled(true);
                        } else if (!board[x - 1][y].isEmpty() && !board[x - 1][y].isWhite()) {
                            board[x - 1][y].setBackground(red);
                            board[x - 1][y].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y + 1].isEmpty()) {
                            board[x + 1][y + 1].setBackground(yellow);
                            board[x + 1][y + 1].setEnabled(true);
                        } else if (!board[x + 1][y + 1].isEmpty() && !board[x + 1][y + 1].isWhite()) {
                            board[x + 1][y + 1].setBackground(red);
                            board[x + 1][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y + 1].isEmpty()) {
                            board[x - 1][y + 1].setBackground(yellow);
                            board[x - 1][y + 1].setEnabled(true);
                        } else if (!board[x - 1][y + 1].isEmpty() && !board[x - 1][y + 1].isWhite()) {
                            board[x - 1][y + 1].setBackground(red);
                            board[x - 1][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y - 1].isEmpty()) {
                            board[x - 1][y - 1].setBackground(yellow);
                            board[x - 1][y - 1].setEnabled(true);
                        } else if (!board[x - 1][y - 1].isEmpty() && !board[x - 1][y - 1].isWhite()) {
                            board[x - 1][y - 1].setBackground(red);
                            board[x - 1][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y - 1].isEmpty()) {
                            board[x + 1][y - 1].setBackground(yellow);
                            board[x + 1][y - 1].setEnabled(true);
                        } else if (!board[x + 1][y - 1].isEmpty() && !board[x + 1][y - 1].isWhite()) {
                            board[x + 1][y - 1].setBackground(red);
                            board[x + 1][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
            }
        } else if (!select.isWhite()) {
            switch (select.getPiece()) {
                case 1:
                    try {
                        if ((y == 6) && (board[x][y - 2].isEmpty() && board[x][y - 1].isEmpty())) {
                            board[x][y - 2].setBackground(yellow);
                            board[x][y - 2].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x][y - 1].isEmpty()) {
                            board[x][y - 1].setBackground(yellow);
                            board[x][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if ((!board[x - 1][y - 1].isEmpty()) && (board[x - 1][y - 1].isWhite())) {
                            board[x - 1][y - 1].setBackground(red);
                            board[x - 1][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if ((!board[x + 1][y - 1].isEmpty()) && (board[x + 1][y - 1].isWhite())) {
                            board[x + 1][y - 1].setBackground(red);
                            board[x + 1][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 2:
                    try {
                        for (int a = 1; a < 8; a++) {
                            if (board[x][y + a].isEmpty()) {
                                board[x][y + a].setBackground(yellow);
                                board[x][y + a].setEnabled(true);
                            } else if ((!board[x][y + a].isEmpty()) && (!board[x][y + a].isWhite())) {
                                break;
                            } else if ((!board[x][y + a].isEmpty()) && (board[x][y + a].isWhite())) {
                                board[x][y + a].setBackground(red);
                                board[x][y + a].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int a = 1; a < 8; a++) {
                            if (board[x + a][y].isEmpty()) {
                                board[x + a][y].setBackground(yellow);
                                board[x + a][y].setEnabled(true);
                            } else if ((!board[x + a][y].isEmpty()) && (!board[x + a][y].isWhite())) {
                                break;
                            } else if ((!board[x + a][y].isEmpty()) && (board[x + a][y].isWhite())) {
                                board[x + a][y].setBackground(red);
                                board[x + a][y].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int a = 1; a < 8; a++) {
                            if (board[x][y - a].isEmpty()) {
                                board[x][y - a].setBackground(yellow);
                                board[x][y - a].setEnabled(true);
                            } else if ((!board[x][y - a].isEmpty()) && (!board[x][y - a].isWhite())) {
                                break;
                            } else if ((!board[x][y - a].isEmpty()) && (board[x][y - a].isWhite())) {
                                board[x][y - a].setBackground(red);
                                board[x][y - a].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int a = 1; a < 8; a++) {
                            if (board[x - a][y].isEmpty()) {
                                board[x - a][y].setBackground(yellow);
                                board[x - a][y].setEnabled(true);
                            } else if ((!board[x - a][y].isEmpty()) && (!board[x - a][y].isWhite())) {
                                break;
                            } else if ((!board[x - a][y].isEmpty()) && (board[x - a][y].isWhite())) {
                                board[x - a][y].setBackground(red);
                                board[x - a][y].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 3:
                    try {
                        if (board[x + 1][y + 2].isEmpty()) {
                            board[x + 1][y + 2].setBackground(yellow);
                            board[x + 1][y + 2].setEnabled(true);
                        } else if ((!board[x + 1][y + 2].isEmpty()) && (board[x + 1][y + 2].isWhite())) {
                            board[x + 1][y + 2].setBackground(red);
                            board[x + 1][y + 2].setEnabled(true);

                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y + 2].isEmpty()) {
                            board[x - 1][y + 2].setBackground(yellow);
                            board[x - 1][y + 2].setEnabled(true);
                        } else if ((!board[x - 1][y + 2].isEmpty()) && (board[x - 1][y + 2].isWhite())) {
                            board[x - 1][y + 2].setBackground(red);
                            board[x - 1][y + 2].setEnabled(true);

                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y - 2].isEmpty()) {
                            board[x + 1][y - 2].setBackground(yellow);
                            board[x + 1][y - 2].setEnabled(true);
                        } else if ((!board[x + 1][y - 2].isEmpty()) && (board[x + 1][y - 2].isWhite())) {
                            board[x + 1][y - 2].setBackground(red);
                            board[x + 1][y - 2].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y - 2].isEmpty()) {
                            board[x - 1][y - 2].setBackground(yellow);
                            board[x - 1][y - 2].setEnabled(true);
                        } else if ((!board[x - 1][y - 2].isEmpty()) && (board[x - 1][y - 2].isWhite())) {
                            board[x - 1][y - 2].setBackground(red);
                            board[x - 1][y - 2].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 2][y + 1].isEmpty()) {
                            board[x + 2][y + 1].setBackground(yellow);
                            board[x + 2][y + 1].setEnabled(true);
                        } else if ((!board[x + 2][y + 1].isEmpty()) && (board[x + 2][y + 1].isWhite())) {
                            board[x + 2][y + 1].setBackground(red);
                            board[x + 2][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 2][y + 1].isEmpty()) {
                            board[x - 2][y + 1].setBackground(yellow);
                            board[x - 2][y + 1].setEnabled(true);
                        } else if ((!board[x - 2][y + 1].isEmpty()) && (board[x - 2][y + 1].isWhite())) {
                            board[x - 2][y + 1].setBackground(red);
                            board[x - 2][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 2][y - 1].isEmpty()) {
                            board[x + 2][y - 1].setBackground(yellow);
                            board[x + 2][y - 1].setEnabled(true);
                        } else if ((!board[x + 2][y - 1].isEmpty()) && (board[x + 2][y - 1].isWhite())) {
                            board[x + 2][y - 1].setBackground(red);
                            board[x + 2][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 2][y - 1].isEmpty()) {
                            board[x - 2][y - 1].setBackground(yellow);
                            board[x - 2][y - 1].setEnabled(true);
                        } else if ((!board[x - 2][y - 1].isEmpty()) && (board[x - 2][y - 1].isWhite())) {
                            board[x - 2][y - 1].setBackground(red);
                            board[x - 2][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 4:
                    try {
                        int a = 1, b = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a][y + b].isEmpty()) {
                                board[x + a][y + b].setBackground(yellow);
                                board[x + a][y + b].setEnabled(true);
                            } else if (!board[x + a][y + b].isEmpty() && !board[x + a][y + b].isWhite()) {
                                break;
                            } else if (!board[x + a][y + b].isEmpty() && board[x + a][y + b].isWhite()) {
                                board[x + a][y + b].setBackground(red);
                                board[x + a][y + b].setEnabled(true);
                                break;
                            }
                            a++;
                            b++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int c = -1, d = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + c][y + d].isEmpty()) {
                                board[x + c][y + d].setBackground(yellow);
                                board[x + c][y + d].setEnabled(true);
                            } else if (!board[x + c][y + d].isEmpty() && !board[x + c][y + d].isWhite()) {
                                break;
                            } else if (!board[x + c][y + d].isEmpty() && board[x + c][y + d].isWhite()) {
                                board[x + c][y + d].setBackground(red);
                                board[x + c][y + d].setEnabled(true);
                                break;
                            }
                            c--;
                            d++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int e = -1, f = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + e][y + f].isEmpty()) {
                                board[x + e][y + f].setBackground(yellow);
                                board[x + e][y + f].setEnabled(true);
                            } else if (!board[x + e][y + f].isEmpty() && !board[x + e][y + f].isWhite()) {
                                break;
                            } else if (!board[x + e][y + f].isEmpty() && board[x + e][y + f].isWhite()) {
                                board[x + e][y + f].setBackground(red);
                                board[x + e][y + f].setEnabled(true);
                                break;

                            }
                            e--;
                            f--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int g = 1, h = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + g][y + h].isEmpty()) {
                                board[x + g][y + h].setBackground(yellow);
                                board[x + g][y + h].setEnabled(true);
                            } else if (!board[x + g][y + h].isEmpty() && !board[x + g][y + h].isWhite()) {
                                break;
                            } else if (!board[x + g][y + h].isEmpty() && board[x + g][y + h].isWhite()) {
                                board[x + g][y + h].setBackground(red);
                                board[x + g][y + h].setEnabled(true);
                                break;
                            }
                            g++;
                            h--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 5:
                    int a1 = 1, a2 = 1;
                    int a3 = -1, a4 = 1;
                    int a5 = -1, a6 = -1;
                    int a7 = 1, a8 = -1;
                    try {
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a1][y + a2].isEmpty()) {
                                board[x + a1][y + a2].setBackground(yellow);
                                board[x + a1][y + a2].setEnabled(true);
                            } else if (!board[x + a1][y + a2].isEmpty() && !board[x + a1][y + a2].isWhite()) {
                                break;
                            } else if (!board[x + a1][y + a2].isEmpty() && board[x + a1][y + a2].isWhite()) {
                                board[x + a1][y + a2].setBackground(red);
                                board[x + a1][y + a2].setEnabled(true);
                            }
                            a1++;
                            a2++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a3][y + a4].isEmpty()) {
                                board[x + a3][y + a4].setBackground(yellow);
                                board[x + a3][y + a4].setEnabled(true);
                            } else if (!board[x + a3][y + a4].isEmpty() && !board[x + a3][y + a4].isWhite()) {
                                break;
                            } else if (!board[x + a3][y + a4].isEmpty() && board[x + a3][y + a4].isWhite()) {
                                board[x + a3][y + a4].setBackground(red);
                                board[x + a3][y + a4].setEnabled(true);
                            }
                            a3--;
                            a4++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a5][y + a6].isEmpty()) {
                                board[x + a5][y + a6].setBackground(yellow);
                                board[x + a5][y + a6].setEnabled(true);
                            } else if (!board[x + a5][y + a6].isEmpty() && !board[x + a5][y + a6].isWhite()) {
                                break;
                            } else if (!board[x + a5][y + a6].isEmpty() && board[x + a5][y + a6].isWhite()) {
                                board[x + a5][y + a6].setBackground(red);
                                board[x + a5][y + a6].setEnabled(true);
                            }
                            a5--;
                            a6--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if (board[x + a7][y + a8].isEmpty()) {
                                board[x + a7][y + a8].setBackground(yellow);
                                board[x + a7][y + a8].setEnabled(true);
                            } else if (!board[x + a7][y + a8].isEmpty() && !board[x + a7][y + a8].isWhite()) {
                                break;
                            } else if (!board[x + a7][y + a8].isEmpty() && board[x + a7][y + a8].isWhite()) {
                                board[x + a7][y + a8].setBackground(red);
                                board[x + a7][y + a8].setEnabled(true);
                            }
                            a7++;
                            a8--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int ct = 1; ct < 8; ct++) {
                            if (board[x + ct][y].isEmpty()) {
                                board[x + ct][y].setBackground(yellow);
                                board[x + ct][y].setEnabled(true);
                            } else if ((!board[x + ct][y].isEmpty()) && (!board[x + ct][y].isWhite())) {
                                break;
                            } else if ((!board[x + ct][y].isEmpty()) && (board[x + ct][y].isWhite())) {
                                board[x + ct][y].setBackground(red);
                                board[x + ct][y].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int ct = 1; ct < 8; ct++) {
                            if (board[x][y + ct].isEmpty()) {
                                board[x][y + ct].setBackground(yellow);
                                board[x][y + ct].setEnabled(true);
                            } else if ((!board[x][y + ct].isEmpty()) && (!board[x][y + ct].isWhite())) {
                                break;
                            } else if ((!board[x][y + ct].isEmpty()) && (board[x][y + ct].isWhite())) {
                                board[x][y + ct].setBackground(red);
                                board[x][y + ct].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int ct = 1; ct < 8; ct++) {
                            if (board[x][y - ct].isEmpty()) {
                                board[x][y - ct].setBackground(yellow);
                                board[x][y - ct].setEnabled(true);
                            } else if ((!board[x][y - ct].isEmpty()) && (!board[x][y - ct].isWhite())) {
                                break;
                            } else if ((!board[x][y - ct].isEmpty()) && (board[x][y - ct].isWhite())) {
                                board[x][y - ct].setBackground(red);
                                board[x][y - ct].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        for (int ct = 1; ct < 8; ct++) {
                            if (board[x - ct][y].isEmpty()) {
                                board[x - ct][y].setBackground(yellow);
                                board[x - ct][y].setEnabled(true);
                            } else if ((!board[x - ct][y].isEmpty()) && (!board[x - ct][y].isWhite())) {
                                break;
                            } else if ((!board[x - ct][y].isEmpty()) && (board[x - ct][y].isWhite())) {
                                board[x - ct][y].setBackground(red);
                                board[x - ct][y].setEnabled(true);
                                break;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 6:
                    try {
                        if (board[x][y + 1].isEmpty()) {
                            board[x][y + 1].setBackground(yellow);
                            board[x][y + 1].setEnabled(true);
                        } else if (!board[x][y + 1].isEmpty() && board[x][y + 1].isWhite()) {
                            board[x][y + 1].setBackground(red);
                            board[x][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x][y - 1].isEmpty()) {
                            board[x][y - 1].setBackground(yellow);
                            board[x][y - 1].setEnabled(true);
                        } else if (!board[x][y - 1].isEmpty() && board[x][y + 1].isWhite()) {
                            board[x][y - 1].setBackground(red);
                            board[x][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y].isEmpty()) {
                            board[x + 1][y].setBackground(yellow);
                            board[x + 1][y].setEnabled(true);
                        } else if (!board[x + 1][y].isEmpty() && board[x][y + 1].isWhite()) {
                            board[x + 1][y].setBackground(red);
                            board[x + 1][y].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y].isEmpty()) {
                            board[x - 1][y].setBackground(yellow);
                            board[x - 1][y].setEnabled(true);
                        } else if (!board[x - 1][y].isEmpty() && board[x][y + 1].isWhite()) {
                            board[x - 1][y].setBackground(red);
                            board[x - 1][y].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y + 1].isEmpty()) {
                            board[x + 1][y + 1].setBackground(yellow);
                            board[x + 1][y + 1].setEnabled(true);
                        } else if (!board[x + 1][y + 1].isEmpty() && board[x][y + 1].isWhite()) {
                            board[x + 1][y + 1].setBackground(red);
                            board[x + 1][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y + 1].isEmpty()) {
                            board[x - 1][y + 1].setBackground(yellow);
                            board[x - 1][y + 1].setEnabled(true);
                        } else if (!board[x - 1][y + 1].isEmpty() && board[x][y + 1].isWhite()) {
                            board[x - 1][y + 1].setBackground(red);
                            board[x - 1][y + 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y - 1].isEmpty()) {
                            board[x - 1][y - 1].setBackground(yellow);
                            board[x - 1][y - 1].setEnabled(true);
                        } else if (!board[x - 1][y - 1].isEmpty() && board[x][y + 1].isWhite()) {
                            board[x - 1][y - 1].setBackground(red);
                            board[x - 1][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y - 1].isEmpty()) {
                            board[x + 1][y - 1].setBackground(yellow);
                            board[x + 1][y - 1].setEnabled(true);
                        } else if (!board[x + 1][y - 1].isEmpty() && board[x][y + 1].isWhite()) {
                            board[x + 1][y - 1].setBackground(red);
                            board[x + 1][y - 1].setEnabled(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
            }
        }
    }

    public void resetBoard(int turn) {
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 7; y++) {
                board[x][y].setEnabled(false);
                if (turn == 0) {
                    if (board[x][y].isWhite() && board[x][y].getPiece() != 0) {
                        board[x][y].setEnabled(true);
                    }
                } else if (turn == 1) {
                    if (!board[x][y].isWhite() && board[x][y].getPiece() != 0) {
                        board[x][y].setEnabled(true);
                    }
                }
                board[x][y].setBgColor(board[x][y].bgColor);
            }
        }
    }

    public void displace(Tile select, int x, int y, int x2, int y2, int next) {
        int bKingX = 4;
        int bKingY = 7;
        int wKingX = 4;
        int wKingY = 0;
        for (int i1 = 0; i1 < 8; i1++) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (board[i1][i2].getPiece() == 6 && board[i1][i2].isWhite()) {
                    wKingX = i1;
                    wKingY = i2;
                }
            }
        }
        for (int i1 = 0; i1 < 8; i1++) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (board[i1][i2].getPiece() == 6 && !board[i1][i2].isWhite()) {
                    bKingX = i1;
                    bKingY = i2;
                }
            }
        }
        if (next == 0) {
            move = name1 + "'s " + board[x2][y2].name + " to " + board[x][y].getCoordinate();
            showMove(this.move);
        } else if (next == 1) {
            move = name2 + "'s " + board[x2][y2].name + " to " + board[x][y].getCoordinate();
            showMove(this.move);
        }
        if (board[x][y].getPiece() == 2 || board[x][y].getPiece() == 6) {
            board[x][y].setCastling(false);
        }

        if (board[x][y].isEmpty()) {
            board[x][y].setWhite(select.isWhite());
            board[x][y].setPiece(select.getPiece());
            board[x][y].setName(select.getName());
            board[x][y].setEmpty(false);
            board[x2][y2].setEmpty(true);
            board[x2][y2].setPiece(0);
        } else if (!board[x][y].isEmpty()) {
            if (next == 0) {
                MEP.p2Elim++;
                MEP.eliminated(0, board[x][y].getPiece());
            } else if (next == 1) {
                MEP.p1Elim++;
                MEP.eliminated(1, board[x][y].getPiece());
            }
            board[x][y].setWhite(select.isWhite());
            board[x][y].setPiece(select.getPiece());
            board[x][y].setName(select.getName());
            board[x][y].setEmpty(false);
            board[x2][y2].setEmpty(true);
            board[x2][y2].setPiece(0);

        }
        if (board[x][y].isWhite()) {
            turn = 1;
        } else if (!board[x][y].isWhite()) {
            turn = 0;
        }
//        for(int a = 0; a < 8; a++){
//            for(int b = 0; b < 8; b++){
//                board[a][b].setEnabled(false);
//            }
//        }
        if (board[x][y].getPiece() == 1) {
            checkPromotion(x, y);
        }
        if (turn == 0) {
            checkCastling(turn);
        } else if (turn == 1) {
            checkCastling(turn);
        }
//        if(checkWhiteKing(wKingX, wKingY)){
////            if(checkMate(wKingX, wKingY, turn)) {
////
////            }else {
//                board[wKingX][wKingY].setChecked(true);
//                JOptionPane.showMessageDialog(null, "Check White King");
////            }
//        }else{
//            board[wKingX][wKingY].setChecked(false);
//        }
//        if(checkBlackKing(bKingX, bKingY)){
////            if(checkMate(wKingX, wKingY, turn)) {
////
////            }else {
//                board[bKingX][bKingY].setChecked(true);
//                JOptionPane.showMessageDialog(null, "Check Black King");
////            }
//        }else{
//            board[bKingX][bKingY].setChecked(false);
//        }
    }

    public void checkCastling(int turn) {
        if (turn == 0) {
            if (board[4][0].getPiece() == 6 && board[7][0].getPiece() == 2) {
                if ((board[5][0].isEmpty() && board[6][0].isEmpty()) && board[4][0].checkCastle() && board[7][0].checkCastle()) {
                    MGB.wCastling.setEnabled(true);
                } else {
                    MGB.wCastling.setEnabled(false);
                }
            }
        } else if (turn == 1) {
            if (board[4][7].getPiece() == 6 && board[7][7].getPiece() == 2) {
                if ((board[5][7].isEmpty() && board[6][7].isEmpty()) && board[4][7].checkCastle() && board[7][7].checkCastle()) {
                    MGB.bCastling.setEnabled(true);
                } else {
                    MGB.wCastling.setEnabled(false);
                }
            }
        }
    }

    public void castle(int turn) {
        if (turn == 0) {
            board[5][0].setWhite(true);
            board[5][0].setEmpty(false);
            board[5][0].setPiece(2);
            board[5][0].setCastling(false);
            board[6][0].setWhite(true);
            board[6][0].setEmpty(false);
            board[6][0].setPiece(6);
            board[6][0].setCastling(false);
            board[4][0].setEmpty(true);
            board[4][0].setPiece(0);
            board[7][0].setEmpty(true);
            board[7][0].setPiece(0);
        } else if (turn == 1) {
            board[5][7].setWhite(false);
            board[5][7].setEmpty(false);
            board[5][7].setPiece(2);
            board[5][7].setCastling(false);
            board[6][7].setWhite(false);
            board[6][7].setEmpty(false);
            board[6][7].setPiece(6);
            board[6][7].setCastling(false);
            board[4][7].setEmpty(true);
            board[4][7].setPiece(0);
            board[7][7].setEmpty(true);
            board[7][7].setPiece(0);
        }
    }

    public boolean checkWhiteKing(int x, int y) {
        int checkers = 0;
        for (int a = 1; a < 7; a++) {
            switch (a) {
                case 1:
                    try {
                        if (board[x + 1][y + 1].getPiece() == 1 && !board[x + 1][y + 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y + 1].getPiece() == 1 && !board[x + 1][y + 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 2:
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x + i][y].isEmpty() && board[x + i][y].isWhite()) {
                                break;
                            }
                            if (board[x + i][y].getPiece() == 2 && !board[x + i][y].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x - i][y].isEmpty() && board[x - i][y].isWhite()) {
                                break;
                            }
                            if (board[x - i][y].getPiece() == 2 && !board[x - i][y].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x][y + i].isEmpty() && board[x][y + i].isWhite()) {
                                break;
                            }
                            if (board[x][y + i].getPiece() == 2 && !board[x][y + i].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x][y - i].isEmpty() && board[x][y - i].isWhite()) {
                                break;
                            } else if (board[x][y - i].getPiece() == 2 && !board[x][y - i].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    break;
                case 3:
                    try {
                        if (board[x + 1][y + 2].getPiece() == 3 && !board[x + 1][y + 2].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y + 2].getPiece() == 3 && !board[x - 1][y + 2].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y - 2].getPiece() == 3 && !board[x + 1][y - 2].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y - 2].getPiece() == 3 && !board[x - 1][y - 2].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 2][y + 1].getPiece() == 3 && !board[x + 2][y + 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 2][y + 1].getPiece() == 3 && !board[x - 2][y + 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 2][y - 1].getPiece() == 3 && !board[x + 2][y - 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 2][y - 1].getPiece() == 3 && !board[x - 2][y - 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 4:
                    try {
                        int a1 = 1, b1 = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + a1][y + b1].getPiece() != 4 && board[x + a1][y + b1].getPiece() != 0) && (board[x + a1][y + b1].isWhite() || !board[x + a1][y + b1].isWhite())) {
                                break;
                            }
                            if (board[x + a1][y + b1].getPiece() == 4 && !board[x + a1][y + b1].isWhite()) {
                                checkers++;
                            }
                            a1++;
                            b1++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int c = -1, d = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + c][y + d].getPiece() != 4 && board[x + c][y + d].getPiece() != 0) && (board[x + c][y + d].isWhite() || !board[x + c][y + d].isWhite())) {
                                break;
                            }
                            if (board[x + c][y + d].getPiece() == 4 && !board[x + c][y + d].isWhite()) {
                                checkers++;
                            }
                            c--;
                            d++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int e = -1, f = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + e][y + f].getPiece() != 4 && board[x + e][y + f].getPiece() != 0) && (board[x + e][y + f].isWhite() || !board[x + e][y + f].isWhite())) {
                                break;
                            }
                            if (board[x + e][y + f].getPiece() == 4 && !board[x + e][y + f].isWhite()) {
                                checkers++;
                            }
                            e--;
                            f--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int g = 1, h = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + g][y + h].getPiece() != 4 && board[x + g][y + h].getPiece() != 0) && (board[x + g][y + h].isWhite() || !board[x + g][y + h].isWhite())) {
                                break;
                            }
                            if (board[x + g][y + h].getPiece() == 4 && !board[x + g][y + h].isWhite()) {
                                checkers++;
                            }
                            g++;
                            h--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 5:
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x + i][y].isEmpty() && board[x + i][y].isWhite()) {
                                break;
                            }
                            if (board[x + i][y].getPiece() == 5 && !board[x + i][y].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x - i][y].isEmpty() && board[x - i][y].isWhite()) {
                                break;
                            }
                            if (board[x - i][y].getPiece() == 5 && !board[x - i][y].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x][y + i].isEmpty() && board[x][y + i].isWhite()) {
                                break;
                            }
                            if (board[x][y + i].getPiece() == 5 && !board[x][y + i].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x][y - i].isEmpty() && board[x][y - i].isWhite()) {
                                break;
                            } else if (board[x][y - i].getPiece() == 5 && !board[x][y - i].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    try {
                        int a1 = 1, b1 = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + a1][y + b1].getPiece() != 5 && board[x + a1][y + b1].getPiece() != 0) && (board[x + a1][y + b1].isWhite() || !board[x + a1][y + b1].isWhite())) {
                                break;
                            }
                            if (board[x + a1][y + b1].getPiece() == 5 && !board[x + a1][y + b1].isWhite()) {
                                checkers++;
                            }
                            a1++;
                            b1++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int c = -1, d = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + c][y + d].getPiece() != 5 && board[x + c][y + d].getPiece() != 0) && (board[x + c][y + d].isWhite() || !board[x + c][y + d].isWhite())) {
                                break;
                            }
                            if (board[x + c][y + d].getPiece() == 5 && !board[x + c][y + d].isWhite()) {
                                checkers++;
                            }
                            c--;
                            d++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int e = -1, f = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + e][y + f].getPiece() != 5 && board[x + e][y + f].getPiece() != 0) && (board[x + e][y + f].isWhite() || !board[x + e][y + f].isWhite())) {
                                break;
                            }
                            if (board[x + e][y + f].getPiece() == 5 && !board[x + e][y + f].isWhite()) {
                                checkers++;
                            }
                            e--;
                            f--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int g = 1, h = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + g][y + h].getPiece() != 5 && board[x + g][y + h].getPiece() != 0) && (board[x + g][y + h].isWhite() || !board[x + g][y + h].isWhite())) {
                                break;
                            }
                            if (board[x + g][y + h].getPiece() == 5 && !board[x + g][y + h].isWhite()) {
                                checkers++;
                            }
                            g++;
                            h--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
            }
        }
        if (checkers > 0){
            return true;
        }
        return false;
    }

    public boolean checkBlackKing(int x, int y) {
        for (int i1 = 0; i1 < 8; i1++) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (board[i1][i2].getPiece() == 6 && !board[i1][i2].isWhite()) {
                    x = i1;
                    y = i2;
                }
            }
        }
        int checkers = 0;
        for (int a = 1; a < 7; a++) {
            switch (a) {
                case 1:
                    try {
                        if (board[x + 1][y - 1].getPiece() == 1 && board[x + 1][y - 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y - 1].getPiece() == 1 && board[x + 1][y - 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 2:
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x + i][y].isEmpty() && !board[x + i][y].isWhite()) {
                                break;
                            }
                            if (board[x + i][y].getPiece() == 2 && board[x + i][y].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x - i][y].isEmpty() && !board[x - i][y].isWhite()) {
                                break;
                            }
                            if (board[x - i][y].getPiece() == 2 && board[x - i][y].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x][y + i].isEmpty() && !board[x][y + i].isWhite()) {
                                break;
                            }
                            if (board[x][y + i].getPiece() == 2 && board[x][y + i].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x][y - i].isEmpty() && !board[x][y - i].isWhite()) {
                                break;
                            } else if (board[x][y - i].getPiece() == 2 && board[x][y - i].isWhite()) {
                                checkers++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    break;
                case 3:
                    try {
                        if (board[x + 1][y + 2].getPiece() == 3 && board[x + 1][y + 2].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y + 2].getPiece() == 3 && board[x - 1][y + 2].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 1][y - 2].getPiece() == 3 && board[x + 1][y - 2].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 1][y - 2].getPiece() == 3 && board[x - 1][y - 2].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 2][y + 1].getPiece() == 3 && board[x + 2][y + 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 2][y + 1].getPiece() == 3 && board[x - 2][y + 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x + 2][y - 1].getPiece() == 3 && board[x + 2][y - 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        if (board[x - 2][y - 1].getPiece() == 3 && board[x - 2][y - 1].isWhite()) {
                            checkers++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 4:
                    try {
                        int a1 = 1, b1 = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + a1][y + b1].getPiece() != 4 && board[x + a1][y + b1].getPiece() != 0) && (board[x + a1][y + b1].isWhite() || !board[x + a1][y + b1].isWhite())) {
                                break;
                            }
                            if (board[x + a1][y + b1].getPiece() == 4 && board[x + a1][y + b1].isWhite()) {
                                checkers++;
                            }
                            a1++;
                            b1++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int c = -1, d = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + c][y + d].getPiece() != 4 && board[x + c][y + d].getPiece() != 0) && (board[x + c][y + d].isWhite() || !board[x + c][y + d].isWhite())) {
                                break;
                            }
                            if (board[x + c][y + d].getPiece() == 4 && board[x + c][y + d].isWhite()) {
                                checkers++;
                            }
                            c--;
                            d++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int e = -1, f = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + e][y + f].getPiece() != 4 && board[x + e][y + f].getPiece() != 0) && (board[x + e][y + f].isWhite() || !board[x + e][y + f].isWhite())) {
                                break;
                            }
                            if (board[x + e][y + f].getPiece() == 4 && board[x + e][y + f].isWhite()) {
                                return true;
                            }
                            e--;
                            f--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int g = 1, h = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + g][y + h].getPiece() != 4 && board[x + g][y + h].getPiece() != 0) && (board[x + g][y + h].isWhite() || !board[x + g][y + h].isWhite())) {
                                break;
                            }
                            if (board[x + g][y + h].getPiece() == 4 && board[x + g][y + h].isWhite()) {
                                return true;
                            }
                            g++;
                            h--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
                case 5:
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x + i][y].isEmpty() && !board[x + i][y].isWhite()) {
                                break;
                            }
                            if (board[x + i][y].getPiece() == 5 && board[x + i][y].isWhite()) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x - i][y].isEmpty() && !board[x - i][y].isWhite()) {
                                break;
                            }
                            if (board[x - i][y].getPiece() == 5 && board[x - i][y].isWhite()) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x][y + i].isEmpty() && !board[x][y + i].isWhite()) {
                                break;
                            }
                            if (board[x][y + i].getPiece() == 5 && board[x][y + i].isWhite()) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    for (int i = 1; i < 8; i++) {
                        try {
                            if (!board[x][y - i].isEmpty() && !board[x][y - i].isWhite()) {
                                break;
                            } else if (board[x][y - i].getPiece() == 5 && board[x][y - i].isWhite()) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ao) {

                        }
                    }
                    try {
                        int a1 = 1, b1 = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + a1][y + b1].getPiece() != 5 && board[x + a1][y + b1].getPiece() != 0) && (board[x + a1][y + b1].isWhite() || !board[x + a1][y + b1].isWhite())) {
                                break;
                            }
                            if (board[x + a1][y + b1].getPiece() == 5 && board[x + a1][y + b1].isWhite()) {
                                return true;
                            }
                            a1++;
                            b1++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int c = -1, d = 1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + c][y + d].getPiece() != 5 && board[x + c][y + d].getPiece() != 0) && (board[x + c][y + d].isWhite() || !board[x + c][y + d].isWhite())) {
                                break;
                            }
                            if (board[x + c][y + d].getPiece() == 5 && board[x + c][y + d].isWhite()) {
                                return true;
                            }
                            c--;
                            d++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int e = -1, f = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + e][y + f].getPiece() != 5 && board[x + e][y + f].getPiece() != 0) && (board[x + e][y + f].isWhite() || !board[x + e][y + f].isWhite())) {
                                break;
                            }
                            if (board[x + e][y + f].getPiece() == 5 && board[x + e][y + f].isWhite()) {
                                return true;
                            }
                            e--;
                            f--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    try {
                        int g = 1, h = -1;
                        for (int cnt = 0; cnt < 8; cnt++) {
                            if ((board[x + g][y + h].getPiece() != 5 && board[x + g][y + h].getPiece() != 0) && (board[x + g][y + h].isWhite() || !board[x + g][y + h].isWhite())) {
                                break;
                            }
                            if (board[x + g][y + h].getPiece() == 5 && board[x + g][y + h].isWhite()) {
                                return true;
                            }
                            g++;
                            h--;
                        }
                    } catch (ArrayIndexOutOfBoundsException ao) {

                    }
                    break;
            }
        }
        return false;
    }

    public boolean checkMate(int x, int y, int who) {
        int in1 = 1, in2 = 0;
        int in3 = -1, in4 = 0;
        int in5 = 0, in6 = 1;
        int in7 = 0, in8 = -1;
        int in9 = -1, in10 = 1;
        int in11 = -1, in12 = -1;
        int in13 = 1, in14 = -1;
        int in15 = 1, in16 = 1;
        int possibleWhite = 0;
        int possibleBlk = 0;
        if (who == 0) {
            if (!checkWhiteKing(x + in1, y + in2) && board[x + in1][y + in2].isEmpty()) {
                possibleWhite++;
            }
            if (!checkWhiteKing(x + in3, y + in4) && board[x + in3][y + in4].isEmpty()) {
                possibleWhite++;
            }
            if (!checkWhiteKing(x + in5, y + in6) && board[x + in5][y + in6].isEmpty()) {
                possibleWhite++;
            }
            if (!checkWhiteKing(x + in7, y + in8) && board[x + in7][y + in8].isEmpty()) {
                possibleWhite++;
            }
            if (!checkWhiteKing(x + in9, y + in10) && board[x + in9][y + in10].isEmpty()) {
                possibleWhite++;
            }
            if (!checkWhiteKing(x + in11, y + in12) && board[x + in11][y + in12].isEmpty()) {
                possibleWhite++;
            }
            if (!checkWhiteKing(x + in13, y + in14) && board[x + in13][y + in14].isEmpty()) {
                possibleWhite++;
            }
            if (!checkWhiteKing(x + in15, y + in16) && board[x + in15][y + in16].isEmpty()) {
                possibleWhite++;
            }
        } else if (who == 1) {
            if (!checkBlackKing(x + in1, y + in2) && board[x + in1][y + in2].isEmpty()) {
                possibleBlk++;
            }
            if (!checkBlackKing(x + in3, y + in4) && board[x + in3][y + in4].isEmpty()) {
                possibleBlk++;
            }
            if (!checkBlackKing(x + in5, y + in6) && board[x + in5][y + in6].isEmpty()) {
                possibleBlk++;
            }
            if (!checkBlackKing(x + in7, y + in8) && board[x + in7][y + in8].isEmpty()) {
                possibleBlk++;
            }
            if (!checkBlackKing(x + in9, y + in10) && board[x + in9][y + in10].isEmpty()) {
                possibleBlk++;
            }
            if (!checkBlackKing(x + in11, y + in12) && board[x + in11][y + in12].isEmpty()) {
                possibleBlk++;
            }
            if (!checkBlackKing(x + in13, y + in14) && board[x + in3][y + in14].isEmpty()) {
                possibleBlk++;
            }
            if (!checkBlackKing(x + in15, y + in16) && board[x + in15][y + in16].isEmpty()) {
                possibleBlk++;
            }
        }
        if (possibleWhite == 0) {
            JOptionPane.showMessageDialog(null, "Checkmate! White wins");
            return true;
        }
        if (possibleBlk == 0) {
            JOptionPane.showMessageDialog(null, "Checkmate! Black wins");
            return true;
        }
        return false;
    }

    public void invalidMove(Tile selected, int x1, int y1, int x2, int y2) {
        board[x][y].setWhite(selected.isWhite());
        board[x][y].setPiece(selected.getPiece());
        board[x2][y2].setPiece(0);
        board[x2][y2].setEmpty(false);

    }
    public void checkPromotion(int x, int y) {
        boolean valid = false;
        if (board[x][y].isWhite() && y == 7) {
            do {
                try {
                    do {
                        promoteChoice = (String) JOptionPane.showInputDialog(null, "Congrats! Your pawn is promoted", "Promotion", JOptionPane.PLAIN_MESSAGE, null, option, " ");
                    } while (promoteChoice.equals(" "));
                    valid = true;
                } catch (NullPointerException n) {
                    JOptionPane.showMessageDialog(null, "Please choose a valid input");
                }
            } while (!valid);
            switch (promoteChoice) {
                case "Rook":
                    board[x][y].setPiece(2);
                    break;
                case "Horse":
                    board[x][y].setPiece(3);
                    break;
                case "Bishop":
                    board[x][y].setPiece(4);
                    break;
                case "Queen":
                    board[x][y].setPiece(5);
                    break;
            }
        } else if (!board[x][y].isWhite() && y == 0) {
            do {
                try {
                    do {
                        promoteChoice = (String) JOptionPane.showInputDialog(null, "Congrats! Your pawn is promoted", "Promotion", JOptionPane.PLAIN_MESSAGE, null, option, " ");
                    } while (promoteChoice.equals(" "));
                    valid = true;
                } catch (NullPointerException n) {
                    JOptionPane.showMessageDialog(null, "Please choose a valid input");
                }
            } while (!valid);
            switch (promoteChoice) {
                case "Rook":
                    board[x][y].setPiece(2);
                    break;
                case "Horse":
                    board[x][y].setPiece(3);
                    break;
                case "Bishop":
                    board[x][y].setPiece(4);
                    break;
                case "Queen":
                    board[x][y].setPiece(5);
                    break;
            }
        }
    }

    public void showMove(String move) {
        MRM.moveField.setText(move);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == MGB.wCastling) {
            castle(0);
            JOptionPane.showMessageDialog(null, "White Castling!");
            turn = 1;
            MGB.wCastling.setEnabled(false);
            resetBoard(1);
            checkCastling(1);
        } else if (actionEvent.getSource() == MGB.bCastling) {
            castle(1);
            JOptionPane.showMessageDialog(null, "Black Castling!");
            turn = 0;
            MGB.bCastling.setEnabled(false);
            resetBoard(0);
            checkCastling(0);
        } else {
            if (clicks == 0) {
                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        if (actionEvent.getSource() == board[x][y]) //board[x][y] was clicked
                        {
                            selected = board[x][y];
                            clicks++;
                            move(selected, x, y, this.turn);
                            fX = x;
                            fY = y;
                        }
                    }
                }
            } else if (clicks == 1) {
                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        if (actionEvent.getSource() == board[x][y]) //board[x][y] was clicked
                        {
                            if (board[x][y] == selected) {
                                clicks--;
                                resetBoard(turn);
                            } else if (board[x][y] != selected) {
                                displace(selected, x, y, fX, fY, turn);
                                clicks--;
                                resetBoard(turn);
                                selected = null;
                            }
                        }
                    }
                }
            }
        }
    }
}
