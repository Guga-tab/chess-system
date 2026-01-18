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

        while (board.positionExists(left)) {
            if (canMove(left)) {
                mat[left.getRow()][left.getColumn()] = true;
            }
            if (board.thereIsAPiece(left)) break;
            left.setValues(left.getRow(), left.getColumn() - 1);
        }

        while (board.positionExists(right)) {
            if (canMove(right)) {
                mat[right.getRow()][right.getColumn()] = true;
            }
            if (board.thereIsAPiece(right)) break;
            right.setValues(right.getRow(), right.getColumn() - 1);
        }

        while (board.positionExists(down)) {
            if (canMove(down)) {
                mat[down.getRow()][down.getColumn()] = true;
            }
            if (board.thereIsAPiece(down)) break;
            down.setValues(down.getRow(), down.getColumn() - 1);
        }

        while (board.positionExists(up)) {
            if (canMove(up)) {
                mat[up.getRow()][up.getColumn()] = true;
            }
            if (board.thereIsAPiece(up)) break;
            up.setValues(up.getRow(), up.getColumn() - 1);
        }
        return mat;
    }
}
