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

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    private void placeNewPiece(ChessPiece piece, char column, int row){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        return (ChessPiece) capturedPiece;
    }

    private void validateSourcePosition(Position sourcePosition){
        if (!board.thereIsAPiece(sourcePosition)) {
            throw new ChessException("There is no piece on source position");
        }
        if (!board.piece(sourcePosition).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece");
        }

        ChessPiece piece = (ChessPiece) board.piece(sourcePosition);

        if (piece.getColor() != currentPlayer) {
            throw new ChessException("A peça escolhida não é sua");
        }
    }

    private void validateTargetPosition(Position source, Position target){
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return  capturedPiece;
    }

    private void changePlayer(){
        if (currentPlayer == Color.WHITE){
            currentPlayer = Color.BLACK;
        } else {
            currentPlayer = Color.WHITE;
        }
    }

    private void initialSetup(){
        placeNewPiece(new King(board, Color.BLACK),'e', 8);
        placeNewPiece(new Rook(board, Color.BLACK), 'd', 8);
        placeNewPiece(new Rook(board, Color.BLACK), 'd', 7);
        placeNewPiece(new Rook(board, Color.BLACK), 'f', 8);
        placeNewPiece(new Rook(board, Color.BLACK), 'f', 7);
        placeNewPiece(new Rook(board, Color.BLACK), 'e', 7);

        placeNewPiece(new King(board, Color.WHITE), 'e', 1);
        placeNewPiece(new Rook(board, Color.WHITE), 'f', 1);
        placeNewPiece(new Rook(board, Color.WHITE), 'd', 2);
        placeNewPiece(new Rook(board, Color.WHITE), 'd', 1);
        placeNewPiece(new Rook(board, Color.WHITE), 'f', 2);
        placeNewPiece(new Rook(board, Color.WHITE), 'e', 2);
    }
}