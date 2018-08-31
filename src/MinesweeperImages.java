import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class MinesweeperImages 
{
	public Image img;
	
	public Image getImage()
	{
		return img;
	}
	
	public ImageIcon getImageIcon() 
    {
    	ImageIcon image = new ImageIcon(img);
        return image;
    }
}
