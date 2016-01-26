package be.groept.vaadin;

import javax.servlet.annotation.WebServlet;

import be.groept.vaadin.util.Search;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

@Theme("IE2Theme")
public class IE2_ui extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest request) {

		Page.getCurrent().setTitle("IE2: Vaadin Order");
		// setting a Search object for the session that will be used to pass the
		// search and orders data between pages
		Search mysearcher = new Search();
		VaadinSession.getCurrent().setAttribute("mysearcher", mysearcher);

		Navigator nv = new Navigator(this, this);
		nv.addView("main", IE2_Overview.class);
		nv.addView("detail", IE2_Detailview.class);

		nv.navigateTo("main");

	}

	@WebServlet(value = { "/IE2/*", "/VAADIN/*", "/*" }, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = IE2_ui.class)
	public static class Servlet extends VaadinServlet {

	}

}
