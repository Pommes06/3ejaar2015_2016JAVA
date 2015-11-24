package be.groept.ex5;

import org.apache.commons.lang3.StringUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean
public class ex5 {

    public String[] getLijstGemeenten() {

        return lijstGemeenten;
    }

    public void setLijstGemeenten(String[] lijstGemeenten) {
        this.lijstGemeenten = lijstGemeenten;
    }

    private String[] lijstGemeenten = {
            "Aalst"
            ,"Aalter"
            ,"Aarschot"
            ,"Aartselaar"
            ,"Affligem"
            ,"Bertem"
            ,"Bever"
            ,"Beveren"

    };

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    private String input;

    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();

        if (StringUtils.isNotBlank(query) && query.length() > 1){
            for(int i = 0; i < lijstGemeenten.length; i++) {
                if (lijstGemeenten[i].toLowerCase().startsWith(query)) {
                    results.add(lijstGemeenten[i]);
                }
            }
        }

        return results;
    }








    }
