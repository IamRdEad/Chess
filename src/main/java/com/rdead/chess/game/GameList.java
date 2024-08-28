package com.rdead.chess.game;

import java.util.HashMap;

public class GameList {
    private static final HashMap<Integer, Game> gameList = new HashMap<>();
    private static int gameId = 1;

    public static void addGame(Game game){
        gameList.put(gameId, game);
        gameId++;
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
