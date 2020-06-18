package com.mycompany.myapp.entities;

import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author 
 */
public class Repair {
    
    private int idRep;
    private String RepairDescription;
    private  Boolean RepairStatus;

//    public Repair(int idRep, String RepairDescription, String RepairStatus) {
//        this.idRep = idRep;
//        this.RepairDescription = RepairDescription;
//        this.RepairStatus = RepairStatus;
//    }

    public Repair(int idRep, String RepairDescription, Boolean RepairStatus) {
        this.idRep = idRep;
        this.RepairDescription = RepairDescription;
        this.RepairStatus = RepairStatus;
    }

    
    public Repair(String RepairDescription, Boolean RepairStatus) {
  
        this.RepairDescription = RepairDescription;
        this.RepairStatus = RepairStatus;
    }

    public Repair() {
    }

    
    public int getIdRep() {
        return idRep;
    }

    public void setIdRep(int idRep) {
        this.idRep = idRep;
    }

  
    public String getRepairDescription() {
        return RepairDescription;
    }

    public void setRepairDescription(String RepairDescription) {
        this.RepairDescription = RepairDescription;
    }

    public Boolean getRepairStatus() {
        return RepairStatus;
    }

    public void setRepairStatus( Boolean RepairStatus) {
        this.RepairStatus = RepairStatus;
    }

    @Override
    public String toString() {
        return "Repair{" + "idRep=" + idRep + ", RepairDescription=" + RepairDescription + ", RepairStatus=" + RepairStatus + '}';
    }


       
}
