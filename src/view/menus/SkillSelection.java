package view.menus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import util.BombType;
import model.elements.Player;
import controller.CharacterChoiceListener;

public class SkillSelection extends JPanel{

	private Player p;
	private HomePane hp;
	private CreatePanel cp;
	private int selected=0;
	private ArrayList<JButton> bombChoice= new ArrayList<JButton>();
	private JButton next = new JButton("Suivant");
	private JButton prev = new JButton("Précédent");
	private JTextArea descrip = new JTextArea();
	private JPanel recap = new JPanel(new GridLayout(1,2));
	
	public SkillSelection(HomePane hp,CreatePanel cp,Player p){
		this.p=p;
		this.hp=hp;
		this.cp=cp;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		CharacterChoiceListener ccl = cp.getCcl();
		ccl.setSs(this);
		descrip.setMaximumSize(new Dimension(getWidth()/3,100));
		descrip.setPreferredSize(new Dimension(getWidth()/3,100));
		descrip.setEditable(false);
		descrip.setFocusable(false);
		descrip.setColumns(25);
		descrip.setLineWrap(true);
		descrip.setWrapStyleWord(true);
		
		c.fill = GridBagConstraints.VERTICAL;
		
		c.insets = new Insets(20, 10, 10, 10);
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight=1;
		c.gridwidth=1;
		add(recap, c);
		recap.add( new PanelImage(HomePane.images.getTrainerIcon(cp.getSelected())));
		
		c.fill = GridBagConstraints.HORIZONTAL;

		c.insets = new Insets(10, 10, 10, 10);
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight=1;
		c.gridwidth=1;
		add(new JLabel("Choisissez votre bombe", JLabel.CENTER), c);
		

		
		JPanel bombs = new JPanel(new GridLayout(1, 4));
		c.ipadx = 0;
		c.ipady = 0;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 2;
		add(bombs, c);
		for (int i = 0; i < 4; i++) {
			JButton choice = new JButton(HomePane.images.getBomb(i, 0));
			bombChoice.add(choice);
			bombs.add(choice);
			choice.addActionListener(ccl);
		}
		
		c.ipady=0;
		c.ipadx=0;
		c.gridx=1;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		add(descrip,c);

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
		descrip.setText(BombType.getDescription(BombType.getBombType(selected)));
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

	public int getSelected() {
		return selected;
	}

	public JTextArea getDescrip() {
		return descrip;
	}

	public void setDescrip(JTextArea descrip) {
		this.descrip = descrip;
	}

	public JPanel getRecap() {
		return recap;
	}

	public void setRecap(JPanel recap) {
		this.recap = recap;
	}
}
