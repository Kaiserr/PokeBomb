package mapEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Grille;
import model.cases.Case;
import util.CaseType;
import util.SpriteLoader;
import view.PokeBomb;

public class EditorFrame extends JFrame {

	private int size = 0;
	private String name = null;
	private ArrayList<Grille> grid=new ArrayList<Grille>();
	private ArrayList<GrilleEditor> guiGrid = new ArrayList<GrilleEditor>();
	public static SpriteLoader images = new SpriteLoader();
	private CaseType selected = CaseType.VIDE;
	private CaseSelector selector;
	public static EditorFrame me;
	private int tabCount = 0;

	public EditorFrame() {
		super("PokéBomb - Map Editor");
		// PanelImage pi = new PanelImage(new
		// ImageIcon("resources/images/menus/home.png"));
		// pi.setLayout(new BorderLayout());
		setContentPane(new JTabbedPane());
		init();
		setIconImage(new ImageIcon("resources/images/BOMB.png").getImage());
		setVisible(true);
		me = this;
	}

	public void init() {
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu file = new JMenu("Fichier");
		JMenuItem newM = new JMenuItem("Nouvelle");
		JMenuItem open = new JMenuItem("Ouvrir");
		JMenuItem save = new JMenuItem("Sauvegarder");
		file.add(newM);
		file.addSeparator();
		file.add(open);
		file.addSeparator();
		file.add(save);
		menubar.add(file);
		JSeparator s = new JSeparator(JSeparator.VERTICAL);
		s.setPreferredSize(new Dimension(20, menubar.getHeight()));
		s.setMaximumSize(new Dimension(20, menubar.getHeight()));
		s.setMinimumSize(new Dimension(20, menubar.getHeight()));
		menubar.add(s);

		JButton play = new JButton("Jouer !");
		menubar.add(new JSeparator(JSeparator.VERTICAL));
		menubar.add(play);

		selector = new CaseSelector(this);

		newM.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				newMap();
			}
		});

		save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				save();

			}
		});

		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				open();

			}
		});

		play.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new PokeBomb();
				me.setVisible(false);
				me.dispose();
			}
		});

		setIconImage(new ImageIcon("resources/images/BOMB.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(500, 500));

		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void newMap() {
		Object[] possibilities = { "8x8", "12x12", "16x16" };
		String s = (String) JOptionPane.showInputDialog(this,
				"Quelle taille ?", "Nouvelle map", JOptionPane.PLAIN_MESSAGE,
				null, possibilities, "8x8");
		if ((s != null) && (s.length() > 0)) {
			if (s.equals(possibilities[0]))
				size = 8;
			else if (s.equals(possibilities[1]))
				size = 12;
			else
				size = 16;
		}

		if (size == 0)
			return;

		Grille g = new Grille(size, size);
		grid.add(g);
		guiGrid.add(new GrilleEditor(g, this));
		JPanel container = new JPanel(new BorderLayout());
		container.add(selector, BorderLayout.EAST, 0);
		container.add(guiGrid.get(tabCount));
		getContentPane().add(container, "New");
		((JTabbedPane) getContentPane()).setSelectedIndex(tabCount);
		tabCount++;
		repaint();
		validate();

	}

	public void save() {
		System.out.println("asked to save");
		File file = null;
		final JFileChooser fc = new JFileChooser(new File("resources/maps"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"TEXT FILES", "txt", "text");
		fc.setFileFilter(filter);
		int returnVal = fc.showSaveDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		}
		if (file == null)
			return;
		PrintWriter writer;
		try {
			writer = new PrintWriter(file, "UTF-8");
			Grille g = grid.get(((JTabbedPane)getContentPane()).getSelectedIndex());
			for (int i = 0; i < g.getWidth(); i++) {
				String toPrint = new String("");
				for (int j = 0; j < g.getHeight(); j++) {
					char c = ' ';
					Case tmp = g.getCaseAt(i, j);
					if (tmp.getType() == 1 && !tmp.getSpawn())
						c = ' ';
					else if (tmp.getType() == 1 && tmp.getSpawn())
						c = 'D';
					else if (tmp.getType() == 2)
						c = '#';
					else if (tmp.getType() == 3)
						c = 'C';
					else if (tmp.getType() == 4)
						c = 'I';
//					System.out.println(c);
					toPrint += c;
				}
				 writer.println(toPrint);
				//System.out.println(toPrint);
			}

			 writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void open() {
		File file = null;
		final JFileChooser fc = new JFileChooser(new File("resources/maps"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"TEXT FILES", "txt", "text");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		}
		if (file == null)
			return;

		Grille g = new Grille(file);
		grid.add(g);
		guiGrid.add(new GrilleEditor(g, this));
		JPanel container = new JPanel(new BorderLayout());
		container.add(selector, BorderLayout.EAST, 0);
		container.add(guiGrid.get(tabCount));
		getContentPane().add(container, file.getName());
		((JTabbedPane) getContentPane()).setSelectedIndex(tabCount);
		tabCount++;
		repaint();
		validate();
	}

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

		new EditorFrame();
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static SpriteLoader getImages() {
		return images;
	}

	public static void setImages(SpriteLoader images) {
		EditorFrame.images = images;
	}

	public CaseType getSelected() {
		return selected;
	}

	public void setSelected(CaseType selected) {
		this.selected = selected;
	}

	public CaseSelector getSelector() {
		return selector;
	}

	public void setSelector(CaseSelector selector) {
		this.selector = selector;
	}
}
