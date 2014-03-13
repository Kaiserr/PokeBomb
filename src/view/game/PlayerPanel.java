package view.game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.ImageLoader;
import model.elements.Player;

public class PlayerPanel extends JPanel{
	
	private Player p;
	
	public PlayerPanel(Player p){
		super(new GridLayout(0,1));
		this.p=p;
		ImageLoader il = new ImageLoader();
		add(new JLabel(p.getNom()));
		add(new JLabel(new ImageIcon("resources/images/PlayerBAS.png")));
		
	}
}
