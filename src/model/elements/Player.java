package model.elements;

import model.cases.Case;

public class Player extends AbstractElement{
	private int direction,pv,maxPv,lvl, nbBombs, radiusPower,power,xp,maxXp;
	private String nom;
	private Case position;
	private boolean fantom=false,dead=false;
	
	public Player(String nom,Case position){
		type="player";
		lvl=1;
		pv=100;
		maxPv=100;
		power=30;
		this.nom=nom;
		direction=AbstractElement.BAS;
		nbBombs=1;
		radiusPower=1;
		xp=0;
		maxXp=3;
		this.position=position;
	}
	
	public void orienter(int dir){
		if(dir<6 && dir>0)
			direction=dir;
	}
	
	public void addXp(int xpToAdd){
		if(xpToAdd>(maxXp-xp)){
			xpToAdd-=(maxXp-xp);
			levelUp();
			addXp(xpToAdd);
		}else if(xpToAdd == (maxXp-xp)){
			levelUp();
		}else if(xpToAdd<(maxXp-xp)){
			xp+=xpToAdd;
		}
	}
	
	public void levelUp(){
		lvl++;
		xp=0;
		maxXp+=3;
		pv+=50;
		maxPv+=50;
		radiusPower++;
		nbBombs++;
		power+=30;
	}
	
	public void heal(int pvToHeal){
		this.pv+=pvToHeal;
		if(pv>maxPv)
			pv=maxPv;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getMaxPv() {
		return maxPv;
	}

	public void setMaxPv(int maxPv) {
		this.maxPv = maxPv;
	}

	public int getNbBombs() {
		return nbBombs;
	}

	public void setNbBombs(int nbBombs) {
		this.nbBombs = nbBombs;
	}

	public int getRadiusPower() {
		return radiusPower;
	}

	public void setRadiusPower(int radiusPower) {
		this.radiusPower = radiusPower;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getMaxXp() {
		return maxXp;
	}

	public void setMaxXp(int maxXp) {
		this.maxXp = maxXp;
	}

	public Case getPosition() {
		return position;
	}

	public void setPosition(Case position) {
		this.position = position;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isFantom() {
		return fantom;
	}

	public void setFantom(boolean fantom) {
		if(fantom==true)
			pv=1;
		this.fantom = fantom;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
		if(dead==true)
			setPv(0);
	}
}
