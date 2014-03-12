package view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePanel extends JPanel{

	private ArrayList<JButton> trainerChoice = new ArrayList<JButton>();
	
	public CreatePanel(){
		JButton button;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
       
        c.insets=new Insets(50, 10, 10, 10);
        
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
		add(new JLabel("Choisissez un entraineur",JLabel.CENTER), c);

		c.insets=new Insets(10, 10, 10, 10);

		SpriteLoader images = new SpriteLoader();
		JPanel trainers = new JPanel(new GridLayout(3,4));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx=0;
		c.ipady=0;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 2;
		add(trainers,c);
		for(int i=0;i<12;i++){
			
			trainers.add(new JButton(images.getTrainerIcon(i)));
		}
		
		
		c.insets=new Insets(10, 50, 10, 10);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weighty = 1.0;
		c.gridx = 0; 
		c.gridwidth = 1;  
		c.gridy = 5;  
		add(new JLabel("Quel est votre nom ?",JLabel.CENTER), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;      
		c.weighty = 1.0;
		c.gridx = 1;      
		c.gridwidth = 1;  
		c.gridy = 5;    
		add(new JTextField(), c);
		
		button = new JButton("Suivant");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       
		c.weighty = 1.0;
		c.gridx = 2;  
		c.gridwidth = 1; 
		c.gridy = 5;      
		add(button, c);
		
	}
	/*public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("resources/images/home.png").getImage(), 0,
				0, getWidth(), getHeight(), this);
	}*/
}
