package com.backend.springboot.app.proyecto.models.service;

import com.backend.springboot.app.commons.proyecto.models.entity.Proyecto;
import com.backend.springboot.app.proyecto.dto.ProyectoDto;
import com.backend.springboot.app.proyecto.intregracion.FacultadFeignService;
import com.backend.springboot.app.proyecto.models.repository.ProyectoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoServiceImpl implements IProyectoService{

    @Autowired
    private ProyectoRespository proyectoRespository;

    @Autowired
    private FacultadFeignService serviceFacultad;

    @Override
    @Transactional(readOnly = true)
    public List<Proyecto> findAll() {
        return (List<Proyecto>) proyectoRespository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proyecto findById(Long id) {
        return proyectoRespository.findById( id ).orElse(null);
    }

    @Override
    @Transactional
    public Proyecto save(Proyecto proyecto) {
        return proyectoRespository.save(proyecto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        proyectoRespository.deleteById(id);
    }


    /*
    @Override
    @Transactional(readOnly = true)
    public List<ProyectoDto> findByIdFacultad(Long idFacultad) {
        List<Proyecto> rs = proyectoRespository.findByFacultad(idFacultad);
        var fac = serviceFacultad.findByIdFacultad(idFacultad);
        System.out.println(fac.get().getNombre()+"Gerald");
        List<ProyectoDto> list = new ArrayList<>();
        for(Proyecto p : rs){
            var proDto = new ProyectoDto();
            proDto.setIdProyecto(p.getIdProyecto());
            proDto.setNombre(p.getNombre());
            proDto.setResenia(p.getResenia());
            proDto.setPort(p.getPort());
            proDto.setObjetivoGeneral(p.getObjetivoGeneral());
            proDto.setObjetivoEspecifico(p.getObjetivoEspecifico());
            proDto.setFacultad(fac.get());
            list.add(proDto);
        }

        return list;
    }
     */
}
