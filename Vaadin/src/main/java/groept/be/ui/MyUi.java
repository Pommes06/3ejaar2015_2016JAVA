package groept.be.ui;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import com.vaadin.ui.components.calendar.CalendarComponentEvents;

import javax.servlet.annotation.WebServlet;
import java.util.concurrent.atomic.AtomicInteger;

public class MyUi extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout verticalLayout = new VerticalLayout();

        boolean visib = false;

        Button button = new Button();
        button.setCaption("Buttoooon");
        button.addClickListener(event -> {
            System.err.println("button geklikt door" + event.getSource().toString()); //gebruik van lambda expression is toegelaten
            Notification.show("Dit is een Vaadin Error Notificatie", "Description van de notificatie", Notification.Type.ERROR_MESSAGE);
        });
        button.setVisible(visib);

        Button button1 = new Button();
        button1.setCaption("klik voor nieuwe knop");
        button1.addClickListener(event -> {
            button.setVisible(!button.isVisible());
            System.err.println("button1 is geklikt");
        });

        verticalLayout.addComponents(button1, button);


        VaadinSession.getCurrent().setAttribute(AtomicInteger.class,new AtomicInteger(0)); //pas sur pour le 0 dedans...
        //setContent(verticalLayout);
        //setContent(new Ex1View());
        //setContent(new Ex2View());


        //voor ex6 navigatie, gebruiken we een panel en in de panel worden verschillende views geladen
        Panel panel = new Panel();
        Navigator nav = new Navigator(this,panel);
        nav.addView("page1",Ex6page1.class);
        nav.addView("page2",Ex6page2.class);

        nav.navigateTo("page1"); //je moet altijd een startpagina bepalen.

        setContent(panel);

    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false,
            ui = MyUi.class)
    public static class Servlet extends VaadinServlet {
    }
}
