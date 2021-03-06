package util;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.elements.AbstractElement;
import model.elements.Player;

/**
 * Chargeur d'image en fonction de la direction
 * @author Kaiser
 *
 */
public class ImageLoader {

	public Image getPlayer(Direction dir,Player p){
		if(!p.isDead()){
			switch (dir){
				case HAUT:
					if(p.isFantom())
						return  new ImageIcon("resources/images/spectrumHAUT.png").getImage();
					return new ImageIcon("resources/images/PlayerHAUT.png").getImage();
				case BAS:
					if(p.isFantom())
						return  new ImageIcon("resources/images/spectrumBAS.png").getImage();
					return new ImageIcon("resources/images/PlayerBAS.png").getImage();
				case DROITE:
					if(p.isFantom())
						return  new ImageIcon("resources/images/spectrumDROITE.png").getImage();
					return new ImageIcon("resources/images/PlayerDROITE.png").getImage();
				case GAUCHE:
					if(p.isFantom())
						return  new ImageIcon("resources/images/spectrumGAUCHE.png").getImage();
					return new ImageIcon("resources/images/PlayerGAUCHE.png").getImage();
				default:
					if(p.isFantom())
						return  new ImageIcon("resources/images/spectrumBAS.png").getImage();
					return new ImageIcon("resources/images/PlayerBAS.png").getImage();
			}
		}else
			return  new ImageIcon("resources/images/tombStone.png").getImage();
	}
	
	public Image getTerrain(int type){
		
		switch (type){
		case 1:
			return new ImageIcon("resources/images/cases/VIDE.png").getImage();
		case 2:
			return new ImageIcon("resources/images/cases/MUR.png").getImage();
		case 3:
			return new ImageIcon("resources/images/cases/MUR2.png").getImage();
		default:
			return new ImageIcon("resources/images/cases/VIDE.png").getImage();
		}
		
	}
	
	public Image getElement(String type,Direction dir){
		if(type.equals("bomb"))
			return new ImageIcon("resources/images/BOMB.png").getImage();
		else if (type.equals("potion")){
			return new ImageIcon("resources/images/elements/potion.png").getImage();
		}else if(type.equals("fire")){
			switch(dir){
				case DROITE:
					return new ImageIcon("resources/images/elements/fireDROITE.png").getImage();
				case GAUCHE:
					return new ImageIcon("resources/images/elements/fireGAUCHE.png").getImage();
				default:
					return new ImageIcon("resources/images/elements/fireHAUTBAS.png").getImage();
					
			}
		}
		else return null;
	
	}
}
