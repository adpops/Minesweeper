import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Testing
{
	JFrame f;
	JPanel board;
	public Testing()
	{
		f = new JFrame();
		f.setResizable(true);
        f.setSize(800, 1000);
        f.setTitle("Minesweeper");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.getContentPane().setLayout(cards);
        
        board = new JPanel();
        board.setLayout(new GridLayout(8, 8, 10, 10));
        f.getContentPane().add(board);
        createBoard();
        f.setVisible(true);
	}
	
	private void createBoard()
	{	
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				Tile tile = new Tile(0, x, y, null);
				tile.setBackground(Color.BLACK);
	            board.add(tile);
			}
		}
	}
	
	public static void main(String args[])
	{
		Testing test = new Testing();
	}
}
