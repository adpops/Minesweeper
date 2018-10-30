import javax.swing.JPanel;

public class StartMenuPanel extends AbstractPanel 
{
	private int generalTxtWidth;
	private int generalTxtHeight;
	private GUIManager gui;
	private String cardName = "startMenu";
	
	public StartMenuPanel(GUIManager gui)
	{
		super(gui);
		createStartMenuPanel();
		gui.addPanel(this, cardName);
	}
	
	private void createStartMenuPanel()
	{
		this.setLayout(null);
	}
	
}
