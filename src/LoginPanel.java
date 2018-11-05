import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class LoginPanel extends AbstractPanel
{
	String cardName = "login";

	public LoginPanel(GUIManager gui)
	{
		super(gui);
		createPanel();
		gui.addPanel(this, cardName);
	}
	
	private void createPanel() 
	{
		this.setLayout(null);
		int txtWidth = generalTxtWidth;
		int txtHeight = generalTxtHeight;
		int txtX = 125;
		int userTxtY = 160;
	    JTextField loginUserTxt = new JTextField();
	    loginUserTxt.setBounds(txtX, userTxtY, txtWidth, txtHeight);
	    this.add(loginUserTxt);
	    loginUserTxt.setColumns(10);
	    
	    int passTxtY = 200; 
	    JPasswordField loginPassField = new JPasswordField();
	    loginPassField.setBounds(txtX, passTxtY, txtWidth, txtHeight);
	    this.add(loginPassField);
	    
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
	    this.add(loginUserPane);
	    
	    int passPaneY = passTxtY;
	    JTextPane loginPassPane = new JTextPane();
	    loginPassPane.setForeground(Color.BLACK);
	    loginPassPane.setBackground(new Color(240, 240, 240));
	    loginPassPane.setText("Password");
	    loginPassPane.setBounds(paneX, passPaneY, paneWidth, paneHeight);
	    loginPassPane.setEditable(false);;
	    this.add(loginPassPane);
	    
	    int btnWidth = generalBtnWidth;
	    int btnHeight = generalBtnHeight;
	    int btnX = 125;
	    int btnY = 260;
	    JButton loginBtn = new JButton("Login");
	    loginBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		gui.switchPanel("startMenu");
	    	}
	    });
	    loginBtn.setBounds(btnX, btnY, btnWidth, btnHeight);
	    this.add(loginBtn);
	    
	    JButton registerBtn = new JButton("Register");
	    registerBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		gui.switchPanel("register");
	    	}
	    });
	    registerBtn.setBounds(btnX, btnY + 40, btnWidth, btnHeight);
	    this.add(registerBtn);
	    
	    JButton exitBtn = new JButton("Exit");
	    exitBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		System.exit(1);
	    	}
	    });
	    exitBtn.setBounds(btnX, btnY + 40*2, btnWidth, btnHeight);
	    this.add(exitBtn);
	}
}
