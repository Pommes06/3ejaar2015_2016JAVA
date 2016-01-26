package be.groept.vaadin;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;

public abstract class IE2_Template extends CustomLayout implements View {

	{
		setTemplateName("layout");

		addComponent(new IE2_Header(), "header");
		addComponent(new IE2_Footer(), "footer");
		addComponent(getBody(), "body");

		// setWidth(800, Unit.PIXELS);


	}

	// method that needs to be implemented by the view using this template
	public abstract Component getBody();

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
