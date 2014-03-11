package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePanel extends JPanel{

	public CreatePanel(){
		super(new GridLayout(3,3));
		
		add(new JLabel(""));
		add(new JLabel("Choisissez votre starter !",JLabel.CENTER));
		add(new JLabel(""));
		add(new JLabel("1",JLabel.CENTER));
		add(new JLabel("2",JLabel.CENTER));
		add(new JLabel("3",JLabel.CENTER));
		add(new JLabel("Nom",JLabel.CENTER));
		add(new JTextField());
		add(new JButton("Suivant"));
	}
	
}
