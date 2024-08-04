package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
public class Delegacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha o campo delegacia")
    private String nomeDaDelegacia;
    private String nomeDoDelegado;
    private String endereco;
    private String contato;

    @OneToMany(mappedBy = "delegacia", cascade = CascadeType.ALL)
    private List<Crime> crimes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaDelegacia() {
        return nomeDaDelegacia;
    }

    public void setNomeDaDelegacia(String nomeDaDelegacia) {
        this.nomeDaDelegacia = nomeDaDelegacia;
    }

    public String getNomeDoDelegado() {
        return nomeDoDelegado;
    }

    public void setNomeDoDelegado(String nomeDoDelegado) {
        this.nomeDoDelegado = nomeDoDelegado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    public Delegacia() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delegacia)) return false;
        Delegacia delegacia = (Delegacia) o;
        return Objects.equals(id, delegacia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
