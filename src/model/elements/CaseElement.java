package model.elements;

import java.awt.Image;

import util.Direction;

public interface CaseElement {
	
	String getType();
	Direction getDirection();
	Image getImage();
}
