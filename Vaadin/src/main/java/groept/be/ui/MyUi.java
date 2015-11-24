package groept.be.ui;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

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

        //setContent(verticalLayout);
        //setContent(new Ex1View());
        setContent(new Ex2View());


    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false,
            ui = MyUi.class)
    public static class Servlet extends VaadinServlet {
    }
}
