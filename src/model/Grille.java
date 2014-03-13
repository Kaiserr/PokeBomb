package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import model.cases.Case;
import model.cases.Mur;
import model.cases.MurCassable;
import model.cases.Vide;
import model.elements.AbstractElement;
import model.elements.Bomb;
import model.elements.CaseElement;
import model.elements.Player;
import model.elements.Potion;
import util.Direction;
import view.game.GrilleGraphique;

public class Grille {
	private Case[][] plateau;
	private Case playerCase;
	private ArrayList<Player> joueurs;
	private int width, height;
	private ArrayList<Case> casesDepart;

	public Grille(int width, int height) {
		plateau = new Case[width][height];
		joueurs=new ArrayList<Player>();
		casesDepart=new ArrayList<Case>();
		this.width = width;
		this.height = height;
		init();
		placePotions();
	}

	public Grille(File map) {
		MapParser parser = new MapParser(map);
		ArrayList<String> lines = (ArrayList<String>) parser.readFile();
		this.width = lines.get(0).length();
		this.height = lines.size();
		plateau = new Case[width][height];
		casesDepart = new ArrayList<Case>();
		joueurs=new ArrayList<Player>();
		init(lines);
		placePotions();
	}

	public void init(ArrayList<String> lines) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				char caseChar = lines.get(i).charAt(j);
				if (caseChar == ' ')
					plateau[i][j] = new Vide(i, j);
				else if (caseChar == '#')
					plateau[i][j] = new Mur(i, j);
				else if (caseChar == 'C')
					plateau[i][j] = new MurCassable(i, j);
				else if (caseChar == 'D') {
					plateau[i][j] = new Vide(i, j);
					casesDepart.add(plateau[i][j]);
				}
			}
		}

	}

	public void init() {

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 || i == height - 1 || j == 0 || j == width - 1)
					plateau[i][j] = new Mur(i, j);
				else
					plateau[i][j] = new Vide(i, j);
			}
		}

	}
	/*
	public Case getCaseFront(Player p) {
		int tmp = p.getDirection();
		int x = p.getPosition().getX();
		int y = p.getPosition().getY();
		switch (tmp) {
		case AbstractElement.HAUT:
			if (y - 1 > 0)
				return getCaseAt(x, y - 1);
		case AbstractElement.BAS:
			if (y + 1 < height)
				return getCaseAt(x, y + 1);
		case AbstractElement.DROITE:
			if (x + 1 < width)
				return getCaseAt(x + 1, y);
		case AbstractElement.GAUCHE:
			if (x - 1 > 0)
				return getCaseAt(x - 1, y);
		default:
			return null;
		}
	}
*/
	
	public Case getCaseFront(Player p) {
		
		int x = p.getPosition().getX();
		int y = p.getPosition().getY();
		
		switch (p.getDirection()) {
			case HAUT:
				if (y - 1 > 0)
					return getCaseAt(x, y - 1);
			case BAS:
				if (y + 1 < height)
					return getCaseAt(x, y + 1);
			case DROITE:
				if (x + 1 < width)
					return getCaseAt(x + 1, y);
			case GAUCHE:
				if (x - 1 > 0)
					return getCaseAt(x - 1, y);
			default:
				return null;
		}
	}
	
	public Bomb poserBombe(GrilleGraphique gg, Player proprio) {
		if (getCaseFront(proprio) != null
				&& getCaseFront(proprio).getType() == 1
				&& !getCaseFront(proprio).hasABomb()
				&& getNbBombs(proprio) < proprio.getNbBombs()) {
			Bomb bomb = new Bomb(this, getCaseFront(proprio), gg, 3000, proprio,proprio.getPower());
			getCaseFront(proprio).ajouterElement(bomb);
			return bomb;
		} else
			return null;

	}

	public int getNbBombs(Player p) {
		int nbBombs = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Case c = getCaseAt(i, j);
				if (c.getElements().size() > 0) {
					for (CaseElement ce : c.getElements()) {
						if (ce.getType().equals("bomb")) {
							Bomb b = (Bomb) ce;
							if (b.getProprio() == p)
								nbBombs++;
						}
					}
				}
			}
		}
		return nbBombs;
	}
	/*
	public void deplacerJoueur(int num,int dir) {
		Case currentPos = joueurs.get(num).getPosition();
		int x = currentPos.getX();
		int y = currentPos.getY();

		int newX = x;
		int newY = y;

		switch (dir) {
		case AbstractElement.HAUT:
			newX = x;
			newY = y - 1;
			break;
		case AbstractElement.BAS:
			newX = x;
			newY = y + 1;
			break;
		case AbstractElement.DROITE:
			newX = x + 1;
			newY = y;
			break;
		case AbstractElement.GAUCHE:
			newX = x - 1;
			newY = y;
			break;
		default:
			break;
		}

		if (getCaseAt(newX, newY).estTraversable()&& !getCaseAt(newX, newY).containPlayer()) {

			getCaseAt(x, y).removeElement(joueurs.get(num));
			getCaseAt(newX, newY).ajouterElement(joueurs.get(num));
			// System.out.println("new X: " + newX + " new Y: " + newY);
			getJoueur(num).setPosition(getCaseAt(newX, newY));
		}

	}
*/
	
	public void deplacerJoueur(int num,Direction dir) {
		Case currentPos = joueurs.get(num).getPosition();
		int x = currentPos.getX();
		int y = currentPos.getY();

		int newX = x;
		int newY = y;

		switch (dir) {
			case HAUT:
				newX = x;
				newY = y - 1;
				break;
			case BAS:
				newX = x;
				newY = y + 1;
				break;
			case DROITE:
				newX = x + 1;
				newY = y;
				break;
			case GAUCHE:
				newX = x - 1;
				newY = y;
				break;
			default:
				break;
		}

		if (getCaseAt(newX, newY).estTraversable()&& !getCaseAt(newX, newY).containPlayer()) {

			getCaseAt(x, y).removeElement(joueurs.get(num));
			getCaseAt(newX, newY).ajouterElement(joueurs.get(num));
			// System.out.println("new X: " + newX + " new Y: " + newY);
			getJoueur(num).setPosition(getCaseAt(newX, newY));
		}

	}
	
	public Case getCaseAt(int x, int y) {
		if (x >= 0 && x < width && y >= 0 && y < height)
			return plateau[x][y];
		else
			return null;
	}

	public void placePotions() {
		Random r = new Random();
		for (int i = 2; i < height - 2; i++) {
			for (int j = 2; j < width - 2; j++) {
				if (r.nextBoolean() && r.nextBoolean())
					getCaseAt(i, j)
							.ajouterElement(
									new Potion(this, getCaseAt(i, j), r
											.nextInt(2) + 1));
			}
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (getCaseAt(j, i).containPlayer())
					s += "X ";
				else
					s += "_ ";
			}
			s += "\n";
		}
		return s;
	}

	public Case getPlayerCase(int num) {
		return joueurs.get(num).getPosition();
	}

	public void setPlayerCase(int num, Case playerCase) {
		joueurs.get(num).setPosition(playerCase);
	}

	public Player getJoueur(int num) {
		if(num<joueurs.size())
			return joueurs.get(num);
		return null;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Case[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(Case[][] plateau) {
		this.plateau = plateau;
	}

	public void addPlayers(ArrayList<Player> joueurs) {
		int nbJoueurs = joueurs.size();
		this.joueurs=joueurs;
		if (nbJoueurs <= casesDepart.size()) {
			int tmp = 0;
			for (Player p : joueurs) {
				casesDepart.get(tmp).ajouterElement(p);
				tmp++;
			}
		}
	}

	public ArrayList<Case> getCasesDepart() {
		return casesDepart;
	}

	public void setCasesDepart(ArrayList<Case> casesDepart) {
		this.casesDepart = casesDepart;
	}

}
