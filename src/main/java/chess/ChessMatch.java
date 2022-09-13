/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Board;

/**
 *
 * @author GCM_02
 */
public class ChessMatch {
    private Board board;
    
    public ChessMatch(){
        board = new Board(8,8);
    }
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
       for(int i=0; i<board.getRows(); i++){
           for (int j = 0; j < board.getColumns(); j++) {
               mat[i][j] = (ChessPiece) board.piece(i,j);
               
           }
       }
       return mat;
    } 
}
