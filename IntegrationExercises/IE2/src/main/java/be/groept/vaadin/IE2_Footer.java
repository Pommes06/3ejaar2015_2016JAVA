package be.groept.vaadin;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class IE2_Footer extends HorizontalLayout {

	{

		Label label = new Label("(c) Thomas Huard");
		label.setSizeUndefined();
		VerticalLayout vl = new VerticalLayout(label);

		vl.setComponentAlignment(label, Alignment.BOTTOM_CENTER);
		addComponent(vl);

		addStyleName("IE2Footer");
		setWidth(100, Unit.PERCENTAGE);
	}

}
