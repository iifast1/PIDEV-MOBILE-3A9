
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Repair;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import com.mycompany.myapp.entities.Enfants;
//import com.mycompany.myapp.entities.Repair;


/**
 *
 * @author mabt - amine 
 */
public class ServiceRepairs {
    
    
    public ArrayList<Repair> repair;
    public static ServiceRepairs instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceRepairs() {
         req = new ConnectionRequest();
    }

    public static ServiceRepairs getInstance() {
        if (instance == null) {
            instance = new ServiceRepairs();
        }
        return instance;
    }
    
     public boolean addRepairs(Repair r) {
     //  String url = "http://localhost/Bascla-master/web/app_dev.php/Av/Repair/addmobil/?RepairDescription=Zzr&RepairStatus=false&id=2";
       String url = Statics.BASE_URL + "Av/Repair/addmobil/?RepairDescription=" + r.getRepairDescription()+ "&RepairStatus=" + r.getRepairStatus()+ "&id=1";
      
        req.setUrl(url);
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
    
    
    
            public ArrayList<Repair> parseRepairs(String jsonText){
        try {
            repair =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Repair e = new Repair();
                float idRep = Float.parseFloat(obj.get("id").toString());
                              e.setIdRep((int) idRep);
          //      e.setIdRep((int)idRep);
//                e.set(obj.get("evName").toString());
//                e.setEvMonth(obj.get("evMonth").toString());
//                e.setEvStart(obj.get("evStart").toString());
//                e.setEvEnd(obj.get("evEnd").toString());
//               
               
             
                e.setRepairDescription(obj.get("RepairDescription").toString());
     e.setRepairStatus(((boolean)Boolean.parseBoolean(obj.get("RepairStatus").toString())));
                              
// e.setRepairStatus(obj.get("RepairStatus").toString());
                            
                
// e.setRepairStatus((Boolean) obj.get("RepairStatus"));


                repair.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return repair;
    }
    
    
        public ArrayList<Repair> getAllRepairs(){
        String url = Statics.BASE_URL+"Av/Repair/repairs/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                repair = parseRepairs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return repair;
    }
      
        /*
        public ArrayList<Repair> getMonthRepair(String evMonth){
        String url = Statics.BASE_URL+"/repairs/findEv/"+evMonth;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                repair = parseRepairs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return repair;
    }  
        */
        
        
        //????????????????????SupEv
      public Boolean supRep(int idRep){
        String url = Statics.BASE_URL+"/repair/delete/"+idRep;
        req.setUrl(url);
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
    
