package be.groept.rmi.client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.UUID;

import be.groept.rmi.server.ChatServer;

public class ChatClient {

	public static void main(String args[]) throws Exception {
		Registry registry = LocateRegistry.getRegistry("172.19.15.139", Registry.REGISTRY_PORT);
		final ChatServer chatServer = (ChatServer) registry.lookup("ChatServer");

		System.out.println("Username please:");
		Scanner scanner = new Scanner(System.in);
		String username = null;
		if (scanner.hasNextLine()) {
			username = scanner.nextLine();
		}

		final UUID uuid = chatServer.logon(username);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						String line = chatServer.listen(uuid);
						if (line != null) {
							System.err.println(line);
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		while (true) {
			if (scanner.hasNextLine()) {
				String input = scanner.nextLine();
				if (input.equals("quit")) {
					chatServer.logoff(uuid);
					System.exit(0);
				}
				chatServer.post(uuid, input);
			}
		}

	}
}
