package view.game;

import java.awt.Graphics;

import model.elements.Bomb;
import util.ImageLoader;
import view.menus.HomePane;

public class DisplayBomb implements Runnable{

	private Thread displayThread;
	private CaseGraphique cg;
	private Bomb bomb;
	
	public DisplayBomb(CaseGraphique cg, Bomb bomb){
		this.cg=cg;
		this.bomb=bomb;
		displayThread=new Thread(this);
		displayThread.start();
	}

	
	public void run() {
		Graphics g = cg.getGraphics();
		ImageLoader il = new ImageLoader();
		try {
			g.drawImage(HomePane.images.getElement(3).getImage(), 0, 0, cg.getWidth(), cg.getHeight(), null);
			Thread.sleep(300);
			g.drawImage(bomb.getImage(), 0, 0, cg.getWidth(), cg.getHeight(), null);
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}
}
