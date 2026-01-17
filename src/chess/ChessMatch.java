package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;
    private Color currentPlayer;

    public ChessMatch() {
        board = new Board(8,8);
        initialSetup();
        currentPlayer = Color.WHITE;
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
        setPiece(new King(board, Color.BLACK),'e', 8);
        setPiece(new Rook(board, Color.BLACK), 'd', 8);
        setPiece(new Rook(board, Color.BLACK), 'd', 7);
        setPiece(new Rook(board, Color.BLACK), 'f', 8);
        setPiece(new Rook(board, Color.BLACK), 'f', 7);
        setPiece(new Rook(board, Color.BLACK), 'e', 7);

        setPiece(new King(board, Color.WHITE), 'e', 1);
        setPiece(new Rook(board, Color.WHITE), 'f', 1);
        setPiece(new Rook(board, Color.WHITE), 'd', 2);
        setPiece(new Rook(board, Color.WHITE), 'd', 1);
        setPiece(new Rook(board, Color.WHITE), 'f', 2);
        setPiece(new Rook(board, Color.WHITE), 'e', 2);
    }

    private void setPiece(ChessPiece piece, char column, int row){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        validadeSourcePosition(sourcePosition.toPosition());
        ChessPiece piece = makeMove(sourcePosition.toPosition(), targetPosition.toPosition());
        changePlayer();

        return piece;
    }

    private void validadeSourcePosition(Position sourcePosition){
        if (!board.thereIsAPiece(sourcePosition)) {
            throw new ChessException("Não há peça na posição de origem");
        }

        ChessPiece piece = (ChessPiece) board.piece(sourcePosition);

        if (piece.getColor() != currentPlayer) {
            throw new ChessException("A peça escolhida não é sua");
        }

        /*if (!piece.isThereAnyPossibleMove()) {
            throw new ChessException("Não há movimentos possíveis para essa peça");
        }*/
    }

    private ChessPiece makeMove(Position sourcePosition, Position targetPosition){
            Piece piece = board.removePiece(targetPosition);
            board.placePiece(board.piece(sourcePosition), targetPosition);
            board.removePiece(sourcePosition);
            return (ChessPiece) piece;
    }

    private void changePlayer(){
        if (currentPlayer == Color.WHITE){
            currentPlayer = Color.BLACK;
        } else {
            currentPlayer = Color.WHITE;
        }
    }
}