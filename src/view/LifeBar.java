package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import model.elements.Player;

public class LifeBar extends JComponent{

	private Player p;
	
	public LifeBar(Player p){
		super();
		this.p=p;
	}
	
	public double getPercentLife(){
	    return ((100*p.getPv())/p.getMaxPv());
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(), getHeight());
		if(getPercentLife()>=50){
			g.setColor(Color.GREEN);
		}else if(getPercentLife()>=33){
			g.setColor(Color.ORANGE);
		}else
			g.setColor(Color.RED);
		
		int width=(int)(getPercentLife()*getWidth())/100;
		g.fillRect(1, 1, width, getHeight()-1);
	}
}
