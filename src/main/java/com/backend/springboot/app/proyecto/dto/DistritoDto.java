package com.backend.springboot.app.proyecto.dto;

public class DistritoDto {

    private Long idDistrito;
    private String nombre;
    private Integer coodigoPostal;
    private ProvinciaDto provincia;

    public DistritoDto(Long idDistrito, String nombre, Integer coodigoPostal, ProvinciaDto provincia) {
        this.idDistrito = idDistrito;
        this.nombre = nombre;
        this.coodigoPostal = coodigoPostal;
        this.provincia = provincia;
    }

    public DistritoDto(){

    }

    public Long getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Long idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCoodigoPostal() {
        return coodigoPostal;
    }

    public void setCoodigoPostal(Integer coodigoPostal) {
        this.coodigoPostal = coodigoPostal;
    }

    public ProvinciaDto getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaDto provincia) {
        this.provincia = provincia;
    }
}

