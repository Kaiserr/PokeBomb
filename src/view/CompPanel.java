package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.elements.Player;

public class CompPanel extends JPanel{
	
	private Player p;
	
	public CompPanel(Player p){
		super(new GridLayout(1,0));
		this.p=p;
		
		for(int i=0;i<4;i++)
			add(new Competence(i,p));
		
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}
}
