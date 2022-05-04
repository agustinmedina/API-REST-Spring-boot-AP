package com.example.holamundo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
   
    @Autowired
    private IPersonaService persoServ;
    @PostMapping ("/new/persona/")
    public void agregarPersona (@RequestBody Persona pers){
        //listaPersonas.add(pers);
        //persoServ.buscarPersona(id);
        persoServ.crearPersona(pers);
    }
    /*

    @PutMapping ("/put/{id}")
    public void modificarPersona (@PathVariable Long id,@RequestBody Persona pers){
        //listaPersonas.add(pers);
        persoServ.buscarPersona(id);
        persoServ.modificarPersona(pers);
    }
    */

    @PutMapping ("/put/{id}")
    public Persona mofidicarPersona (@PathVariable Long id, @RequestParam("nombre") String nuevoNombre,
    @RequestParam ("apellido") String nuevoApellido){
        Persona pers = persoServ.buscarPersona(id);

        pers.setApellido(nuevoApellido);
        pers.setNombre(nuevoNombre);
        
        persoServ.modificarPersona(pers);

        return pers;

    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas (){
        //return listaPersonas;
        return persoServ.verPersonas();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    }


}
