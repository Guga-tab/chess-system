package application;

import boardgame.Board;


public class UI {
    private Board board;

    public UI(Board board) {
        this.board = board;
    }

    public void print(){
        int qtRow = board.getRows();
        int qtColumns = board.getColums();
        for (int i = 0; i < qtRow; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < qtColumns; j++) {
                if (board.piece(i, j) != null){
                    System.out.print("P ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

}