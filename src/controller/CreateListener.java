package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import model.elements.Player;
import view.CreatePlayerPanel;

public class CreateListener implements ActionListener{

	private Game g;
	private CreatePlayerPanel cpp;
	
	public CreateListener(Game g,CreatePlayerPanel cpp){
		this.g=g;
		this.cpp=cpp;
	}
	
	public void actionPerformed(ActionEvent e) {
		Player p = new Player(cpp.getNameField().getText(),null);
		//g.addPlayer(p);
		cpp.getSp().addPlayer(p);
	}
	
	
}
