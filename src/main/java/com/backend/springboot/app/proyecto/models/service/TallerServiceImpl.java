package com.backend.springboot.app.proyecto.models.service;

import com.backend.springboot.app.commons.proyecto.models.entity.Taller;
import com.backend.springboot.app.proyecto.models.repository.ProyectoRespository;
import com.backend.springboot.app.proyecto.models.repository.TallerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TallerServiceImpl implements ITallerService {

    @Autowired
    private TallerRepository tallerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Taller> findAll() {
        return (List<Taller>) tallerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Taller findById(Long id) {
        return tallerRepository.findById(id).orElse(null);
    }

    @Override
    public Taller save(Taller taller) {
        return tallerRepository.save(taller);
    }

    @Override
    public void delete(Taller taller) {
        tallerRepository.delete(taller);
    }
}
