package util;

/**
 * Enum�ration des diff�rentes bombes et leurs effets
 * @author Kaiser
 *
 */
public enum BombType {
	RACAILLOU(0),
	SMOGO(1),
	VOLTORB(2),
	STALGAMIN(3);
	
	private int value;
	
	private BombType(int value){
		this.value=value;
	}
	
	public static BombType getBombType(int value){
		switch (value) {
		case 0:
			return RACAILLOU;
		case 1:
			return SMOGO;
		case 2:
			return VOLTORB;
		case 3:
			return STALGAMIN;
		default:
			return RACAILLOU;
		}
	}
	
	public String toString(){
		String s="";
		switch(this){
		case RACAILLOU:
			s="Racaillou";
			break;
		case SMOGO:
			s="Smogo";
			break;
		case VOLTORB:
			s="Voltorbe";
			break;
		case STALGAMIN:
			s="Stalgamin";
			break;
		default:
			break;
		}
		return s;
	}
	
	public static String getDescription(BombType bomb){
		String s="";
		switch(bomb){
		case RACAILLOU:
			s="Projette des �clats de roche, assommant les ennemis touch�s et les empeche de bouger un certain temps.";
			break;
		case SMOGO:
			s="Empoisonne les ennemis touch�s pendant un certain temps. Ceux-ci subiront plus de d�gats des prochaines bombes.";
			break;
		case VOLTORB:
			s="Paralyse les ennemis touch�s durant un certain temps, les empechants de poser des bombes.";
			break;
		case STALGAMIN:
			s="G�le le sol � l'explosion, cr�ant des blocs de glace incassables et empechant les joueurs de passer avant de fondre.";
			break;
		default:
			break;
		}
		return s;
	}
}
