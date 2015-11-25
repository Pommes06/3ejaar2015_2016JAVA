package groept.be.ui;


import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

public class Ex6page2 extends GridLayout implements View{


    {
        setSpacing(true);
        setColumns(2);
        setRows(2);
    }

    private List<String> gemeenten = new ArrayList<String>(){

    };


    private Button previous = new Button();
    private Button next = new Button();

    private Label counter = new Label();

    private TextField inputveld = new TextField();

    private HorizontalLayout hl1 = new HorizontalLayout();
    private HorizontalLayout hl2 = new HorizontalLayout();


    public Ex6page2() {

        previous.setCaption("Vorige");
        next.setCaption("Volgende");


        inputveld.setConverter(new StringToIntegerConverter());
        inputveld.setImmediate(true);

        next.addClickListener(event -> {
                UI.getCurrent().getNavigator().navigateTo("page2");

        });



        hl1.setHeight(20, Unit.PIXELS);
        hl1.addComponents(counter);
        hl2.addComponents(previous, next);


        this.addComponents(hl1, hl2);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}

