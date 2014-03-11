package model.elements;

public abstract class AbstractElement implements CaseElement{

	public static final int HAUT=1,BAS=2,DROITE=3,GAUCHE=4;
	protected int direction;
	protected String type;
	
	public String getType(){
		return type;
	}
	
}
