package br.edu.ifpb.pweb2.caderneta.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="TB_Estudante")
public class Estudante{
	
	@Id
	@Column(name="nu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nm_nome")
	private String nome;
	
	@Column(name="dt_nascimento")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataNasc;
	
	//login
	//private String email;
	
	@Column(name="nu_faltas")
	private Integer faltas;
	
	@Column(name="nu_nota1")
	private BigDecimal nota1;
	
	@Column(name="nu_nota2")
	private BigDecimal nota2;
	
	@Column(name="nu_nota3")
	private BigDecimal nota3;
	
	@Column(name="nu_notaFinal")
	private BigDecimal notaFinal;
	

	private SituacaoEnum situacao = SituacaoEnum.MT;
	
	
	public Estudante() {

	}

	public Estudante(Integer id, String nome,Date dataNasc ) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public BigDecimal getNota1() {
		return nota1;
	}

	public void setNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public void setNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public void setNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	public BigDecimal getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(BigDecimal notaFinal) {
		this.notaFinal = notaFinal;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", dataNasc=" + dataNasc + "]";
	}

		

}
