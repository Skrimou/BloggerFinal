package com.esliceu.springbootintento.repository;

import com.esliceu.springbootintento.model.Publicacio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicacioRepository extends CrudRepository<Publicacio,Integer> {

    /* Definir les consultes que surtin de l'estandar*/
    List<Publicacio> findAllByTitolContainsOrContingutContains(String s, String s2);

    //Alguna consulta especifica
    @Query(nativeQuery=true,value="valuefrom Publicacio where contingut=:contingut")
    Publicacio findAllByTitolOrContent(String contingut);
}
