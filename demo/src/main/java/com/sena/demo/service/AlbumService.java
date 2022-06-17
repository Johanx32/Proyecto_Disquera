package com.sena.demo.service;

import java.util.List;

import com.sena.demo.models.Album;
import com.sena.demo.models.IAlbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlbumService implements IAlbumService{

    @Autowired
    private IAlbum albumd;

    @Override
        public List<Album> findAll() {
        return (List<Album>) albumd.findAll();
    }

    @Override
    public Album findOne(Integer Id_Album) {
        return albumd.findById(Id_Album).orElse(null);
    }

    public void save(Album album) {
        albumd.save(album);
    }

    @Override
    public void delete(Integer Id_Album) {
        albumd.deleteById(Id_Album);
    }
 
}