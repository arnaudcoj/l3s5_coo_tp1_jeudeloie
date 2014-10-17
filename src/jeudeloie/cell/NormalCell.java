package jeudeloie.cell;

/**
 * Class representing the Normal Cells in the goose game. Note that there can be
 * only one player by cell.
 * 
 * @author Cojez Arnaud
 */
public class NormalCell extends AbstractCell {

	// Methods

	/**
	 * Constructor for the NormalCell class
	 * 
	 * @param index
	 *            integer representing the index of the Cell on the Board
	 */
	public NormalCell(int index) {
		super(index);
	}
	
	public String toString() {
		return "Normal cell " + this.getIndex();
	}
}
