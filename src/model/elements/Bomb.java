package model.elements;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import model.Grille;
import model.cases.AbstractCase;
import model.cases.Case;
import util.Direction;
import util.StdAudio;
import view.GrilleGraphique;

public class Bomb extends AbstractElement implements Runnable {

	private Grille plateau;
	private GrilleGraphique gg;
	private Case position;
	private Thread bombThread;
	private int delay, power;
	private Player proprio;

	public Bomb(Grille plateau, Case pos, GrilleGraphique gg, int delay,
			Player proprio, int power) {
		this.plateau = plateau;
		this.position = pos;
		this.gg = gg;
		this.delay = delay;
		this.power = power;
		bombThread = new Thread(this);
		bombThread.start();
		type = "bomb";
		this.proprio = proprio;

		setDirection(Direction.FIXE);
	}

	public void explode() throws MalformedURLException {

		int nbCasse = 0;
		ArrayList<Case> aoe = getAOE(proprio.getRadiusPower());
		ArrayList<Player> lostHealth = new ArrayList<Player>();

		StdAudio audio = new StdAudio();
		audio.playBackGround("resources/sounds/explode");
		
		
		
		for (Case c : aoe) {
			// c.ajouterElement(new Fire(this, c, AbstractElement.HAUT));
			c.ajouterElement(new Fire(this, c, Direction.HAUT));
			for (CaseElement ce : c.getElements()) {
				if (ce.getType().equals("player")) {
					lostHealth.add((Player) ce);
				}
			}
			gg.repaint();
			

			if (c.estCassable()) {
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

		for (Case c : aoe)
			((AbstractCase) c).removeElementByType("fire");

		position.setTraversable(true);
		position.removeElement(this);
		proprio.addXp(nbCasse);
		for (Player p : lostHealth) {
			p.setPv(p.getPv() - power);
			gg.repaint();
			if (p.getPv() <= 0 && !p.isFantom())
				p.setFantom(true);
			else if (p.getPv() <= 0 && p.isFantom())
				p.setDead(true);

		}
		gg.repaint();
		try {
			bombThread.sleep(1000);
			audio.disposeSound();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run() {
		try {
			bombThread.sleep(delay);
			explode();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
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
}
