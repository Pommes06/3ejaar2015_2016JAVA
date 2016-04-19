package be.groept.ie4.screens;

public class ShopSelectionScreen extends AbstractScreen {

	@Override
	public String[] drawScreenInternal(String... parameters) {
		System.out.println("Welcome " + parameters[0] +", you are now shopping in " + parameters[1]+"." +
				"/nMake your selection (q to quit)" );
		return new String[] { readFromConsole("Input")};
	}
}
