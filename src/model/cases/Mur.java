package model.cases;

import java.util.ArrayList;

import model.elements.CaseElement;

/**
 * Mur incassable
 * @author Kaiser
 *
 */
public class Mur extends AbstractCase{
	
	public Mur(int x,int y){
		this.x=x;
		this.y=y;
		type=2;
		elements = new ArrayList<CaseElement>();
		traversable=false;
	}
	
	public int getType() {
		return type;
	}

}
