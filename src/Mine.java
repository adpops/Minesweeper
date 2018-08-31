import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Mine extends MinesweeperImages
{
	public Mine()
	{
		img = setImage();
	}
	
	private Image setImage() 
    {
        String filename = "Mine.png";

        URL urlPieceImg = getClass().getResource("images/" + filename);
        return new ImageIcon(urlPieceImg).getImage();        
    }
}