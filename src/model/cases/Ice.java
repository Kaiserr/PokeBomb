package model.cases;

import java.util.ArrayList;

import model.elements.CaseElement;

/**
 * Mur de glace
 * @author Kaiser
 *
 */
public class Ice extends AbstractCase{

	public Ice(int x,int y){
		this.x=x;
		this.y=y;
		type=4;
		elements = new ArrayList<CaseElement>();
		traversable=false;
		cassable=true;
	}
	
	public int getType() {
		return type;
	}

}
