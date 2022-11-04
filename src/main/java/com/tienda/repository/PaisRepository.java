/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rlobando
 */
@Repository //Patron decorador indicando que es un repositorio
public interface PaisRepository extends CrudRepository<Pais,Long>{   //Se pasa al repository-->El pais (entidad) long (tipo de antributo en nuestro primaryKey
} 