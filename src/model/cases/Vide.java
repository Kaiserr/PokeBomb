package model.cases;

import java.util.ArrayList;

import model.elements.CaseElement;

public class Vide extends AbstractCase{
	
	
	public Vide(int x,int y){
		this.x=x;
		this.y=y;
		type=1;
		elements = new ArrayList<CaseElement>();
		traversable=true;
	}
	

	public int getType() {
		return type;
	}
	
	

}
