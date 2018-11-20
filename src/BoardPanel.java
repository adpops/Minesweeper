
public class BoardPanel extends AbstractPanel
{
	int difficulty;
	int width;
	int height;
	
	public BoardPanel(GUIManager gui) 
	{
		super(gui);
		this.difficulty = gui.getDifficulty();
		decideBoardDimensions();
		createPanel();
	}
	
	private void createPanel()
	{
		
	}
	
	private void decideBoardDimensions()
	{
		switch(difficulty)
		{
			case 0:
				
		}
	}
}
