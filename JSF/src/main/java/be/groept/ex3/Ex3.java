package be.groept.ex3;

import sun.util.calendar.LocalGregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@ManagedBean
@SessionScoped
public class Ex3 {

    public BigDecimal getInputtekst() {
        return inputtekst;
    }

    public void setInputtekst(BigDecimal inputtekst) {
        this.inputtekst = inputtekst;
    }

    @Min(0)
    private BigDecimal inputtekst = null;


    public void buttonpress(ActionEvent actionevent){

    }


    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    @Future
    private Date inputdate = null;





    public String getInputtwee() {
        return inputtwee;
    }

    public void setInputtwee(String inputtwee) {
        this.inputtwee = inputtwee;
    }

@NullOrNumber
    private String inputtwee = null;

}
