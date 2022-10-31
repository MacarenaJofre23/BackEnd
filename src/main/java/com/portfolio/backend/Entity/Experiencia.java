package com.portfolio.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String nombreExperiencia;
    private String descripcionExperiencia;
    private int comienzo;
    private int finalizacion;
  
    public Experiencia(){
    }
    public Experiencia(String nombreExperiencia, String descripcionExperiencia, int comienzo, int finalizacion){
        this.nombreExperiencia = nombreExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
        this.comienzo = comienzo;
        this.finalizacion = finalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExperiencia() {
        return nombreExperiencia;
    }

    public void setNombreExperiencia(String nombreExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
    }

    public String getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(String descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }
     public int getComienzo() {
        return comienzo;
    }
     public void setComienzo(int comienzo){
         this.comienzo = comienzo;
     }

     public int getFinalizacion(){
         return finalizacion;
     }
    public void setFinalizacion(int finalizacion) {
        this.finalizacion = finalizacion;
    }

    
    
}
