package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.cases.Case;
import model.elements.CaseElement;
import model.elements.Fire;

public class CaseGraphique extends JPanel {

	private Case pos;
	private ImageLoader il;
	private GrilleGraphique cg;

	public CaseGraphique(Case pos,GrilleGraphique cg) {
		super();
		il=new ImageLoader();
		this.cg=cg;
		this.pos = pos;
	}
	
	public void paintComponent(Graphics g){
	
		g.drawImage(il.getTerrain(pos.getType()), 0, 0, getWidth(), getHeight(), this);
		
		if(pos.containPlayer()){
			g.drawImage(il.getPlayer(pos.getJoueur().getDirection(),pos.getJoueur()), 0, 0, getWidth(), getHeight(), this);
			g.setColor(Color.GREEN);
			g.drawString("PV: "+pos.getJoueur().getPv(),5, getHeight()-5);
		}
		
		for(CaseElement ce : pos.getElements())
			if(pos.getType()==1)
				g.drawImage(il.getElement(ce.getType(),0), 0, 0, getWidth(), getHeight(), this);
			else if(!ce.getType().equals("fire") && !ce.getType().equals("potion"))
				g.drawImage(il.getElement(ce.getType(), 0), 0, 0, getWidth(), getHeight(), this);
	}
	
	public String toString(){
		return pos.containPlayer()?"X ":"_ ";
	}
}
