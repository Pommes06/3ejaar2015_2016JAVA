package be.groept.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chatserver/{nickname}", decoders = { ChatMessageDecoder.class }, encoders = { ChatMessageEncoder.class })
public class ChatEndpoint {

	private ChatServer chatServer;

	private static final List<Session> sessions = new ArrayList<>();

	@OnOpen
	public void open(final Session session, @PathParam("nickname") String nickname) throws IOException {
		UUID uuid = chatServer.logon(nickname);
		sessions.add(session);
		session.getUserProperties().put("uuid", uuid);
		System.out.println(nickname + " just logged on!");
	}

	@OnMessage
	public void receive(JsonObject jsonObject, Session session) throws IOException, EncodeException {
		String message = jsonObject.getJsonString("message").getString();
		if (message == null || message.length() < 1) {
			session.getBasicRemote().sendObject(message("Nice try, but you have to at least supply one character"));
			return;
		}

		chatServer.post((UUID) session.getUserProperties().get("uuid"), message);
	}

	@OnClose
	public void close(Session session, CloseReason reason) {
		chatServer.logoff((UUID) session.getUserProperties().get("uuid"));
		sessions.remove(session);
	}

	@OnError
	public void error(Session session, Throwable error) {
		try {
			session.getBasicRemote().sendObject(error(getSaneExceptionMessage(error)));
		} catch (IOException | EncodeException e) {
			e.printStackTrace();
		}
		error.printStackTrace();
	}

	//TODO Use event API annotation here to receive messages fired from the EJB
	public void send() throws Exception {
		for (Session session : sessions) {
			//session.getBasicRemote().sendObject(message(chatEvent.getMessage()));
		}
	}

	// ------- Helpers
	private JsonObject message(String message) {
		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
		jsonObjectBuilder.add("message", message);
		return jsonObjectBuilder.build();
	}

	private JsonObject error(String message) {
		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
		jsonObjectBuilder.add("error", message);
		return jsonObjectBuilder.build();
	}

	private String getSaneExceptionMessage(Throwable error) {
		while (error.getCause() != null) {
			return getSaneExceptionMessage(error.getCause());
		}
		return error.toString();
	}
}