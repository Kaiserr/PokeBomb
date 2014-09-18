package view.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import model.cases.Case;
import model.elements.Bomb;
import model.elements.CaseElement;
import model.elements.Player;
import util.Direction;
import util.ImageLoader;
import util.SpriteLoader;
import view.menus.HomePane;

/**
 * Représentation graphique d'une case
 * @author Kaiser
 *
 */
public class CaseGraphique extends JPanel {

	private Case pos;
	private GrilleGraphique cg;

	public CaseGraphique(Case pos,GrilleGraphique cg) {
		super();
		this.cg=cg;
		this.pos = pos;
	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawImage(HomePane.images.getCase(pos.getType()).getImage(), 0, 0, getWidth(), getHeight(), this);
		
		if(pos.containPlayer()){
			
			
			g2.drawImage(HomePane.images.getTrainer(pos.getJoueur()).getImage(), 5,  getHeight()-((int)Math.round(  getHeight()*.8)), (int)Math.round( getWidth()*.8), (int)Math.round(  getHeight()*.8), this);
			
			//BARRE DE VIE
			g2.setColor(Color.BLACK);
			g2.drawRect(getWidth()-20, 5,10, getHeight()-10);
			
			double percentLife=getPercentLife(pos.getJoueur());
			double percentMissing=getPercentLifeMissing(pos.getJoueur());
			int height=(int)(percentLife*(getHeight()-11))/100;
			int offSet=(int)(percentMissing*(getHeight()-11))/100;
			if(percentLife>=50){
				g2.setColor(Color.GREEN);
			}else if(percentLife>=33){
				g2.setColor(Color.ORANGE);
			}else
				g2.setColor(Color.RED);
			g2.fillRect(getWidth()-19, 6+offSet, 9, height);
			
			g2.setColor(Color.WHITE);
			Font textFont = new Font("Arial", Font.BOLD, 12); 
			g2.setFont(textFont);
			
			g2.drawString(pos.getJoueur().getNom()+" "+pos.getJoueur().getLvl(),8, 13);
		}
		
		for(CaseElement ce : pos.getElements())
			if(ce != pos.getJoueur())
				g2.drawImage(ce.getImage(), 0, 0,getWidth(),getHeight(), this);
				
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
	
	public void setPosition(Case c){
		this.pos=c;
	}
}
