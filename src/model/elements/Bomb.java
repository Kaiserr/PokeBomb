package model.elements;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import model.Grille;
import model.cases.AbstractCase;
import model.cases.Case;
import model.cases.Ice;
import util.Direction;
import util.SpriteLoader;
import view.game.GrilleGraphique;
import view.menus.HomePane;

/**
 * El�ment repr�sentant une bombe, Thread � part pour le timer et l'explosion sans bloquer le jeu
 * @author Kaiser
 *
 */
public class Bomb extends AbstractElement implements Runnable {

	private Grille plateau;
	private GrilleGraphique gg;
	private Thread bombThread;
	private int delay, power;
	private Player proprio;

	public Bomb(Grille plateau, Case pos, GrilleGraphique gg, int delay,
			Player proprio, int power) {
		this.plateau = plateau;
		position = pos;
		this.gg = gg;
		this.delay = delay;
		this.power = power;
		bombThread = new Thread(this);
		bombThread.start();
		type =4;
		this.proprio = proprio;

		setDirection(Direction.FIXE);
	}

	public void explode() {

		int nbCasse = 0;
		ArrayList<Case> aoe = getAOE(proprio.getRadiusPower());
		ArrayList<Player> lostHealth = new ArrayList<Player>();

		HomePane.audio.playBackGround("resources/sounds/game/explode");

		for (Case c : aoe) {
			c.ajouterElement(new Fire(this, c, Direction.FIXE));
			for (CaseElement ce : c.getElements()) {
				if (ce.getType()==6) {
					lostHealth.add((Player) ce);
				}
			}
			gg.repaint();

			if (c.estCassable()) {
				if(proprio.getBomb()==3 && proprio.getBombEvol()==1){
					Random r = new Random();
					if(r.nextBoolean() && r.nextBoolean())
						c.gele();
					else
						c.casse();
				}
					
				else
					c.casse();
				nbCasse++;
			}
		}
		try {
			bombThread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Case c : aoe){
			((AbstractCase) c).removeElementByType(0);
			
		}

		position.removeElement(this);
		int dead = 0;
		int fantom = 0;
		int touched = 0;
		for (Player p : lostHealth) {
			p.removeHP(power);
			if (p != proprio){
				touched++;
				if(p.isFantom())
						fantom++;
			    else if (p.isDead()) 
						dead++;
			
			}
			
		}
		proprio.addXp(nbCasse + (touched * 2) + (fantom * 3) + (dead * 5));
		gg.repaint();
		
		try {
			bombThread.sleep(1000);
			HomePane.audio.disposeSound();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run() {
		try {
			bombThread.sleep(delay);
			explode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Case> getAOE(int radius) {
		int x = position.getX();
		int y = position.getY();
		ArrayList<Case> voisins = new ArrayList<Case>();
		ArrayList<Case> droite = new ArrayList<Case>();
		ArrayList<Case> gauche = new ArrayList<Case>();
		ArrayList<Case> haut = new ArrayList<Case>();
		ArrayList<Case> bas = new ArrayList<Case>();
		ArrayList<Case> toRemove = new ArrayList<Case>();

		for (int i = 1; i <= radius; i++) {
			if (plateau.getCaseAt(x + i, y) != null) {
				droite.add(plateau.getCaseAt(x + i, y));
			}
			if (plateau.getCaseAt(x - i, y) != null) {
				gauche.add(plateau.getCaseAt(x - i, y));
			}
			if (plateau.getCaseAt(x, y + i) != null) {
				bas.add(plateau.getCaseAt(x, y + i));
			}
			if (plateau.getCaseAt(x, y - i) != null) {
				haut.add(plateau.getCaseAt(x, y - i));
			}
		}
		boolean remove = false;
		for (Case c : droite) {
			if (c.getType() == 2 || remove) {
				toRemove.add(c);
				remove = true;
			}
		}
		remove = false;
		for (Case c : gauche) {
			if (c.getType() == 2 || remove) {
				toRemove.add(c);
				remove = true;
			}
		}
		remove = false;
		for (Case c : haut) {
			if (c.getType() == 2 || remove) {
				toRemove.add(c);
				remove = true;
			}
		}
		remove = false;
		for (Case c : bas) {
			if (c.getType() == 2 || remove) {
				toRemove.add(c);
				remove = true;
			}
		}

		voisins.addAll(haut);
		voisins.addAll(bas);
		voisins.addAll(gauche);
		voisins.addAll(droite);
		voisins.removeAll(toRemove);
		return voisins;
	}

	public Grille getPlateau() {
		return plateau;
	}

	public void setPlateau(Grille plateau) {
		this.plateau = plateau;
	}

	public GrilleGraphique getGg() {
		return gg;
	}

	public void setGg(GrilleGraphique gg) {
		this.gg = gg;
	}

	public Case getPosition() {
		return position;
	}

	public void setPosition(Case position) {
		this.position = position;
	}

	public Thread getBombThread() {
		return bombThread;
	}

	public void setBombThread(Thread bombThread) {
		this.bombThread = bombThread;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public Player getProprio() {
		return proprio;
	}

	public void setProprio(Player proprio) {
		this.proprio = proprio;
	}

	public Image getImage() {
		Image toReturn = SpriteLoader.getBomb(proprio.getBomb(),
				proprio.getBombEvol()).getImage();
		return toReturn;
	}
}
