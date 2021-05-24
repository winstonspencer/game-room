package com.gameroom;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 *
 * @author coce@snhu.edu
 */
public class Team extends Entity {

    private List<Player> players;

    /**
     * The Team constructor creates a new <code>Team</code> object
     * with the specified id and name.
     *
     * @param id   The player ID
     * @param name The player name.
     */
    public Team(long id, String name) {
        super(id, name);
        this.players = new LinkedList<Player>();
    }

    /**
     * Adds a new <code>Player</code> to the list of players.
     *
     * @param name the players name.
     * @return the newly added player.
     */
    public Player addPlayer(String name) {
        Player p = new Player(GameService.getInstance().getNextPlayerId(), name);
        this.players.add(p);
        return p;
    }

    /**
     * The string representation of the <code>Team</code> object.
     *
     * @return the string representation of the <code>Team</code> object.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
