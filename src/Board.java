import java.util.List;

import javax.swing.JPanel;

public class Board extends JPanel
{
	private Tile tileList[][];
	private int width;
	private int height;
	
	public Board(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		tileList = new Tile[width][height];
	}
	
	public Tile[][] getTileList()
	{
		return tileList;
	}
}
