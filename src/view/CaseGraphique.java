package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import util.Direction;

import model.cases.Case;
import model.elements.CaseElement;
import model.elements.Player;

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
			
			SpriteLoader sl = new SpriteLoader();
			g.drawImage(sl.getTrainer(pos.getJoueur()).getImage(), 5, 5, getWidth()-10, getHeight()-5, this);
			
			//BARRE DE VIE
			g.setColor(Color.BLACK);
			g.drawRect(getWidth()-20, 5,10, getHeight()-10);
			
			double percentLife=getPercentLife(pos.getJoueur());
			
			int height=(int)(percentLife*(getHeight()-11))/100;
			if(percentLife>=50){
				g.setColor(Color.GREEN);
			}else if(percentLife>=33){
				g.setColor(Color.ORANGE);
			}else
				g.setColor(Color.RED);
			g.fillRect(getWidth()-19, 6, 9, height);
			
			g.setColor(Color.WHITE);
			
			g.drawString(pos.getJoueur().getNom(),5, 10);
		}
		
		for(CaseElement ce : pos.getElements())
			if(pos.getType()==1)
				g.drawImage(il.getElement(ce.getType(), Direction.FIXE), 0, 0, getWidth(), getHeight(), this);
			else if(!ce.getType().equals("fire") && !ce.getType().equals("potion"))
				g.drawImage(il.getElement(ce.getType(), Direction.FIXE), 0, 0, getWidth(), getHeight(), this);
	}
	
	public double getPercentLife(Player p){
		System.out.println(p.getPv());
	    return ((100*p.getPv())/p.getMaxPv());
	}
	
	public String toString(){
		return pos.containPlayer()?"X ":"_ ";
	}
}
