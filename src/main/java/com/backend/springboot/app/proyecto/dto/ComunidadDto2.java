package com.backend.springboot.app.proyecto.dto;

import com.backend.springboot.app.commons.ubigeo.models.entity.Comunidad;

public class ComunidadDto2 {

    private Comunidad data;
    private String succes;
    private String message;

    public ComunidadDto2(Comunidad data, String succes, String message) {
        this.data = data;
        this.succes = succes;
        this.message = message;
    }

    public ComunidadDto2(){

    }

    public Comunidad getData() {
        return data;
    }

    public void setData(Comunidad data) {
        this.data = data;
    }

    public String getSucces() {
        return succes;
    }

    public void setSucces(String succes) {
        this.succes = succes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
