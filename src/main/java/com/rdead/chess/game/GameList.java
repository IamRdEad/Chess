package com.rdead.chess.game;

import java.util.HashMap;

public class GameList {
    private static final HashMap<Integer, Game> gameList = new HashMap<>();
    private static int gameId = 1;

    public static int addGame(Game game){
        gameList.put(gameId, game);
        gameId++;
        return gameId-1;
    }

    public static Game getGameById(Integer gameId) throws RuntimeException{
        if (gameList.containsKey(gameId)){
            return gameList.get(gameId);
        }
        else{
            throw  new RuntimeException("game id doesnt exist");
        }
    }
}
