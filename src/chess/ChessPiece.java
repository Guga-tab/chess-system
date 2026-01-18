package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    protected Board board;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position){
        Piece p = board.piece(position);
        return p != null && ((ChessPiece) p).getColor() != this.getColor();
    }

    //Verifica se a posição é válida E se há ou não uma peça na posição OU se é oponente
    protected boolean canMove(Position position) {
        return board.positionExists(position) &&
                (!board.thereIsAPiece(position) || isThereOpponentPiece(position));
    }

    @Override
    public abstract String toString();
}
