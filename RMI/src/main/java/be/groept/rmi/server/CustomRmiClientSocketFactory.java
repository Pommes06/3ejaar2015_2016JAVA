package be.groept.rmi.server;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

/**
 * Created by koen on 16/03/16.
 */
public class CustomRmiClientSocketFactory implements RMIClientSocketFactory, Serializable {

	static final long serialVersionUID = 1L;

	private String hostname;

	private CustomRmiClientSocketFactory() {
	}

	public CustomRmiClientSocketFactory(final String hostname) {
		this.hostname = hostname;
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException {
		return new Socket(hostname, port);
	}
}