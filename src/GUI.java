

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI
{	
	private JFrame f = 	new JFrame();
	private JPanel login;
	private JPanel startMenu;
	private JPanel game;
	private JPanel register;
	private Board board;
     
	private JTextField loginUser;
	private JPasswordField loginPass;
	private JTextField regUser;
	private JPasswordField regPass;
	
	private int width;
	private int height;
	private int mines;
	
	private int frameX;
	private int frameY;
	
	private int defaultFieldWidth = 200;
	private int defaultFieldHeight = 35;
	
	private int defaultLblWidth = 100;
	private int defaultLblHeight = 25;

	private int defaultBtnWidth = 150;
	private int defaultBtnHeight = 35;
	
	CardLayout cards = new CardLayout();

	public GUI()
	{	
		//This will create the window
		f.setResizable(true);
        f.setSize(800, 1000);
        f.setTitle("Minesweeper");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(cards);
        
        //Gets the size of the frame. Used in positioning other objects on frame
        frameX = f.getWidth();
		frameY = f.getHeight();	
       
        loginPanel();
        startMenuPanel();
        gamePanel();
        registerPanel();
        f.setSize(800, 1000);
	}
	
	private void loginPanel()
	{
		login = new JPanel();
		f.getContentPane().add(login, "LOGIN");
		login.setLayout(null);
		
		//Create Login Fields 
	    int loginFieldWidth = defaultFieldWidth;
	    int loginFieldHeight = defaultFieldHeight;
	    int loginFieldX = (frameX - loginFieldWidth)/2;
	    int loginFieldY = (frameY - loginFieldHeight)/2;
	    
	    loginUser = new JTextField();
	    loginUser.setBounds(loginFieldX, loginFieldY - 30, loginFieldWidth, loginFieldHeight);
	    login.add(loginUser);
	    loginUser.setColumns(10);
	    
	    loginPass = new JPasswordField();
	    loginPass.setBounds(loginFieldX, loginFieldY + 30, loginFieldWidth, loginFieldHeight);
	    login.add(loginPass);
		   
		//Create Username and Password Labels
		int loginLblWidth = defaultLblWidth;
		int loginLblHeight = defaultLblHeight;
		int loginLblX = loginFieldX - 110;
		int loginLblY = loginFieldY;
		
		JLabel loginUserLbl = new JLabel("Username");
		loginUserLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginUserLbl.setBounds(loginLblX, loginLblY - 25, loginLblWidth, loginLblHeight);
		login.add(loginUserLbl);
		
		JLabel loginPassLbl = new JLabel("Password");
		loginPassLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginPassLbl.setBounds(loginLblX, loginLblY + 35, loginLblWidth, loginLblHeight);
		login.add(loginPassLbl);
		 
		//Create Login and Register Buttons  
		int loginBtnWidth = defaultBtnWidth;
		int loginBtnHeight = defaultBtnHeight;
		int loginBtnX = loginFieldX + (loginFieldWidth - loginBtnWidth)/2;
		int loginBtnY = loginFieldY + 30;
		
		JButton loginStartBtn = new JButton("Login");
		loginStartBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cards.show(f.getContentPane(), "START");
			}
		});
		loginStartBtn.setBounds(loginBtnX, loginBtnY + 60, loginBtnWidth, loginBtnHeight);
		login.add(loginStartBtn);
		
		JButton loginRegBtn = new JButton("Register");
		loginRegBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cards.show(f.getContentPane(), "REGISTER");	
			}
		});
		loginRegBtn.setBounds(loginBtnX, loginBtnY + 120, loginBtnWidth, loginBtnHeight);
		login.add(loginRegBtn);
		
		JButton loginLeaderBtn = new JButton("Leaderboard");
		loginLeaderBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		loginLeaderBtn.setBounds(loginBtnX, loginBtnY + 220, loginBtnWidth, loginBtnHeight);
		login.add(loginLeaderBtn);
		
		JButton loginExitBtn = new JButton("Exit");
		loginExitBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		loginExitBtn.setBounds(loginBtnX, loginBtnY + 270, loginBtnWidth, loginBtnHeight);
		login.add(loginExitBtn);
	}
	
	private void startMenuPanel()
	{
		startMenu = new JPanel();
        f.getContentPane().add(startMenu, "START");
        startMenu.setLayout(null);
        
        //Create Login and Register Buttons  
  		int startBtnWidth = defaultBtnWidth;
  		int startBtnHeight = defaultBtnHeight;
  		int startBtnX = (frameX - startBtnWidth) / 4;
  		//int startBtnX = (frameX / 3) - (startBtnWidth / 2);
  		int startBtnY = (frameY - startBtnHeight) / 2;
        
        JButton startBeginnerBtn = new JButton("Beginner");
        startBeginnerBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		width = 8;
        		height = 8;
        		mines = 10;
        		
        		board = new Board(width, height, mines);
                game.add(board, BorderLayout.CENTER);
        		cards.show(f.getContentPane(), "GAME");        
        	}
        });
        startBeginnerBtn.setBounds(startBtnX, startBtnY, startBtnWidth, startBtnHeight);
        startMenu.add(startBeginnerBtn);

        JButton startIntermediateBtn = new JButton("Intermediate");
        startIntermediateBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		width = 16;
        		height = 16;
        		mines = 40;
        		
        		board = new Board(width, height, mines);
                game.add(board, BorderLayout.CENTER);
        		cards.show(f.getContentPane(), "GAME");			
        	}
        });
        startIntermediateBtn.setBounds(startBtnX * 2, startBtnY, startBtnWidth, startBtnHeight);
        startMenu.add(startIntermediateBtn);
        
        JButton startExpertBtn = new JButton("Expert");
        startExpertBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		width = 24;
        		height = 24;
        		mines = 99;
        		
        		board = new Board(width, height, mines);
                game.add(board, BorderLayout.CENTER);
        		cards.show(f.getContentPane(), "GAME");      	
        	}
        });
        startExpertBtn.setBounds(startBtnX * 3, startBtnY, startBtnWidth, startBtnHeight);
        startMenu.add(startExpertBtn);
        
        JButton startExitBtn = new JButton("Exit");
		startExitBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
        		cards.show(f.getContentPane(), "LOGIN");        	
			}
		});
		startExitBtn.setBounds(startBtnX * 2, frameY/2 + 270, startBtnWidth, startBtnHeight);
		startMenu.add(startExitBtn);
	}
	
	private void gamePanel() 
	{
		game = new JPanel();
		game.setLayout(new BorderLayout());
		f.getContentPane().add(game, "GAME");
        
	}
	
	private void registerPanel()
	{
		register = new JPanel();
        f.getContentPane().add(register, "REGISTER");
        register.setLayout(null);
        
        //Create Register Fields 
        int regFieldWidth= defaultFieldWidth;
        int regFieldHeight = defaultFieldHeight;
        int regFieldX = (frameX - regFieldWidth)/2;
        int regFieldY = (frameY - regFieldHeight)/2;
        
        regUser = new JTextField();
        regUser.setBounds(regFieldX, regFieldY - 30, regFieldWidth, regFieldHeight);
        register.add(regUser);
        regUser.setColumns(10);
        
        regPass = new JPasswordField();
        regPass.setBounds(regFieldX, regFieldY + 30, regFieldWidth, regFieldHeight);
        register.add(regPass);
       
        //Create Username and Password Labels
        int regLblWidth = defaultLblWidth;
        int regLblHeight = defaultLblHeight;
        int regLblX = regFieldX - 110;
        int regLblY = regFieldY;
        
        JLabel regUserLbl = new JLabel("Username");
        regUserLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        regUserLbl.setBounds(regLblX, regLblY - 25, regLblWidth, regLblHeight);
        register.add(regUserLbl);
        
        JLabel regPassLbl = new JLabel("Password");
        regPassLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        regPassLbl.setBounds(regLblX, regLblY + 35, regLblWidth, regLblHeight);
        register.add(regPassLbl);
         
        //Create Register and Back Buttons  
        int regBtnWidth = defaultBtnWidth;
        int regBtnHeight = defaultBtnHeight;
        int regBtnX = regFieldX + (regFieldWidth- regBtnWidth)/2;
        int regBtnY = regFieldY + 30;
        
        JButton regCreateAccBtn = new JButton("Create Account");
        regCreateAccBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		cards.show(f.getContentPane(), "START");
        	}
        });
        regCreateAccBtn.setBounds(regBtnX, regBtnY + 60, regBtnWidth, regBtnHeight);
        register.add(regCreateAccBtn);
        
        JButton regBackBtn = new JButton("Back");
        regBackBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		cards.show(f.getContentPane(), "LOGIN");	
        	}
        });
        regBackBtn.setBounds(regBtnX, regBtnY + 120, regBtnWidth, regBtnHeight);
        register.add(regBackBtn);
        f.setVisible(true);
	}
}
