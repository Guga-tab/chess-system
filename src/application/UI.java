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
        for (int i = 0; i <= qtRow; i++) {
            if(i == 8){
                System.out.println("  a b c d e f g h");
                break;
            }
            System.out.print(i + 1 + " ");
            for (int j = 0; j < qtColumns; j++) {
                if (board.piece(i, j) != null){
                    //Lógica para imprimir o Símbolo/Letra da peça
                    System.out.print("P ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

}