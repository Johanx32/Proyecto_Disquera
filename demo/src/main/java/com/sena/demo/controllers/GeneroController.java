package com.sena.demo.controllers;

import javax.validation.Valid;

import com.sena.demo.models.Genero;
import com.sena.demo.models.IGenero;

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
@SessionAttributes("genero")
@RequestMapping("/genero")

public class GeneroController {

    @Autowired
    private IGenero Generod;
    
    @GetMapping(path={"/listar","","/"})
    public String listar(Model model){
        model.addAttribute("generosV", Generod.findAll());
        return "genero/genero";
        
    }

    @GetMapping("/editar/{Id_Genero}")
        public String ver(@PathVariable Integer Id_Genero,Model model){
            Genero genero = null;
                if(Id_Genero>0){
                genero = Generod.findOne(Id_Genero);
            }else{
                return "redirect:listar";
            }
                model.addAttribute("genero",genero); 
                model.addAttribute("accion", "Actualizar Genero");
                return "genero/formulario";
        }


    @GetMapping("/formgenero")
        public String form(Model model){
            Genero genero = new Genero();
            model.addAttribute("genero", genero);
            model.addAttribute("accion", "Agregar Genero");

            return "genero/formulario"; 
        }

    @PostMapping("/addgenero")
        public String add(@Valid Genero genero, BindingResult res, Model model,  SessionStatus status){
        if(res.hasErrors()){
        return "genero/formulario";
        }
        /*m.addAttribute("generosV",genero);
        return "genero/verG";*/

        Generod.save(genero); 
        status.setComplete();  
        return "redirect:listar";
    }

    @GetMapping("/eliminar/{Id_Genero}")
    public String delete(@PathVariable Integer Id_Genero) {
        if(Id_Genero > 0) {
            Generod.delete(Id_Genero);
        }
        return "forward:../listar";
    }
}


