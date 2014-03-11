package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.elements.Player;
import controller.CompListener;

public class Competence extends JPanel{

	private final int c1=0,c2=1,c3=2,c4=3;
	private int comp;
	private Player p;
	
	public Competence(int comp,Player p){
		super(new GridLayout(3,1));
		this.comp=comp;
		this.p=p;
		switch(comp){
			case c1:
				add(new JLabel("A"),JLabel.CENTER);
				add(new JLabel("Puissance bombe"),JLabel.CENTER);
				break;
			case c2:
				add(new JLabel("Z"));
				add(new JLabel("Nombre bombes"),JLabel.CENTER);
				break;
			case c3:
				add(new JLabel("E"));
				add(new JLabel("Not implemented"),JLabel.CENTER);
				break;
			case c4:
				add(new JLabel("R"));
				add(new JLabel("Not implemented"),JLabel.CENTER);
				break;
				
		}
		
	}
}
