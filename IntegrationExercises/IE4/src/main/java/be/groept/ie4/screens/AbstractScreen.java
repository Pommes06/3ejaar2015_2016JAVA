package be.groept.ie4.screens;

import java.util.Scanner;

public abstract class AbstractScreen implements Screen {

	private Scanner scanner = new Scanner(System.in);

	@Override
	public String[] drawScreen(String... parameters) {
		for (int i = 0; i < 5; i++) {
			System.out.println("");
		}

		return drawScreenInternal(parameters);
	}

	public abstract String[] drawScreenInternal(String... parameters);

	public String readFromConsole(String prefix) {
		System.out.print("\n" + prefix + ":");
		String input = scanner.next();

		if ("q".equals(input)) {
			System.exit(0);
		}
		return input;
	}
}
