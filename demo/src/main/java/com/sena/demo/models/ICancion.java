package com.sena.demo.models;

import java.util.List;

public interface ICancion {
    public List<Cancion> findAll();
    public void save (Cancion cancion);
    public Cancion findOne(Integer Id_Cancion);
    public void delete(Integer Id_Cancion);
}
