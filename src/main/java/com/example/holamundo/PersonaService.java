package com.example.holamundo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    //Autowired nos permite hacer inyeccion de dependencias, 
    //puede ser mediante constructores o mediante Setter y demas
    //sin la necesidad de estar usando new cada rato y crear
    //un monton de instancias

    public IPersonaRepository persoRepo;

    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
        
    }

    @Override
    public void modificarPersona(Persona per) {
        persoRepo.save(per);        
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
        
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
   
    
}
