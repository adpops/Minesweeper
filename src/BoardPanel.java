import java.awt.GridLayout;
import java.util.Random;

public class BoardPanel extends AbstractPanel
{
	private int difficulty;
	private int width;
	private int height;
	private int numOfMines;
	private Tile [][] tileList;
	private Tile [][] tilesWithMines;
	private String cardName = "boardPanel";
	
	public BoardPanel(GUIManager gui) 
	{
		super(gui);
		gui.addPanel(this, cardName);
		this.difficulty = gui.getDifficulty();
		decideBoardDimensions();
		setLayout(new GridLayout(width, height));
		
		tileList = new Tile[8][8];
		tilesWithMines = new Tile[width][height];
		
		createPanel();
		placeMines();
	}
	
	private void createPanel()
	{
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				Tile tile = new Tile(x, y, this);
				this.add(tile);
				tileList[x][y] = tile;
				System.out.println(tileList.length);
			}
		}
	}
	
	private void decideBoardDimensions()
	{
		switch(difficulty)
		{
			case 0:
				width = 8;
				height = 8;
				numOfMines = 10;
				break;
			case 1:
				width = 16;
				height = 16;
				numOfMines = 40;
				break;
			case 2:
				width = 16;
				height = 30;
				numOfMines = 40;
				break;
		}
	}
	
	private void placeMines()
	{
		Random rand = new Random();
		int posX = 0;
		int posY = 0;
		int maxXValue = width;
		int maxYValue = height;
		int numOfMinesPlaced = 0;
		
		while(numOfMinesPlaced < numOfMines)
		{
			posX = rand.nextInt(maxXValue);
			posY = rand.nextInt(maxYValue);

			if(!tileList[posX][posY].getHasMine())
			{
				tileList[posX][posY].setMine();
				tilesWithMines[posX][posY] = tileList[posX][posY];
				numOfMinesPlaced++;
			}
		}
	}
}
