package com.fourcatsdev.aula08.modelo;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;


@Entity
public class Crime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data;


	@NotNull
	@Column(columnDefinition = "TEXT")
	private String descricaoDoCrime;

	//private String generoDoAcusado;

	@NotNull
	private String crimeComposto;

	@NotNull
	@Column(columnDefinition = "TEXT")
	private String localDoCrime;

	@NotNull
	@Column(columnDefinition = "TEXT")
	private String pontoDeReferencia;




	//@OneToOne(fetch = FetchType.LAZY, mappedBy = "crime",cascade = CascadeType.ALL) // Será gerado a chave estrangeira lá na tabela "crime"
    @OneToOne(mappedBy = "crime",cascade = CascadeType.ALL) // Será gerado a chave estrangeira lá na tabela "crime"
    private TipoPenal tipoPenal;



	@OneToOne( mappedBy = "crime",cascade = CascadeType.ALL) //, fetch = FetchType.LAZY, orphanRemoval=true
	private Vitima vitima;


	@ManyToOne
	private Bairro bairro;

	@ManyToOne
	private Delegacia delegacia;

	@ManyToOne
	private AndamentoOcorrencia andamentoOcorrencia;


	@ManyToOne
	private TipoDeCrime tipoDeCrime;

	@ManyToOne
	private Genero genero;

	@ManyToOne
	private TipoDeLocal tipoDeLocal;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public String getDescricaoDoCrime() {
		return descricaoDoCrime;
	}

	public void setDescricaoDoCrime(String descricaoDoCrime) {
		this.descricaoDoCrime = descricaoDoCrime;
	}


	public String getCrimeComposto() {
		return crimeComposto;
	}

	public void setCrimeComposto(String crimeComposto) {
		this.crimeComposto = crimeComposto;
	}

	public String getLocalDoCrime() {
		return localDoCrime;
	}

	public void setLocalDoCrime(String localDoCrime) {
		this.localDoCrime = localDoCrime;
	}

	public String getPontoDeReferencia() {
		return pontoDeReferencia;
	}

	public void setPontoDeReferencia(String pontoDeReferencia) {
		this.pontoDeReferencia = pontoDeReferencia;
	}


	public TipoDeCrime getTipoDeCrime() {
		return tipoDeCrime;
	}

	public void setTipoDeCrime(TipoDeCrime tipoDeCrime) {
		this.tipoDeCrime = tipoDeCrime;
	}

	public TipoPenal getTipoPenal() {
		return tipoPenal;
	}

	public void setTipoPenal(TipoPenal tipoPenal) {
		this.tipoPenal = tipoPenal;
	}



	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Delegacia getDelegacia() {
		return delegacia;
	}

	public void setDelegacia(Delegacia delegacia) {
		this.delegacia = delegacia;
	}

	public AndamentoOcorrencia getAndamentoOcorrencia() {
		return andamentoOcorrencia;
	}

	public void setAndamentoOcorrencia(AndamentoOcorrencia andamentoOcorrencia) {
		this.andamentoOcorrencia = andamentoOcorrencia;
	}

	public Vitima getVitima() {
		return vitima;
	}

	public void setVitima(Vitima vitima) {
		this.vitima = vitima;
	}


	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public TipoDeLocal getTipoDeLocal() {
		return tipoDeLocal;
	}

	public void setTipoDeLocal(TipoDeLocal tipoDeLocal) {
		this.tipoDeLocal = tipoDeLocal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Crime)) return false;
		Crime crime = (Crime) o;
		return Objects.equals(id, crime.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Crime() {

	}
}
