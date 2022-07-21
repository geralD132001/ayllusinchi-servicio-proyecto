package com.backend.springboot.app.proyecto.intregracion;


import com.backend.springboot.app.commons.sedes.models.entity.Facultad;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "servicio-sedes")
public interface FacultadClienteRest {

    @GetMapping("/comunidad/ver/{id}")
    public Optional<Facultad>  findFacultad(@PathVariable Long id);
}
