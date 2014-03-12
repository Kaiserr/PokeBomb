package view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class SpriteLoader {

	private ArrayList<BufferedImage> trainersIcon = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage[]> trainersSprite = new ArrayList<BufferedImage[]>();
	private File trainersIconFile = new File("resources/images/trainersIcon.png");
	private File trainersSpriteFile = new File("resources/images/trainersSpriteSheet.png");
	private BufferedImage trainersIconImage,trainersSpriteImage;
	
	
	public SpriteLoader(){
		try {
			trainersIconImage = ImageIO.read(trainersIconFile);
			System.out.println(trainersIconImage.getWidth());
			initTrainersIcons();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initTrainersIcons(){
		int offset=0;
		for(int col=0;col<13;col++){
			trainersIcon.add(trainersIconImage.getSubimage((col*50)+offset, 0, 50, 80));
			System.out.println(col*50);
				
		}
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