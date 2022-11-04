package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rlobando
 */
@Entity //Patron decorador,en tiempo de ejecucion(cuando se instancia una clase "pais por ejemplo", le da ciertas caracteristicas a nuestra clase como tal , Spring va a entender que ese
//objeto es una entidad
@Table(name = "paises")//le indico que la tabla que hace  refencia se llama "paises"
//Mapeando mi tabla llamada paises a una clase de JAVA, con la misma cantidad de atributos que tenga mi DB

public class Pais implements Serializable {

    @Id      //identificador que sea unico 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //esto es autoincremental, para cuando hagamos un insert , que el ID no es requerido ya que tiene autoincremental
    private long id;//primary key 
    private String pais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
