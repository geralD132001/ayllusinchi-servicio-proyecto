package com.backend.springboot.app.proyecto.controllers;

import com.backend.springboot.app.commons.proyecto.models.entity.Proyecto;
import com.backend.springboot.app.commons.proyecto.models.entity.Taller;
import com.backend.springboot.app.proyecto.models.service.ITallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("taller")
public class TallerController {

    @Autowired
    private ITallerService tallerService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta");
        result.put("data", tallerService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) throws InterruptedException{

        HashMap<String, Object> result = new HashMap<>();
        Taller data = tallerService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Taller con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody Taller taller, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Taller data = tallerService.save(taller);
        result.put("success", true);
        result.put("message", "El Taller se ha registrado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/editar/{idTaller}")
    public ResponseEntity<?> update(@PathVariable(value = "idTaller") Long idTaller, @RequestBody Taller taller,
                                    HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Taller data = tallerService.findById(idTaller);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe taller con Id: " + idTaller);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            tallerService.save(taller);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del Taller.");
            result.put("data", taller);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{idTaller}")
    public ResponseEntity<?> delete(@PathVariable(value = "idTaller") Long idTaller, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Taller data = tallerService.findById(idTaller);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe División con id: " + idTaller);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            // data.setEstado(false);
            tallerService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
