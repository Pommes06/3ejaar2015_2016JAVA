package be.groept.chat;

import java.util.UUID;

public interface ChatServerRemote {

	static final long serialVersionUID = 1L;

	UUID logon(String nickName);

	void post(UUID uuid, String message);

	String listen(UUID uuid);

	void logoff(UUID uuid);
}
