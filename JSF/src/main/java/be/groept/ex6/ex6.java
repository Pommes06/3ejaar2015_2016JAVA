package be.groept.ex6;

import org.apache.commons.lang3.StringUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean
public class ex6 {


    public void resetbutton(ActionEvent actionEvent){
        input1 = null;
        input2 = null;
        input3 = null;
    }

    public void submitbutton(ActionEvent actionEvent){

    }


    public String getInput1() {
        return input1;
    }

    public void setInput1(String input1) {
        this.input1 = input1;
    }

    public String getInput2() {
        return input2;
    }

    public void setInput2(String input2) {
        this.input2 = input2;
    }

    public String getInput3() {
        return input3;
    }

    public void setInput3(String input3) {
        this.input3 = input3;
    }

    private String input1;

    private String input2;

    private String input3;






    }
