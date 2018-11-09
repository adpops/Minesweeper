import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class RegisterPanel extends AbstractPanel 
{
	private String cardName = "register";

	public RegisterPanel(GUIManager gui) 
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
	    JTextField regUserTxt = new JTextField();
	    regUserTxt.setBounds(txtX, userTxtY, txtWidth, txtHeight);
	    this.add(regUserTxt);
	    regUserTxt.setColumns(10);
	    
	    int passTxtY = 200; 
	    JPasswordField regPassField = new JPasswordField();
	    regPassField.setBounds(txtX, passTxtY, txtWidth, txtHeight);
	    this.add(regPassField);
	    
	    int paneWidth = 63;
	    int paneHeight = 25;
	    int paneX = 50;
	    int userPaneY = userTxtY;
	    JTextPane regUserPane = new JTextPane();
	    regUserPane.setForeground(Color.BLACK);
	    regUserPane.setBackground(new Color(240, 240, 240));
	    regUserPane.setText("Username");
	    regUserPane.setBounds(paneX, userPaneY, paneWidth, paneHeight);
	    regUserPane.setEditable(false);;
	    this.add(regUserPane);
	    
	    int passPaneY = passTxtY;
	    JTextPane regPassPane = new JTextPane();
	    regPassPane.setForeground(Color.BLACK);
	    regPassPane.setBackground(new Color(240, 240, 240));
	    regPassPane.setText("Password");
	    regPassPane.setBounds(paneX, passPaneY, paneWidth, paneHeight);
	    regPassPane.setEditable(false);;
	    this.add(regPassPane);
	    
	    int btnWidth = generalBtnWidth + 10;
	    int btnHeight = generalBtnHeight;
	    int btnX = 125;
	    int createBtnY = 260;
	    JButton createAccBtn = new JButton("Create Account");
	    createAccBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		gui.setAccount(regUserPane.toString(), regPassPane.toString());
	    		gui.switchPanel("startMenu");
	    	}
	    });
	    createAccBtn.setBounds(btnX, createBtnY, btnWidth, btnHeight);
	    this.add(createAccBtn);
	    
	    int backBtnY = createBtnY + 40;
	    JButton backBtn = new JButton("Back");
	    backBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		gui.switchPanel("login");
	    	}
	    });
	    backBtn.setBounds(btnX, backBtnY, btnWidth, btnHeight);
	    this.add(backBtn);

	}
}
