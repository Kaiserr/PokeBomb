package view.menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import util.SpriteLoader;
import controller.CharacterChoiceListener;

public class CreatePanel extends JPanel {

	private ArrayList<JButton> trainerChoice = new ArrayList<JButton>();
	private JButton next = new JButton("Suivant");
	private JButton prev = new JButton("Retour au menu");
	private JTextField nameField = new JTextField();
	private HomePane hp;
	private int selected=0;
	private CharacterChoiceListener ccl = new CharacterChoiceListener(this);
	
	public CreatePanel(HomePane hp) {
		this.hp=hp;
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		c.insets = new Insets(50, 10, 10, 10);
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
		add(new JLabel("Choisissez un entraineur", JLabel.CENTER), c);

		c.insets = new Insets(10, 10, 10, 10);

		JPanel trainers = new JPanel(new GridLayout(3, 4));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 2;
		add(trainers, c);
		for (int i = 0; i < 12; i++) {
			JButton choice = new JButton(HomePane.images.getTrainerIcon(i));
			trainerChoice.add(choice);
			trainers.add(choice);
			choice.addActionListener(ccl);
		}

		

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 5;
		add(new JLabel("Quel est votre nom ?", JLabel.CENTER), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weighty = 1.0;
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = 5;
		add(nameField, c);

		c.fill = GridBagConstraints.HORIZONTAL;

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
		
		
		
		setSelected(selected);

	}

	/*
	 * public void paintComponent(Graphics g) { g.drawImage(new
	 * ImageIcon("resources/images/home.png").getImage(), 0, 0, getWidth(),
	 * getHeight(), this); }
	 */

	public ArrayList<JButton> getTrainerChoice() {
		return trainerChoice;
	}

	public void setTrainerChoice(ArrayList<JButton> trainerChoice) {
		this.trainerChoice = trainerChoice;
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public HomePane getHp() {
		return hp;
	}

	public void setHp(HomePane hp) {
		this.hp = hp;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		trainerChoice.get(this.selected).setBackground(Color.LIGHT_GRAY);
		this.selected = selected;
		trainerChoice.get(selected).setBackground(new Color(0,155,61));
	}

	public JButton getPrev() {
		return prev;
	}

	public void setPrev(JButton prev) {
		this.prev = prev;
	}

	public CharacterChoiceListener getCcl() {
		return ccl;
	}

	public void setCcl(CharacterChoiceListener ccl) {
		this.ccl = ccl;
	}
}
