package com.backend.springboot.app.proyecto.intregracion;


import com.backend.springboot.app.proyecto.dto.ComunidadDto2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "servicio-ubigeo")
public interface ComunidadClienteRest {

    @GetMapping("/{id}")
    public Optional<ComunidadDto2> findComunidad(@PathVariable Long id);
}
