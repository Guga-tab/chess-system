package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[board.getRows()][board.getColums()];
        Position left = new Position(position.getRow() ,position.getColumn() - 1);
        Position right = new Position(position.getRow() ,position.getColumn() + 1);
        Position up = new Position(position.getRow() + 1 ,position.getColumn());
        Position down = new Position(position.getRow() - 1 ,position.getColumn());
        Position leftUp = new Position(position.getRow() + 1 ,position.getColumn() - 1);
        Position rightUp = new Position(position.getRow() + 1 ,position.getColumn() + 1);
        Position leftDown = new Position(position.getRow() - 1 ,position.getColumn() - 1);
        Position rightDown = new Position(position.getRow() - 1 ,position.getColumn() + 1);

        if (canMove(left)) mat[left.getRow()][left.getColumn()] = true;
        if (canMove(right)) mat[right.getRow()][right.getColumn()] = true;
        if (canMove(up)) mat[up.getRow()][up.getColumn()] = true;
        if (canMove(down)) mat[down.getRow()][down.getColumn()] = true;
        if (canMove(leftUp)) mat[leftUp.getRow()][leftUp.getColumn()] = true;
        if (canMove(rightUp)) mat[rightUp.getRow()][rightUp.getColumn()] = true;
        if (canMove(leftDown)) mat[leftDown.getRow()][leftDown.getColumn()] = true;
        if (canMove(rightDown)) mat[rightDown.getRow()][rightDown.getColumn()] = true;

        return mat;
    }
}
