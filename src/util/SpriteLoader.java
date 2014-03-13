package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import model.elements.Player;

public class SpriteLoader {

	private ArrayList<BufferedImage> trainersIcon = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage[]> trainersSprite = new ArrayList<BufferedImage[]>();
	private ArrayList<BufferedImage[]> allbombs = new ArrayList<BufferedImage[]>();
	private BufferedImage[] spectrum = new BufferedImage[4];
	
	private File trainersIconFile = new File("resources/images/trainersIcon.png");
	private File trainersSpriteFile = new File("resources/images/trainersSpriteSheet.png");
	private File spectrumSpriteFile = new  File("resources/images/SpectrumSpriteSheet.png");
	private File graveStoneSprite = new  File("resources/images/tombStone.png");
	private File bombs = new  File("resources/images/bombSprite.png");
	
	private BufferedImage trainersIconImage,trainersSpriteImage,spectrumSprites,graveStone,bombSprite;
	
	
	public SpriteLoader(){
		try {
			trainersIconImage = ImageIO.read(trainersIconFile);
			trainersSpriteImage = ImageIO.read(trainersSpriteFile);
			spectrumSprites = ImageIO.read(spectrumSpriteFile);
			graveStone=ImageIO.read(graveStoneSprite);
			bombSprite=ImageIO.read(bombs);
			initTrainersIcons();
			initTrainersSprite();
			initBombsSprite();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initBombsSprite() {
		for(int col=0;col<3;col++){
			for(int line=0;line<2;line++){
				if(line==0){
					allbombs.add(new BufferedImage[2]);
					allbombs.get(col)[line]=bombSprite.getSubimage((col*40), (line*40), 40, 40);
				}else{
					allbombs.get(col)[line]=bombSprite.getSubimage((col*40), (line*40), 40, 40);
				}
			}
		}
		
	}
	
	public ImageIcon getBomb(int num,int evol){
		BufferedImage toRender = allbombs.get(num)[evol];
		Graphics2D graphics2D = toRender.createGraphics();
		graphics2D.drawImage(toRender, 0, 0, toRender.getWidth(), toRender.getHeight(), null);
		graphics2D.dispose();
		ImageIcon toReturn = new ImageIcon(toRender);
		
		return toReturn;
	} 

	public void initTrainersIcons(){
		for(int col=0;col<12;col++){
			trainersIcon.add(trainersIconImage.getSubimage((col*60), 0, 60, 60));
				
		}
	}
	
	public void initTrainersSprite(){
		for(int col=0;col<12;col++){
			for(int line=0;line<4;line++){
				if(line==0){
					trainersSprite.add(new BufferedImage[4]);
					trainersSprite.get(col)[line]=trainersSpriteImage.getSubimage((col*40), (line*37)+2, 40, 37);
				}else{
					trainersSprite.get(col)[line]=trainersSpriteImage.getSubimage((col*40), (line*37)+2, 40, 37);
				}
			}
		}
		for(int line=0;line<4;line++)
			spectrum[line]=spectrumSprites.getSubimage(0, line*40, 40, 40);
			
		
	}
	
	public ImageIcon getTrainer(Player p){
		BufferedImage toRender;
		Direction dir = p.getDirection();
		int num = p.getSkin();
		if(!p.isFantom()){
			switch(dir){
				case BAS:
					toRender=trainersSprite.get(num)[0];
					break;
				case HAUT:
					toRender=trainersSprite.get(num)[3];
					break;
				case DROITE:
					toRender=trainersSprite.get(num)[2];
					break;
				case GAUCHE:
					toRender=trainersSprite.get(num)[1];
					break;
				default:
					toRender=trainersSprite.get(num)[0];
					break;
			}
		}else if(!p.isDead()){
			switch(dir){
			case BAS:
				toRender=spectrum[0];
				break;
			case HAUT:
				toRender=spectrum[3];
				break;
			case DROITE:
				toRender=spectrum[2];
				break;
			case GAUCHE:
				toRender=spectrum[1];
				break;
			default:
				toRender=spectrum[0];
				break;
			}
		}else{
			toRender=graveStone;
			
		}
		Graphics2D graphics2D = toRender.createGraphics();
		graphics2D.drawImage(toRender, 0, 0, toRender.getWidth(), toRender.getHeight(), null);
		graphics2D.dispose();
		ImageIcon toReturn = new ImageIcon(toRender);
		
		return toReturn;
	}
	
	public ImageIcon getTrainerIcon(int col){
		BufferedImage toRender = trainersIcon.get(col);
		Graphics2D graphics2D = toRender.createGraphics();
		graphics2D.drawImage(toRender, 0, 0, toRender.getWidth(), toRender.getHeight(), null);
		graphics2D.dispose();
		ImageIcon toReturn = new ImageIcon(toRender);
		
		return toReturn;
	}

	public ArrayList<BufferedImage> getTrainersIcon() {
		return trainersIcon;
	}

	public void setTrainersIcon(ArrayList<BufferedImage> trainersIcon) {
		this.trainersIcon = trainersIcon;
	}

	public ArrayList<BufferedImage[]> getTrainersSprite() {
		return trainersSprite;
	}

	public void setTrainersSprite(ArrayList<BufferedImage[]> trainersSprite) {
		this.trainersSprite = trainersSprite;
	}

	public File getTrainersIconFile() {
		return trainersIconFile;
	}

	public void setTrainersIconFile(File trainersIconFile) {
		this.trainersIconFile = trainersIconFile;
	}

	public File getTrainersSpriteFile() {
		return trainersSpriteFile;
	}

	public void setTrainersSpriteFile(File trainersSpriteFile) {
		this.trainersSpriteFile = trainersSpriteFile;
	}

	public BufferedImage getTrainersIconImage() {
		return trainersIconImage;
	}

	public void setTrainersIconImage(BufferedImage trainersIconImage) {
		this.trainersIconImage = trainersIconImage;
	}

	public BufferedImage getTrainersSpriteImage() {
		return trainersSpriteImage;
	}

	public void setTrainersSpriteImage(BufferedImage trainersSpriteImage) {
		this.trainersSpriteImage = trainersSpriteImage;
	}
}