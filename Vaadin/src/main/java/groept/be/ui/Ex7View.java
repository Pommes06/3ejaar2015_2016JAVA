package groept.be.ui;


import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.*;

public class Ex7View extends VerticalLayout{


    {
        setSpacing(true);
    }


    private Button bt1 = new Button("Submit");
    private Button bt2 = new Button("Reset");

    private TextField txtfield1 = new TextField();
    private TextField txtfield2 = new TextField();
    private TextField txtfield3 = new TextField();
    private Label lb1 = new Label();

    private HorizontalLayout hl1 = new HorizontalLayout();
    private HorizontalLayout hl2 = new HorizontalLayout();



    public Ex7View() {



        bt1.addClickListener(event -> {
            if(txtfield1.isValid()) {
                lb1.setCaption("you have entered: " + txtfield1.getValue() + " " + txtfield2.getValue() + " " + txtfield3.getValue());
            }

        });

        bt2.addClickListener(event -> {

            txtfield1.setValue("");
            txtfield2.setValue("");
            txtfield3.setValue("");
            lb1.setCaption("");
        });


        txtfield1.addValidator(new StringLengthValidator("De lengte van het veld moet 1 karakter bedragen.",0,1,true));
        txtfield1.setNullRepresentation("");
        txtfield1.setNullSettingAllowed(true);


        //hl1.setHeight(20, Unit.PIXELS);
        hl1.addComponents(txtfield1, txtfield2, txtfield3, lb1);
        hl2.addComponents(bt1, bt2);



        this.addComponents(hl1, hl2);
    }
}

