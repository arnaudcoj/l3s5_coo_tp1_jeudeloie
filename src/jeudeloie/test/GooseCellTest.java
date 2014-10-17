package jeudeloie.test;

import static org.junit.Assert.assertEquals;
import jeudeloie.Player;
import jeudeloie.cell.GooseCell;

import org.junit.Before;
import org.junit.Test;

public class GooseCellTest {

	@Before
	public void createCellAndPlayer() {
		GooseCell n = new GooseCell(0);
		Player p = new Player("bob");
		n.welcome(p);
		p.setActualCell(n);
	}
	
	@Test
	public void testHandleMove() {
		GooseCell n = new GooseCell(0);
		assertEquals(12, n.handleMove(12));
	}

	@Test
	public void testToString() {
		GooseCell n = new GooseCell(0);
		assertEquals("Goose cell 0", n.toString());
	}

}
