package mapEditor;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.cases.Case;
import util.CaseType;
import view.menus.HomePane;

/**
 * Bouton avec image pour le changement de type de case de l'éditeur
 * @author Kaiser
 *
 */
public class ButtonCase extends JButton {

	private Case pos;
	private GrilleEditor ge;
	private EditorFrame ef;

	public ButtonCase(final Case pos, final GrilleEditor ge,
			final EditorFrame ef) {
		super();
		this.ge = ge;
		this.pos = pos;
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ef.getSelected().getValue() < 5)
					pos.setType(ef.getSelected().getValue());
				else{
					if(!pos.getSpawn()){
						pos.setType(1);
						pos.setSpawn(true);
					}else{
						pos.setType(1);
						pos.setSpawn(false);
					}
				}
				ge.repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(EditorFrame.images.getCase(pos.getType()).getImage(), 4, 4,
				getWidth() - 8, getHeight() - 8, this);
		
		if(pos.getSpawn())
			g.drawImage(EditorFrame.images.getGraveStone().getImage(), 4, 4,
					getWidth() - 8, getHeight() - 8, this);
			
	}

	public void setPosition(Case c) {
		this.pos = c;
	}
}
