package model.cases;

import java.util.ArrayList;

import model.elements.CaseElement;

public class MurCassable extends AbstractCase{
	
	public MurCassable(int x,int y){
		this.x=x;
		this.y=y;
		type=3;
		elements = new ArrayList<CaseElement>();
		traversable=false;
		cassable=true;
	}
	
	public int getType() {
		return type;
	}

}
