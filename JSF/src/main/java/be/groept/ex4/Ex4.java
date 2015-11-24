package be.groept.ex4;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@SessionScoped
@ManagedBean
public class Ex4 {

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private int counter = 0;

    public void increment(ActionEvent actionEvent){
        this.counter++;
    }




}
