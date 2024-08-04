package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class TipoDeCrime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String tipoDeCrime;
    private String descricao;

    @OneToMany(mappedBy = "tipoDeCrime",cascade = CascadeType.ALL)
    private List<Crime> crime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeCrime() {
        return tipoDeCrime;
    }

    public void setTipoDeCrime(String tipoDeCrime) {
        this.tipoDeCrime = tipoDeCrime;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Crime> getCrime() {
        return crime;
    }

    public void setCrime(List<Crime> crime) {
        this.crime = crime;
    }

    public TipoDeCrime() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDeCrime)) return false;
        TipoDeCrime that = (TipoDeCrime) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
