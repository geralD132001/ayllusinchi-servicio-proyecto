package com.backend.springboot.app.proyecto.models.service;

import com.backend.springboot.app.commons.proyecto.models.entity.Programa;
import com.backend.springboot.app.proyecto.models.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProgramaServiceImpl implements IProgramaService{

    @Autowired
    private ProgramaRepository programaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Programa> findAll() {
        return (List<Programa>) programaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Programa findById(Long id) {
        return programaRepository.findById( id ).orElse(null);
    }

    @Override
    public Programa save(Programa programa) {
        return programaRepository.save(programa);
    }

    @Override
    public void delete(Programa programa) {
        programaRepository.delete(programa);
    }
}
