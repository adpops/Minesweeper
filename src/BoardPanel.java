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
	int numOfMinesPlaced = 0;

	while (numOfMinesPlaced < numOfMines) {
	    posX = rand.nextInt(width);
	    posY = rand.nextInt(height);

	    if (!(tileList[posX][posY].getNum() == -1)) {
		// System.out.println(posX + ", " + posY);
		tileList[posX][posY].setNum(-1);
		tilesWithMines[posX][posY] = tileList[posX][posY];
		numOfMinesPlaced++;
	    }
	}
    }
}
