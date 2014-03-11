package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import controller.KeyboardListener;
import model.Grille;
import model.cases.Case;
import model.cases.Vide;

public class GrilleGraphique extends JPanel{

	private Grille g;
	//private HashMap<Integer,ArrayList<CaseGraphique>> cases;
	private CaseGraphique [][] cases;
	
	public GrilleGraphique(Grille g){
		this.g=g;
		//cases=new HashMap<Integer,ArrayList<CaseGraphique>>();
		cases=new CaseGraphique[g.getWidth()][g.getHeight()];
		setLayout(new GridLayout(g.getWidth(),g.getHeight()));
		init();
		
		
	}
	
	public void init(){
		/*for(int i=0;i<g.getHeight();i++){
			cases.put(i, new ArrayList<CaseGraphique>());
			for(int j=0;j<g.getWidth();j++){
				CaseGraphique cg = new CaseGraphique(g.getCaseAt(i, j));
				cases.get(i).add(cg);
				this.add(cg);
			}
		}*/
		
		for(int i=0;i<g.getHeight();i++){
			for(int j=0;j<g.getWidth();j++){
				CaseGraphique cg = new CaseGraphique(g.getCaseAt(i, j),this);
				cases[i][j]=cg;
				//cases.get(i).add(cg);
				
			}
		}

		for(int col=0; col<g.getHeight();col++){
			for(int line=0;line<g.getWidth();line++){
				this.add(cases[line][col]);
			}
		}
		
		/*for(int i=0;i<g.getHeight();i++){
			for(int j=0;j<g.getWidth();j++){
				System.out.println(cases.get(i).get(j));
			}
		}*/
	}

	public Grille getG() {
		return g;
	}

	public void setG(Grille g) {
		this.g = g;
	}

	/*public HashMap<Integer,ArrayList<CaseGraphique>> getCases() {
		return cases;
	}

	public void setCases(HashMap<Integer,ArrayList<CaseGraphique>> cases) {
		this.cases = cases;
	}*/
	
}
