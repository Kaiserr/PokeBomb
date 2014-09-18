package view.game;

import model.elements.Player;

/**
 * Thread pour les effets de détonnation des bombes
 * @author Kaiser
 *
 */
public class EffectThread implements Runnable{
	private boolean[] effects={false,false,false};
	//Paralysie - Poison - Stun
	private Thread myThread;
	private int current;
	private Player p;
	
	public EffectThread(){
		
	}
	
	public void start(int effect){
		myThread=new Thread(this);
		current=effect;
		effects[effect]=true;
		myThread.start();
		
	}
	
	public void run() {
		try {
			Thread.sleep(3000);
			effects[current]=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myThread.stop();
		return;
	}
	
	public void setPoison(boolean poison){
		effects[1]=poison;
	}
	
	public void setPara(boolean para){
		effects[0]=para;
	}
	
	public void setStun(boolean stun){
		effects[2]=stun;
	}
	
}
