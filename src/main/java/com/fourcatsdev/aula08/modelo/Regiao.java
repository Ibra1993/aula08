package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da região deve ser informado")
    private String nomeDaRegiao;



    @OneToMany(mappedBy = "regiao",cascade = CascadeType.ALL)
    private List<Cidade> cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaRegiao() {
        return nomeDaRegiao;
    }

    public void setNomeDaRegiao(String nomeDaRegiao) {
        this.nomeDaRegiao = nomeDaRegiao;
    }


    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }

    public Regiao() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Regiao)) return false;
        Regiao regiao = (Regiao) o;
        return Objects.equals(id, regiao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
