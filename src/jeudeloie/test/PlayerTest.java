package jeudeloie.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import jeudeloie.Player;
import jeudeloie.cell.NormalCell;
import jeudeloie.cell.TrapCell;
import jeudeloie.cell.WaitCell;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testSetActualCell() {
		Player p = new Player("Regis");
		NormalCell nc = new NormalCell(0);
		assertNull(p.getActualCell());
		p.setActualCell(nc);
		assertEquals(nc, p.getActualCell());
	}

	@Test
	public void testGetName() {
		Player p = new Player("Regis");
		assertEquals("Regis", p.getName());
	}

	@Test
	public void testToString() {
		Player p = new Player("Regis");
		NormalCell nc = new NormalCell(0);
		p.setActualCell(nc);		
		System.out.println(p.toString());
		assertEquals("Regis is in Normal cell 0", p.toString());
	}

	@Test
	public void testIsOnTrapCell() {
		Player p = new Player("Regis");
		NormalCell nc = new NormalCell(0);
		TrapCell tc = new TrapCell(1);
		assertFalse(p.isOnTrapCell());
		p.setActualCell(tc);
		assertTrue(p.isOnTrapCell());
		p.setActualCell(nc);
		assertFalse(p.isOnTrapCell());
	}

	@Test
	public void testIsWaiting() {
		Player p = new Player("Regis");
		NormalCell nc = new NormalCell(0);
		WaitCell wc = new WaitCell(1,3);
		assertFalse(p.isWaiting());
		p.setActualCell(wc);
		assertTrue(p.isWaiting());
		p.setActualCell(nc);
		assertFalse(p.isWaiting());
	}

}
