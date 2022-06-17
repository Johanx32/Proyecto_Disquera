package com.sena.demo.service;

import java.util.List;
import com.sena.demo.models.Album;


public interface IAlbumService {
    public List<Album> findAll();
    public void save (Album album);
    public Album findOne(Integer Id_Album);
    public void delete(Integer Id_Album);
}
