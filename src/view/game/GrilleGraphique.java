package view.game;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Grille;
import model.cases.Case;

/**
 * Représentation graphique du plateau de jeu
 * @author Kaiser
 *
 */
public class GrilleGraphique extends JPanel {

	private Grille g;
	private CaseGraphique[][] cases;

	public GrilleGraphique(Grille g) {
		this.g = g;
		cases = new CaseGraphique[g.getWidth()][g.getHeight()];
		setLayout(new GridLayout(g.getWidth(), g.getHeight()));
		init();
	}

	public void init() {

		for (int i = 0; i < g.getHeight(); i++) {
			for (int j = 0; j < g.getWidth(); j++) {
				CaseGraphique cg = new CaseGraphique(g.getCaseAt(i, j), this);
				cases[i][j] = cg;

			}
		}

		for (int col = 0; col < g.getHeight(); col++) {
			for (int line = 0; line < g.getWidth(); line++) {
				this.add(cases[line][col]);
			}
		}

	}

	public Grille getG() {
		return g;
	}

	public void setG(Grille g) {
		this.g = g;
	}

	public void setCaseAt(int x, int y, Case c) {
		cases[x][y].setPosition(c);
	}

}
