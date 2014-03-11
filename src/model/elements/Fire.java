package model.elements;

import model.cases.Case;

public class Fire extends AbstractElement{

	private Bomb source;
	private Case position;
	private int direction;
	private String type;
	
	public Fire(Bomb b,Case position,int direction){
		source=b;
		this.position=position;
		this.direction=direction;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
