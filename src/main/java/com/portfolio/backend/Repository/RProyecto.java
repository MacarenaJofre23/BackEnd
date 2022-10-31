package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer>{
public Optional<Proyecto> findByNombreProyecto(String nombreProyecto);
public boolean existsByNombreProyecto(String nombreProyecto);
}
