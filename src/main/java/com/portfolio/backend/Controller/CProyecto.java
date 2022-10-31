package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoProyecto;
import com.portfolio.backend.Entity.Proyecto;
import com.portfolio.backend.Security.Controller.Mensaje;
import com.portfolio.backend.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://frontendportafolioapp.web.app")
public class CProyecto {
    
    @Autowired
    SProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto) {
        if (StringUtils.isBlank(dtoproyecto.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombreProyecto(dtoproyecto.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtoproyecto.getNombreProyecto(), dtoproyecto.getDescripcionProyecto(), dtoproyecto.getComienzo(), dtoproyecto.getFinalizacion());
        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (sProyecto.existsByNombreProyecto(dtoproyecto.getNombreProyecto()) && sProyecto.getByNombreProyecto(dtoproyecto.getNombreProyecto()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe "), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproyecto.getNombreProyecto()))
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = sProyecto.getOne(id).get();
       proyecto.setNombreProyecto(dtoproyecto.getNombreProyecto());
       proyecto.setDescripcionProyecto(dtoproyecto.getDescripcionProyecto());
       proyecto.setComienzo(dtoproyecto.getComienzo());
       proyecto.setFinalizacion(dtoproyecto.getFinalizacion());
       
       sProyecto.save(proyecto);
       return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }
    
    
       @DeleteMapping("/delete/{id}")
       public ResponseEntity<?> delete(@PathVariable("id") int id){
           if (!sProyecto.existsById(id))
               return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
           
           sProyecto.delete(id);
           
           return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
       }

    
}
