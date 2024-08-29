package com.rdead.chess.chessLogic;

import com.rdead.chess.BoardForTesting;
import com.rdead.chess.BoardResponse;
import com.rdead.chess.Response;
import com.rdead.chess.chessLogic.Pieces.Piece;
import com.rdead.chess.game.Game;
import com.rdead.chess.game.GameList;
import com.rdead.chess.move.MoveRequest;
import java.util.List;

public class MoveHandler {

    public static BoardResponse checkMove(MoveRequest moveRequest){
        int fromRow = moveRequest.getFrom().getRow();
        int fromCol = moveRequest.getFrom().getCol();
        int toRow = moveRequest.getTo().getRow();
        int toCol = moveRequest.getTo().getCol();
        String username = moveRequest.getUsername();
        BoardResponse response = new BoardResponse();

        System.out.println("Received move from: (" + fromRow + ", " + fromCol + ") to (" + toRow + ", " + toCol + ")");
        System.out.println("from: " + username);

        Game game = GameList.getGameById(1);
        Board b = game.getBoard();

        Piece p = b.getPiece(fromRow, fromCol);
        if(p==null){
            response.setContent("there is no piece there");
            response.setCode(404);
            return response;
        }
        String isPieceInNewPlace = b.getPiece(toRow, toCol) == null? "E" : b.getPiece(toRow, toCol).getType();
        String newPlace = fromRow + String.valueOf(fromCol) + toRow + toCol + isPieceInNewPlace;
        List<String> possibleMoves = p.possibleMoves();

        if(possibleMoves.contains(newPlace)){
            System.out.println("move is possible");
            response.setContent("Move is possible");
            response.setCode(301);
            b.makeMove(fromRow, fromCol, toRow, toCol);
            p.setNewPlace(toRow, toCol);
            response.setBoard(b.boardToSting());
            b.printBoard();
        }
        else{
            System.out.println("move is impossible");
            response.setContent("Move is impossible");
            response.setCode(401);
        }
        return response;
    }
}
