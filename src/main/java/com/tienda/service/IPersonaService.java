/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;


import com.tienda.entity.Persona;
import java.util.List;

/**
 *En esta Clase voy a definir los metodos donde  quiero :obtener todas las personas, obtener persona por ID, guardar una persona, eliminar etc....
 * @author rlobando
 */
public interface IPersonaService {
    public List<Persona> getAllPersona();
    public Persona getPersonaById (long id);
    public void savePersona(Persona persona);
    public void delete (long id);
}
