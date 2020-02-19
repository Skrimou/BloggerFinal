package com.esliceu.springbootintento.repository;

import com.esliceu.springbootintento.model.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface UsuariRepository extends CrudRepository<Usuari,Integer> {
 Usuari findByEmailAndContrasenya(String usuari,String contrasenya);
}
