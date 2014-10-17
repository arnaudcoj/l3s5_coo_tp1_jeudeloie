package jeudeloie;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import jeudeloie.cell.AbstractCell;

/*
 * @author Arnaud Cojez
 * General class for the goose game
 */
public class Game {

	// Attributes
	private Collection<Player> players;
	private Board board;
	private Iterator<Player> currentPlayer;
	private final Random random;

	// Methods

	/**
	 * Constructor of the Game class
	 * 
	 * @param board
	 *            The Board used during the game
	 */
	public Game(Board board) {
		this.players = new LinkedList<Player>();
		this.board = board;
		this.currentPlayer = players.iterator();
		this.random = new Random();
	}

	/**
	 * Constructor of the Game class with a StandardBoard
	 */
	public Game() {
		this.players = new LinkedList<Player>();
		this.board = new StandardBoard();
		this.currentPlayer = players.iterator();
		this.random = new Random();
	}

	/**
	 * Throws a die
	 * 
	 * @return an integer between 1 and 6
	 */
	private int throwDie() {
		return (this.random.nextInt(6) + 1);
	}

	/**
	 * Plays the Goose Game. Loops every players turns until the game is
	 * finished.
	 */
	public void play() {
		while (!isFinished())
			this.playTurn();
	}

	/**
	 * Returns true if the game is finished
	 * 
	 * @return true if there is a player on the end cell or if all players are
	 *         stuck (on trap cells)
	 */
	public boolean isFinished() {
		return this.board.playerOnEndCell() || this.allPlayersAreStuck();
	}

	public boolean allPlayersAreStuck() {
		for (Iterator<Player> i = this.players.iterator(); i.hasNext();) {
			if (!i.next().isOnTrapCell()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Play one player's turn.
	 */
	public void playTurn() {
		// some useful variables
		Player theOne = this.currentPlayer.next();
		System.out.print(theOne + ", ");
		// we want to know if the player can play
		if (theOne.isWaiting())	
			System.out.println(theOne.getName() + " has to wait.");
		else if (theOne.isOnTrapCell())
			System.out.println(theOne.getName() + " is stuck.");
		else
		{
			//The player can move, we throw the dice
			int dice = this.throwDie() + this.throwDie();
			System.out.print(theOne.getName() + " throws " + dice + ", ");

			// We want to know the future cell
			AbstractCell nextCell = (AbstractCell) this.board.computeTargetCell(theOne, dice);
			System.out.println(theOne.getName() + " reaches " + nextCell + ".");
			// We move the player
			this.board.movePlayer(theOne, nextCell);
		}
		// We change the iterator to the next player
		if (!this.currentPlayer.hasNext()) {
			this.currentPlayer.remove();
			this.currentPlayer = players.iterator();
		}
	}

	private void initPlayers(int i) {
		for (int k = 0; k < i; k++) {
			Player player = new Player("Player" + (k + 1));
			this.players.add(player);
		}
	}

	private void usage() {
		System.out.println("une seule option un nombre positif de joueurs");
	}

	public static void main(String[] args) {
		Game theGame = new Game();
		int nbPlayers = Integer.valueOf(args[1]).intValue();
		if (nbPlayers <= 0) {
			theGame.usage();
			return;
		}
		theGame.initPlayers(nbPlayers);
		theGame.play();
		return;

	}
}
