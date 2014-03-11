package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.CreatePanel;
import view.HomePane;

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
			CreatePanel pane=new CreatePanel();
			frame.setContentPane(pane);
			frame.repaint();
			frame.validate();
		}else if(source==pane.getMulti()){
			//TODO
		}else if(source==pane.getOnline()){
			//TODO
		}
	}
}
