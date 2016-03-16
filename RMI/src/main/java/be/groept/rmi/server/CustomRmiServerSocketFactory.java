package be.groept.rmi.server;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;

/**
 * Created by koen on 16/03/16.
 */
public class CustomRmiServerSocketFactory implements RMIServerSocketFactory, Serializable {

	static final long serialVersionUID = 1L;

	private InetAddress inetAddress;

	private CustomRmiServerSocketFactory() {
	}

	public CustomRmiServerSocketFactory(InetAddress inetAddress) {
		this.inetAddress = inetAddress;
	}

	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		return new ServerSocket(port, port, inetAddress);
	}
}
