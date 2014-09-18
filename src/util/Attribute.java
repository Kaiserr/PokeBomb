package util;

/**
 * �num�ration des capacit�s que peut choisir le joueur
 * @author Kaiser
 *
 */
public enum Attribute {
	PV(0),
	XP(1),
	DAMAGE(2),
	BOMB(3),
	INVISIBILITY(4),
	HEAL(5),
	EFFECTREDUCTION(6),
	NONE(7);
	
	private int value;
	
	private Attribute(int value){
		this.value=value;
	}
	
	public static Attribute getAttribute(int value){
		switch (value) {
		case 0:
			return PV;
		case 1:
			return XP;
		case 2:
			return DAMAGE;
		case 3:
			return BOMB;
		case 4:
			return INVISIBILITY;
		case 5:
			return HEAL;
		case 6:
			return EFFECTREDUCTION;
		default:
			return NONE;
		}
	}
	
	public String toString(){
		String s="";
		switch(this){
		case PV:
			s="Bonus de Points de vie";
			break;
		case XP:
			s="Bonus d'experience";
			break;
		case DAMAGE:
			s="Bonus aux d�gats des bombes";
			break;
		case BOMB:
			s="Bombe suppl�mentaire";
			break;
		case INVISIBILITY:
			s="Invisibilit�";
			break;
		case HEAL:
			s="Drain de vie";
			break;
		case EFFECTREDUCTION:
			s="R�duction des effets";
			break;
		default:
			s="Aucun bonus";
			break;
		}
		return s;
	}
	
	public static String getDescription(Attribute attr){
		String s="";
		switch(attr){
		case PV:
			s="Commence avec plus de points de vie et gagne plus de points de vie par niveaux.";
			break;
		case XP:
			s="Gagne plus d'exp�rience durant la partie.";
			break;
		case DAMAGE:
			s="Les bombes infligeront plus de d�gats aux adversaires.";
			break;
		case BOMB:
			s="Commence la partie avec une bombe suppl�mentaire.";
			break;
		case INVISIBILITY:
			s="Vous deviendrez invisible aux yeux des autres joueurs pendant un court instant lorsque vous subissez des d�gats.";
			break;
		case HEAL:
			s="Vous r�cuperer une partie des d�gats inflig�s par vos bombes sous la forme de points de vie.";
			break;
		case EFFECTREDUCTION:
			s="Les effets du type paralysie, poison etc dureront moins longtemps sur vous que sur les autres joueurs.";
			break;
		default:
			s="Aucun bonus";
			break;
		}
		return s;
	}
}
