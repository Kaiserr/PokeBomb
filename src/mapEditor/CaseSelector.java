package mapEditor;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.CaseType;

/**
 * Side panel de séléction des différentes cases
 * @author Kaiser
 *
 */
public class CaseSelector extends JPanel {

	private EditorFrame ef;
	private JButton vide, mur, murCassable,glace, spawn;
	private int selected = 0;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();

	public CaseSelector(final EditorFrame ef) {
		super(new GridLayout(5, 1));
		this.ef = ef;
		vide = new JButton();
		vide.add(new JLabel(EditorFrame.images.getCase(1)));
		mur = new JButton();
		mur.add(new JLabel(EditorFrame.images.getCase(2)));
		murCassable = new JButton();
		murCassable.add(new JLabel(EditorFrame.images.getCase(3)));
		glace = new JButton();
		glace.add(new JLabel(EditorFrame.images.getCase(4)));
		spawn = new JButton();
		spawn.add(new JLabel(EditorFrame.images.getGraveStone()));
		add(vide);
		add(mur);
		add(murCassable);
		add(glace);
		add(spawn);
		buttons.add(vide);
		buttons.add(mur);
		buttons.add(murCassable);
		buttons.add(glace);
		buttons.add(spawn);
		
		vide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ef.setSelected(CaseType.VIDE);
				setSelected(0);

			}
		});

		mur.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ef.setSelected(CaseType.MUR);
				setSelected(1);

			}
		});

		murCassable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ef.setSelected(CaseType.MURCASSABLE);
				setSelected(2);

			}
		});
		
		glace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ef.setSelected(CaseType.GLACE);
				setSelected(3);

			}
		});

		spawn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ef.setSelected(CaseType.SPAWN);
				setSelected(4);
			}
		});
		setSelected(0);
	}

	public void setSelected(int selected) {
		buttons.get(this.selected).setBackground(Color.LIGHT_GRAY);
		this.selected = selected;
		buttons.get(selected).setBackground(new Color(0,155,61));
	}
}
