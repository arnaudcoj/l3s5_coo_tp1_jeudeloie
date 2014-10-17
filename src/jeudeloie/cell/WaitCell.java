package jeudeloie.cell;

import jeudeloie.Player;
import jeudeloie.cell.AbstractCell;

/**
 * Class representing the Wait Cell in the goose game.
 * This cell makes the player wait a previously defined amount of turns before he can leave.
 * @author Cojez Arnaud
 */
public class WaitCell extends AbstractCell {
	
	//Attributes
	
	private final int maxTurns;
	private int turnsRemaining;

	//Methods
	
	/**
	 * Constructor for the WaitCell class
	 * @param index
	 * 		integer representing the index of the cell on the board
	 * @param maxTurns
	 * 		integer representing the number of turns the player will have to wait.
	 */
	public WaitCell(int index, int maxTurns) {
		super(index);
		this.maxTurns = maxTurns;
		this.turnsRemaining = maxTurns;
	}

	/**
	 * Returns the amount of turns for the player to wait
	 * @return the turns remaining
	 */
	public int getTurnsRemaining() {
		return this.turnsRemaining;
	}
	
	/**
	 * Indicates if a player occupying this cell can, at this turn, leave the cell
	 * Each call to this function decrease the turnsRemaining counter
	 * @return true if and only if the player in this cell can freely leaves the cell at this turn
	 */
	@Override
	public boolean canBeLeftNow() {
		return this.turnsRemaining-- <= 0;
	}

	/**
	 * resets the turnsRemaining counter to maxTurns
	 */
	private void resetTurns()
	{
		this.turnsRemaining = this.maxTurns;
	}
	
	/**
	 * Makes the actual <code>player</code> leave the cell
	 * Also resets the turnsRemaining counter
	 */
	@Override
	public void eject(Player player) {
		super.eject(player);
		this.resetTurns();
	}
	
	public String toString() {
		return "Wait cell " + this.getIndex();
	}

}
