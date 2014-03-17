package model.cases;

import java.awt.Image;
import java.util.ArrayList;

import model.elements.CaseElement;
import model.elements.Player;
import view.menus.HomePane;

public abstract class AbstractCase implements Case{

	protected ArrayList<CaseElement> elements;
	protected boolean containPlayer=false;
	protected int x;
	protected int y;
	protected int type;
	protected boolean traversable,hasABomb=false,cassable=false;
	
	public Image getImage(){
		return HomePane.images.getCase(type).getImage();
	}
	
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
	
	public void gele(){
		type=4;
		traversable=false;
	}
	
	public void setTraversable(boolean t){
		traversable=t;
	}
	
	public boolean estTraversable(){
		return traversable && !hasABomb;
	}
	
	public void ajouterElement(CaseElement ce){
		elements.add(ce);
		if(ce.getType()==6)
			containPlayer=true;
		if(ce.getType()==4)
			hasABomb=true;
	}
	
	public Player getJoueur(){
		if(containPlayer){
			for(CaseElement ce : getElements()){
				if(ce.getType()==6)
					return (Player)ce;
			}
		}
		return null;
	}
	
	public void removeElement(CaseElement ce){
		elements.remove(ce);
		if(ce.getType()==6)
			containPlayer=false;
		if(ce.getType()==4)
			hasABomb=false;
	}
	
	public void removeElementByType(int type){
		for(CaseElement ce : getElements()){
			if(ce.getType()== type ){
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
