package jeudeloie;
import jeudeloie.Cell;

/*
 * @author Arnaud Cojez
 * Classe for the players of the goose game
 */

public class Player {

	//Player's Attributes
	private final String name;
	private Cell actualCell;
	
	
	/**
	 * Constructor for the Player Classe
	 * Note that <code>actualCell</code> is set to <code>Null</code>, the player must be placed on a cell after its creation
	 * @param name
	 * 		String representing the Player's <code>name</code>
	 */
	public Player(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets the Player's <code>actualCell</code> attribute to <code>targetCell</code>
	 * @param targetCell
	 */
	public void setActualCell(Cell targetCell)
	{
		if(this.actualCell != null)
			this.actualCell.eject(this); 
		this.actualCell = targetCell;
	}
	
	/**
	 * Returns the Player's actual Cell
	 * @return the Player's <code>actualCell</code>
	 */
	public Cell getActualCell()
	{
		return this.actualCell;
	}
	
	/**
	 * Returns the Player's name
	 * @return the Player's <code>name</code>
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns a <code>String</code> describing the Player's situation
	 * @return a description of the Player's situation
	 */
	public String toString()
	{
		return this.name + " is in " + this.actualCell;
	}

	/**
	 * Returns true if the player is on a trap cell
	 * @return true if the player is on a trap cell
	 */
	public boolean isOnTrapCell() {
		if(this.getActualCell() != null)
			return this.getActualCell().isRetaining(); 
		return false;
	}

	/**
	 * Returns true if the player can't play at this turn
	 * @return true if the player can't play at this turn
	 */
	public boolean isWaiting() {
		if(this.getActualCell() != null)
			return !this.getActualCell().canBeLeftNow();
		return false;
	}
}