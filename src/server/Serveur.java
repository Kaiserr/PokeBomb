package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Serveur {

	private ServerSocket serveurSocket = null;
	private ArrayList<Service> services = new ArrayList<Service>();
	private HashMap<Socket, String> clients = new HashMap<Socket, String>();
	private int port = 8599;
	private boolean run = false;
	private Thread loop;

	public Serveur() {
		try {
			serveurSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Serveur(int port) {
		this.port = port;
		try {
			serveurSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Boucle du serveur, Accepte des clients et lance un service pour traiter
	 * ses requetes
	 * 
	 * @throws Exception
	 */
	public void miseEnService() throws Exception {
		run = true;
		loop = new Thread(new ServeurLoop(this));
		loop.start();
	}

	/**
	 * Arrete la boucle du serveur
	 * 
	 * @throws IOException
	 */
	public void stop() {
		try {
			run = false;
			for (Service s : services) {
				if (s.getClient().isConnected()) {
					s.getClient().close();
				}
				s = null;
			}
			// ServeurGui.updateConnects();
			services.clear();
			loop.stop();
			serveurSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getters & Setters
	 * 
	 */

	public ServerSocket getServeurSocket() {
		return serveurSocket;
	}

	public void setServeurSocket(ServerSocket serveurSocket) {
		this.serveurSocket = serveurSocket;
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}

	public HashMap<Socket, String> getClients() {
		return clients;
	}

	public void setClients(HashMap<Socket, String> clients) {
		this.clients = clients;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

}
