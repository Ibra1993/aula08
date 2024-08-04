package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String genero;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Crime> crime;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Vitima> vitima;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeneroDoAcusado() {
        return genero;
    }

    public void setGeneroDoAcusado(String generoDoAcusado) {
        this.genero = genero;
    }

    public List<Crime> getCrime() {
        return crime;
    }

    public void setCrime(List<Crime> crime) {
        this.crime = crime;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Vitima> getVitima() {
        return vitima;
    }

    public void setVitima(List<Vitima> vitima) {
        this.vitima = vitima;
    }


}
