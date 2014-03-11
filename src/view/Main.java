package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;
import controller.KeyboardListener;

public class Main {

	public static void main(String[] args) {
		JFrame jf=new JFrame("PokeBomb !");
		Game g = new Game();
		JPanel mainPane= new JPanel(new BorderLayout());
		jf.setContentPane(mainPane);
		GrilleGraphique gg = new GrilleGraphique(g.getPlateau());
		mainPane.add(gg,BorderLayout.CENTER);
		mainPane.add(new SidePanel(g,gg),BorderLayout.EAST);
		//CompPanel competences = new CompPanel(null);
		//mainPane.add(competences,BorderLayout.SOUTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setSize(400, 400);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setVisible(true);

		gg.addKeyListener(new KeyboardListener(gg));
	}

}


/*
 * 
 *  [0][1][2][3][4]  <- HashMap
 * 	 |  |  | 
 * 	[0][0]...
 *  [1][1]...
 * 	[2][2]
 * 	[3][3]
 * 	[4][4]
 * 
 */
