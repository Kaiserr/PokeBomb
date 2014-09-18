package model.elements;

import java.awt.Image;

import model.cases.Case;
import util.Direction;
import util.SpriteLoader;

/**
 * Elément abstrait regroupant les fonctions et attributs communs a tous les éléments
 * @author Kaiser
 *
 */
public abstract class AbstractElement implements CaseElement{

	//public static final int HAUT=1,BAS=2,DROITE=3,GAUCHE=4;
	//protected int direction;
	protected Case position;
	private Direction dir;
	protected int type;
	
	public int getType(){
		return type;
	}
	
	public Direction getDirection() {
		return this.dir;
	}
	
	public void setDirection(Direction direction) {
		this.dir = direction;
	}
	
	public abstract Image getImage();	
}
