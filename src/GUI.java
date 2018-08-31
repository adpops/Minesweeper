import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI
{	
	static JFrame f = 	new JFrame();
	JPanel login;
    JPanel startMenu;
    JPanel game;
    JPanel register;
     
	private JTextField loginUser;
	private JPasswordField loginPass;
	private JTextField regUser;
	private JPasswordField regPass;
	
	CardLayout cards = new CardLayout();

	public GUI()
	{
		//length and width of board, will determine how many tiles are created. Inputed by user during difficulty selection.
		int height = 1;
		int width = 1;
	
		//This will create the window
		f.setResizable(false);
        f.setSize(1600, 900);
        f.setTitle("Minesweeper");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(cards);
        
        int frameX = f.getWidth();
		int frameY = f.getHeight();
        	
		
		
        /*******************/
        /*   Login Panel   */
        /*******************/
		
        login = new JPanel();
        f.getContentPane().add(login, "LOGIN");
        login.setLayout(null);
        
        //Create Login Fields 
        int loginFieldWidth = 130;
        int loginFieldHeight = 35;
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
        int loginLblWidth = 100;
        int loginLblHeight = 25;
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
        int loginBtnWidth = 120;
        int loginBtnHeight = 35;
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
        	{        		cards.show(f.getContentPane(), "REGISTER");	
        	}
        });
        loginRegBtn.setBounds(loginBtnX, loginBtnY + 120, loginBtnWidth, loginBtnHeight);
        login.add(loginRegBtn);
        
        JButton loginExitBtn = new JButton("Exit");
        loginExitBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		System.exit(0);
        	}
        });
        loginExitBtn.setBounds(loginBtnX, loginBtnY + 220, loginBtnWidth, loginBtnHeight);
        login.add(loginExitBtn);
        
        
        
        /**********************/
        /*  Start Menu Panel  */
        /**********************/
        startMenu = new JPanel();
        f.getContentPane().add(startMenu, "START");
        
        
        
        /*******************/
        /*   Game Panel    */
        /*******************/
        
        game = new JPanel();
        f.getContentPane().add(game, "GAME");
        
        
        
        /**********************/
        /*   Register Panel   */
        /**********************/
        
        register = new JPanel();
        f.getContentPane().add(register, "REGISTER");
        register.setLayout(null);
        
        //Create Register Fields 
        int regFieldWidth= 130;
        int regFieldHeight = 35;
        int regFieldX = (frameX - loginFieldWidth)/2;
        int regFieldY = (frameY - regFieldHeight)/2;
        
        regUser = new JTextField();
        regUser.setBounds(regFieldX, regFieldY - 30, loginFieldWidth, regFieldHeight);
        register.add(regUser);
        regUser.setColumns(10);
        
        regPass = new JPasswordField();
        regPass.setBounds(regFieldX, regFieldY + 30, loginFieldWidth, regFieldHeight);
        register.add(regPass);
       
        //Create Username and Password Labels
        int regLblWidth = 100;
        int regLblHeight = 25;
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
        int regBtnWidth = 150;
        int regBtnHeight = 35;
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
