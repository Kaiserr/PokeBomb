package model.elements;

import java.awt.Image;

import util.Direction;

/**
 * Interface Element représentant un élément sur une case (joueur, potions, explosions...)
 * @author Kaiser
 *
 */
public interface CaseElement {
	
	int getType();
	Direction getDirection();
	Image getImage();
}
