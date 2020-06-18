package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.mycompany.myapp.services.ServiceRepairs;

/**
 *
 * @author medam
 */
public class ListRepairsForm  extends Form{
    public ListRepairsForm(Form previous) {
               setTitle("List Repairs");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceRepairs.getInstance().getAllRepairs().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack()); 
    }
    
}
