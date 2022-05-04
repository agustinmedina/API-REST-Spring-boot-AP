package com.example.holamundo;
import java.util.List;


public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersona (Persona per);
    public void modificarPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    //en el ultimo caso devuelve persona por eso no va void
    
}
