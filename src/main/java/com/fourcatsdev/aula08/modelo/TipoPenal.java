package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TipoPenal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String tipoPenal;

    //@OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.REMOVE})   //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY)   //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Crime crime;


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

    public String getTipoPenal() {
        return tipoPenal;
    }

    public void setTipoPenal(String tipoPenal) {
        this.tipoPenal = tipoPenal;
    }

   public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoPenal)) return false;
        TipoPenal tipoPenal = (TipoPenal) o;
        return Objects.equals(id, tipoPenal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public TipoPenal() {

    }


}
