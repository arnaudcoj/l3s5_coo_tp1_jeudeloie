package jeudeloie.cell;

import jeudeloie.Cell;

/**
 * Class representing the Teleporting Cell in the goose game.
 * This cell teleports the player who reached it to an other cell, defined previously.
 * @author Cojez Arnaud
 */
public class TeleportCell extends AbstractCell {

	private Cell targetCell;
	/**
	 * @param index
	 */
	public TeleportCell(int index, Cell targetCell) {
		super(index);
		this.targetCell = targetCell;
	}
	
	/**
	 * Returns the index of the cell realy reached by a player when he reaches this cell. For normal cells, the returned value equals
	 * <code>getIndex()</code> and is thus independent from
	 * <code>diceThrow</code>.
	 * 
	 * @param diceThrow
	 * 		the result of the dice when the player reaches this cell
	 * 
	 * @return the index of the cell effectively reached when a player reaches this cell after the given throw of dice
	 */	
	@Override
	public int handleMove(int diceThrow) {
		return this.targetCell.getIndex();
	}
	
	public String toString() {
		return "Teleport cell " + this.getIndex();
	}
}
