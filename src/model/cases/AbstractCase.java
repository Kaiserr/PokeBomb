package model.cases;

import java.util.ArrayList;

import model.elements.AbstractElement;
import model.elements.CaseElement;
import model.elements.Player;

public abstract class AbstractCase implements Case{

	protected ArrayList<CaseElement> elements;
	protected boolean containPlayer=false;
	protected int x;
	protected int y;
	protected int type;
	protected boolean traversable,hasABomb=false,cassable=false;
	
	public ArrayList<CaseElement> getElements(){
		return elements;
	}
	
	public boolean estCassable(){
		return cassable;
	}
	
	public void casse(){
		if(estCassable()){
			type=1;
			traversable=true;
			
		}
	}
	
	public void setTraversable(boolean t){
		traversable=t;
	}
	
	public boolean estTraversable(){
		return traversable && !hasABomb;
	}
	
	public void ajouterElement(CaseElement ce){
		elements.add(ce);
		if(ce.getType().equals("player"))
			containPlayer=true;
		if(ce.getType().equals("bomb"))
			hasABomb=true;
	}
	
	public Player getJoueur(){
		if(containPlayer){
			for(CaseElement ce : getElements()){
				if(ce.getType().equals("player"))
					return (Player)ce;
			}
		}
		return null;
	}
	
	public void removeElement(CaseElement ce){
		elements.remove(ce);
		if(ce.getType().equals("player"))
			containPlayer=false;
		if(ce.getType().equals("bomb"))
			hasABomb=false;
	}
	
	public void removeElementByType(String type){
		for(CaseElement ce : getElements()){
			if(ce.getType().equals(type)){
				getElements().remove(ce);
				return;
			}
			
		}
	}
	
	public boolean hasABomb(){
		return hasABomb;
	}
	
	public boolean containPlayer(){
		return containPlayer;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
