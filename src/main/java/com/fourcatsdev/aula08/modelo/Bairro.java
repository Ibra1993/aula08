package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
public class Bairro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do bairro deve ser informado")
    private String nomeDoBairro;
    /*private String rua;
    @Column(columnDefinition = "TEXT")
    private String complemento;   */

    @OneToMany(mappedBy = "bairro",cascade = CascadeType.ALL)
    private List<Cidade> cidade;

    @OneToMany(mappedBy = "bairro", cascade = CascadeType.ALL)
    private List<Crime> crime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoBairro() {
        return nomeDoBairro;
    }

    public void setNomeDoBairro(String nomeDoBairro) {
        this.nomeDoBairro = nomeDoBairro;
    }

/*
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
*/

    public List<Crime> getCrime() {
        return crime;
    }

    public void setCrime(List<Crime> crime) {
        this.crime = crime;
    }

    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }

    public Bairro() {

    }


}
