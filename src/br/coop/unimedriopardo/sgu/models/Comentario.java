package br.coop.unimedriopardo.sgu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "unrp_sgu_comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQ_SGU_COMENTARIO")
    @SequenceGenerator(sequenceName = "SEQ_SGU_COMENTARIO", allocationSize = 1, name = "PK_SEQ_SGU_COMENTARIO")
	private Integer id;

	@NotBlank
	@Column(name = "codigo",  nullable = false)
	private String codigo;

	@NotBlank
	@Column(name = "competencia", nullable = false)
	private String competencia;

	@NotBlank
	@Column(name = "comentario", length=500  ,nullable = false)
	private String comentario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
