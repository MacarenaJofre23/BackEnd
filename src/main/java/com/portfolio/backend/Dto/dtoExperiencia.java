package com.portfolio.backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String nombreExperiencia;
    
    @NotBlank
    private String descripcionExperiencia;
    

    private int comienzo;
    private int finalizacion;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExperiencia, String descripcionExperiencia, int comienzo, int finalizacion) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
        this.comienzo = comienzo;
        this.finalizacion = finalizacion;
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
