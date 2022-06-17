package com.sena.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Album;

    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_Album;

    private String APublicacion;

    private Boolean estado_Album;

    public Album(){

    }

    public Album(Integer Id_Album, String nombre_Album, String APublicacion, Boolean estado_Album){
        this.Id_Album = Id_Album;
        this.nombre_Album = nombre_Album;
        this.APublicacion = APublicacion;
        this.estado_Album = estado_Album;
    }

    //Getters y setters 
    
    public void setId_Album(Integer Id_Album) {
        this.Id_Album = Id_Album;
    }
    
    public Integer getId_Album() {
        return Id_Album;
    } 

    public void setNombre_Album(String nombre_Album) {
        this.nombre_Album = nombre_Album;
    }

    public String getNombre_Album() {
        return nombre_Album;
    }

    public void setAPublicacion(String APublicacion){
        this.APublicacion = APublicacion;
    }

    public String getAPublicacion(){
        return APublicacion;
    }

    public void setEstado_Album(Boolean estado_Album) {
        this.estado_Album = estado_Album;
    }

    public Boolean getEstado_Album() {
        return estado_Album;
    }
}