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
    
	private JTextField username;
	private JPasswordField password;
	
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
        
        username = new JTextField();
        username.setBounds(loginFieldX, loginFieldY - 30, loginFieldWidth, loginFieldHeight);
        login.add(username);
        username.setColumns(10);
        
        password = new JPasswordField();
        password.setBounds(loginFieldX, loginFieldY + 30, loginFieldWidth, loginFieldHeight);
        login.add(password);
        
        //Create Login and Register Buttons  
        int loginBtnWidth = 120;
        int loginBtnHeight = 35;
        int loginBtnX = loginFieldX + (loginFieldWidth - loginBtnWidth)/2;
        int loginBtnY = loginFieldY + 30;
        
        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		cards.show(f.getContentPane(), "START");
        	}
        });
        loginBtn.setBounds(loginBtnX, loginBtnY + 60, loginBtnWidth, loginBtnHeight);
        login.add(loginBtn);
        
        JButton registerBtn = new JButton("Register");
        registerBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		cards.show(f.getContentPane(), "REGISTER");
        	}
        });
        registerBtn.setBounds(loginBtnX, loginBtnY + 120, loginBtnWidth, loginBtnHeight);
        login.add(registerBtn);
        
        //Create Username and Password Labels
        int loginLblWidth = 100;
        int loginLblHeight = 25;
        int loginLblX = loginFieldX - 110;
        int loginLblY = loginFieldY;
        
        JLabel userLbl = new JLabel("Username");
        userLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userLbl.setBounds(loginLblX, loginLblY - 25, loginLblWidth, loginLblHeight);
        login.add(userLbl);
        
        JLabel passLbl = new JLabel("Password");
        passLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passLbl.setBounds(loginLblX, loginLblY + 35, loginLblWidth, loginLblHeight);
        login.add(passLbl);
        
        
        
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
        f.setVisible(true);
	}
}
