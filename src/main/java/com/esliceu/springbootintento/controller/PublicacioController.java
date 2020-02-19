package com.esliceu.springbootintento.controller;

import com.esliceu.springbootintento.manager.PublicacioManager;
import com.esliceu.springbootintento.manager.UserManager;
import com.esliceu.springbootintento.model.Publicacio;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
@RestController
public class PublicacioController {
    @Autowired
    Gson gson;

    @Autowired
    UserManager userManager;

    @Autowired
    PublicacioManager publicacioManager;

    @GetMapping("/cerca")
    public List<Publicacio> findByTitleOrContent(String cerca){
        String s = "hola";
        return this.publicacioManager.findAllByTitolOrContent(s);
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody String jsonLogin) throws UnsupportedEncodingException {
        JsonObject jsonObject = gson.fromJson(jsonLogin,JsonObject.class);

        String user = jsonObject.get("user").getAsString();
        String pwd = jsonObject.get("pwd").getAsString();

        if (userManager.validate(user,pwd)){
            System.out.println("usuari: "+user+"pwd: "+pwd);
            String token = Jwts.builder()
                    .claim("username","joan")
                    .setExpiration(new Date(System.currentTimeMillis()))
                    .signWith(SignatureAlgorithm.HS512, TextCodec.BASE64.encode("Aixo es el meu secret")).compact();
            return new ResponseEntity<>(token,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }


    }

}
