package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Grille;
import model.elements.AbstractElement;
import model.elements.CaseElement;
import model.elements.Potion;
import util.Direction;
import view.GrilleGraphique;

public class KeyboardListener implements KeyListener{
	
	private GrilleGraphique gg;
	private Grille g;
	
	public KeyboardListener(GrilleGraphique gg){
		this.gg=gg;
		this.g=gg.getG();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void keyPressed(KeyEvent e) {
		if(!g.getJoueur(0).isDead()){
			switch (e.getKeyCode()){
			
				case KeyEvent.VK_UP:
					if(g.getJoueur(0).getDirection()==AbstractElement.HAUT)
						g.deplacerJoueur(0,AbstractElement.HAUT);
					else
						g.getJoueur(0).orienter(AbstractElement.HAUT);
					break;
				case KeyEvent.VK_DOWN:
					if(g.getJoueur(0).getDirection()==AbstractElement.BAS)
						g.deplacerJoueur(0,AbstractElement.BAS);
					else
						g.getJoueur(0).orienter(AbstractElement.BAS);
					break;
				case KeyEvent.VK_RIGHT:
					if(g.getJoueur(0).getDirection()==AbstractElement.DROITE)
						g.deplacerJoueur(0,AbstractElement.DROITE);
					else
						g.getJoueur(0).orienter(AbstractElement.DROITE);
					break;
				case KeyEvent.VK_LEFT:
					if(g.getJoueur(0).getDirection()==AbstractElement.GAUCHE)
						g.deplacerJoueur(0,AbstractElement.GAUCHE);
					else
						g.getJoueur(0).orienter(AbstractElement.GAUCHE);
					break;
				case KeyEvent.VK_SPACE:
					g.poserBombe(gg,g.getJoueur(0));
					
					break;
					
				/*case KeyEvent.VK_W:
					g.getJoueur(0).setRadiusPower(g.getJoueur(0).getRadiusPower()+1);
					break;
				case KeyEvent.VK_X:
					g.getJoueur(0).setNbBombs(g.getJoueur(0).getNbBombs()+1);
					break;*/
					/*
			}
		}
		for(CaseElement ce : g.getPlayerCase(0).getElements()){
			if(ce.getType().equals("potion"))
				((Potion)ce).heal(g.getJoueur(0));
		}
			
		
		if(g.getJoueur(1)!=null){
			switch (e.getKeyCode()){
			
				case KeyEvent.VK_Z:
					if(g.getJoueur(1).getDirection()==AbstractElement.HAUT)
						g.deplacerJoueur(1,AbstractElement.HAUT);
					else
						g.getJoueur(1).orienter(AbstractElement.HAUT);
					break;
				case KeyEvent.VK_S:
					if(g.getJoueur(1).getDirection()==AbstractElement.BAS)
						g.deplacerJoueur(1,AbstractElement.BAS);
					else
						g.getJoueur(1).orienter(AbstractElement.BAS);
					break;
				case KeyEvent.VK_D:
					if(g.getJoueur(1).getDirection()==AbstractElement.DROITE)
						g.deplacerJoueur(1,AbstractElement.DROITE);
					else
						g.getJoueur(1).orienter(AbstractElement.DROITE);
					break;
				case KeyEvent.VK_Q:
					if(g.getJoueur(1).getDirection()==AbstractElement.GAUCHE)
						g.deplacerJoueur(1,AbstractElement.GAUCHE);
					else
						g.getJoueur(1).orienter(AbstractElement.GAUCHE);
					break;
				case KeyEvent.VK_E:
					g.poserBombe(gg,g.getJoueur(1));
					
					break;
			}
			for(CaseElement ce : g.getPlayerCase(1).getElements()){
				if(ce.getType().equals("potion"))
					((Potion)ce).heal(g.getJoueur(1));
			}
			
		}
		
		gg.repaint();
		
	}
*/
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(!g.getJoueur(0).isDead()){
			switch (e.getKeyCode()){
			
				case KeyEvent.VK_UP:
					if(g.getJoueur(0).getDirection()==Direction.HAUT)
						g.deplacerJoueur(0,Direction.HAUT);
					else
						g.getJoueur(0).orienter(Direction.HAUT);
					break;
				case KeyEvent.VK_DOWN:
					if(g.getJoueur(0).getDirection()==Direction.BAS)
						g.deplacerJoueur(0,Direction.BAS);
					else
						g.getJoueur(0).orienter(Direction.BAS);
					break;
				case KeyEvent.VK_RIGHT:
					if(g.getJoueur(0).getDirection()==Direction.DROITE)
						g.deplacerJoueur(0,Direction.DROITE);
					else
						g.getJoueur(0).orienter(Direction.DROITE);
					break;
				case KeyEvent.VK_LEFT:
					if(g.getJoueur(0).getDirection()==Direction.GAUCHE)
						g.deplacerJoueur(0,Direction.GAUCHE);
					else
						g.getJoueur(0).orienter(Direction.GAUCHE);
					break;
				case KeyEvent.VK_SPACE:
					g.poserBombe(gg,g.getJoueur(0));
					
					break;
					
				/*case KeyEvent.VK_W:
					g.getJoueur(0).setRadiusPower(g.getJoueur(0).getRadiusPower()+1);
					break;
				case KeyEvent.VK_X:
					g.getJoueur(0).setNbBombs(g.getJoueur(0).getNbBombs()+1);
					break;*/
					
			}
		}
		for(CaseElement ce : g.getPlayerCase(0).getElements()){
			if(ce.getType().equals("potion"))
				((Potion)ce).heal(g.getJoueur(0));
		}
			
		
		if(g.getJoueur(1)!=null){
			switch (e.getKeyCode()){
			
				case KeyEvent.VK_Z:
					if(g.getJoueur(1).getDirection()==Direction.HAUT)
						g.deplacerJoueur(1,Direction.HAUT);
					else
						g.getJoueur(1).orienter(Direction.HAUT);
					break;
				case KeyEvent.VK_S:
					if(g.getJoueur(1).getDirection()==Direction.BAS)
						g.deplacerJoueur(1,Direction.BAS);
					else
						g.getJoueur(1).orienter(Direction.BAS);
					break;
				case KeyEvent.VK_D:
					if(g.getJoueur(1).getDirection()==Direction.DROITE)
						g.deplacerJoueur(1,Direction.DROITE);
					else
						g.getJoueur(1).orienter(Direction.DROITE);
					break;
				case KeyEvent.VK_Q:
					if(g.getJoueur(1).getDirection()==Direction.GAUCHE)
						g.deplacerJoueur(1,Direction.GAUCHE);
					else
						g.getJoueur(1).orienter(Direction.GAUCHE);
					break;
				case KeyEvent.VK_E:
					g.poserBombe(gg,g.getJoueur(1));
					
					break;
			}
			for(CaseElement ce : g.getPlayerCase(1).getElements()){
				if(ce.getType().equals("potion"))
					((Potion)ce).heal(g.getJoueur(1));
			}
			
		}
		
		gg.repaint();
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}