package be.groept.vaadin;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class IE2_Header extends HorizontalLayout {

	public IE2_Header() {

		Image imgorder = new Image();
		imgorder.setSource(new ThemeResource("images/order_logo.jpeg"));

		Label welcome = new Label("Welcome to the Order site");
		welcome.setSizeUndefined();

		Button th1bt = new Button("Theme1");
		Button th2bt = new Button("Theme2");

		th1bt.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				event.getButton().getParent().getParent()
						.removeStyleName("IE2Header");
				event.getButton().getParent().getParent()
						.addStyleName("IE2Headerv2");

			}
		});

		th2bt.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				event.getButton().getParent().getParent()
						.removeStyleName("IE2Headerv2");
				event.getButton().getParent().getParent()
						.addStyleName("IE2Header");

			}
		});

		VerticalLayout themebuttons = new VerticalLayout(th1bt, th2bt);
		themebuttons.setSizeUndefined();
		addComponents(imgorder, welcome, themebuttons);
		setComponentAlignment(imgorder, Alignment.TOP_LEFT);
		setComponentAlignment(welcome, Alignment.MIDDLE_CENTER);
		setComponentAlignment(themebuttons, Alignment.BOTTOM_RIGHT);

		addStyleName("IE2Header");
		setWidth(100, Unit.PERCENTAGE);

	}

}
