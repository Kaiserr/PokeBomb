package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import model.elements.Player;
import view.game.CreatePlayerPanel;
import view.menus.SkillSelection;

public class CreateListener implements ActionListener{

	private Game g;
	private CreatePlayerPanel cpp;
	
	public CreateListener(Game g,CreatePlayerPanel cpp){
		this.g=g;
		this.cpp=cpp;
	}
	
	public void actionPerformed(ActionEvent e) {
		Player p = new Player(cpp.getNameField().getText(),0,null);
		//g.addPlayer(p);
		cpp.getSp().addPlayer(p);
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public CreatePlayerPanel getCpp() {
		return cpp;
	}

	public void setCpp(CreatePlayerPanel cpp) {
		this.cpp = cpp;
	}

	
	
}
