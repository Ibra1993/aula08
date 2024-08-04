package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import java.util.List;

@Entity

public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String matrimonio;

    @OneToMany(mappedBy = "estadoCivil", cascade = CascadeType.ALL)
    private List<Vitima> vitima;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatrimonio() {
        return matrimonio;
    }

    public void setMatrimonio(String matrimonio) {
        this.matrimonio = matrimonio;
    }

    public List<Vitima> getVitima() {
        return vitima;
    }

    public void setVitima(List<Vitima> vitima) {
        this.vitima = vitima;
    }



}
