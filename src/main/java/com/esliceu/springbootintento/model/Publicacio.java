package com.esliceu.springbootintento.model;

import javax.persistence.*;

@Entity
@Table(name="publicacio")
public class Publicacio {
    @Id
    @Column(name="idpublicacio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpublicacio;

    @Column(name="titol", nullable = false)
    private String titol;

    @Column(name="contingut", nullable = false)
    private String contingut;

    @Column(name="obsercacions", nullable = false)
    private String observacions;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="usuari_idusuari"), name = "usuari_idusuari",nullable = false)
    private Usuari usuari;

    public int getIdpublicacio() {
        return idpublicacio;
    }

    public void setIdpublicacio(int idpublicacio) {
        this.idpublicacio = idpublicacio;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getContingut() {
        return contingut;
    }

    public void setContingut(String contingut) {
        this.contingut = contingut;
    }

    public String getObservacions() {
        return observacions;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
}
