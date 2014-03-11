package model.elements;

import model.Grille;
import model.cases.Case;
import view.GrilleGraphique;

public class Potion extends AbstractElement{

	private final int LESSER=1,MEDIUM=2,MAX=3;
	private int power;
	private Grille plateau;
	private Case position;
	
	public Potion(Grille plateau,Case pos,int power){
		this.power=power;
		type="potion";
		this.plateau=plateau;
		this.position=pos;
	}
	
	public void heal(Player p){
		p.heal(pvRestored(p));
		position.getElements().remove(this);
	}
	
	public int pvRestored(Player p){
		int pv=0;
		switch (power){
		case LESSER: //25%
			pv=p.getMaxPv()/4;
			break;
		case MEDIUM: //50%
			pv=p.getMaxPv()/2;
			break;
		case MAX: //100%
			pv=p.getMaxPv();
			break;
		}
		return pv;
	}
}
