package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import util.StdAudio;
import view.SidePanel;

public class StartListener implements ActionListener{

	private Game g;
	private SidePanel sp;
	
	public StartListener(Game g,SidePanel sp){
		this.g=g;
		this.sp=sp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		g.start();
		sp.getGg().requestFocus();
		sp.getGg().repaint();
	}

}
