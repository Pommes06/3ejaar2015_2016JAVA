package be.groept.chat;

import java.io.ByteArrayOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ChatMessageEncoder implements Encoder.Text<JsonObject> {

	@Override
	public String encode(JsonObject object) throws EncodeException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JsonWriter jsonWriter = Json.createWriter(bos);
		jsonWriter.writeObject(object);
		jsonWriter.close();
		return bos.toString();
	}

	@Override
	public void destroy() {
		System.err.println("encoder destroy");
	}

	@Override
	public void init(EndpointConfig arg0) {
		// Do nothing
	}
}
