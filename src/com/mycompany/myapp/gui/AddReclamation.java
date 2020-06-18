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
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamations;

/**
 *
 * @author medam
 */
public class AddReclamation extends Form {
    public AddReclamation(Form previous ){
                setLayout(BoxLayout.y());
        setTitle("Add a new reclamation");
                Button btnValider = new Button("Add Reclamation");

                    TextField sujet = new TextField("", "Reclamationsujet");    
                    TextField dis = new TextField("", "ReclamationDisponibilite");
                    TextField qual = new TextField("", "Reclamationqualite");
                     TextField serv = new TextField("", "ReclamationServices");
                     TextField desc = new TextField("", "ReclamationDescription");
                     
                          
                    btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((desc.getText().length()==0)||(sujet.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                     try {
                       Reclamation rc = new Reclamation(sujet.getText(),Integer.parseInt(dis.getText()),Integer.parseInt(qual.getText()),Integer.parseInt(serv.getText()),desc.getText());
                         
                       //Repair r = new Repair(des.getText(),statut.getText());
                         
                       
                        if( ServiceReclamations.getInstance().addReclamations(rc))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", " must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
                    addAll(sujet,dis,qual,serv,desc,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());



    }
    
}
