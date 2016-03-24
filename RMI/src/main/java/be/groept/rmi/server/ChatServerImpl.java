package be.groept.rmi.server;

import java.rmi.RemoteException;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public abstract class ChatServerImpl implements ChatServer {

	private ConcurrentHashMap<String, UserData> users = new ConcurrentHashMap<>();

	@Override
	public UUID logon(String nickName) throws RemoteException {
		UUID uuid = UUID.randomUUID();
		UserData userData = new UserData();
		userData.nickName = nickName;
		userData.uuid = uuid;

		UserData existing = users.putIfAbsent(nickName, userData);
		if (existing != null) {
			throw new RuntimeException("Nickname:" + nickName + " is already taken");
		}
		return uuid;
	}

	@Override
	public void post(UUID uuid, String message) throws RemoteException {
		String line = "@" + getUserData(uuid).nickName + ":>" + message;
		System.err.println(line);

		for (UserData userData : users.values()) {
			try {
				userData.messageQueue.put(line);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String listen(UUID uuid) throws RemoteException {
		try {
			return getUserData(uuid).messageQueue.poll(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void logoff(UUID uuid) throws RemoteException {
		users.remove(getUserData(uuid).nickName);
	}

	private UserData getUserData(UUID uuid) {
		for (Entry<String, UserData> entry : users.entrySet()) {
			if (entry.getValue().uuid.equals(uuid)) {
				return entry.getValue();
			}
		}
		throw new IllegalStateException("UUID:" + uuid.toString() + " not known");
	}

	private class UserData {

		private String nickName;

		private UUID uuid;

		private final BlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(10000);

	}
}
