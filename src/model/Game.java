package model;

import java.io.File;
import java.util.ArrayList;

import util.StdAudio;
import model.elements.Player;

/**
 * Initialisation du modéle de jeu: plateau et joueurs
 * @author Kaiser
 *
 */
public class Game {

	private Grille plateau;
	private ArrayList<Player> joueurs;
	
	public Game(){
		joueurs = new ArrayList<Player>();
		plateau = new Grille(new File("resources/maps/map1.txt"));
		//start();
	}
	
	public void addPlayer(Player j){
		joueurs.add(j);
	}
	
	public void start(){
		plateau.addPlayers(joueurs);
		int tmp=0;
		for(Player p:joueurs){
			plateau.setPlayerCase(tmp, plateau.getCasesDepart().get(tmp));
			tmp++;
		}
		
	}

	public Grille getPlateau() {
		return plateau;
	}

	public void setPlateau(Grille plateau) {
		this.plateau = plateau;
	}

	public ArrayList<Player> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Player> joueurs) {
		this.joueurs = joueurs;
	}
}
