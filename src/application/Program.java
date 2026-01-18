package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program{
    public static void main() {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());

                System.out.print("Source: ");
                String pos = sc.next();
                ChessPosition source = UI.readChessPosition(pos);

                System.out.print("Target: ");
                pos = sc.next();
                ChessPosition target = UI.readChessPosition(pos);

                chessMatch.performChessMove(source, target);
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}