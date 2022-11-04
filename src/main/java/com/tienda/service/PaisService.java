/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;


/**
 *
 * @author rlobando
 * 
 */
import com.tienda.entity.Pais;
import com.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PaisService implements IPaisService {
    
    @Autowired   //para instanciar un repo dentro del servicio(es tener mundos aparte)ocupa un enlace que es el AUTOWIRED, enlaza ese tipo diferente de objetos o elemntos
    private PaisRepository paisRepository;

    @Override
    public List<Pais> listCountry() {
        return (List<Pais>)paisRepository.findAll();  }   
}
