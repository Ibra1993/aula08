package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity

public class Naturalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String naturalidade;


    @OneToMany(mappedBy = "naturalidade",cascade = CascadeType.ALL)
    private List<Vitima> vitima;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Naturalidade)) return false;
        Naturalidade that = (Naturalidade) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public List<Vitima> getVitima() {
        return vitima;
    }

    public void setVitima(List<Vitima> vitima) {
        this.vitima = vitima;
    }
}
