package util;

/**
 * Enumération des différents types de cases
 * @author Kaiser
 *
 */
public enum CaseType {

	VIDE(1),
	MUR(2),
	MURCASSABLE(3),
	GLACE(4),
	SPAWN(5);
	
	private int value;
	
	private CaseType(int value){
		this.value=value;
	}
	
	public static CaseType getCaseType(int value){
		switch (value) {
		case 0:
			return VIDE;
		case 1:
			return MUR;
		case 2:
			return MURCASSABLE;
		case 3:
			return GLACE;
		default:
			return SPAWN;
		}
	}
	
	public String toString(){
		String s="";
		switch(this){
		case VIDE:
			s="Vide";
			break;
		case MUR:
			s="Mur";
			break;
		case MURCASSABLE:
			s="Mur cassable";
			break;
		case GLACE:
			s="Glace";
			break;
		default:
			s="Spawn";
			break;
		}
		return s;
	}
	
	public int getValue(){
		return value;
	}
}
