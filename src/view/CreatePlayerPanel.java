package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Game;
import controller.CreateListener;

public class CreatePlayerPanel extends JPanel{
	
	private Game g;
	private JTextArea nameField;
	private JButton add;
	private SidePanel sp;
	
	public CreatePlayerPanel(Game g, SidePanel sp){
		super(new GridLayout(0,2));
		this.g=g;
		this.sp=sp;
		nameField=new JTextArea();
		add=new JButton("Ajouter");
		add(new JLabel("Nom: "));
		add(nameField);
		add(new JLabel());
		add(add);
		add.addActionListener(new CreateListener(g,this));
		
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public JTextArea getNameField() {
		return nameField;
	}

	public void setNameField(JTextArea name) {
		this.nameField = name;
	}

	public JButton getAdd() {
		return add;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public SidePanel getSp() {
		return sp;
	}

	public void setSp(SidePanel sp) {
		this.sp = sp;
	}
}
