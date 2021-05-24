package com.gameroom;

/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 *
 * @author coce@snhu.edu
 */
public class Player extends Entity {

    /**
     * The Player constructor creates a new <code>Player</code> object
     * with the specified id and name.
     *
     * @param id The player ID
     * @param name The player name.
     */
    public Player(long id, String name) {
        super(id, name);
    }

    /**
     * The string representation of the <code>Player</code> object.
     *
     * @return the string representation of the <code>Player</code> object
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
