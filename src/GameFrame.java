import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	BoardPanel boardPanel;
	
	public GameFrame(GUIManager gui)
	{
		boardPanel = gui.getBoardPanel();
		boardPanel = new BoardPanel(gui, this);
		JButton b = new JButton();
		boardPanel.add(b);
		
		createFrame();
		pack();
		this.setVisible(true);
	}
	
	private void createFrame()
	{
		setSize(30 * boardPanel.getWidth(), 30 * boardPanel.getHeight());
		this.setResizable(false);
		this.setLayout(new BorderLayout());
	}
}
