package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[board.getRows()][board.getColums()];
        Position left = new Position(position.getRow() ,position.getColumn() - 1);
        Position right = new Position(position.getRow() ,position.getColumn() + 1);
        Position up = new Position(position.getRow() + 1 , position.getColumn());
        Position down = new Position(position.getRow() - 1 , position.getColumn());
        while(board.positionExists(left)){
            mat[left.getRow()][left.getColumn()] = true;
            left.setValues(left.getRow(), left.getColumn() - 1);
        }
        while(board.positionExists(right)){
            mat[right.getRow()][right.getColumn()] = true;
            right.setValues(right.getRow(), right.getColumn() + 1);
        }
        while(board.positionExists(up)){
            mat[up.getRow()][up.getColumn()] = true;
            up.setValues(up.getRow() + 1, up.getColumn());
        }
        while(board.positionExists(down)){
            mat[down.getRow()][down.getColumn()] = true;
            down.setValues(down.getRow() - 1, down.getColumn());
        }
        return mat;
    }
}
