package com.backend.springboot.app.proyecto.dto;


import java.io.Serializable;

public class ProyectoDto implements Serializable {

    private Long idProyecto;
    private String nombre;
    private String resenia;
    private Integer port;
    private String objetivoGeneral;
    private String objetivoEspecifico;
    private ComunidadDto comunidad;

    public ProyectoDto(Long idProyecto, String nombre, String resenia, Integer port, String objetivoGeneral, String objetivoEspecifico, ComunidadDto comunidad) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.resenia = resenia;
        this.port = port;
        this.objetivoGeneral = objetivoGeneral;
        this.objetivoEspecifico = objetivoEspecifico;
        this.comunidad = comunidad;
    }

    public ProyectoDto() {

    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResenia() {
        return resenia;
    }

    public void setResenia(String resenia) {
        this.resenia = resenia;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public ComunidadDto getComunidad() {
        return comunidad;
    }

    public void setComunidad(ComunidadDto comunidad) {
        this.comunidad = comunidad;
    }
}

