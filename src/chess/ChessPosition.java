package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if ((column >= 'a' && column <= 'h') && (row >=1 && row <=8)) {
            this.column = column;
            this.row = row;
        }else{
            throw new ChessException("Posição de xadrez inválida!");
        }
    }

    protected static ChessPosition fromPosition(Position position){
         return new ChessPosition((char) (position.getColumn() + 'a'), position.getRow() + 1);
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
