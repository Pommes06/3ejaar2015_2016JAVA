package groept.be.ui;


import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

public class Ex4View extends GridLayout{


    {
        setSpacing(true);
        setColumns(2);
        setRows(5);
    }

    private List<String> gemeenten = new ArrayList<String>(){

    };

    private ComboBox comboBox = new ComboBox("Select your city:",gemeenten);

    private Button bt1 = new Button();

    private Label lb1 = new Label();

    private TextField inputveld = new TextField();

    private HorizontalLayout hl1 = new HorizontalLayout();
    private HorizontalLayout hl2 = new HorizontalLayout();


    public Ex4View() {

        bt1.setCaption("Druk");
        inputveld.setInputPrompt("Schrijf hier");

        inputveld.setConverter(new StringToIntegerConverter());
        inputveld.setImmediate(true);

        bt1.addClickListener(event -> {
            if (inputveld.isValid()) {
                String caption = inputveld.getValue();

                lb1.setCaption(caption);
            }
        });

        inputveld.addFocusListener(event -> {
            bt1.setCaption("typing...");
        });
        inputveld.addBlurListener(event -> {
            bt1.setCaption("Druk");
        });


        hl1.setHeight(20, Unit.PIXELS);
        hl1.addComponents(bt1, inputveld);
        hl2.addComponents(lb1);


        this.addComponents(hl1, hl2);
    }
}

