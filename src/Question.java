import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Question extends MinesweeperImages
{
	private Image img;	
	public Question()
	{
		img = setImage();
	}
	
	private Image setImage() 
    {
        String filename = "Flag.png";

        URL urlPieceImg = getClass().getResource("images/" + filename);
        return new ImageIcon(urlPieceImg).getImage();        
    }
}
