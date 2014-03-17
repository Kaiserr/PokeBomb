package mapEditor;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Grille;
import model.cases.Case;
import view.game.CaseGraphique;

public class GrilleEditor extends JPanel{
	
	private Grille g;
	private ButtonCase[][] cases;
	private EditorFrame ef;
	
	public GrilleEditor(Grille g,EditorFrame ef) {
		this.g = g;
		this.ef=ef;
		cases = new ButtonCase[g.getWidth()][g.getHeight()];
		setLayout(new GridLayout(g.getWidth(), g.getHeight()));
		init();
	}
	
	public void init() {

		for (int i = 0; i < g.getHeight(); i++) {
			for (int j = 0; j < g.getWidth(); j++) {
				ButtonCase cg = new ButtonCase(g.getCaseAt(i, j), this,ef);
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
