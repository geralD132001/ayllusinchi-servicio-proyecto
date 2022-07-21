package com.backend.springboot.app.proyecto.controllers;

import com.backend.springboot.app.commons.proyecto.models.entity.Programa;
import com.backend.springboot.app.commons.proyecto.models.entity.Taller;
import com.backend.springboot.app.proyecto.models.service.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = { "https://ayllusinchis-app.azurewebsites.net" })
@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private IProgramaService programaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta");
        result.put("data", programaService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) throws InterruptedException{

        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Programa con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody Programa programa, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.save(programa);
        result.put("success", true);
        result.put("message", "El Programa se ha registrado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/editar/{idPrograma}")
    public ResponseEntity<?> update(@PathVariable(value = "idPrograma") Long idPrograma, @RequestBody Programa programa,
                                    HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.findById(idPrograma);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe programa con Id: " + idPrograma);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            programaService.save(programa);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del Programa.");
            result.put("data", programa);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{idPrograma}")
    public ResponseEntity<?> delete(@PathVariable Long idPrograma, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.findById(idPrograma);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe División con id: " + idPrograma);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            // data.setEstado(false);
            programaService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
