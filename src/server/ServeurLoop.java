package server;

import java.io.IOException;
import java.net.Socket;

public class ServeurLoop implements Runnable{
	private Serveur serv;
	
	public ServeurLoop(Serveur serv){
		this.serv=serv;
	}

	public void run(){
		Socket client = null;
		while (serv.isRun()) {
			try {
				client = serv.getServeurSocket().accept();
				Service babysitter = new Service(client, serv);
				
				serv.getServices().add(babysitter);
				//ServeurGui.updateConnects();
				//ServeurGui.writeInLog("Nouveau Service démarré, id:"+serv.getServices().indexOf(babysitter)+".", false);
				
				Thread th = new Thread(babysitter);
				th.start();
	
					
				if(!serv.isRun()){
					return;
				}

			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}	
		return;
	}

}
