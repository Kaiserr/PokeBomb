package model.elements;

import java.awt.Image;

import model.Grille;
import model.cases.Case;
import util.Direction;
import util.ImageLoader;
import view.game.GrilleGraphique;
import view.menus.HomePane;

public class Potion extends AbstractElement{

	private final int LESSER=1,MEDIUM=2,MAX=3;
	private int power;
	private Grille plateau;
	
	public Potion(Grille plateau,Case pos,int power){
		this.power=power;
		type=5;
		this.plateau=plateau;
		position=pos;
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
	
	public Image getImage() {
		if(position.getType()==1){
			/*ImageLoader il = new ImageLoader();
			Image toReturn = il.getElement(type, Direction.FIXE);
			return toReturn;*/
			return HomePane.images.getElement(5).getImage();
		}
		return null;
	}
}
