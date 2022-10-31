package com.portfolio.backend.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreEducacion;
    
    @NotBlank
    private String descripcionEducacion;
    
    private int comienzo;
    
    private int finalizacion;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEducacion, String descripcionEducacion, int comienzo, int finalizacion) {
        this.nombreEducacion = nombreEducacion;
        this.descripcionEducacion = descripcionEducacion;
        this.comienzo = comienzo;
        this.finalizacion = finalizacion;
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
