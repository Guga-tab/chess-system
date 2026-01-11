package boardgame;

import chess.exceptions.BoardException;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows > 0 && columns > 0) {
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
        } else {
            throw new BoardException("Dimensões do tabuleiro inválidas");
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColums() {
        return columns;
    }

    public void setColums(int columns) {
        this.columns = columns;
    }

    // Buscar uma peça do Board através da linha e coluna
    public Piece piece(int row, int columns){
        Position position = new Position(row, columns);
        return piece(position);
    }

    // Buscar uma peça do Board através da classe Position
    public Piece piece(Position position){
        if (positionExists(position)){
            return pieces[position.getRow()][position.getColumn()];
        } else{
            throw new BoardException("Posição inválida");
        }
    }

    // Coloca uma peça no tabuleiro
    public void placePiece(Piece piece, Position position){
        if(!thereIsAPiece(position)){
            if (positionExists(position)){
                pieces[position.getRow()][position.getColumn()] = piece;
                piece.position = position;
            } else{
                throw new BoardException("Posição inválida");
            }
        }else{
            throw new BoardException("Há uma peça nessa posição");
        }
    }

    // Verifica se a posição informada é válida
    public boolean positionExists(Position position){
        if(
            (position.getRow() <= rows - 1 && position.getColumn() <= columns - 1) &&
            (position.getRow() >= 0 && position.getColumn() >= 0)
        ){
            return true;
        }else{
            return false;
        }
    }

    // Verifica se há uma peça nesta posição
    public boolean thereIsAPiece(Position position){
        if(positionExists(position)){
            if (piece(position) != null){
                return true;
            } else {
                return false;
            }
        }else{
            throw new BoardException("Posição inválida");
        }
    }
}
