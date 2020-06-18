
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Repair;
import com.mycompany.myapp.services.ServiceRepairs;

/**
 *
 * @author medam
 */
public class AddRepair extends Form {
    public AddRepair(Form previous ){
                setLayout(BoxLayout.y());
        setTitle("Add a new repair");
                Button btnValider = new Button("Add Repair");


                TextField des = new TextField("", "RepairDescription");
                    TextField statut = new TextField("", "Repairstatus");
                    btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((des.getText().length()==0)||(statut.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                     try {
                       Repair r = new Repair(des.getText(),Boolean.valueOf(statut.getText()));
                          //Repair r = new Repair(des.getText(),statut.getText());
                         
                       
                        if( ServiceRepairs.getInstance().addRepairs(r))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
                    addAll(des,statut,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());



    }
    
}
