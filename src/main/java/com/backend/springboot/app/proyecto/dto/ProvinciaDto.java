package com.backend.springboot.app.proyecto.dto;

public class ProvinciaDto {

    private Long idProvincia;
    private String nombre;
    private DepartamentoDto departamento;

    public ProvinciaDto(Long idProvincia, String nombre, DepartamentoDto departamento) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public ProvinciaDto(){

    }

    public Long getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DepartamentoDto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDto departamento) {
        this.departamento = departamento;
    }
}
