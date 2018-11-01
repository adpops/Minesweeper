import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public abstract class AbstractPanel extends JPanel
{
	protected JFrame frame;
	protected int frameWidth;
	protected int frameHeight;
	protected int generalTxtWidth = 150;
	protected int generalTxtHeight = 25;
	protected int generalBtnWidth = 120;
	protected int generalBtnHeight = 25;
	protected GUIManager gui;
	
	public AbstractPanel(GUIManager gui)
	{
		generalTxtWidth = gui.getGeneralTxtWidth();
		generalTxtHeight = gui.getGeneralTxtHeight();
		generalBtnWidth = gui.getGeneralBtnWidth();
		generalBtnHeight = gui.getGeneralBtnHeight();
		frameWidth = gui.getFrameWidth();
		frameHeight = gui.getFrameHeight();
		this.gui = gui;
	}
}