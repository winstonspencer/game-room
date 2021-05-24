package com.gameroom;

import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity{

	private List<Team> teams;

	/**
	 * The Game constructor creates a new <code>Game</code> object
	 * with the specified id and name.
	 *
	 * @param id The player ID
	 * @param name The player name.
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	 * Adds a new <code>Team</code> to the list of teams.
	 *
	 * @param name the team name.
	 * @return the newly added team.
	 */
	public Team addTeam(String name) {
		final Team t = new Team(GameService.getInstance().getNextTeamId(), name);
		this.teams.add(t);
		return t;
	}


	/**
	 * The string representation of the <code>Game</code> object.
	 * @return the string representation of the <code>Game</code> object.
	 */
	@Override
	public String toString(){
		return super.toString();
	}

}
