package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import util.Attribute;
import view.game.GrilleGraphique;
import view.menus.AttributeSelection;

public class AttributeListener implements ActionListener {

	private AttributeSelection as;
	private Attribute attr;

	public AttributeListener(AttributeSelection as) {
		this.as = as;
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();

		if (as.getAttrChoice().contains(source)) {
			as.setSelected(as.getAttrChoice().indexOf(source));
			attr = Attribute.getAttribute(as.getSelected());

		}else if(source == as.getPrev()){
			as.getHp().getFrame().setContentPane(as.getSs());
			as.getHp().getFrame().repaint();
			as.getHp().getFrame().validate();
		}else if(source == as.getNext()){
			as.getP().setBonus(attr);
			as.getHp().getG().addPlayer(as.getP());
			GrilleGraphique gg =new GrilleGraphique(as.getHp().getG().getPlateau()); 
			as.getHp().getFrame().setContentPane(gg);
			
			as.getHp().getG().start();
			gg.addKeyListener(new KeyboardListener(gg));
			gg.requestFocus();
			gg.repaint();
			as.getHp().getFrame().validate();
		}

	}

}
