import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JPanel
{
	private Cover cover;
	private Number num;
	private Flag flag;
	private Mine mine;
	private ImageIcon coverImg;
	private ImageIcon numImg;
	private ImageIcon flagImg;
	private ImageIcon questionImg;
	private ImageIcon mineImg;
	private Listener listener;
	private boolean alive;
	private boolean containsMine;
	private int x;
	private int y;
	private int iconType;
	
	private final int COVER = 0;
	private final int NUMBER = 1;
	private final int FLAG = 2;
	private final int QUESTION = 3;
	private final int MINE = 4;
	
	public Tile(int number, int x, int y, Board board)
	{
		this.x = x;
		this.y = y;
		
		//Number image code
		this.num = new Number(number);
		numImg = (num.getNumber() != 0 && num.getNumber() != -1) ? num.getImageIcon() : null;
		
		//Flag image code
		flag = new Flag();
		flagImg = flag.getImageIcon();
		
		//Tile cover image code
		cover = new Cover();
		coverImg = cover.getImageIcon();
		placeImageOnTile(COVER);
		
		//Mine image code
		containsMine = (num.getNumber() == -1) ? true : false;
		if(containsMine)
		{
			mine = new Mine();
			mineImg = mine.getImageIcon();
		}
		
		//each tile needs it's own listener, that way I know which tile is being clicked on
		listener = new Listener(this, board);
	    this.addMouseListener(listener);
	}

	//This will place the correct image on a tile depending on the 'type' specified
	public void placeImageOnTile(int type)
	{
		JLabel imageLbl = null;

		switch(type)
		{
			case COVER:
				imageLbl = new JLabel(coverImg);
				break;
			case NUMBER:
				imageLbl = new JLabel(numImg);
				break;
			case FLAG:
				imageLbl = new JLabel(flagImg);
				break;
			case QUESTION:
				imageLbl = new JLabel(questionImg);
				break;
			case MINE:
				imageLbl = new JLabel(mineImg);
				break;
		}
		iconType = type;
		this.add(imageLbl);
	}
	
	public boolean getContainsMine()
	{
		return containsMine;
	}
	
	public int getNum()
	{
		return num.getNumber();
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean getAlive()
	{
		return alive;
	}
	
	public void setAlive(boolean mode)
	{
		alive = mode;
	}
	
	public void removeImage(int type)
	{
		JLabel imageLbl = new JLabel(coverImg);
		switch(type)
		{
			case NUMBER:
				imageLbl = new JLabel(numImg);
				break;
			case FLAG:
				imageLbl = new JLabel(flagImg);
				break;
			case COVER:
				imageLbl = new JLabel(coverImg);
				break;
			case MINE:
				imageLbl = new JLabel(mineImg);
				break;
		}
		this.remove(imageLbl);
	}
	
	public int getIconType()
	{
		return iconType;
	}
}

