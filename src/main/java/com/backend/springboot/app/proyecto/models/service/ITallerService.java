package com.backend.springboot.app.proyecto.models.service;



import com.backend.springboot.app.commons.proyecto.models.entity.Taller;

import java.util.List;

public interface ITallerService {

    public List<Taller> findAll();
    public Taller findById(Long id);
    public Taller save(Taller taller);
    public void delete(Taller taller);
}
