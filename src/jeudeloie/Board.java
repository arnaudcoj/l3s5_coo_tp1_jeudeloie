package jeudeloie;

import jeudeloie.cell.AbstractCell;

/**
 * Abstract class representing a Board for the goose game.
 * 
 * @author Cojez Arnaud
 */
public abstract class Board {

	// Attributes

	protected final Cell[] cellArray;
	protected final AbstractCell endCell;

	// Methods

	/**
	 * Constructor for the AbstractCell class
	 * 
	 * @param cellArray
	 *            Array of Cells which will be placed on the board
	 */
	public Board(Cell[] cellArray) {
		this.cellArray = cellArray;
		this.endCell = (AbstractCell) cellArray[cellArray.length - 1];
	}

	/**
	 * Returns the number of Cells of the Board
	 * 
	 * @return number of Cells of the Board
	 */
	public int getSize() {
		return this.cellArray.length;
	}

	/**
	 * Returns the Cell of index <code>index</code> on the board
	 * 
	 * @param index
	 * @return the Cell of index <code>index</code>
	 */
	public Cell getCell(int index) throws IndexOutOfBoundsException {
		if (index > this.cellArray.length)
			throw new IndexOutOfBoundsException("getCell: index out of bounds");
		return this.cellArray[index];
	}

	/**
	 * Returns the "Start" Cell on the board
	 * 
	 * @return the "Start" Cell
	 */
	public Cell getStartCell() {
		return this.cellArray[0];
	}

	/**
	 * Returns the last Cell on the board
	 * 
	 * @return the last Cell
	 */
	public Cell getEndCell() {
		return this.cellArray[cellArray.length - 1];
	}

	/**
	 * Links <code>player</code> and <code>cell</code> together
	 * 
	 * @param player
	 *            the player put on the cell
	 * @param cell
	 *            the cell reached by the player
	 */
	public void putPlayerOnCell(Player player, Cell cell) {
		player.setActualCell(cell);
		cell.welcome(player);
	}
	

	/**
	 * Links <code> to the Start Cell
	 * 
	 * @param player
	 *            the player put on the cell
	 */
	public void putPlayerOnStart(Player player) {
		player.setActualCell(this.cellArray[0]);
		this.cellArray[0].welcome(player);
	}

	

	/**
	 * Swaps two players cells
	 * 
	 * @param player1
	 * @param player2
	 */
	public void swapPlayers(Player player1, Player player2) {
		Cell tmpCell = player1.getActualCell();
		putPlayerOnCell(player1, player2.getActualCell());
		putPlayerOnCell(player2, tmpCell);
	}
	
	/**
	 * Change the place of the player on the board.
	 * @param player the current player
	 * @param nextCell the target cell
	 */
	public void movePlayer(Player player, AbstractCell nextCell){
		if (nextCell.isBusy()) {
			swapPlayers(player, nextCell.getPlayer()) ;
		}else{
			this.putPlayerOnCell(player, nextCell) ;	
		}
	}
	
	/**
	 * Computes the Cell aimed by <code>player</code>
	 * 
	 * @param player
	 *            the actual player
	 * @param diceThrow
	 *            the result of the dice throw
	 * @return the aimed cell
	 */
	public Cell computeTargetCell(Player player, int diceThrow) {
		int targetIndex = this.normalizeIndex(player.getActualCell().getIndex()
				+ diceThrow);
		return this.cellArray[targetIndex];
	}
	
	/**
	 * Computes the Cell really reached by <code>player</code>
	 * 
	 * @param player
	 *            the actual player
	 * @param diceThrow
	 *            the result of the dice throw
	 * @return the really cell
	 */
	public Cell computeRealCell(Player player, int diceThrow) {
		int reachedCell = this.computeTargetCell(player, diceThrow).handleMove(diceThrow);
		return this.cellArray[reachedCell];
	}
	
	/**
	 * Returns the correct index if <code>index</code> exceeds the end Cell's
	 * index
	 * 
	 * @param index
	 *         the raw index
	 * @return the correct index
	 */
	public int normalizeIndex(int index) {
		int boardSize = this.cellArray[cellArray.length - 1].getIndex();
		if (index > boardSize)
			return boardSize - (index % boardSize);
		return index;
	}
	
	/**
	 * Returns true if there is a player on the end cell
	 * @return true if there is a player on the end cell
	 */
	public boolean playerOnEndCell() {
		return this.cellArray[cellArray.length - 1].isBusy();
	}
	
}
