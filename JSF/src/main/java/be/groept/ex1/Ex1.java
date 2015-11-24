package be.groept.ex1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


@SessionScoped
@ManagedBean(name="exercise1")
public class Ex1 {

    public boolean isShowtekst() {
        return showtekst;
    }

    public void setShowtekst(boolean showtekst) {
        this.showtekst = showtekst;
    }

    private boolean showtekst = false;

    public void button (ActionEvent actionEvent){
        setShowtekst(!this.showtekst);
        setActiontekst(actionEvent.getSource().toString());
    }

    public String getActiontekst() {
        return actiontekst;
    }

    public void setActiontekst(String actiontekst) {
        this.actiontekst = actiontekst;
    }

    public String actiontekst;

}
