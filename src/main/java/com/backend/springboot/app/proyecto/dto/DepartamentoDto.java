package com.backend.springboot.app.proyecto.dto;

public class DepartamentoDto {

    private Long idDepartamento;
    private String nombre;

    public DepartamentoDto(Long idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public DepartamentoDto(){

    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
