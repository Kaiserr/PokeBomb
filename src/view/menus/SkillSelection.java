package view.menus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.elements.Player;
import util.SpriteLoader;
import controller.CharacterChoiceListener;

public class SkillSelection extends JPanel{

	private Player p;
	private HomePane hp;
	private CreatePanel cp;
	private int selected=0;
	private ArrayList<JButton> bombChoice= new ArrayList<JButton>();
	private JButton next = new JButton("Commencer");
	private JButton prev = new JButton("Précédent");
	
	public SkillSelection(HomePane hp,CreatePanel cp,Player p){
		this.p=p;
		this.hp=hp;
		this.cp=cp;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		SpriteLoader images = new SpriteLoader();
		CharacterChoiceListener ccl = cp.getCcl();
		ccl.setSs(this);
		c.fill = GridBagConstraints.HORIZONTAL;

		c.insets = new Insets(50, 10, 10, 10);
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
		add(new JLabel("Choisissez votre bombe", JLabel.CENTER), c);
		
		c.insets = new Insets(10, 10, 10, 10);

		c.fill = GridBagConstraints.HORIZONTAL;
		
		JPanel bombs = new JPanel(new GridLayout(1, 3));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 2;
		add(bombs, c);
		for (int i = 0; i < 3; i++) {
			JButton choice = new JButton(images.getBomb(i, 0));
			bombChoice.add(choice);
			bombs.add(choice);
			choice.addActionListener(ccl);
		}
		

		c.anchor=GridBagConstraints.LAST_LINE_START;
		c.ipady = 0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 6;
		add(prev, c);
		prev.addActionListener(ccl);
		
		

		c.anchor=GridBagConstraints.LAST_LINE_END;
		c.ipady = 0;
		c.weighty = 1.0;
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 6;
		add(next, c);
		next.addActionListener(ccl);

		setSelected(0);
	}
	
	public void setSelected(int selected) {
		bombChoice.get(this.selected).setBackground(Color.LIGHT_GRAY);
		this.selected = selected;
		bombChoice.get(selected).setBackground(new Color(0,155,61));
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public HomePane getHp() {
		return hp;
	}

	public void setHp(HomePane hp) {
		this.hp = hp;
	}

	public CreatePanel getCp() {
		return cp;
	}

	public void setCp(CreatePanel cp) {
		this.cp = cp;
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}

	public JButton getPrev() {
		return prev;
	}

	public void setPrev(JButton prev) {
		this.prev = prev;
	}

	public ArrayList<JButton> getBombChoice() {
		return bombChoice;
	}

	public void setBombChoice(ArrayList<JButton> bombChoice) {
		this.bombChoice = bombChoice;
	}
}

/*

CHOIX ENTRE 3 BOMBES DIFFÉRENTES AU DÉPART:
-VOLTORBE
	INFLIGE DES DEGATS ELECTRIQUES ET PARALYSE LES ENNEMIS TOUCHÉS,
	 LES EMPECHANT DE POSER DES BOMBES PENDANT UN CERTAIN TEMPS.
	 
	 AMÉLIORATION EN ELECTRODE

-SMOGO
	EMPOISONNE L'ENNEMI PENDANT UN CERTAIN TEMPS, SUBIT PLUS DE DEGATS
	DES PROCHAINES BOMBES PENDANT LA DUREE DU POISON.
	
	AMÉLIORATION EN SMOGOGO

-RACAILLOU
	LES DEBRIS DE PIERRE PROJETÉS ASSOMENT LES ENNEMIS, LES EMPECHANTS
	DE BOUGER PENDANT LA DURÉE DU STUN. 
	
	AMÉLIORATION EN GRAVALANCHE
*/