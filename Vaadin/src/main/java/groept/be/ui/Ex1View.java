package groept.be.ui;


import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class Ex1View extends HorizontalLayout{

    {
        setSpacing(true); //semble correct à Koen. entre les {} c'est un code qui sera exécuté avant le constructeur...
    }


    private Button bt1 = new Button();

    private Label lb1 = new Label();


    public Ex1View() {

        bt1.setCaption("Druk");
        bt1.addClickListener(event -> {
            lb1.setVisible(!lb1.isVisible());
        });
        lb1.setCaption("Hello world!");
        lb1.setVisible(false);

        this.addComponents(bt1, lb1);
    }
}

