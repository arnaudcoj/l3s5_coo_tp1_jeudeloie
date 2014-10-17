package jeudeloie.test;

import static org.junit.Assert.*;
import jeudeloie.cell.TrapCell;

import org.junit.Test;

public class TrapCellTest {
	
	@Test
	public void testTrapCell() {
		TrapCell tc = new TrapCell(0);
		assertEquals(0, tc.getIndex());
	}

	@Test
	public void testCanBeLeftNow() {
		TrapCell tc = new TrapCell(0);
		assertFalse(tc.canBeLeftNow());
	}

	@Test
	public void testIsRetaining() {
		TrapCell tc = new TrapCell(0);
		assertTrue(tc.isRetaining());
	}

	@Test
	public void testToString() {
		TrapCell tc = new TrapCell(0);
		assertEquals("Trap cell 0", tc.toString());
	}

}
