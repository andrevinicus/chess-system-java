/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GCM_02
 */
public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Board board;
    private boolean check;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }
    public boolean getCheck(){
        return check;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);

            }
        }
        return mat;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validadeSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece perfomChessMove(ChessPosition sourcePasition, ChessPosition targetPosition) {
        Position source = sourcePasition.toPosition();
        Position target = targetPosition.toPosition();
        validadeSourcePosition(source);
        validadeTargetPosition(source, target);
        Piece caputuredPiece = makeMove(source, target);
        
        if(testeCheck(currentPlayer)){
            undoMove(source, target, caputuredPiece);
            throw new ChessExeption("You can't put yourself in check");
        }
        check = (testeCheck(opponent(currentPlayer))) ? true : false;
        
        nextTurn();
        return (ChessPiece) caputuredPiece;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        
        if(capturedPiece != null){
            piecesOnTheBoard.remove(capturedPiece);
            capturedPiece.add(capturedPiece);
        }
        
        return capturedPiece;

    }
    
    private void undoMove(Position source, Position target, Piece capturedPiece){
        Piece p = board.removePiece(target);
        board.placePiece(p, source);
        
        if(capturedPiece != null){
            board.placePiece(capturedPiece, target);
            capturedPiece.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }
    }

    private void validadeSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessExeption("There is no piece on source position");
        }
        if (currentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
            throw new ChessExeption("The chosen piece is not yours");
        }
        if (!board.piece(position).isTherePossibleMove()) {
            throw new ChessExeption("There is no possible move for the chosen piece");
        }
    }

    private void validadeTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessExeption("The chosen piece can't move to target position");
        }
    }

    private void nextTurn() {
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }
    private Color opponent(Color color){
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }
    private ChessPiece king(Color color){
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(collector.toList());
        for(Piece p : list){
            if(p instanceof King){
                return (ChessPiece)p; 
            }
        }
        throw new IllegalStateException("There is no " + color + "king of the board");
    }
    private boolean testeCheck(Color color){
        Position KiPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(collector.toList());
        for(Piece p: opponentPieces){
            boolean[][]mat = p.possibleMoves();
            if(mat[KiPosition.getRow()][KiPosition.getColumn()]){
                return true;
            }
        }
        return false;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
