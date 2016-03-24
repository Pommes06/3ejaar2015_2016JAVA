package be.groept.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface ChatServer extends Remote {

	static final long serialVersionUID = 1L;

	UUID logon(String nickName) throws RemoteException;

	void post(UUID uuid, String message) throws RemoteException;

	String listen(UUID uuid) throws RemoteException;

	void logoff(UUID uuid) throws RemoteException;

}
