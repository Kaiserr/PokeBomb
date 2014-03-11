package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.elements.Player;

public class CompListener implements ActionListener{

	private int comp;
	private Player p;
	
	public CompListener(int comp,Player p){
		this.comp=comp;
		this.p=p;
	}
	
	public void actionPerformed(ActionEvent e) {
	}

}
