package com.backend.springboot.app.proyecto.models.service;

import com.backend.springboot.app.commons.proyecto.models.entity.Proyecto;
import com.backend.springboot.app.proyecto.dto.ProyectoDto;

import java.util.List;

public interface IProyectoService {

    public List<Proyecto> findAll();
    public Proyecto findById(Long id);
    public Proyecto save(Proyecto proyecto);
    public void deleteById(Long id);
    // public List<ProyectoDto> findByIdFacultad(Long idFacultad);



}
