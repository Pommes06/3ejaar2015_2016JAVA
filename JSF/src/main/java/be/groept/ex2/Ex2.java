package be.groept.ex2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@SessionScoped
@ManagedBean
public class Ex2 {

private String inputtekst;

    public String getInputtekst() {
        return inputtekst;
    }

    public void setInputtekst(String inputtekst) {
        this.inputtekst = inputtekst;

    }
    public void buttonpress(ActionEvent actionevent){

    }
}
