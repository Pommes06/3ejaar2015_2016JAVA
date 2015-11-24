package be.groept.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean implements Serializable {


    public HashMap<String, String> getTalen() {
        return talen;
    }

    public void setTalen(HashMap<String, String> talen) {
        this.talen = talen;
    }



    private static HashMap<String, String> talen;

    static{
        talen = new LinkedHashMap<String,String>();
        talen.put("English", "en"); //label, value
        talen.put("Nederlands", "nl");

    }

    private String localeCode = "en";

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String loecaleCode) {
        this.localeCode = localeCode;
    }

    public String getAnderetaal() {

        String taallang = (this.localeCode=="en")?"Nederlands":"English";
        this.anderetaal= talen.get(taallang);

        return anderetaal;
    }

    public void setAnderetaal(String anderetaal) {
        this.anderetaal = anderetaal;
    }

    private String anderetaal;

    // value change event listener
    public void changeLocale(ValueChangeEvent newlocale) {

        this.localeCode = newlocale.getNewValue().toString();

        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(this.localeCode));


        // loop country map to compare locale code
        //for (Map.Entry<String, Object> entry : countries.entrySet()) {
        //	if (entry.getValue().toString().equals(newLocaleValue)) {
        //		FacesContext.getCurrentInstance().getViewRoot()
        //				.setLocale((Locale) entry.getValue());
        //	}
        //}

    }


}
