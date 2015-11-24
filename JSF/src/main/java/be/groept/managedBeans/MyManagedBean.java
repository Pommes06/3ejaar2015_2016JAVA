package be.groept.managedBeans;

import org.primefaces.component.outputlabel.OutputLabel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@SessionScoped
@ManagedBean
public class MyManagedBean {

    private String name;

    private OutputLabel outputlabel;

    public void button(ActionEvent actionEvent){
        System.err.println("Button clicked. Nu met extra test.");
            }

    public OutputLabel getOutputlabel() {
        return outputlabel;
    }

    public void setOutputlabel(OutputLabel outputlabel) {
        this.outputlabel = outputlabel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
