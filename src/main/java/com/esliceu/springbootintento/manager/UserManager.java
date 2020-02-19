package com.esliceu.springbootintento.manager;

import com.esliceu.springbootintento.model.Usuari;
import com.esliceu.springbootintento.repository.UsuariRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    @Autowired
    UsuariRepository usuariRepository;

    public boolean validate(String usuari,String password){
        return usuariRepository.findByEmailAndContrasenya(usuari,password)!=null;
    }

    public Usuari jsonToUser(String json){
        JsonObject jsonObject = gson.fromJson(jsonLogin,JsonObject.class);

        String user = jsonObject.get("user").getAsString();
        String pwd = jsonObject.get("pwd").getAsString();
        return
    }
}
