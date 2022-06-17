package com.sena.demo.controllers;

import javax.validation.Valid;

import com.sena.demo.models.Album;
import com.sena.demo.service.IAlbumService;

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
@SessionAttributes("album")
@RequestMapping("/album")

public class AlbumController {

    @Autowired
    private IAlbumService albumd;

    @GetMapping(path={"/listaralbum","/listar",""})
    public String listar(@Valid Album album, Model model){

        model.addAttribute("album", albumd.findAll());
        return "album/album";
        
    }

    @GetMapping("/veralbum")
    public String verc(Model model){
        Album album = new Album(); 
        model.addAttribute("album", album);
        return "album/verC";
    }
    

    @GetMapping("/editar/{Id_Album}")
    public String ver(@PathVariable Integer Id_Album,Model model){
        Album album =null;
        if(Id_Album>0){
        album  = albumd.findOne(Id_Album);
        }else{
        return "redirect:listar";
        }
        model.addAttribute("album", album);
        model.addAttribute("accion", "Actualizar Album");
        return "album/formulario";
    }

    @PostMapping("/addalbum")     
    public String ingresar(@Valid Album album, BindingResult res, Model model,SessionStatus status){
        if(res.hasErrors()){
            return "album/formulario";
        }
        albumd.save(album);
        status.setComplete();
        return "redirect:listar";
    }

    @GetMapping("/formalbum")
    public String form(Model model){
        Album album = new Album();
        model.addAttribute("album", album);
        model.addAttribute("accion", "Añadir Album");
        return "album/formulario";
    }

    @GetMapping("/delete/{Id_Album}")
    public String delete(@PathVariable Integer Id_Album) {
        if(Id_Album > 0) {
            albumd.delete(Id_Album);
        }

        return "redirect:../listar";
    } 
}