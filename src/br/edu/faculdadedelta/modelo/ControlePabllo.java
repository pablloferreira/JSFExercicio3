package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class ControlePabllo {

	private Long id;
	private String descricao;
	private Date dateInicio;
	private Date dateFinal;
	private String paciente;
	private int qtExames;
	private Double valorProced;
	
	public ControlePabllo() {
		
	}

	public ControlePabllo(Long id, String descricao, Date dateInicio, Date dateFinal, String paciente, int qtExames,
			Double valorProced) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dateInicio = dateInicio;
		this.dateFinal = dateFinal;
		this.paciente = paciente;
		this.qtExames = qtExames;
		this.valorProced = valorProced;
	}

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

	public Date getDateInicio() {
		return dateInicio;
	}

	public void setDateInicio(Date dateInicio) {
		this.dateInicio = dateInicio;
	}

	public Date getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(Date dateFinal) {
		this.dateFinal = dateFinal;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public int getQtExames() {
		return qtExames;
	}

	public void setQtExames(int qtExames) {
		this.qtExames = qtExames;
	}

	public Double getValorProced() {
		return valorProced;
	}

	public void setValorProced(Double valorProced) {
		this.valorProced = valorProced;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControlePabllo other = (ControlePabllo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
