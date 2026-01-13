package chess;

import boardgame.Board;
import boardgame.BoardException;
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
        setPiece(new King(board, Color.BLACK),'e', 1);
        setPiece(new Rook(board, Color.BLACK), 'd', 1);
        setPiece(new Rook(board, Color.BLACK), 'd', 2);
        setPiece(new Rook(board, Color.BLACK), 'f', 2);
        setPiece(new Rook(board, Color.BLACK), 'f', 1);
        setPiece(new Rook(board, Color.BLACK), 'e', 2);

        setPiece(new King(board, Color.WHITE), 'e', 8);
        setPiece(new Rook(board, Color.WHITE), 'f', 8);
        setPiece(new Rook(board, Color.WHITE), 'd', 8);
        setPiece(new Rook(board, Color.WHITE), 'd', 7);
        setPiece(new Rook(board, Color.WHITE), 'f', 7);
        setPiece(new Rook(board, Color.WHITE), 'e', 7);
    }

    private void setPiece(ChessPiece piece, char column, int row){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        validadeSourcePosition(sourcePosition.toPosition(), targetPosition.toPosition());
        makeMove(sourcePosition.toPosition(), targetPosition.toPosition());
    }

    private boolean validadeSourcePosition(Position sourcePosition, Position targetPosition){
        if (board.positionExists(sourcePosition) && board.positionExists(targetPosition)){
            return true;
        } else{
            throw new BoardException("Posições inválidas");
        }
    }

    private void makeMove(Position sourcePosition, Position targetPosition){
        if (board.thereIsAPiece(targetPosition)){
            board.removePiece(targetPosition);
            board.placePiece(board.piece(sourcePosition), targetPosition);
            board.removePiece(sourcePosition);
        }else{
            board.placePiece(board.piece(sourcePosition), targetPosition);
            board.removePiece(sourcePosition);
        }
    }
}