package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoPersona;
import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Security.Controller.Mensaje;
import com.portfolio.backend.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin (origins = "https://frontendportafolioapp.web.app/")
public class PersonaController {
    
    @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
   
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esta persona ya existe "), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        
       Persona persona = personaService.getOne(id).get();
       
       persona.setNombre(dtopersona.getNombre());
       persona.setApellido(dtopersona.getApellido());
       persona.setDescripcion(dtopersona.getDescripcion());
       persona.setImgPerfil(dtopersona.getImgPerfil());
       persona.setTitulo(dtopersona.getTitulo());
       
       personaService.save(persona);
       return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }
    /*
       @DeleteMapping("/delete/{id}")
       public ResponseEntity<?> delete(@PathVariable("id") int id){
           if (!personaService.existsById(id))
               return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
           
           personaService.delete(id);
           
           return new ResponseEntity(new Mensaje("Persona Eliminada"), HttpStatus.OK);
       }
     */
     @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (personaService.existsByNombre(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Esta persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtopersona.getNombre(),dtopersona.getApellido(), dtopersona.getDescripcion(),dtopersona.getImgPerfil(),dtopersona.getTitulo());
        personaService.save(persona);

        return new ResponseEntity(new Mensaje("Creada"), HttpStatus.OK);
    }
      

}
