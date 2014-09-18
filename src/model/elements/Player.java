package model.elements;

import java.awt.Image;

import util.Attribute;
import util.Direction;
import util.SpriteLoader;
import view.menus.HomePane;
import model.cases.Case;
/**
 * Element représentant un joueur
 * @author Kaiser
 *
 */
public class Player extends AbstractElement{
	private int skin=3 ,pv,maxPv,lvl, nbBombs, radiusPower,power,xp,maxXp,bomb=0,bombEvol=0;
	private String nom;
	private Case position;
	private boolean fantom=false,dead=false;
	private Attribute bonus=Attribute.NONE;
	private boolean[] effects={false,false,false};
	
	public Player(String nom,int skin,Case position){
		type=6;
		lvl=1;
		pv=100;
		maxPv=100;
		power=30;
		this.nom=nom;
		//direction=AbstractElement.BAS;
		nbBombs=1;
		radiusPower=1;
		xp=0;
		maxXp=3;
		position=position;
		this.skin=skin;
		setDirection(Direction.BAS);
	}
	
	/*
	public void orienter(int dir){
		if(dir<6 && dir>0)
			direction=dir;

	}
	*/
	
	public void orienter(Direction direction){
		setDirection(direction);
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
		maxXp+=3*lvl;
		pv+=20;
		maxPv+=20;
		
		if(lvl%2==0){
			nbBombs++;
			radiusPower++;
		}
		
		if(lvl==3)
			bombEvol=1;
		
		switch(bomb){
		case 0: //RACAILLOU
			power+=12;
			break;
		case 1: //SMOGO
			power+=12;
			break;
		case 2: //VOLTORBE
			power +=20;
			break;
		case 3: //STALGAMIN
			power+=15;
			break;
		}
		
	}
	
	public void heal(int pvToHeal){
		this.pv+=pvToHeal;
		if(pv>maxPv)
			pv=maxPv;
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
	
	public void removeHP(int hp){
		pv=pv-hp;
		if (getPv() <= 0 && !isFantom()) {
			setFantom(true);
		} else if (getPv() <= 0 && isFantom()) {
			setDead(true);
		}
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

	public int getSkin() {
		return skin;
	}

	public void setSkin(int skin) {
		this.skin = skin;
	}

	public int getBomb() {
		return bomb;
	}

	public void setBomb(int bomb) {
		this.bomb = bomb;
	}

	public int getBombEvol() {
		return bombEvol;
	}

	public void setBombEvol(int bombEvol) {
		this.bombEvol = bombEvol;
	}

	@Override
	public Image getImage() {
		Image toReturn = SpriteLoader.getTrainer(this).getImage();
		return toReturn;
	}

	public Attribute getBonus() {
		return bonus;
	}

	public void setBonus(Attribute bonus) {
		this.bonus = bonus;
	}
}
