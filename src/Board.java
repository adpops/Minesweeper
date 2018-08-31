import java.util.List;

import javax.swing.JPanel;

//This class will create the gameboard
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
