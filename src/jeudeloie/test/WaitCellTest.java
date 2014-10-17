package jeudeloie.test;


import static org.junit.Assert.*;
import jeudeloie.Player;
import jeudeloie.cell.WaitCell;

import org.junit.Test;

public class WaitCellTest {

	@Test
	public void testWaitCell() {
		WaitCell wc = new WaitCell(0, 3);
		assertEquals(0, wc.getIndex());
		assertEquals(3, wc.getTurnsRemaining());
	}
	
	@Test
	public void testCanBeLeftNow() {
		WaitCell wc = new WaitCell(0, 2);
		assertFalse(wc.canBeLeftNow());
		assertFalse(wc.canBeLeftNow());
		assertTrue(wc.canBeLeftNow());
	}
	
	
	@Test
	public void testEjectAndResetTurns() {
		WaitCell wc = new WaitCell(0, 1);
		Player p = new Player("bob");
		wc.welcome(p);
		assertFalse(wc.canBeLeftNow());
		assertTrue(wc.canBeLeftNow());
		wc.eject(p);
		assertEquals(1, wc.getTurnsRemaining());
	}
}