import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frameWidth = 400; 
		frameHeight = 700;
		frame = new JFrame();
		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("Minesweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		createLoginPanel();
	}

	private void createLoginPanel() 
	{
		JPanel loginP = new JPanel();
		frame.getContentPane().add(loginP, loginCard);
		loginP.setLayout(null);
		
		int txtWidth = generalTxtWidth;
		int txtHeight = generalTxtHeight;
		int txtX = 125;
		int userTxtY = 160;
	    JTextField loginUserTxt = new JTextField();
	    loginUserTxt.setBounds(txtX, userTxtY, txtWidth, txtHeight);
	    loginP.add(loginUserTxt);
	    loginUserTxt.setColumns(10);
	    
	    int passTxtY = 200; 
	    JPasswordField loginPassField = new JPasswordField();
	    loginPassField.setBounds(txtX, passTxtY, txtWidth, txtHeight);
	    loginP.add(loginPassField);
	    
	    int paneWidth = 63;
	    int paneHeight = 25;
	    int paneX = 50;
	    int userPaneY = userTxtY;
	    JTextPane loginUserPane = new JTextPane();
	    loginUserPane.setForeground(Color.BLACK);
	    loginUserPane.setBackground(new Color(240, 240, 240));
	    loginUserPane.setText("Username");
	    loginUserPane.setBounds(paneX, userPaneY, paneWidth, paneHeight);
	    loginUserPane.setEditable(false);;
	    loginP.add(loginUserPane);
	    
	    int passPaneY = passTxtY;
	    JTextPane loginPassPane = new JTextPane();
	    loginPassPane.setForeground(Color.BLACK);
	    loginPassPane.setBackground(new Color(240, 240, 240));
	    loginPassPane.setText("Password");
	    loginPassPane.setBounds(paneX, passPaneY, paneWidth, paneHeight);
	    loginPassPane.setEditable(false);;
	    loginP.add(loginPassPane);
	    
	    int btnWidth = 120;
	    int btnHeight = 25;
	    int btnX = 125;
	    int btnY = 260;
	    JButton loginBtn = new JButton("Login");
	    loginBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    	}
	    });
	    loginBtn.setBounds(btnX, btnY, btnWidth, btnHeight);
	    loginP.add(loginBtn);
	    
	    JButton registerBtn = new JButton("Register");
	    registerBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    	}
	    });
	    registerBtn.setBounds(btnX, btnY + 40, btnWidth, btnHeight);
	    loginP.add(registerBtn);
	    
	    JButton exitBtn = new JButton("Exit");
	    exitBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    	}
	    });
	    exitBtn.setBounds(btnX, btnY + 40*2, btnWidth, btnHeight);
	    loginP.add(exitBtn);
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
