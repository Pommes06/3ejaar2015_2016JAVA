package be.groept.chat;

import java.io.ByteArrayInputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ChatMessageDecoder implements Decoder.Text<JsonObject> {

	@Override
	public JsonObject decode(String s) throws DecodeException {
		JsonReader jsonReader = Json.createReader(new ByteArrayInputStream(s.getBytes()));
		return jsonReader.readObject();
	}

	@Override
	public boolean willDecode(String s) {
		return true;
	}

	@Override
	public void destroy() {
		// Not used
	}

	@Override
	public void init(EndpointConfig config) {
		// Not used
	}
}
