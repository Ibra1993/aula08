package com.fourcatsdev.aula08.modelo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Vitima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Insira o nome da vítima")
    @NotNull
    private String nome;
    private String mae;
    private String pai;


    @NotBlank(message = "Insira o endereço vítima")
    @NotNull
    private String residencia;
    @NotBlank(message = "Insira o endereço da vítima")
    @NotNull
    private String endereco;
    private Date nascimento;

    private String telefone;
    private String relatorDoCrime;
    @NotNull(message = "Insira o tipo de documento da vítima")
    private String tipoDeDocumento;
    private String nacionalidade;

    @NotBlank(message = "Insira o número do documento da vítima")
    @NotNull
    private String numeroDoDocumento;
    private Date dataDaExpedicaoDocumento;
    private String zap;
    @Email
    private String email;

    @ManyToOne
    private Profissao profissao;

    @ManyToOne
    private Naturalidade naturalidade;

    @ManyToOne
    private Genero genero;

    @ManyToOne
    private EstadoCivil estadoCivil;


    @OneToOne(fetch = FetchType.LAZY)
    private Crime crime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }



    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRelatorDoCrime() {
        return relatorDoCrime;
    }

    public void setRelatorDoCrime(String relatorDoCrime) {
        this.relatorDoCrime = relatorDoCrime;
    }

    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNumeroDoDocumento() {
        return numeroDoDocumento;
    }

    public void setNumeroDoDocumento(String numeroDoDocumento) {
        this.numeroDoDocumento = numeroDoDocumento;
    }

    public Date getDataDaExpedicaoDocumento() {
        return dataDaExpedicaoDocumento;
    }

    public void setDataDaExpedicaoDocumento(Date dataDaExpedicaoDocumento) {
        this.dataDaExpedicaoDocumento = dataDaExpedicaoDocumento;
    }

    public String getZap() {
        return zap;
    }

    public void setZap(String zap) {
        this.zap = zap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }


    public Naturalidade getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Naturalidade naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Vitima() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vitima)) return false;
        Vitima vitima = (Vitima) o;
        return Objects.equals(id, vitima.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
