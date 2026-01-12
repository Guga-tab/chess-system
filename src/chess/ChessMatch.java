package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColums()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColums(); j++) {
                //ChessPiece - //Piece
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void initialSetup(){
        setPiece(new King(board, Color.BLACK), 'd', 8);
        setPiece(new King(board, Color.WHITE),'d', 1);
        setPiece(new Rook(board, Color.WHITE), 'a', 1);
        setPiece(new Rook(board, Color.WHITE), 'h', 1);
        setPiece(new Rook(board, Color.BLACK), 'a', 8);
        setPiece(new Rook(board, Color.BLACK), 'h', 8);
    }

    private void setPiece(ChessPiece piece, char column, int row){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
}