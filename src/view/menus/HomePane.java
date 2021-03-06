package view.menus;

import java.awt.Font;
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

/**
 * Panel de la page d'acceuil !
 * @author Kaiser
 *
 */
public class HomePane extends JPanel {


	private JButton solo, multi, online, editor, exit;
	private JFrame frame;
	private Game g = new Game();
	public static SpriteLoader images = new SpriteLoader();
	public static StdAudio audio = new StdAudio();
	public static Font font22 = new Font("Serif", Font.BOLD, 22);
	public static Font font14 = new Font("Serif", Font.BOLD, 12);

	public HomePane(JFrame frame) {
		super(new GridBagLayout());
		this.frame = frame;
		GridBagConstraints c = new GridBagConstraints();
		HomeListener hl = new HomeListener(frame, this);
		solo = new JButton("Partie solo");
		solo.setFont(font14);
		multi = new JButton("Partie multi");
		multi.setFont(font14);
		online = new JButton("Partie en ligne");
		online.setFont(font14);
		editor=new JButton("Editeur de cartes");
		editor.setFont(font14);
		exit = new JButton("Quitter");
		exit.setFont(font14);
		
		solo.addActionListener(hl);
		multi.addActionListener(hl);
		online.addActionListener(hl);
		editor.addActionListener(hl);
		exit.addActionListener(hl);

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
		c.gridx = 0;
		c.gridy = 6;
		add(editor, c);
		c.gridx = 0;
		c.gridy = 7;
		add(exit, c);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(
				new ImageIcon("resources/images/menus/home.png").getImage(), 0,
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
	
	public JButton getEditor() {
		return editor;
	}

	public void setEditor(JButton editor) {
		this.editor = editor;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
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
