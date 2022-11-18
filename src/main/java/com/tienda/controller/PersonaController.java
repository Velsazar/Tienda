/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller //igual definimos que es Controller
public class PersonaController {

    @Autowired //que vamos a usar el personaService
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;
    /*          
Get:pide solicitar una copia de un recurso
Post:envia datos a un servidor para crear un nuevo recurso
put:envia datos a un servidor para modificar un recurso existente
Delete:enviar para eliminar un recurso.   
llamo al metodo GET   le indico la URL*/
    @GetMapping("/persona")//investigando esta parte es de request mapping , son los metodos anotadas en las clases anotadas de Controller
    public String index(Model model) {//estoy pasando un model --> obajeto tipo modelo(pasarle info al front-End)
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Personas");//Mediante el metodo .AddAttribute recibe dos parametros, Titulo--> donde en mi Html diga titulo va ser sustituido por tabla PERSONA
        model.addAttribute("personas", listaPersona);
        return "personas";//lo que devolvemos es el Html al final de cuentas.
    }

    @GetMapping("/personaN")
    public String crearPersona(Model model) {//MODEL desde el back-ENd enviar informacion al FRont-End
        List<Pais> listaPaises = paisService.listCountry();//entra en paisService, obtiene la info de listaPaises, y la guarda en una variable
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPaises);
        return "crear";   //devulve crear el html
    }

    @PostMapping("/save") //este actua como acceso directo , cooinciden conla expresion URI
    public String guardarPersona(@ModelAttribute Persona persona) {/*el @ModelAttribute es el objeto que utilizamos para recibir informacion  desde el front end hacia el Backend
                                                                    recibimos(informacion desde el frontEND) al backend--> un objeto de tipo persona el cual voy a llamar persona
                                                                    voy a llamar persona
                                                                    osea VAMOS a recibir un objeto de tipo persona */
        personaService.savePersona(persona);//no retorna nada, ocupo pasar el objeto, recibe el SAVE 
        return "redirect:/persona";//queremos redirigirlo hacia persona, quien es? todo el metodo @GetMapping("/persona")
    }

    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", persona);//permite cargar la info previa ya metida en la BD
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    @GetMapping("/delete/{id}")//variable de ruta 
    public String eliminarPersona(@PathVariable("id") Long idPersona) {
        personaService.delete(idPersona);
        return "redirect:/persona";
    }
    
}
