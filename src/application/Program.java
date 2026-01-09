package application;

import boardgame.Board;

public class Program{
    public static void main() {
        Board board = new Board(8, 8);
        UI ui = new UI(board);

        ui.print();
    }
}