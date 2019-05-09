import java.awt.GridLayout;
import java.util.Random;

public class BoardPanel extends AbstractPanel {
    private int difficulty;
    private int width;
    private int height;
    private int numOfMines;
    private Tile[][] tileList;
    private Tile[][] tilesWithMines;
    private String cardName = "boardPanel";

    public BoardPanel(GUIManager gui, GameFrame game) {
	super(gui);
	width = game.getTileWidth();
	height = game.getTileHeight();
	numOfMines = game.getNumOfMines();
	setLayout(new GridLayout(width, height));
	tileList = new Tile[width][height];
	tilesWithMines = new Tile[width][height];

	createPanel();
	placeMines();
	placeNums();

	game.add(this);
    }

    private void createPanel() {
	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		Tile tile = new Tile(x, y, this);
		this.add(tile);
		tileList[x][y] = tile;
	    }
	}
    }

    private void placeMines() {
	Random rand = new Random();
	int posX = 0;
	int posY = 0;
	int minesPlaced = 0;

	while (minesPlaced < numOfMines) {
	    posX = rand.nextInt(width);
	    posY = rand.nextInt(height);

	    if (!(tileList[posX][posY].getNum() == -1)) {
		tileList[posX][posY].setNum(-1);
		tilesWithMines[posX][posY] = tileList[posX][posY];
		minesPlaced++;
	    }
	}
    }

    private void placeNums() {
	// System.out.println(tileList.length + " " + tilesWithMines.size);

	for (Tile[] tileArray : tilesWithMines) {
	    for (Tile tile : tileArray) {
		if (tile != null) {
		    System.out.println(tile.getNum());

		    for (int xCount = -1; tile.getTileX() + xCount < 8; xCount += 2) {

			int posX = tile.getTileX() + xCount;
			tileList[posX][tile.getTileY()].addNum(1);
			System.out.println(posX + " " + tile.getTileY());
			for (int yCount = -1; tile.getTileY() + yCount < 8; yCount += 2) {
			    int posY = tile.getTileY() + yCount;
			    tileList[posX][posY].addNum(1);
			    System.out.println(tile.getTileX() + xCount + " " + tile.getTileY() + yCount);
			}
		    }
		    for (int yCount = -1; yCount < 8; yCount = +2) {
			tileList[tile.getTileX()][tile.getTileY() + yCount].addNum(1);
			System.out.println(tile.getTileX() + " " + tile.getTileY() + yCount);
		    }
		}

	    }
	}
    }
}
