package groept.be.ui;


import com.vaadin.ui.*;

public class Ex2View extends HorizontalLayout{

    private Button bt1 = new Button();

    private Label lb1 = new Label();

    private TextField inputveld = new TextField();

    public Ex2View() {

        bt1.setCaption("Druk");
        bt1.addClickListener(event -> {
            lb1.setCaption(inputveld.getCaption());
        });

        inputveld.setInputPrompt("Schrijf hier");
        this.addComponents(bt1,inputveld, lb1);
    }
}

