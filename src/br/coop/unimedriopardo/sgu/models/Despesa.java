package br.coop.unimedriopardo.sgu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "unrp_sgu_despesa")
public class Despesa {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQ_SGU_DESPESA")
    @SequenceGenerator(sequenceName = "SEQ_SGU_DESPESA", allocationSize = 1, name = "PK_SEQ_SGU_DESPESA")
	private Integer id;

	@Column(name="data_lanc")
	private String dataLanc;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="nr_conta")
	private String nrConta;
	
	@Column(name="classificacao")
	private String classificacao;
	
	@Column(name="valor")
	private String valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataLanc() {
		return dataLanc;
	}

	public void setDataLanc(String dataLanc) {
		this.dataLanc = dataLanc;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNrConta() {
		return nrConta;
	}

	public void setNrConta(String nrConta) {
		this.nrConta = nrConta;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
