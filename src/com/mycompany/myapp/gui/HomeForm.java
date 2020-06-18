package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author medamine
 */
public class HomeForm extends Form{
Form current;
    public HomeForm() {
        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option: \n"));
        
         add(new Label("Reclamations : "));
        Button btnListReclam = new Button("List Reclamtions");
        Button addReclam = new Button("Add Reclamations");
        
         //add(new Label("Repairs : "));
        Label lbx = new Label("Repairs : ");
         Button btnListTasks = new Button("List Repairs");
        Button addRepair = new Button("Add Repair");
        
        btnListTasks.addActionListener(e-> new ListRepairsForm(current).show());
        addRepair.addActionListener(e->new AddRepair(current).show());
         btnListReclam.addActionListener(e-> new ListReclamationForm(current).show());
        addReclam.addActionListener(e->new AddReclamation(current).show());
        addAll(btnListReclam,addReclam,lbx,btnListTasks,addRepair);
    
        
    }
    
}
