package com.gameroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 *
 * @author coce@snhu.edu
 */
public class GameService {

    /**
     * A list of the active games
     */
    private static List<Game> games = new ArrayList<Game>();

    /*
     * Holds the next game identifier
     */
    private static long nextGameId = 1;

    /*
     * Holds the single instance of the <code>GameService</code> object.
     */
    private static final GameService gameService = new GameService();

    /*
     * Instantiates a new <code>GameService</code>.
     */
    private GameService() {
        // Do nothing
    }

    /**
     * Construct a new game instance
     *
     * @param name the unique name of the game
     * @return the game instance (new or existing)
     */
    public Game addGame(String name) {

        // Create local game instance
		// Use iterator to look for existing game with same name
        Game game = this.getGame(name);

        // if not found, make a new game instance and add to list of games
        if (game == null) {
            game = new Game(nextGameId++, name);
            games.add(game);
        }

        // return the new/existing game instance to the caller
        return game;
    }

    /**
     * Returns the game instance at the specified index.
     * <p>
     * Scope is package/local for testing purposes.
     * </p>
     *
     * @param index index position in the list to return
     * @return requested game instance
     */
    Game getGame(int index) {
        return games.get(index);
    }

    /**
     * Returns the game instance with the specified id.
     *
     * @param id unique identifier of game to search for
     * @return requested game instance
     */
    public Game getGame(long id) {

        // a local game instance
        Game game = null;

        // A local variable to hold the next game in the iterator
		Game savedGame = null;

		// Create a lock so that the nextGameId cannot be incremented
		// while the application is searching for a game.  This makes the
		// application thread safe.  A most efficient search will be needed
		// as the more games are saved the longer it will take to find a game.
		synchronized(this) {

			// Check of the game id is greater than nextGameId.
			// No savedGame can have an id greater than nextGameId
			if (id <= nextGameId) {

				// Get the iterator from game list.
				Iterator<Game> iter = games.iterator();

				// Loop through iterator until the game is found
				// or the iterator has no more games.
				while (iter.hasNext()) {

					// Get the next saved game
					savedGame = iter.next();

					// Check of savedGame ID is equal to the id passed in.
					if (id == savedGame.getId()) {

						// Assign that savedGame instance to the local variable game
						game = savedGame;
					}
				}
			}
		}

		// return the game to the caller.
        return game;
    }

    /**
     * Returns the game instance with the specified name.
     *
     * @param name unique name of game to search for
     * @return requested game instance
     */
    public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// A local variable to hold the next game in the iterator
		Game savedGame = null;

		// Only continue if the specified name is not null or empty or blank.
		if(null != name && !name.trim().equals("")) {

			// Get the iterator from game list.
			Iterator<Game> iter = games.iterator();

			// Loop through iterator until the game is found
			// or the iterator has no more games.
			while (iter.hasNext()) {

				// Get the next saved game
				savedGame = iter.next();

				// Check of savedGame ID is equal to the id passed in.
				if (name.equalsIgnoreCase(savedGame.getName())) {

					// Assign that savedGame instance to the local variable game
					game = savedGame;
				}
			}
		}

		// return the game to the caller.
		return game;
    }

    /**
     * Returns the number of games currently active
     *
     * @return the number of games currently active
     */
    public int getGameCount() {
        return games.size();
    }

    /**
     * Returns a single instance of the <code>GameService</code>.
     * If no instance exists one will be created.
     *
     * @return the single instance of the <code>GameService</code>.
     */
    public static final GameService getInstance(){
        return gameService;
    }
}
