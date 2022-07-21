package com.backend.springboot.app.proyecto.controllers;

import com.backend.springboot.app.commons.proyecto.models.entity.Proyecto;
import com.backend.springboot.app.proyecto.dto.ProyectoDto;
import com.backend.springboot.app.proyecto.models.service.IProyectoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "https://ayllusinchis-app.azurewebsites.net" })
@RestController
public class ProyectoController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Environment env;

    @Autowired
    // @Qualifier("serviceFeign")
    private IProyectoService proyectoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta");
        result.put("data", proyectoService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) throws InterruptedException{
        /*if(id.equals(10L)) {
            throw new IllegalStateException("Proyecto no encontrado!");
        }

        if(id.equals(4L)) {
            TimeUnit.SECONDS.sleep(5L);
        }
         */

        // proyecto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        // proyecto.setPort(port);

        HashMap<String, Object> result = new HashMap<>();
        Proyecto data = proyectoService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Proyecto con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* @GetMapping("/facultad/ver/{facultad}")
    public List<ProyectoDto> listarProyectos(@PathVariable Long facultad){

        return proyectoService.findByIdFacultad(facultad);

    }
     */


    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<?> crear(@RequestBody Proyecto proyecto) {
        HashMap<String, Object> result = new HashMap<>();
        Proyecto data = proyectoService.save(proyecto);

        result.put("success", true);
        result.put("message", "El Proyecto se ha registrado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



    @PutMapping("/editar/{idProyecto}")
    public ResponseEntity<?> editar(@PathVariable Long idProyecto, @RequestBody Proyecto proyecto){
        HashMap<String, Object> result = new HashMap<>();
        Proyecto data = proyectoService.findById(idProyecto);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Proyecto con Id: " + idProyecto);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            proyectoService.save(proyecto);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del Proyecto.");
            result.put("data", proyecto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/eliminar/{idProyecto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> eliminar(@PathVariable Long idProyecto){
        HashMap<String, Object> result = new HashMap<>();
        Proyecto data = proyectoService.findById(idProyecto);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe División con id: " + idProyecto);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            // data.setEstado(false);
            proyectoService.deleteById(idProyecto);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
