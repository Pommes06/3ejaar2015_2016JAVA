package groept.be.ui;


import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.*;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Ex4View extends GridLayout{

    private final List<String> gemeenten = new ArrayList<String>();

    {
        setSpacing(true);
        gemeenten.add("Antwerpen");
        gemeenten.add("Aalst");
        gemeenten.add("Brussel");
        gemeenten.add("Namen");
        gemeenten.add("Gent");
        gemeenten.add("Aarlen");
        gemeenten.add("Bastenaken");
        gemeenten.add("Luik");
        gemeenten.add("Luxemburg");

    }


    private ComboBox comboBox = new ComboBox("Select your city:",gemeenten){

        private String filterString;

        @Override
        public void setFilteringMode(FilteringMode filteringMode) {
            super.setFilteringMode(filteringMode.CONTAINS);
        }

        @Override
        protected List<?> getFilteredOptions() {
          if (StringUtils.isNotBlank(filterString) && filterString.length() > 1){
              return super.getFilteredOptions();
          }
            return new ArrayList<>();
        };

        @Override
        public void changeVariables(Object source, Map<String, Object> variables) {
            super.changeVariables(source, variables);
            filterString = (String) variables.get("filter");
        }


    };

    private Label lb1 = new Label("Enter municipality: ");
    private Label lb2 = new Label();


    public Ex4View() {

        comboBox.addValueChangeListener(event -> lb2.setValue("Welcome to " + event.getProperty().getValue().toString() +"!"));

        this.addComponents(lb1, comboBox, lb2);
    }
}

