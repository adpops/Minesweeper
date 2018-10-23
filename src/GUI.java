import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.CardLayout;

public class GUI 
{
	private JFrame frame;
	private int frameWidth;
	private int frameHeight;
	private int generalTxtWidth = 150;
	private int generalTxtHeight = 25;
	private String loginCard = "login";

	public GUI() 
	{
		frameWidth = 900; 
		frameHeight = 700;
		frame = new JFrame();
		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("Minesweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		createLoginPanel();
	}

	private void createLoginPanel() 
	{
		JPanel loginP = new JPanel();
		frame.getContentPane().add(loginP, loginCard);
		loginP.setLayout(null);
		
		int loginTxtWidth = generalTxtWidth;
		int loginTxtHeight = generalTxtHeight;
		int loginTxtX = frameWidth * 2/3 - loginTxtWidth/2;
		//int loginTxtY = (frameHeight - )
		JTextField loginUserTxt = new JTextField();
	    loginUserTxt.setBounds(loginTxtX, 167, loginTxtWidth, loginTxtHeight);
	    loginP.add(loginUserTxt);
	    loginUserTxt.setColumns(10);
	}
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI window = new GUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
