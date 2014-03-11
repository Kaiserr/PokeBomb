package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Service implements Runnable {
	private Socket client;
	private PrintWriter envoi;
	private BufferedReader reception;
	private String loginClient = "[ANONYME]";
	private Serveur server;
	private boolean deco = false;

	public Service(Socket client, Serveur serv) {
		this.client = client;
		server = serv;
		try {
			envoi = new PrintWriter(client.getOutputStream(), true);
			reception = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		String message = "";

		while (client.isConnected() && server.isRun()) {
			try {
				message = reception.readLine();
				String[] query = message.split(" ");
				//
				if (deco) {
					client.close();
					server.getClients().remove(client);
					server.getServices().remove(this);
					return;
				}

			} catch (IOException e) {
				e.printStackTrace();
				if (!client.isClosed())
					try {
						client.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				server.getClients().remove(client);
				server.getServices().remove(this);
				return;
			}

		}

	}

	/**
	 * Ajouter le couple socket-login dans la hashmap clients
	 * 
	 * @param login
	 * @return String
	 */
	private boolean connect(Socket client, String login) {
		if (!server.getClients().containsKey(client)) {
			server.getClients().put(client, login);
			loginClient = login;
			return true;
		} else {
			return false;
		}
	}

	public String getLoginClient() {
		return loginClient;
	}

	public void setLoginClient(String loginClient) {
		this.loginClient = loginClient;
	}

	public Serveur getServer() {
		return server;
	}

	public void setServer(Serveur server) {
		this.server = server;
	}

	public boolean isDeco() {
		return deco;
	}

	public void setDeco(boolean deco) {
		this.deco = deco;
	}

	/**
	 * Deconnecte le client
	 * 
	 * @return String
	 */
	private void disconnect() {
		deco = true;
	}

	/**
	 * Getters & Setters
	 */

	public Serveur getserver() {
		return server;
	}

	public void setserver(Serveur server) {
		this.server = server;
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

	public PrintWriter getEnvoi() {
		return envoi;
	}

	public void setEnvoi(PrintWriter envoi) {
		this.envoi = envoi;
	}

	public BufferedReader getReception() {
		return reception;
	}

	public void setReception(BufferedReader reception) {
		this.reception = reception;
	}

}
