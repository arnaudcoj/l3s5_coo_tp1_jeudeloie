package jeudeloie.cell;

import jeudeloie.Cell;
import jeudeloie.Player;
import java.util.List;
import java.util.LinkedList;

/**
 * Class representing the Start Cell in the goose game.
 * Note that there can be more than 1 player in this cell.
 * @author Cojez Arnaud
 */
public class StartCell implements Cell {

	//Attributes
	private List<Player> players;

	//Methods

	/**
	 * Constructor for the StartCell class
	 * @param index
	 * 		integer representing the index of the cell on the board 
	 */
	public StartCell() {
		this.players = new LinkedList<Player>();
	}

	/**
	 * Indicates if a player occupying this cell can, at this turn, leave the
	 * cell.
	 *
	 * @return true if and only if the player in this cell can freely leaves the
	 * cell at this turn
	 */
	public boolean canBeLeftNow() {
		return true;
	}

	/**
	 * Indicates if a cell holds a player until another player reaches the same
	 * cell.
	 *
	 * @return true if and only if the only way for a player to get out of this
	 * cell is for another player to replace him
	 */
	public boolean isRetaining() {
		return false;
	}

	/**
	 * Indicates the position in the board of this cell.
	 *
	 * @return 0 (the start cell has to be the first cell).
	 */
	public int getIndex() {
		return 0;
	}
	
	/**
	 * Returns the index of the cell really reached by a player when he reaches
	 * this cell. For normal cells, the returned value equals
	 * <code>getIndex()</code> and is thus independent from
	 * <code>diceThrow</code>.
	 *
	 * @param diceThrow
	 * the result of the dice when the player reaches this cell
	 * @return the index of the cell effectively reached when a player reaches
	 * this cell after the given throw of dice
	 */
	public int handleMove(int diceThrow) {
		return getIndex();
	}

	/**
	* Returns the players currently occupying this cell, <code>null</code> if
	* none.
	*
	* @return the players currently in this cell, <code>null</code> if none.
	*/
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	* Remembers <code>player</code> to be in this cell.
	*
	* @param player
	* the new player in this cell
	*/
	public void welcome(Player player) {
		this.players.add(player);
	}

	/**
	 * Makes <code>player</code> leave the cell
	 */
	public void eject(Player player) {
		this.players.remove(player);
	}

	@Override
	public boolean isBusy() {
		return false;
	}
	
	public String toString() {
		return "Start cell";
	}
}
