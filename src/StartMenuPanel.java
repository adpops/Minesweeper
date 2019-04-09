import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartMenuPanel extends AbstractPanel {
    private String cardName = "startMenu";

    public StartMenuPanel(GUIManager gui) {
	super(gui);
	createPanel();
	gui.addPanel(this, cardName);
    }

    private void createPanel() {
	this.setLayout(null);
	int btnWidth = generalBtnWidth - 10;
	int btnHeight = generalBtnHeight;
	int btnY = frameHeight / 2 - btnHeight;
	int easyBtnX = frameWidth / 3 - btnWidth - 20;
	JButton easyBtn = new JButton("Easy");
	easyBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		gui.setDifficulty(0);
		gui.initializeBoard();
		gui.switchPanel("boardPanel");
	    }
	});
	easyBtn.setBounds(easyBtnX, btnY, btnWidth, btnHeight);
	this.add(easyBtn);

	int intermediateBtnX = 2 * (frameWidth / 3) - btnWidth - 20;
	JButton intermediateBtn = new JButton("Intermediate");
	intermediateBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		gui.setDifficulty(1);
		gui.initializeBoard();
		gui.switchPanel("boardPanel");
	    }
	});
	intermediateBtn.setBounds(intermediateBtnX, btnY, btnWidth, btnHeight);
	this.add(intermediateBtn);

	int hardBtnX = frameWidth - btnWidth - 20;
	JButton hardBtn = new JButton("Expert");
	hardBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		gui.setDifficulty(2);
		gui.initializeBoard();
		gui.switchPanel("boardPanel");
	    }
	});
	hardBtn.setBounds(hardBtnX, btnY, btnWidth, btnHeight);
	this.add(hardBtn);

	int backBtnX = intermediateBtnX;
	int backBtnY = btnY + 50;
	JButton backBtn = new JButton("Back");
	backBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		gui.switchPanel("login");
	    }
	});
	backBtn.setBounds(backBtnX, backBtnY, btnWidth, btnHeight);
	this.add(backBtn);

	int leaderboardBtnX = intermediateBtnX;
	int leaderboardBtnY = backBtnY + 50;
	JButton leaderboardBtn = new JButton("Leaderboard");
	leaderboardBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// gui.switchPanel("startMenu");
	    }
	});
	leaderboardBtn.setBounds(leaderboardBtnX, leaderboardBtnY, btnWidth, btnHeight);
	this.add(leaderboardBtn);
    }
}
