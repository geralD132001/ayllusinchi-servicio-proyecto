package com.backend.springboot.app.proyecto.dto;

public class ComunidadDto {

    private Long idComunidad;
    private String nombre;
    private DistritoDto distrito;

    public ComunidadDto(Long idComunidad, String nombre, DistritoDto distrito) {
        this.idComunidad = idComunidad;
        this.nombre = nombre;
        this.distrito = distrito;
    }

    public ComunidadDto() {

    }

    public Long getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Long idComunidad) {
        this.idComunidad = idComunidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DistritoDto getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoDto distrito) {
        this.distrito = distrito;
    }
}
