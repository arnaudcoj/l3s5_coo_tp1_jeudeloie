package jeudeloie.test;

import static org.junit.Assert.*;
import jeudeloie.Board;
import jeudeloie.Player;
import jeudeloie.StandardBoard;
import jeudeloie.cell.AbstractCell;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testTeleportation() {
		Board b = new StandardBoard();
		Player p = new Player("bob") ;
		b.putPlayerOnStart(p);
		assertFalse(30 == b.computeTargetCell(p, 42).getIndex()) ;
		assertTrue(30 == b.computeRealCell(p, 42).getIndex()) ;
	}
	
	@Test
	public void testNormalizeIndex() {
		Board b = new StandardBoard();
		assertEquals(3, b.normalizeIndex(3));
		assertEquals(42, b.normalizeIndex(42));
		assertEquals(60, b.normalizeIndex(66));
	}

	@Test
	public void testPlayerOnEndCell() {
		Board b = new StandardBoard();
		Player p = new Player("bob") ;
		b.putPlayerOnStart(p);
		b.movePlayer(p, (AbstractCell) b.getEndCell());
		assertTrue(b.playerOnEndCell()) ;
	}

}