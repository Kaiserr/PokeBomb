package model.elements;

import util.Direction;

public abstract class AbstractElement implements CaseElement{

	//public static final int HAUT=1,BAS=2,DROITE=3,GAUCHE=4;
	//protected int direction;
	private Direction dir;
	protected String type;
	
	public String getType(){
		return type;
	}
	
	public Direction getDirection() {
		return this.dir;
	}
	
	public void setDirection(Direction direction) {
		this.dir = direction;
	}
	
}
