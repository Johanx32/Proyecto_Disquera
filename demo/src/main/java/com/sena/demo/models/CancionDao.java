package com.sena.demo.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CancionDao implements ICancion{
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Cancion> findAll() {
        return em.createQuery("from Cancion").getResultList();
    }
    
    //Sobreescritura de metodos
    @Override
        @Transactional(readOnly = true)
            public Cancion findOne(Integer Id_Cancion) {
                return em.find(Cancion.class, Id_Cancion);
            }
 
    
    @Transactional
    @Override
    public void save(Cancion cancion) {
        if (cancion.getId_Cancion() != null && cancion.getId_Cancion() > 0) {
                em.merge(cancion);
                } else {
                    em.persist(cancion);
                }
            }

    @Override
    @Transactional
        public void delete(Integer Id_Cancion) {
            em.remove(findOne(Id_Cancion));
        }
}
