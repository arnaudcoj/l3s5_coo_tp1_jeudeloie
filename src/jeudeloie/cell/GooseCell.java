package jeudeloie.cell;

/**
 * Class representing the Goose Cell in the goose game. When a player reaches
 * this cell, he can move again as much as the dice throw.
 * 
 * @author Cojez Arnaud
 */
public class GooseCell extends AbstractCell {

	// Methods

	/**
	 * Constructor for the GooseCell class
	 * 
	 * @param index
	 *            integer representing the index of the Cell on the Board
	 */
	public GooseCell(int index) {
		super(index);
	}

	/**
	 * Returns the index of the cell really reached by a player when he reaches
	 * this cell. The returned value equals <code>diceThrow</code>.
	 * 
	 * @param diceThrow
	 *            the result of the dice when the player reaches this cell
	 * 
	 * @return the index of the cell effectively reached when a player reaches
	 *         this cell after the given throw of dice
	 */
	@Override
	public int handleMove(int diceThrow) {
		return (diceThrow);
	}

	@Override
	public String toString() {
		return "Goose cell " + this.getIndex();
	}
	
}
