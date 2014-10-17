package jeudeloie.test;

import static org.junit.Assert.*;
import jeudeloie.Player;
import jeudeloie.cell.StartCell;

import org.junit.Test;

public class StartCellTest {

	@Test
	public void testStartCell() {
		StartCell sc = new StartCell();
		assertTrue(sc != null);
	}

	@Test
	public void testCanBeLeftNow() {
		StartCell sc = new StartCell();
		assertTrue(sc.canBeLeftNow());
	}

	@Test
	public void testIsRetaining() {
		StartCell sc = new StartCell();
		assertFalse(sc.isRetaining());
	}

	@Test
	public void testGetIndex() {
		StartCell sc = new StartCell();
		assertEquals(0, sc.getIndex());
	}

	@Test
	public void testHandleMove() {
		StartCell sc = new StartCell();
		assertEquals(sc.getIndex(), sc.handleMove(12));
	}

	@Test
	public void testWelcomeGetPlayersAndEject() {
		StartCell sc = new StartCell();
		Player bob = new Player("Bob");
		Player theDude = new Player("Lebowsky");
		sc.welcome(bob);
		assertTrue(sc.getPlayers().contains(bob));
		sc.welcome(theDude);
		assertTrue(sc.getPlayers().contains(bob));
		assertTrue(sc.getPlayers().contains(theDude));
		sc.eject(bob);
		assertFalse(sc.getPlayers().contains(bob));
		assertTrue(sc.getPlayers().contains(theDude));
		sc.eject(theDude);
		assertFalse(sc.getPlayers().contains(theDude));
	}

	@Test
	public void testIsBusy() {
		StartCell sc = new StartCell();
		Player bob = new Player("Bob");
		assertFalse(sc.isBusy());
		sc.welcome(bob);
		assertFalse(sc.isBusy());
	}

	@Test
	public void testToString() {
		StartCell sc = new StartCell();
		assertEquals("Start cell", sc.toString());
	}
}
