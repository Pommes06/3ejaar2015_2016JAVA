package groept.be.ui;


import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.server.ErrorMessage;
import com.vaadin.ui.*;

public class Ex2View extends VerticalLayout{


    {
        setSpacing(true);
    }
    private Button bt1 = new Button();

    private Label lb1 = new Label();

    private TextField inputveld = new TextField();

    private HorizontalLayout hl1 = new HorizontalLayout();
    private HorizontalLayout hl2 = new HorizontalLayout();


    public Ex2View() {

        bt1.setCaption("Druk");
        inputveld.setInputPrompt("Schrijf hier");

        inputveld.setConverter(new StringToIntegerConverter());
        inputveld.setImmediate(true);

        bt1.addClickListener(event -> {
            if(inputveld.isValid()) {
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

