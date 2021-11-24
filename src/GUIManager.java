import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIManager {
    private JFrame frame;
    private int frameWidth;
    private int frameHeight;
    private int generalTxtWidth = 150;
    private int generalTxtHeight = 25;
    private int generalBtnWidth = 120;
    private int generalBtnHeight = 25;
    private Account acc;
    private int difficulty;
    private CardLayout cards = new CardLayout(0, 0);

    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private StartMenuPanel startMenuPanel;
    private GameFrame gameFrame;
    private BoardPanel boardPanel;

    public GUIManager() {
	frameWidth = 400;
	frameHeight = 700;
	frame = new JFrame();
	frame.setSize(frameWidth, frameHeight);
	frame.setTitle("Minesweeper");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.getContentPane().setLayout(cards);

	loginPanel = new LoginPanel(this);
	registerPanel = new RegisterPanel(this);
	startMenuPanel = new StartMenuPanel(this);
    }

    public void initializeBoard() {
	gameFrame = new GameFrame(this);
    }

    public int getGeneralTxtWidth() {
	return generalTxtWidth;
    }

    public int getGeneralTxtHeight() {
	return generalTxtHeight;
    }

    public int getGeneralBtnWidth() {
	return generalBtnWidth;
    }

    public int getGeneralBtnHeight() {
	return generalBtnHeight;
    }

    public int getFrameWidth() {
	return frameWidth;
    }

    public int getFrameHeight() {
	return frameHeight;
    }

    public JFrame getFrame() {
	return frame;
    }

    public Account getAccount() {
	return acc;
    }

    public int getDifficulty() {
	return difficulty;
    }

    public void setAccount(String username, String password) {
	acc = new Account(username, password);
	startMenuPanel.setAccount(acc);
    }

    public void setDifficulty(int difficulty) {
	this.difficulty = difficulty;
    }

    public void switchPanel(String cardName) {
	cards.show(frame.getContentPane(), cardName);
    }

    public void addPanel(JPanel panel, String cardName) {
	frame.getContentPane().add(panel, cardName);
    }

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GUIManager window = new GUIManager();
		    window.frame.setVisible(true);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }
}
