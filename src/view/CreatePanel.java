package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CharacterChoiceListener;

public class CreatePanel extends JPanel {

	private ArrayList<JButton> trainerChoice = new ArrayList<JButton>();
	private JButton next = new JButton("Commencer");
	private JTextField nameField = new JTextField();
	private HomePane hp;

	public CreatePanel(HomePane hp) {
		this.hp=hp;
		CharacterChoiceListener ccl = new CharacterChoiceListener(this);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		c.insets = new Insets(50, 10, 10, 10);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
		add(new JLabel("Choisissez un entraineur", JLabel.CENTER), c);

		c.insets = new Insets(10, 10, 10, 10);

		SpriteLoader images = new SpriteLoader();
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
			JButton choice = new JButton(images.getTrainerIcon(i));
			trainerChoice.add(choice);
			trainers.add(choice);
			choice.addActionListener(ccl);
		}

		c.insets = new Insets(10, 50, 10, 10);

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
		c.ipady = 0;
		c.weighty = 1.0;
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 5;
		add(next, c);
		next.addActionListener(ccl);

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
}
