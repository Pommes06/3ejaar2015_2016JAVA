package be.groept.ex7;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="exercise7")
public class Ex7 {

    public String navigateToPage2(){
        navigationcounter++;
        return "success";
    }

    private int navigationcounter = 0;

    public int getNavigationcounter() {
        return navigationcounter;
    }

    public void setNavigationcounter(int navigationcounter) {
        this.navigationcounter = navigationcounter;
    }



    public String navigateFromPage3(){
        navigationcounter++;
        return "anystring";
    }

}
