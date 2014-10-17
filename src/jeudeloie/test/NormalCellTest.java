package jeudeloie.test;

import static org.junit.Assert.*;
import jeudeloie.Player;
import jeudeloie.cell.NormalCell;

import org.junit.Test;

public class NormalCellTest {
	@Test
	public void testPlayerOnCell() {
		NormalCell n = new NormalCell(0);
		Player p = new Player("bob");
		assertFalse(n.isBusy());
		n.welcome(p);
		assertTrue(n.isBusy());
		n.eject(p);
		assertFalse(n.isBusy());
	}

	@Test
	public void doesBasicMethodsWork() {
		NormalCell n = new NormalCell(0);
		Player p = new Player("bob");
		n.welcome(p);
		assertTrue(n.canBeLeftNow());
		assertFalse(n.isRetaining());
		assertEquals(0, n.getIndex());
		assertEquals(p, n.getPlayer());
		assertEquals("Normal cell 0", n.toString());
		assertEquals(n.getIndex(), n.handleMove(12));
	}
}
