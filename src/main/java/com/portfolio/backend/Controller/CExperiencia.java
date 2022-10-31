package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoExperiencia;
import com.portfolio.backend.Entity.Experiencia;
import com.portfolio.backend.Security.Controller.Mensaje;
import com.portfolio.backend.Service.SExperiencia;
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
@RequestMapping("/experiencialaboral")
@CrossOrigin(origins = "https://frontendportafolioapp.web.app")
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexperiencia) {
        if (StringUtils.isBlank(dtoexperiencia.getNombreExperiencia())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existsByNombreExperiencia(dtoexperiencia.getNombreExperiencia())) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoexperiencia.getNombreExperiencia(), dtoexperiencia.getDescripcionExperiencia(), dtoexperiencia.getComienzo(), dtoexperiencia.getFinalizacion());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexperiencia) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (sExperiencia.existsByNombreExperiencia(dtoexperiencia.getNombreExperiencia()) && sExperiencia.getByNombreExperiencia(dtoexperiencia.getNombreExperiencia()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Experiencia ya existe "), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoexperiencia.getNombreExperiencia()))
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
       experiencia.setNombreExperiencia(dtoexperiencia.getNombreExperiencia());
       experiencia.setDescripcionExperiencia(dtoexperiencia.getDescripcionExperiencia());
       experiencia.setComienzo(dtoexperiencia.getComienzo());
       experiencia.setFinalizacion(dtoexperiencia.getFinalizacion());
       
       sExperiencia.save(experiencia);
       return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
       @DeleteMapping("/delete/{id}")
       public ResponseEntity<?> delete(@PathVariable("id") int id){
           if (!sExperiencia.existsById(id))
               return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
           
           sExperiencia.delete(id);
           
           return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
       }

}
