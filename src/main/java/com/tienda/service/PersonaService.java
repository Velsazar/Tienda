/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;


import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rlobando
 */

@Service      //Definimos que es un Servicio
public class PersonaService implements IPersonaService{//implementamos los metodos de la Interfaz

    @Autowired  //para utilizar el persona reposiory
    private PersonaRepository personaRepository;
    //Aqui ocupamos el Persona repository para obtener la info requerida en los metodos que vayamos a usar 
    @Override
    public List<Persona> getAllPersona() {  
        return (List<Persona>)personaRepository.findAll(); //igual al de Pais, hace el findAll y se parcea  para que sea una lista PERSONA
    }

    @Override
    public Persona getPersonaById(long id) { //ocupa un parametro, pero si este Query no existe, no retornamos nada, al hacer el .OrElse(Null) sino existe devuelva NULL
        return personaRepository.findById(id).orElse(null);
     }

    @Override
    public void savePersona(Persona persona) { //paso objeto tipo persona, tiene la info de persona
        personaRepository.save(persona); 
     }

    @Override
    public void delete(long id) { 
        personaRepository.deleteById(id);
    }    
}