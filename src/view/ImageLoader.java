package view;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.elements.AbstractElement;
import model.elements.Player;

public class ImageLoader {

	public Image getPlayer(int dir,Player p){
		switch (dir){
		case AbstractElement.HAUT:
			if(p.isFantom())
				return  new ImageIcon("resources/images/spectrumHAUT.png").getImage();
			return new ImageIcon("resources/images/PlayerHAUT.png").getImage();
		case AbstractElement.BAS:
			if(p.isFantom())
				return  new ImageIcon("resources/images/spectrumBAS.png").getImage();
			return new ImageIcon("resources/images/PlayerBAS.png").getImage();
		case AbstractElement.DROITE:
			if(p.isFantom())
				return  new ImageIcon("resources/images/spectrumDROITE.png").getImage();
			return new ImageIcon("resources/images/PlayerDROITE.png").getImage();
		case AbstractElement.GAUCHE:
			if(p.isFantom())
				return  new ImageIcon("resources/images/spectrumGAUCHE.png").getImage();
			return new ImageIcon("resources/images/PlayerGAUCHE.png").getImage();
		default:
			if(p.isFantom())
				return  new ImageIcon("resources/images/spectrumBAS.png").getImage();
			return new ImageIcon("resources/images/PlayerBAS.png").getImage();
		}
	}
	
	public Image getTerrain(int type){
		
		switch (type){
		case 1:
			return new ImageIcon("resources/images/VIDE.png").getImage();
		case 2:
			return new ImageIcon("resources/images/MUR.png").getImage();
		case 3:
			return new ImageIcon("resources/images/MUR2.png").getImage();
		default:
			return new ImageIcon("resources/images/VIDE.png").getImage();
		}
		
	}
	
	public Image getElement(String type,int dir){
		if(type.equals("bomb"))
			return new ImageIcon("resources/images/BOMB.png").getImage();
		else if (type.equals("potion")){
			return new ImageIcon("resources/images/potion.png").getImage();
		}else if(type.equals("fire")){
			switch(dir){
				case AbstractElement.DROITE:
					return new ImageIcon("resources/images/fireDROITE.png").getImage();
				case AbstractElement.GAUCHE:
					return new ImageIcon("resources/images/fireGAUCHE.png").getImage();
				default:
					return new ImageIcon("resources/images/fireHAUTBAS.png").getImage();
					
			}
		}
		else return null;
	
	}
}
