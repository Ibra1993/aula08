package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class AndamentoOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String estado;

    @OneToMany(mappedBy = "andamentoOcorrencia",cascade = CascadeType.ALL)
    private List<Crime> crimes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    public AndamentoOcorrencia() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AndamentoOcorrencia)) return false;
        AndamentoOcorrencia that = (AndamentoOcorrencia) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
