package application;

import chess.ChessMatch;

public class Program{
    public static void main() {

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}