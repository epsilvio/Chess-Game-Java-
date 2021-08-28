package PvP;

import javax.swing.*;
import java.awt.*;

public class Tile extends JButton{
    Color bgColor;
    boolean white;
    boolean empty;
    boolean captured;
    boolean checked;
    boolean castling;
    int piece;
    String coordinate;
    String name;
    Icon icon;
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

    public Tile(){
        this.setSize(new Dimension(65,65));

    }
    public void setBgColor(Color color){
        this.bgColor = color;
        this.setBackground(bgColor);
    }
    public void setWhite(boolean isWhite){
        this.white = isWhite;

    }
    public void setEmpty(boolean isEmpty){
        this.empty = isEmpty;
        if(empty){
            this.piece = 0;
            this.icon = null;
        }
    }

    public void setPiece(int pc){
        this.piece = pc;
        switch(this.piece){
            case 0:
                this.setIcon(null);
                break;
            case 1:
                if (this.isWhite()){
                    this.setIcon(wPawn);
                    this.setName("Pawn");
                    this.checked = false;
                }else{
                    this.setIcon(bPawn);
                    this.setName("Pawn");
                    this.checked = false;
                }
                break;
            case 2:
                if (this.isWhite()){
                    this.setIcon(wRook);
                    this.setName("Rook");
                    this.setCastling(true);
                }else{
                    this.setIcon(bRook);
                    this.setName("Rook");
                    this.checked = false;
                    this.setCastling(true);
                }
                break;
            case 3:
                if (this.isWhite()){
                    this.setIcon(wHorse);
                    this.setName("Horse");
                    this.checked = false;
                }else{
                    this.setIcon(bHorse);
                    this.setName("Horse");
                    this.checked = false;
                }
                break;
            case 4:
                if (this.isWhite()){
                    this.setIcon(wBishop);
                    this.setName("Bishop");
                    this.checked = false;
                }else{
                    this.setIcon(bBishop);
                    this.setName("Bishop");
                    this.checked = false;
                }

                break;
            case 5:

                if (this.isWhite()){
                    this.setIcon(wQueen);
                    this.setName("Queen");
                    this.checked = false;
                }else{
                    this.setIcon(bQueen);
                    this.setName("Queen");
                    this.checked = false;
                }

                break;
            case 6:
                if (this.isWhite()){
                    this.setIcon(wKing);
                    this.setName("King");
                    this.setChecked(false);
                    this.setCastling(true);
                }else{
                    this.setIcon(bKing);
                    this.setName("King");
                    this.setChecked(false);
                    this.setCastling(true);
                }
                break;

        }

    }
    public void setCoordinate(String coord){
        this.coordinate = coord;
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean isWhite (){

        return this.white;
    }
    public boolean isEmpty(){

        return this.empty;
    }
    public int getPiece(){
        return this.piece;
    }
    public String getCoordinate(){

        return this.coordinate;
    }
    public void setChecked(boolean check){
        this.checked = check;
    }
    public void setCastling(boolean castle){
        this.castling = castle;

    }
    public boolean checkCastle(){
        return this.castling;
    }
    public boolean isChecked(){
        return this.checked;
    }

    public void castling(){

    }

    public String getName(){
        return this.name;
    }
    public void resetColor(){
        this.setBgColor(this.bgColor);
    }


}
