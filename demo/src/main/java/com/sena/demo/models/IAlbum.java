package com.sena.demo.models;

import org.springframework.data.repository.CrudRepository;
public interface IAlbum extends CrudRepository<Album,Integer> {
    
}