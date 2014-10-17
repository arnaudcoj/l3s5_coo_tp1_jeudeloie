package jeudeloie.cell;

import jeudeloie.*;

/**
 * Abstract class representing the average behaviour of the Cells in the goose
 * game. Note that there can be only one player by cell.
 * 
 * @author Cojez Arnaud
 */
public abstract class AbstractCell implements Cell {

	// Attributes

	protected int index;
	protected Player player;

	// Methods

	/**
	 * Constructor for the AbstractCell class
	 * 
	 * @param index
	 *            integer representing the index of the Cell on the Board
	 */
	public AbstractCell(int index) {
		this.index = index;
		this.player = null;
	}

	/**
	 * Indicates if a player occupying this cell can, at this turn, leave the
	 * cell
	 * 
	 * @return true if and only if the player in this cell can freely leaves the
	 *         cell at this turn
	 */
	public boolean canBeLeftNow() {
		return true;
	}

	/**
	 * Indicates if a cell holds a player until another player reaches the same
	 * cell
	 * 
	 * @return true if and only if the only way for a player to get out of this
	 *         cell is for another player to replace him
	 */
	public boolean isRetaining() {
		return false;
	}

	/**
	 * Indicates the position in the board of this cell
	 * 
	 * @return a number greater than or equal to 0 (for the starting cell only).
	 */
	public int getIndex() {
		return this.index;
	}
	
	/**
	 * Return the player which is on the cell.
	 * @return the player which is on the cell.
	 */
	public Player getPlayer() {
		return this.player ; 
	}

	/**
	 * Returns the index of the cell really reached by a player when he reaches
	 * this cell. For normal cells, the returned value equals
	 * <code>getIndex()</code> and is thus independent from
	 * <code>diceThrow</code>.
	 * 
	 * @param diceThrow
	 *            the result of the dice when the player reaches this cell
	 * 
	 * @return the index of the cell effectively reached when a player reaches
	 *         this cell after the given throw of dice
	 */
	public int handleMove(int diceThrow) {
		return this.getIndex();
	}

	/**
	 * Remembers <code>player</code> to be in this cell
	 * 
	 * @param player
	 *            the new player in this cell
	 **/
	public void welcome(Player player) {
		this.player = player;
	}

	/**
	 * Makes the actual <code>player</code> leave the cell
	 */
	public void eject(Player player) {
		this.player = null;
	}
	
	/**
	 * Returns true if there is a player on the cell
	 * @return true if there is a player on the cell
	 */
	public boolean isBusy() {
		return !(this.player == null);
	}
}
