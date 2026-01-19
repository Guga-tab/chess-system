package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColums() {
        return columns;
    }

    // Buscar uma peça do Board através da linha e coluna
    public Piece piece(int row, int column){
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    // Buscar uma peça do Board através da classe Position
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    // Coloca uma peça no tabuleiro
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    //Remove um peça do tabuleiro
    public Piece removePiece(Position position){
        if(!thereIsAPiece(position)){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }


    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    // Verifica se a posição informada é válida
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    // Verifica se há uma peça nesta posição
    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
