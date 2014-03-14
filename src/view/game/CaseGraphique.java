package view.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.cases.Case;
import model.elements.Bomb;
import model.elements.CaseElement;
import model.elements.Player;
import util.Direction;
import util.ImageLoader;
import util.SpriteLoader;

public class CaseGraphique extends JPanel {

	private Case pos;
	private ImageLoader il;
	private GrilleGraphique cg;
	private SpriteLoader sl = new SpriteLoader();

	public CaseGraphique(Case pos,GrilleGraphique cg) {
		super();
		il=new ImageLoader();
		this.cg=cg;
		this.pos = pos;
	}
	
	public void paintComponent(Graphics g){
	
		g.drawImage(il.getTerrain(pos.getType()), 0, 0, getWidth(), getHeight(), this);
		
		if(pos.containPlayer()){
			
			
			g.drawImage(sl.getTrainer(pos.getJoueur()).getImage(), 5, 5, getWidth()-10, getHeight()-5, this);
			
			//BARRE DE VIE
			g.setColor(Color.BLACK);
			g.drawRect(getWidth()-20, 5,10, getHeight()-10);
			
			double percentLife=getPercentLife(pos.getJoueur());
			double percentMissing=getPercentLifeMissing(pos.getJoueur());
			int height=(int)(percentLife*(getHeight()-11))/100;
			int offSet=(int)(percentMissing*(getHeight()-11))/100;
			if(percentLife>=50){
				g.setColor(Color.GREEN);
			}else if(percentLife>=33){
				g.setColor(Color.ORANGE);
			}else
				g.setColor(Color.RED);
			g.fillRect(getWidth()-19, 6+offSet, 9, height);
			
			g.setColor(Color.WHITE);
			
			g.drawString(pos.getJoueur().getNom()+" "+pos.getJoueur().getLvl(),8, 10);
		}
		
		for(CaseElement ce : pos.getElements())
			g.drawImage(ce.getImage(), 0, 0, getWidth(), getHeight(), this);
				
	}
	
	public double getPercentLife(Player p){
	    return ((100*p.getPv())/p.getMaxPv());
	}
	
	public double getPercentLifeMissing(Player p){
	    return ((100*(p.getMaxPv()-p.getPv()))/p.getMaxPv());
	}
	
	public String toString(){
		return pos.containPlayer()?"X ":"_ ";
	}
}
