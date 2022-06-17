package com.sena.demo.controllers;

import javax.validation.Valid;

import com.sena.demo.models.Cancion;
import com.sena.demo.models.ICancion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("cancion")
@RequestMapping("/cancion")

public class CancionController {

    @Autowired
    private ICancion canciond;
    
    @GetMapping(path={"/listar","","/"})
    public String listar(Model model){
        model.addAttribute("cancion", canciond.findAll());
        return "cancion/cancion";
        
    }
    

    @GetMapping("/editar/{Id_Cancion}")
        public String ver(@PathVariable Integer Id_Cancion,Model model){
            Cancion cancion = null;
                if(Id_Cancion>0){
                cancion = canciond.findOne(Id_Cancion);
            }else{
                return "redirect:listar";
            }
                model.addAttribute("cancion",cancion); 
                model.addAttribute("accion", "Actualizar Cancion");
                return "cancion/formulario";
        }


    @GetMapping("/formcancion")
        public String form(Model model){
            Cancion cancion = new Cancion();
            model.addAttribute("cancion", cancion);
            model.addAttribute("accion", "Agregar Cancion");

            return "cancion/formulario"; 
        }

    @PostMapping("/addcancion")
        public String add(@Valid Cancion cancion, BindingResult res, Model model,  SessionStatus status){
        if(res.hasErrors()){
        return "cancion/formulario";
        }
        canciond.save(cancion); 
        status.setComplete();  
        return "redirect:listar";
    }

    @GetMapping("/eliminar/{Id_Cancion}")
    public String delete(@PathVariable Integer Id_Cancion) {
        if(Id_Cancion > 0) {
            canciond.delete(Id_Cancion);
        }
        return "forward:../listar";
    }
}
