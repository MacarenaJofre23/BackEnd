package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Proyecto;
import com.portfolio.backend.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {

    @Autowired
    RProyecto rProyecto;
    
    public List<Proyecto> list(){
        return rProyecto.findAll();
    }
    public Optional<Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }
    public Optional<Proyecto> getByNombreProyecto(String nombreProyecto){
        return rProyecto.findByNombreProyecto(nombreProyecto);
    }
    public void save(Proyecto proyecto){
       rProyecto.save(proyecto); 
    }
    public void delete(int id){
        rProyecto.deleteById(id);
    }
    public boolean existsById(int id){
        return rProyecto.existsById(id);
    }
    public boolean existsByNombreProyecto(String nombreProyecto){
        return rProyecto.existsByNombreProyecto(nombreProyecto);
    }
    
}

