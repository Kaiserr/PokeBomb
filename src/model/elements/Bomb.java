package model.elements;

import java.util.ArrayList;

import model.Grille;
import model.cases.AbstractCase;
import model.cases.Case;
import view.GrilleGraphique;

public class Bomb extends AbstractElement implements Runnable{

	private Grille plateau;
	private GrilleGraphique gg;
	private Case position;
	private Thread bombThread;
	private int delay,power;
	private Player proprio;
	
	
	public Bomb(Grille plateau,Case pos,GrilleGraphique gg, int delay,Player proprio,int power){
		this.plateau=plateau;
		this.position=pos;
		this.gg=gg;
		this.delay=delay;
		this.power=power;
		bombThread=new Thread(this);
		bombThread.start();
		type="bomb";
		this.proprio = proprio;
	}
	
	public void explode(){
		int nbCasse=0;
		ArrayList<Case> aoe = getAOE(proprio.getRadiusPower());
		for(Case c : aoe){
			c.ajouterElement(new Fire(this, c, AbstractElement.HAUT));
			for(CaseElement ce : c.getElements()){
				if(ce.getType().equals("player")){
					((Player)ce).setPv(((Player)ce).getPv()-power);
					gg.repaint();
					if(((Player)ce).getPv()<=0)
						((Player)ce).setFantom(true);
				}
			}
			gg.repaint();
			
			if(c.estCassable()){
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
		for(Case c : aoe)
			((AbstractCase)c).removeElementByType("fire");
		
		position.setTraversable(true);
		position.removeElement(this);
		proprio.addXp(nbCasse);
		gg.repaint();
	}
	
	public void run(){
		try {
			bombThread.sleep(delay);
			explode();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Case> getAOE(int radius){
		int x= position.getX();
		int y= position.getY();
		ArrayList<Case> voisins = new ArrayList<Case>();
		ArrayList<Case> droite = new ArrayList<Case>();
		ArrayList<Case> gauche = new ArrayList<Case>();
		ArrayList<Case> haut = new ArrayList<Case>();
		ArrayList<Case> bas = new ArrayList<Case>();
		ArrayList<Case> toRemove = new ArrayList<Case>();
		
		for(int i=1;i<=radius;i++){
			if(plateau.getCaseAt(x+i, y)!=null){
				droite.add(plateau.getCaseAt(x+i, y));
			}
			if(plateau.getCaseAt(x-i, y)!=null){
				gauche.add(plateau.getCaseAt(x-i, y));
			}
			if(plateau.getCaseAt(x, y+i)!=null){
				bas.add(plateau.getCaseAt(x, y+i));
			}
			if(plateau.getCaseAt(x, y-i)!=null){
				haut.add(plateau.getCaseAt(x, y-i));
			}
		}
		boolean remove=false;
		for(Case c : droite){
			if(c.getType()==2 || remove){
				toRemove.add(c);
				remove=true;
			}
		}
		remove=false;
		for(Case c : gauche){
			if(c.getType()==2 || remove){
				toRemove.add(c);
				remove=true;
			}
		}
		remove=false;
		for(Case c : haut){
			if(c.getType()==2 || remove){
				toRemove.add(c);
				remove=true;
			}
		}
		remove=false;
		for(Case c : bas){
			if(c.getType()==2 || remove){
				toRemove.add(c);
				remove=true;
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