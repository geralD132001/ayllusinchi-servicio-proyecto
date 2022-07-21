package com.backend.springboot.app.proyecto.intregracion;

import com.backend.springboot.app.proyecto.dto.ComunidadDto;

import java.util.Optional;

public interface ComunidadFeignService {

    public Optional<ComunidadDto> findByIdComunidad(Long idComunidad);

}
