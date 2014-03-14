package model.elements;

import java.awt.Image;

import util.Direction;
import util.ImageLoader;
import view.menus.HomePane;
import model.cases.Case;

public class Fire extends AbstractElement{

	private Bomb source;
	//private int direction;
	private String type;
	
	public Fire(Bomb b,Case position,Direction direction){
		source=b;
		position=position;
		//this.direction=direction;
		
		this.setDirection(direction);
		this.type="fire";
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Image getImage() {
		/*ImageLoader il = new ImageLoader();
		Image toReturn = il.getElement(type, Direction.FIXE);
		return toReturn;*/
		return HomePane.images.getElement(0).getImage();
	}
}
