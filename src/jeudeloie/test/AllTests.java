package jeudeloie.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoardTest.class, GooseCellTest.class, NormalCellTest.class,
		StartCellTest.class, TeleportCellTest.class, TrapCellTest.class,
		WaitCellTest.class })
public class AllTests {

}
