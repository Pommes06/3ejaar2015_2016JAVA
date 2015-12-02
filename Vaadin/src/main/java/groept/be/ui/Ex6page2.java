package groept.be.ui;


import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex6page2 extends GridLayout implements View{


    {
        setSpacing(true);
        setColumns(1);
        setRows(2);
    }


    private Button previous = new Button();
    private Button next = new Button();

    private Label counter = new Label("" +  VaadinSession.getCurrent().getAttribute(AtomicInteger.class).getAndIncrement());

    private HorizontalLayout hl1 = new HorizontalLayout();
    private HorizontalLayout hl2 = new HorizontalLayout();


    public Ex6page2() {

        previous.setCaption("Vorige");
        next.setCaption("Volgende");

        next.addClickListener(event -> {
            UI.getCurrent().getNavigator().navigateTo("page3");

        });

        previous.addClickListener(event -> {
            UI.getCurrent().getNavigator().navigateTo("page1");

        });


        //hl1.setHeight(20, Unit.PIXELS);
        hl1.addComponents(counter);
        hl2.addComponents(previous, next);


        this.addComponents(hl1, hl2);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}

