import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel {
    protected JFrame frame;
    protected int frameWidth;
    protected int frameHeight;
    protected int generalTxtWidth = 150;
    protected int generalTxtHeight = 25;
    protected int generalBtnWidth = 120;
    protected int generalBtnHeight = 25;
    protected GUIManager gui;
    protected Account acc;

    public AbstractPanel(GUIManager gui) {
	generalTxtWidth = gui.getGeneralTxtWidth();
	generalTxtHeight = gui.getGeneralTxtHeight();
	generalBtnWidth = gui.getGeneralBtnWidth();
	generalBtnHeight = gui.getGeneralBtnHeight();
	frameWidth = gui.getFrameWidth();
	frameHeight = gui.getFrameHeight();
	this.gui = gui;
    }

    public void setAccount(Account acc) {
	this.acc = acc;
    }
}