package chess;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerabe;
    private ChessPiece promoted;

    public ChessMatch(int turn, Color currentPlayer, boolean check, boolean checkMate, ChessPiece enPassantVulnerabe, ChessPiece promoted) {
        this.turn = turn;
        this.currentPlayer = currentPlayer;
        this.check = check;
        this.checkMate = checkMate;
        this.enPassantVulnerabe = enPassantVulnerabe;
        this.promoted = promoted;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheckMate() {
        return checkMate;
    }

    public void setCheckMate(boolean checkMate) {
        this.checkMate = checkMate;
    }

    public ChessPiece getEnPassantVulrabe() {
        return enPassantVulnerabe;
    }

    public void setEnPassantVulrabe(ChessPiece enPassantVulnerabe) {
        this.enPassantVulnerabe = enPassantVulnerabe;
    }

    public ChessPiece getPromoted() {
        return promoted;
    }

    public void setPromoted(ChessPiece promoted) {
        this.promoted = promoted;
    }
}
