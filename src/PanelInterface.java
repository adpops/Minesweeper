import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class PanelInterface extends JPanel
{
	private int generalTxtWidth;
	private int generalTxtHeight;
	private GUIManager gui;
	
	public PanelInterface(GUIManager gui)
	{
		generalTxtWidth = gui.getGeneralTxtWidth();
		generalTxtHeight = gui.getGeneralTxtHeight();
		this.gui = gui;
	}
}