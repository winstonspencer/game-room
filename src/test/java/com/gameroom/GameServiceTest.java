package com.gameroom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private static long testGameId;
    private final static String testGameName = UUID.randomUUID().toString();

    private void validateGame(Game game){
        assertEquals(testGameId, game.getId());
        assertEquals(testGameName, game.getName());
    }

    @BeforeAll
    static void setupGameService(){
        testGameId = GameService.getInstance().addGame(testGameName).getId();
    }

    @Test
    void addGame() {
        Game game = GameService.getInstance().addGame(UUID.randomUUID().toString());
        assertNotNull(game);
        assertTrue(game.getId() > 0);
        assertNotNull(game.getName());
    }

    @Test
    void getGame(){
        Game savedGame = GameService.getInstance().getGame(0);
        validateGame(savedGame);
    }

    @Test
    void testGetGameLong(){
        Game savedGame = GameService.getInstance().getGame(testGameId);
        validateGame(savedGame);
    }

    @Test
    void testGetGameString() {
        Game savedGame = GameService.getInstance().getGame(testGameName);
        validateGame(savedGame);
    }

    @Test
    void getGameCount() {
        assertEquals(2, GameService.getInstance().getGameCount());
    }

    @Test
    void getInstance() {
        assertNotNull(GameService.getInstance());
    }
}