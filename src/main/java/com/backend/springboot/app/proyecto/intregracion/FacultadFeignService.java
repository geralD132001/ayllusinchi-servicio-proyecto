package com.backend.springboot.app.proyecto.intregracion;

import com.backend.springboot.app.proyecto.dto.FacultadDto;

import java.util.Optional;

public interface FacultadFeignService {

    public Optional<FacultadDto> findByIdFacultad(Long idFacultad);

}
