import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Number extends MinesweeperImages
{
	private int num;
	
	public Number(int num)
	{
		img = setImage(num);
		this.num = num;
	}
	
	private Image setImage(int number) 
    {
        String filename = "";

        switch (number) 
        {
            case 1:
                filename += "One";
                break;
            case 2:
                filename += "Two";
                break;
            case 3:
                filename += "Three";
                break;
            case 4:
                filename += "Four";
                break;
            case 5:
                filename += "Five";
                break;
            case 6:
                filename += "Six";
                break;
            case 7:
                filename += "Seven";
                break;
            case 8:
                filename += "Eight";
                break;
        }
        
        if(num > 0)
        {
        	filename += ".png";

            URL urlPieceImg = getClass().getResource("images/" + filename);
            return new ImageIcon(urlPieceImg).getImage();        
        }
        return null;
    }
	
	public int getNumber()
	{
		return num;
	}
}
