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

import com.sun.crypto.provider.DESParameters;

import model.elements.Player;
import util.Attribute;
import controller.AttributeListener;

public class AttributeSelection extends JPanel{
	
	private Player p;
	private HomePane hp;
	private SkillSelection ss;
	private int selected=0;
	private ArrayList<JButton> attrChoice= new ArrayList<JButton>();
	private JButton next = new JButton("Commencer");
	private JButton prev = new JButton("Précédent");
	private JTextArea descrip = new JTextArea();
	public AttributeSelection(HomePane hp,SkillSelection ss,Player p){
		this.p=p;
		this.hp=hp;
		this.ss=ss;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		AttributeListener al=new AttributeListener(this); 
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
		add(ss.getRecap(), c);
		ss.getRecap().add( new PanelImage(HomePane.images.getBomb(ss.getSelected(), 0)));
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 1;
		add(new JLabel("Choisissez votre attribut", JLabel.CENTER), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 10, 10, 10);
		
		JPanel attr = new JPanel(new GridLayout(3, 3));
		c.ipadx = 0;
		c.ipady = 0;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = 3;
		c.gridheight = 3;
		c.ipady=100;
		c.ipadx=100;
		c.gridx = 0;
		c.gridy = 2;
		add(attr, c);
		for (int i = 0; i < Attribute.values().length-1; i++) {
			JButton choice = new JButton(Attribute.values()[i].toString());
			attrChoice.add(choice);
			attr.add(choice);
			choice.addActionListener(al);
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
		prev.addActionListener(al);
		
		

		c.anchor=GridBagConstraints.LAST_LINE_END;
		c.ipady = 0;
		c.weighty = 1.0;
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 6;
		add(next, c);
		next.addActionListener(al);
		
		setSelected(0);
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

	public SkillSelection getSs() {
		return ss;
	}

	public void setSs(SkillSelection ss) {
		this.ss = ss;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		attrChoice.get(this.selected).setBackground(Color.LIGHT_GRAY);
		this.selected = selected;
		attrChoice.get(selected).setBackground(new Color(0,155,61));
		descrip.setText(Attribute.getDescription(Attribute.getAttribute(selected)));
	}

	public ArrayList<JButton> getAttrChoice() {
		return attrChoice;
	}

	public void setAttrChoice(ArrayList<JButton> attrChoice) {
		this.attrChoice = attrChoice;
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

	public JTextArea getDescrip() {
		return descrip;
	}

	public void setDescrip(JTextArea descrip) {
		this.descrip = descrip;
	}
	
	
}
