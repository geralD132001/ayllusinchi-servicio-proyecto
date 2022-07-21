package com.backend.springboot.app.proyecto.models.repository;

import com.backend.springboot.app.commons.proyecto.models.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProyectoRespository extends JpaRepository<Proyecto, Long> {


  // List<Proyecto> findByFacultad(Long idFacultad);

}
