package edu.bj.avaliacao.model;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table (name="NOTA")
public class Nota extends AbstractModel<Long>{

	@Column (name = "nota1")
	private Double nota1;
	
	@Column (name = "nota2")
	private Double nota2;
	
	@Column (name = "nota3")
	private Double nota3;

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getNota3() {
		return nota3;
	}

	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}
	
	
}
