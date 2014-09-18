package model.elements;

import java.awt.Image;

import util.Direction;
import util.ImageLoader;
import view.menus.HomePane;
import model.cases.Case;

/**
 * Le sprite de détonnation d'une bombe !
 * @author Kaiser
 *
 */
public class Fire extends AbstractElement{

	private Bomb source;
	//private int direction;
	private int type;
	private int subType;
	
	public Fire(Bomb b,Case position,Direction direction){
		source=b;
		position=position;
		//this.direction=direction;
		
		this.setDirection(direction);
		type=0;
		subType=b.getProprio().getBomb();
	}

	public Bomb getSource() {
		return source;
	}

	public void setSource(Bomb source) {
		this.source = source;
	}

	public Case getPosition() {
		return position;
	}

	public void setPosition(Case position) {
		this.position = position;
	}

	/*
	public int getDirection() {
		return direction;
	}
	

	public void setDirection(int direction) {
		this.direction = direction;
	}
*/
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public Image getImage() {
		/*ImageLoader il = new ImageLoader();
		Image toReturn = il.getElement(type, Direction.FIXE);
		return toReturn;*/
		return HomePane.images.getElement(subType).getImage();
	}
}
