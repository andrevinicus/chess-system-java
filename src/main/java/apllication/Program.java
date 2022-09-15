/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package apllication;

import chess.ChessMatch;

/**
 *
 * @author GCM_02
 */
public class Program {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ChessMatch chessmath = new ChessMatch();
        UI.printBoard(chessmath.getPieces());

    }
}
