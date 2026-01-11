package chess;

import boardgame.Board;
import boardgame.Piece;
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
        setPiece(new King(board, Color.BLACK), new Position(0, 4));
        setPiece(new King(board, Color.WHITE), new Position(7, 4));
        setPiece(new Rook(board, Color.WHITE), new Position(0, 0));
        setPiece(new Rook(board, Color.WHITE), new Position(0, 7));
        setPiece(new Rook(board, Color.BLACK), new Position(7, 7));
        setPiece(new Rook(board, Color.BLACK), new Position(7, 0));
    }

    private void setPiece(ChessPiece piece, Position position){
        board.placePiece(piece, position);
    }
}