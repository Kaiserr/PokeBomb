package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import mapEditor.EditorFrame;
import view.menus.CreatePanel;
import view.menus.HomePane;

public class HomeListener implements ActionListener{
	
	private JFrame frame;
	private HomePane pane;
	
	public HomeListener(JFrame mainFrame,HomePane oldPane){
		frame=mainFrame;
		pane=oldPane;
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		
		if(source==pane.getSolo()){
			CreatePanel createPane=new CreatePanel(pane);
			frame.setContentPane(createPane);
			frame.repaint();
			frame.validate();
		}else if(source==pane.getMulti()){
			//TODO
		}else if(source==pane.getOnline()){
			//TODO
		}else{
			new EditorFrame();
			frame.setVisible(false);
			frame.dispose();
		}
	}
}
