package boardgame;

import chess.ChessPiece;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] pM = possibleMoves();
        for (int i = 0; i < pM.length; i++) {
            for (int j = 0; j < pM[i].length; j++) {
                if (pM[i][j]){
                    return true;
                }
            }
        }
        return false;
    }


}