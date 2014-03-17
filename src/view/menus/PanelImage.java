package view.menus;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImage extends JPanel{
	
	private Image img;
	
	public PanelImage(ImageIcon img){
		super();
		this.img=img.getImage();
		setMaximumSize(new Dimension(70,70));
		setPreferredSize(new Dimension(70,70));
		setMinimumSize(new Dimension(70,70));
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
	}
}
