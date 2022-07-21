package com.backend.springboot.app.proyecto.models.service;



import com.backend.springboot.app.commons.proyecto.models.entity.Programa;

import java.util.List;

public interface IProgramaService {

    public List<Programa> findAll();
    public Programa findById(Long id);
    public Programa save(Programa programa);
    public void delete(Programa programa);
}
