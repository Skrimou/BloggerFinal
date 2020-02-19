package com.esliceu.springbootintento.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usuari")
public class Usuari {
    @Id
    @Column(name="idusuari")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="email", nullable = false,unique = true)
    private String email;
    @Column(name="contrasenya", nullable = false)
    private String contrasenya;
    @Column(name="nom", nullable = false)
    private String nom;
    @Column(name="cognom", nullable = false)
    private String cognom;
    @Column(name="rol", nullable = false)
    private String rol;

    @OneToMany(mappedBy = "usuari")
    private Set<Publicacio> publicacions;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Set<Publicacio> getPublicacions() {
        return publicacions;
    }

    public void setPublicacions(Set<Publicacio> publicacions) {
        this.publicacions = publicacions;
    }

    public Usuari() {
    }

    @Override
    public String toString() {
        return "Usuari{" +
                "idusuari=" + id +
                ", contrasenya='" + contrasenya + '\'' +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                '}';
    }
}
