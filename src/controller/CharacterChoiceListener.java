package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.elements.Player;
import util.StdAudio;
import view.game.GrilleGraphique;
import view.menus.AttributeSelection;
import view.menus.CreatePanel;
import view.menus.SkillSelection;

public class CharacterChoiceListener implements ActionListener{

	private CreatePanel cp;
	private int skin=0,bomb=0;
	private String name="Sacha";

	private SkillSelection ss=null;
	
	public CharacterChoiceListener(CreatePanel cp){
		this.cp=cp;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton source = (JButton)e.getSource();
		
		if(cp.getTrainerChoice().contains(source)){
			 skin= cp.getTrainerChoice().indexOf(source);
			 cp.setSelected(skin);
		}else if(source==cp.getPrev()){
			cp.getHp().getFrame().setContentPane(cp.getHp());
			cp.getHp().getFrame().repaint();
			cp.getHp().getFrame().validate();
		}else if(source == cp.getNext()){
			name=cp.getNameField().getText();
			Player p = new Player(name,skin, null);
			
			
			cp.getHp().getFrame().setContentPane(new SkillSelection(cp.getHp(),cp, p));
			cp.getHp().getFrame().validate();
			
		
		}else if(source == ss.getPrev()){
			cp.getHp().getFrame().setContentPane(cp);
			cp.getHp().getFrame().repaint();
			cp.getHp().getFrame().validate();
		}else if(source == ss.getNext()){
			AttributeSelection attrS = new AttributeSelection(cp.getHp(), ss, ss.getP());
			cp.getHp().getFrame().setContentPane(attrS);
			cp.getHp().getFrame().repaint();
			cp.getHp().getFrame().validate();
		}else if(ss.getBombChoice().contains(source)){
			bomb = ss.getBombChoice().indexOf(source);
			ss.setSelected(bomb);
			ss.getP().setBomb(bomb);
		}
	}

	public CreatePanel getCp() {
		return cp;
	}

	public void setCp(CreatePanel cp) {
		this.cp = cp;
	}

	public int getSkin() {
		return skin;
	}

	public void setSkin(int skin) {
		this.skin = skin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SkillSelection getSs() {
		return ss;
	}

	public void setSs(SkillSelection ss) {
		this.ss = ss;
	}

}
