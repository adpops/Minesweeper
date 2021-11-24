import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Cover extends MinesweeperImages {
    public Cover() {
	img = setImage();
    }

    private Image setImage() {
	String filename = "Cover.png";

	URL urlPieceImg = getClass().getResource("images/" + filename);
	return new ImageIcon(urlPieceImg).getImage();
    }
}
