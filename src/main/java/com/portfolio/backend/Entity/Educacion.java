package com.portfolio.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String nombreEducacion;
    private String descripcionEducacion;
    private int comienzo;
    private int finalizacion;

    public Educacion() {
    }

    public Educacion(String nombreEducacion, String descripcionEducacion, int comienzo, int finalizacion) {
        this.nombreEducacion = nombreEducacion;
        this.descripcionEducacion = descripcionEducacion;
        this.comienzo = comienzo;
        this.finalizacion = finalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEducacion() {
        return nombreEducacion;
    }

    public void setNombreEducacion(String nombreEducacion) {
        this.nombreEducacion = nombreEducacion;
    }

    public String getDescripcionEducacion() {
        return descripcionEducacion;
    }

    public void setDescripcionEducacion(String descripcionEducacion) {
        this.descripcionEducacion = descripcionEducacion;
    }
    
    public int getComienzo(){
       return comienzo;
    }
    
    public void setComienzo(int comienzo){
        this.comienzo = comienzo;
    }
    public int getFinalizacion(){
        return finalizacion;
    }

    public void setFinalizacion(int finalizacion){
        this.finalizacion = finalizacion;
    }
   
    
}
