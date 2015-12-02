package groept.be.ui;


import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.ui.*;

public class Ex3View extends VerticalLayout{


    {
        setSpacing(true);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private int counter = 0;

    private void increment(){
        counter++;
    }


    private Button bt1 = new Button();
    private Button bt2 = new Button();
    private Button bt3 = new Button();
    private Button btall = new Button();

    private Label lb1 = new Label();
    private Label lb2 = new Label();
    private Label lb3 = new Label();

    private HorizontalLayout hl1 = new HorizontalLayout();
    private HorizontalLayout hl2 = new HorizontalLayout();
    private HorizontalLayout hl3 = new HorizontalLayout();
    private HorizontalLayout hl4 = new HorizontalLayout();


    public Ex3View() {

        bt1.setCaption("Druk");

        bt1.addClickListener(event -> {
            increment();
            lb1.setCaption(String.valueOf(getCounter()));
        });

        bt2.setCaption("Druk");

        bt2.addClickListener(event -> {
            increment();
            lb2.setCaption(String.valueOf(getCounter()));
        });

        bt3.setCaption("Druk");

        bt3.addClickListener(event -> {
            increment();
            lb3.setCaption(String.valueOf(getCounter()));
        });

        btall.setCaption("Update All");

        btall.addClickListener(event -> {
            increment();
            lb1.setCaption(String.valueOf(getCounter()));
            lb2.setCaption(String.valueOf(getCounter()));
            lb3.setCaption(String.valueOf(getCounter()));

        });


        //hl1.setHeight(20, Unit.PIXELS);
        hl1.addComponents(bt1, lb1);
        hl2.addComponents(bt2, lb2);
        hl3.addComponents(bt3, lb3);
        hl4.addComponents(btall);


        this.addComponents(hl1, hl2, hl3, hl4);
    }
}

