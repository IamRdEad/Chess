package com.rdead.chess.game;

import com.rdead.chess.chessLogic.Board;
import com.rdead.chess.chessLogic.Pieces.Piece;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Game {
    private Player playerWhite;
    private Player playerBlack;
    private Board board;
    private int turn;
    private boolean vsPlayer;

    public Game(String playerWhite, String playerBlack, int code, boolean vsPlayer) {
        this.playerWhite = new Player(playerWhite, "white");
        this.playerBlack = new Player(playerBlack, "black");
        this.board = new Board(code);
        this.turn = 0;
        this.vsPlayer = vsPlayer;
    }

    public boolean handleGame(int row, int col, int newRow, int newCol){
        if(vsPlayer){
            return playerHandle(row, col, newRow, newCol);
        }
        else{
            return computerHandle(row, col, newRow, newCol);
        }
    }

    private boolean computerHandle(int row, int col, int newRow, int newCol) {
        Piece piece = board.getPiece(row, col);
        if(piece == null || piece.getColor().equals("black"))
            return false;

        String isPieceInNewPlace = board.getPiece(newRow, newCol) == null? "E" : board.getPiece(newRow, newCol).getType();
        String move = row + String.valueOf(col) + newRow + newCol + isPieceInNewPlace;
        List<String> possibleMoves = piece.possibleMoves();
        if(possibleMoves.contains(move)){
            board.makeMove(move);
            piece.setNewPlace(newRow, newCol);
            List<String> moves = board.allMoves("black");
            int rnd = (int) (Math.random() * moves.size());
            String computerMove = moves.get(rnd);
            System.out.println("computer move is: " + computerMove);
            int fromComRow = Character.getNumericValue(computerMove.charAt(0));
            int fromComCol = Character.getNumericValue(computerMove.charAt(1));
            int toComRow = Character.getNumericValue(computerMove.charAt(2));
            int toComCol = Character.getNumericValue(computerMove.charAt(3));
            Piece comPiece = board.getPiece(fromComRow, fromComCol);
            board.makeMove(computerMove);
            System.out.println("computer piece is: " + comPiece);
            comPiece.setNewPlace(toComRow, toComCol);
            return true;
        }
        return false;
    }

    private boolean playerHandle(int row, int col, int newRow, int newCol) {
        return true;
    }
}
