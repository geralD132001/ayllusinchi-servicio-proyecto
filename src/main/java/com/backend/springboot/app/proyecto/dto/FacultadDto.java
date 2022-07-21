package com.backend.springboot.app.proyecto.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class FacultadDto implements Serializable {

    private Long idFacultad;
    private String nombre;
    private String abreviacion;

    public FacultadDto(Long idFacultad, String nombre, String abreviacion) {
        this.idFacultad = idFacultad;
        this.nombre = nombre;
        this.abreviacion = abreviacion;
    }

    public FacultadDto(){
    }

    public Long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Long idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }
}

