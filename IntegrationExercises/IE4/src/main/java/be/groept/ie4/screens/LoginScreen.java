package be.groept.ie4.screens;

public class LoginScreen extends AbstractScreen {

	@Override
	public String[] drawScreenInternal(String... parameters) {
		System.out.println("Enter username and password (q to quit).");
		return new String[] { readFromConsole("Username"),
				readFromConsole("Password") };
	}
}
