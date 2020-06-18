package com.mycompany.myapp.entities;

/**
 *
 * @author bhk
 */

public class Reclamation {
   private int idReclam;
   private int Disponibilite;
   private  int qualite;
   private int Services;
   private String Description;
   private String Sujet;

    public Reclamation(int idReclam,String Sujet, int Disponibilite, int qualite, int Services, String Description) {
        this.idReclam = idReclam;
        this.Disponibilite = Disponibilite;
        this.qualite = qualite;
        this.Services = Services;
        this.Description = Description;
        this.Sujet = Sujet;
    }

    public Reclamation(String Sujet,int Disponibilite, int qualite, int Services, String Description) {
        this.Disponibilite = Disponibilite;
        this.qualite = qualite;
        this.Services = Services;
        this.Description = Description;
        this.Sujet = Sujet;
    }

    
    
    
    public Reclamation() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdReclam() {
        return idReclam;
    }

    public void setIdReclam(int idReclam) {
        this.idReclam = idReclam;
    }

    public int getDisponibilite() {
        return Disponibilite;
    }

    public void setDisponibilite(int Disponibilite) {
        this.Disponibilite = Disponibilite;
    }

    public int getQualite() {
        return qualite;
    }

    public void setQualite(int qualite) {
        this.qualite = qualite;
    }

    public int getServices() {
        return Services;
    }

    public void setServices(int Services) {
        this.Services = Services;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getSujet() {
        return Sujet;
    }

    public void setSujet(String Sujet) {
        this.Sujet = Sujet;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclam=" + idReclam + ", Disponibilite=" + Disponibilite + ", qualite=" + qualite + ", Services=" + Services + ", Description=" + Description + ", Sujet=" + Sujet + '}';
    }


    public void setIdRe(int idReclam) {
        this.idReclam = idReclam;
    }

      
}
