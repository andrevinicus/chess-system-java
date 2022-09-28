/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package apllication;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        ChessMatch chessmath = new ChessMatch();
        
        while (true) {

            UI.printBoard(chessmath.getPieces());
            System.out.println();
            System.out.println("Source");
            ChessPosition source = UI.readChessPosition(sc);
            
            System.out.println();
            System.out.println("Target");
            ChessPosition target = UI.readChessPosition(sc);
            
            ChessPiece capiturePiece = ChessMatch.performChessMove(source, target);

        }
    }
}