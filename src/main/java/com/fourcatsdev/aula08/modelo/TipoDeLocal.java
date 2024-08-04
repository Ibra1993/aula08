package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class TipoDeLocal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String tipoDeLocal;

    @OneToMany(mappedBy = "tipoDeLocal", cascade = CascadeType.ALL)
    private List<Crime> crime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeLocal() {
        return tipoDeLocal;
    }

    public void setTipoDeLocal(String tipoDeLocal) {
        this.tipoDeLocal = tipoDeLocal;
    }

    public List<Crime> getCrime() {
        return crime;
    }

    public void setCrime(List<Crime> crime) {
        this.crime = crime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDeLocal)) return false;
        TipoDeLocal that = (TipoDeLocal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
