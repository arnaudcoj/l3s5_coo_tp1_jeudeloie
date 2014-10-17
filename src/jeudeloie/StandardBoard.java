package jeudeloie;

import jeudeloie.Cell;
import jeudeloie.cell.*;

/**
 * Class representing the Standard Board for the goose game.
 * 
 * @author Cojez Arnaud
 */
public class StandardBoard extends Board {

	public StandardBoard() {
		super(new Cell[64]);
		int i;
		this.cellArray[0] = new StartCell();

		for (i = 1; i < 6; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[6] = new TeleportCell(6, this.cellArray[12]);

		for (i = 7; i < 9; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[9] = new GooseCell(9);

		for (i = 10; i < 18; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[18] = new GooseCell(18);

		this.cellArray[19] = new WaitCell(19, 2);

		for (i = 20; i < 27; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[27] = new GooseCell(27);

		for (i = 28; i < 31; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[31] = new TrapCell(31);

		for (i = 32; i < 36; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[36] = new GooseCell(36);

		for (i = 37; i < 42; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[42] = new TeleportCell(42, this.cellArray[30]);

		for (i = 43; i < 45; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[45] = new GooseCell(45);

		for (i = 46; i < 52; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[52] = new TrapCell(52);

		this.cellArray[53] = new NormalCell(53);

		this.cellArray[54] = new GooseCell(54);

		for (i = 55; i < 58; i++)
			this.cellArray[i] = new NormalCell(i);

		this.cellArray[58] = new TeleportCell(58, this.cellArray[1]);

		for (i = 59; i < 64; i++)
			this.cellArray[i] = new NormalCell(i);
	}
}
