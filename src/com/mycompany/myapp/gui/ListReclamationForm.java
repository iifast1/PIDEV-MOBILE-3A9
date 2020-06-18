
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.mycompany.myapp.services.ServiceReclamations;

/**
 *
 * @author medam
 */
public class ListReclamationForm extends Form {
    public ListReclamationForm(Form previous) {
               setTitle("List Reclamations");
        
        SpanLabel sp1 = new SpanLabel();
        sp1.setText(ServiceReclamations.getInstance().getAllReclamations().toString());
        add(sp1);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack()); 
    }
}
    