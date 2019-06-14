import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JOptionPane;

public class BoardPanel extends AbstractPanel {
	private int width;
	private int height;
	private int numOfMines;
	private Tile[][] tileList;
	private Tile[][] tilesWithMines;
	private String cardName = "boardPanel";
	private GameFrame game;

	public BoardPanel(GUIManager gui, GameFrame game) {
		super(gui);
		this.game = game;
		width = game.getTileWidth();
		height = game.getTileHeight();
		numOfMines = 10; //game.getNumOfMines();
		setLayout(new GridLayout(width, height));
		tileList = new Tile[width][height];
		tilesWithMines = new Tile[width][height];

		createPanel();
		placeMines();
		placeNums();

		game.add(this);
	}

	private void createPanel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Tile tile = new Tile(x, y, this);
				tile.setAlive(true);
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
		for (Tile[] tileArray : tilesWithMines) {
			for (Tile tile : tileArray) {
				if (tile != null) {
					for (int xCount = -1; xCount <= 1; xCount += 2) {
						int posX = tile.getTileX() + xCount;
						if (posX <= (width - 1) && posX >= 0) {
							if (tileList[posX][tile.getTileY()].getNum() != -1) {
								tileList[posX][tile.getTileY()].addNum(1);
							}

							for (int yCount = -1; yCount <= 1; yCount += 2) {
								int posY = tile.getTileY() + yCount;
								if (posY <= (height - 1) && posY >= 0) {
									if (tileList[posX][posY].getNum() != -1) {
										tileList[posX][posY].addNum(1);
									}
								}

							}
						}
					}

					for (int yCount = -1; yCount <= 1; yCount += 2) {
						int posY = tile.getTileY() + yCount;
						if (posY <= (height - 1) && posY >= 0) {
							if (tileList[tile.getTileX()][posY].getNum() != -1) {
								tileList[tile.getTileX()][posY].addNum(1);
							}
						}
					}
				}
			}
		}
	}

	public void clearTiles(int x, int y, int lblType) {
		if (x <= (width - 1) && x >= 0 && y <= (height - 1) && y >= 0) {
			Tile tile = tileList[x][y];
			if (tile.getAlive() && tile.getNum() == 0) {
				tile.removeImage(lblType);
				tile.setAlive(false);

				clearTiles(x - 1, y, lblType);
				clearTiles(x - 1, y - 1, lblType);
				clearTiles(x - 1, y + 1, lblType);

				clearTiles(x + 1, y, lblType);
				clearTiles(x + 1, y - 1, lblType);
				clearTiles(x + 1, y + 1, lblType);

				clearTiles(x, y - 1, lblType);
				clearTiles(x, y + 1, lblType);
			}
		}
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(game, "Game Over", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
		game.dispose();
	}
}
