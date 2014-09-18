package model.cases;

import java.awt.Image;
import java.util.ArrayList;

import model.elements.CaseElement;
import model.elements.Player;

/**
 * Interface représentant une case du jeu
 * @author Kaiser
 *
 */
public interface Case {
	
	public Image getImage();
	
	public void setSpawn(boolean b);
	
	public boolean getSpawn();
	
	public int getType();
	
	public void setType(int type);

	public boolean estTraversable();

	public boolean estCassable();
	
	public void casse();
	
	public void gele();
	
	public boolean hasABomb();
	
	public void setTraversable(boolean b);
	
	public ArrayList<CaseElement> getElements();
		
	public void ajouterElement(CaseElement ce);
	
	public void removeElement(CaseElement ce);
	
	public Player getJoueur();
	
	public boolean containPlayer();
	
	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);
}
