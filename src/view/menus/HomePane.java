package view.menus;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.SpriteLoader;
import util.StdAudio;
import model.Game;
import controller.HomeListener;

public class HomePane extends JPanel {

	private JButton solo, multi, online;
	private JFrame frame;
	private Game g = new Game();
	public static SpriteLoader images = new SpriteLoader();
	public static StdAudio audio = new StdAudio();

	public HomePane(JFrame frame) {
		super(new GridBagLayout());
		this.frame = frame;
		GridBagConstraints c = new GridBagConstraints();
		solo = new JButton("Partie solo");
		multi = new JButton("Partie multi");
		online = new JButton("Partie en ligne");
		solo.addActionListener(new HomeListener(frame, this));
		multi.addActionListener(new HomeListener(frame, this));
		online.addActionListener(new HomeListener(frame, this));
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(290, 5, 5, 5);

		c.gridx = 0;
		c.gridy = 3;
		add(solo, c);
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 4;
		add(multi, c);
		c.gridx = 0;
		c.gridy = 5;
		add(online, c);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("resources/images/menus/home.png").getImage(), 0,
				0, getWidth(), getHeight(), this);
	}

	public JButton getSolo() {
		return solo;
	}

	public void setSolo(JButton solo) {
		this.solo = solo;
	}

	public JButton getMulti() {
		return multi;
	}

	public void setMulti(JButton multi) {
		this.multi = multi;
	}

	public JButton getOnline() {
		return online;
	}

	public void setOnline(JButton online) {
		this.online = online;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

}
