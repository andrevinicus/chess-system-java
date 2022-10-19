/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package apllication;

import chess.ChessExeption;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.println("Source");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.println("Target");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capituredPiece = chessMatch.perfomChessMove(source, target);
                
                if(capituredPiece != null){
                    captured.add(capituredPiece);
                }
            } catch (ChessExeption e) {
                System.out.println(e.getMessage());
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
 
}
