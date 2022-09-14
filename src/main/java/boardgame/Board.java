/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boardgame;

/**
 *
 * @author GCM_02
 */
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardExecption("Erro creat board: there must be at least 1 row an 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column)){
            throw new BoardExecption("Position not on de board");
        }
        return pieces[row][column];

    }

    public Piece piece(Position position) {
        if(!positionExists(position)){
            throw new BoardExecption("Position not on de board");
        }
        return pieces[position.getRow()][position.getColumn()];

    }

    public void placePiece(Piece piece, Position position) {
        if(thereIsApice(position)){
            throw new BoardExecption("There is already a piece on pisition " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsApice(Position position) {
         if(!positionExists(position)){
            throw new BoardExecption("Position not on de board");
        }
        return piece(position) != null;
    }
}
