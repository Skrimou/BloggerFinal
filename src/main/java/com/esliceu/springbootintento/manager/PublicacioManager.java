package com.esliceu.springbootintento.manager;

import com.esliceu.springbootintento.model.Publicacio;
import com.esliceu.springbootintento.model.Usuari;
import com.esliceu.springbootintento.repository.PublicacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacioManager {

    @Autowired
    PublicacioRepository publicacioRepository;

    public void add(Publicacio publicacio){
        publicacioRepository.save(publicacio);
    }

    public List<Publicacio> findAllByTitolOrContent(String s){

        return this.publicacioRepository.findAllByTitolContainsOrContingutContains(s,s);
    }
    public Usuari findUsuari(Publicacio publicacio){
        return null;
    }
}
