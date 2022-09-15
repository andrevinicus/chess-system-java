/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Position;

/**
 *
 * @author GCM_02
 */
public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessExeption("Error istantiating ChessPossition. Valid values are from A1 to H8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    protected Position toPosition(){
        return new Position(8 - row, 8 - column);
    }
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()), '8' - position.getRow());
    }
    @Override
    public String toString(){
        return "" + column + row;
    }
}
