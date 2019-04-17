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
	// placeMines();

	game.add(this);
    }

    private void createPanel() {
	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		Tile tile = new Tile(x, y, this, -1);
		this.add(tile);
		tileList[x][y] = tile;
	    }
	}
    }

    private void placeMines() {
	Random rand = new Random();
	int posX = 0;
	int posY = 0;
	int maxXValue = width;
	int maxYValue = height;
	int numOfMinesPlaced = 0;

	while (numOfMinesPlaced < numOfMines) {
	    posX = rand.nextInt(maxXValue);
	    posY = rand.nextInt(maxYValue);

	    if (!tileList[posX][posY].getHasMine()) {
		tileList[posX][posY].setMine();
		tilesWithMines[posX][posY] = tileList[posX][posY];
		numOfMinesPlaced++;
	    }
	}
    }
}
