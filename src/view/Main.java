package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.Game;
import controller.KeyboardListener;

public class Main {

	public static void main(String[] args) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
			try {
				UIManager
						.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		JFrame jf = new JFrame("PokeBomb !");
		Game g = new Game();
		JPanel mainPane = new JPanel(new BorderLayout());
		jf.setContentPane(mainPane);
		GrilleGraphique gg = new GrilleGraphique(g.getPlateau());
		mainPane.add(gg, BorderLayout.CENTER);
		mainPane.add(new SidePanel(g, gg), BorderLayout.EAST);
		// CompPanel competences = new CompPanel(null);
		// mainPane.add(competences,BorderLayout.SOUTH);
		gg.addKeyListener(new KeyboardListener(gg));

		//jf.setContentPane(new HomePane(jf));

		jf.setIconImage(new ImageIcon("resources/images/BOMB.png").getImage());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setMinimumSize(new Dimension(400, 400));
		
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setVisible(true);

	}

}

/*
 * 
 * [0][1][2][3][4] <- HashMap | | | [0][0]... [1][1]... [2][2] [3][3] [4][4]
 */
