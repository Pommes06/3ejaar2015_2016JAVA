package be.groept.chat;

import java.util.UUID;

public interface ChatServerWs {

	static final long serialVersionUID = 1L;

	String logon(String nickName);

	void post(String uuid, String message);

	String listen(String uuid);

	void logoff(String uuid);
}
