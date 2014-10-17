package jeudeloie.test;

import static org.junit.Assert.assertEquals;
import jeudeloie.cell.NormalCell;
import jeudeloie.cell.TeleportCell;

import org.junit.Test;

public class TeleportCellTest {

	@Test
	public void testTeleportCell() {
		NormalCell nc = new NormalCell(1);
		TeleportCell tc = new TeleportCell(0, nc);
		assertEquals(0, tc.getIndex());
		assertEquals(1, tc.handleMove(12));
	}
	
	@Test
	public void testHandleMove() {
		NormalCell nc = new NormalCell(1);
		TeleportCell tc = new TeleportCell(0, nc);
		assertEquals(nc.getIndex(), tc.handleMove(12));
	}

	@Test
	public void testToString() {
		TeleportCell tc = new TeleportCell(0, new NormalCell(1));
		assertEquals("Teleport cell 0", tc.toString());
	}

}
