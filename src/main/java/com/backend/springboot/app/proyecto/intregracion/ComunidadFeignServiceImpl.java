package com.backend.springboot.app.proyecto.intregracion;

import com.backend.springboot.app.proyecto.dto.ComunidadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComunidadFeignServiceImpl implements ComunidadFeignService{

    @Autowired
    private ComunidadClienteRest comunidadFeign;

    @Override
    public Optional<ComunidadDto> findByIdComunidad(Long idComunidad) {

        var comunidad = comunidadFeign.findComunidad(idComunidad);

        System.out.println("Estudiante " + comunidad.get().getData().getNombre());

        if(comunidad.isPresent()){
            var comunidadDto = new ComunidadDto();
            comunidadDto.setIdComunidad(comunidad.get().getData().getIdComunidad());
            comunidadDto.setNombre(comunidad.get().getData().getNombre());
            return Optional.of(comunidadDto);
        }

        return Optional.empty();
    }
}
