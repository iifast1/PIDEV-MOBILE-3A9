
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author medam
 */
public class ServiceReclamations {
    
    
    public ArrayList<Reclamation> reclamation;
    public static ServiceReclamations instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceReclamations() {
         req = new ConnectionRequest();
    }

    public static ServiceReclamations getInstance() {
        if (instance == null) {
            instance = new ServiceReclamations();
        }
        return instance;
    }
    
     public boolean addReclamations(Reclamation c) {
     //  String url = "http://localhost/Bascla-master/web/app_dev.php/Av/Reclamation/addmobil/?ReclamationDescription=Zzr&ReclamationStatus=false&id=2";
                                                                               
     String url1 = Statics.BASE_URL + "Av/Reclamation/addmobilRec/?reclamationSubjet="  + c.getSujet()+ "&disponibility=" + c.getDisponibilite() + "qualility=" + c.getQualite() + "&reclamationDescription=" + c.getDescription() + "&id=1";
        req.setUrl(url1);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
            public ArrayList<Reclamation> parseReclamations(String jsonText){
        try {
            reclamation =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Reclamation ex = new Reclamation();
                float idRec = Float.parseFloat(obj.get("id").toString());
                      ex.setIdRe((int) idRec);
            
          ex.setDisponibilite(((int)Float.parseFloat(obj.get("Disponibilite").toString())));
           ex.setQualite(((int)Float.parseFloat(obj.get("Qualite").toString())));
               ex.setServices(((int)Float.parseFloat(obj.get("Services").toString())));
                  
//         ex.setDisponibilite((int) Disponibilie);
//         ex.setQualite((int) Qualite);
//         ex.setServices((int) services);
         ex.setDescription(obj.get("ReclamationDescription").toString());
           ex.setSujet(obj.get("ReclamationSujet").toString());
// e.setReclamationStatus(obj.get("ReclamationStatus").toString());
                            
                
// e.setReclamationStatus((Boolean) obj.get("ReclamationStatus"));


                reclamation.add(ex);
            }
            
            
        } catch (IOException ex) {
            
        }
        return reclamation;
    }
    
    
        public ArrayList<Reclamation> getAllReclamations(){
        String url1 = Statics.BASE_URL+"Av/Reclamation/reclamations/all";
        req.setUrl(url1);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamation = parseReclamations(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamation;
    }
      
        /*
        public ArrayList<Reclamation> getMonthReclamation(String evMonth){
        String url = Statics.BASE_URL+"/reclamations/findEv/"+evMonth;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamation = parseReclamations(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamation;
    }  
        */
        
        
        //????????????????????SupEv
      public Boolean supRep(int idRep){
        String url1 = Statics.BASE_URL+"/reclamation/delete/"+idRep;
        req.setUrl(url1);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

        
}
    
