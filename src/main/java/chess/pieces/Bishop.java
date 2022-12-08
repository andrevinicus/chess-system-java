/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author GCM_02
 */
public class Bishop extends ChessPiece {

    public Bishop(Board board,Color color ) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }
    @Override
    public boolean[][] possibleMoves() {
       boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
       
       Position p = new Position(0, 0);
       
       
       //Nw
       p.setValues(position.getRow() -1,position.getColumn()-1);
       while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
           mat[p.getRow()][p.getColumn()] = true;
           p.setValues(p.getRow() -1, p.getColumn() - 1);
       }
       if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
       }
        //ne
       p.setValues(position.getRow() -1 ,position.getColumn() + 1);
       while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
           mat[p.getRow()][p.getColumn()] = true;
           p.setValues(p.getRow() -1, p.getColumn() + 1);
       }
       if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
       }
         //Ne
       p.setValues(position.getRow() +1,position.getColumn() +1);
       while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
           mat[p.getRow()][p.getColumn()] = true;
           p.setValues(p.getRow() +1, p.getColumn() + 1);
       }
       if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
       }
         //nw
       p.setValues(position.getRow() +1,position.getColumn()-1);
       while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
           mat[p.getRow()][p.getColumn()] = true;
           p.setValues(p.getRow() +1 , p.getColumn() -1);
       }
       if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
       }
       return mat; 
    }
    
}
