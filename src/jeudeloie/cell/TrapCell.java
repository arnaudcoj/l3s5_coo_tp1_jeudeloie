package jeudeloie.cell;

/**
 * Class representing the Wait Cell in the goose game.
 * This cell makes the player wait for another player to trade their positions.
 * That's the only for a player to leave a Trap Cell.
 * @author Cojez Arnaud
 */
public class TrapCell extends AbstractCell {

	//Methods
	
	/**
	 * Constructor for the TrapCell class
	 * @param index
	 * 		integer representing the index of the Cell on the board
	 */
	public TrapCell(int index) {
		super(index);
	}

	/**
	 * Indicates if a player occupying this cell can, at this turn, leave the cell
	 * 
	 * @return true if and only if the player in this cell can freely leaves the cell at this turn
	 */
	@Override
	public boolean canBeLeftNow() {
		return false;
	}
	
	/**
	 * Indicates if a cell holds a player until another player reaches the same cell
	 * 
	 * @return true if and only if the only way for a player to get out of this cell is for another player to replace him
	 */
	@Override
	public boolean isRetaining() {
		return true;
	}
	
	public String toString() {
		return "Trap cell " + this.getIndex();
	}
}
