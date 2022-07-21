package com.backend.springboot.app.proyecto.intregracion;

import com.backend.springboot.app.proyecto.dto.FacultadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FacultadFeignServiceImpl implements FacultadFeignService {

    @Autowired
    private FacultadClienteRest clienteFeign;


    @Override
    public Optional<FacultadDto> findByIdFacultad(Long idFacultad) {
        var fac = clienteFeign.findFacultad(idFacultad);
        System.out.println("Prueba"+ fac.get().getNombre());

        if(fac.isPresent()){
            var facDto = new FacultadDto();
            facDto.setIdFacultad(fac.get().getIdFacultad());
            facDto.setNombre(fac.get().getNombre());
            facDto.setAbreviacion(fac.get().getAbreviacion());
            // esta trayendo valores nulos
            // var factDto2 = FacultadDto.builder().idFacultad(idFacultad).build());
            return Optional.of(facDto);
        }
        return Optional.empty();
    }
}
