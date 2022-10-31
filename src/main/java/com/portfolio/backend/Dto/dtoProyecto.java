package com.portfolio.backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {
    
    @NotBlank
    private String nombreProyecto;
    
    @NotBlank
    private String descripcionProyecto;
    
    private int comienzo;
    private int finalizacion;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreProyecto, String descripcionProyecto, int comienzo, int finalizacion) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.comienzo = comienzo;
        this.finalizacion = finalizacion;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public int getComienzo() {
        return comienzo;
    }

    public void setComienzo(int comienzo) {
        this.comienzo = comienzo;
    }

    public int getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(int finalizacion) {
        this.finalizacion = finalizacion;
    }
    
    
}
