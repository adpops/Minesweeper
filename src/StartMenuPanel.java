import javax.swing.JPanel;

public class StartMenuPanel extends JPanel 
{
	private int generalTxtWidth;
	private int generalTxtHeight;
	private GUIManager gui;
	
	public StartMenuPanel(GUIManager gui)
	{
		generalTxtWidth = gui.getGeneralTxtWidth();
		generalTxtHeight = gui.getGeneralTxtHeight();
		this.gui = gui;
		createStartMenuPanel();
	}
	
	private void createStartMenuPanel()
	{
		this.setLayout(null);
	}
	
}
