package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Profissao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nomeDaProfissao;
    private String descricao;

    @OneToMany(mappedBy = "profissao",cascade = CascadeType.ALL)
    private List<Vitima> vitima;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaProfissao() {
        return nomeDaProfissao;
    }

    public void setNomeDaProfissao(String nomeDaProfissao) {
        this.nomeDaProfissao = nomeDaProfissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Vitima> getVitima() {
        return vitima;
    }

    public void setVitima(List<Vitima> vitima) {
        this.vitima = vitima;
    }

    public Profissao() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profissao)) return false;
        Profissao profissao = (Profissao) o;
        return Objects.equals(id, profissao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
