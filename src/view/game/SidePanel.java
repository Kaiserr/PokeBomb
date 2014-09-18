package view.game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Game;
import model.elements.Player;
import controller.StartListener;

/**
 * DEPRECATED // A IMPLEMENTER ?
 * Panel d'infos du jeu
 * @author Kaiser
 *
 */
public class SidePanel extends JPanel{
	
	private Game g;
	private JButton start;
	private JPanel playerPane;
	private GrilleGraphique gg;
	
	public SidePanel(Game g,GrilleGraphique gg){
		super(new BorderLayout());
		this.g=g;
		this.gg=gg;
		add(new CreatePlayerPanel(g,this),BorderLayout.NORTH);
		
		playerPane=new JPanel(new GridLayout(0,1));
		add(playerPane,BorderLayout.CENTER);
		
		start=new JButton("Commencer !");
		add(start,BorderLayout.SOUTH);
		start.addActionListener(new StartListener(g,this));
	}
	
	public void addPlayer(Player p){
		g.addPlayer(p);
		playerPane.add(new PlayerPanel(p));
		
		repaint();
		validate();
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public JPanel getPlayerPane() {
		return playerPane;
	}

	public void setPlayerPane(JPanel playerPane) {
		this.playerPane = playerPane;
	}

	public GrilleGraphique getGg() {
		return gg;
	}

	public void setGg(GrilleGraphique gg) {
		this.gg = gg;
	}
}
