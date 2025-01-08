package models;

//Teste de comitagem

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Checklist extends Model{
	@Temporal(TemporalType.DATE)
	public Date dataChecklist;
	@Required 
	public String volante;
	@Required 
	public String setas;
	@Required 
	public String marcha;
	@Required
	public String embreagem;
	@Required
	public String freios;
	@Required
	public String acelerador;
	@Required 
	public String buzina;
	

	@Enumerated(EnumType.STRING)
	public TipoChecklist tipoChecklist;
	
	@ManyToOne
	public Carro carro;
	
	@ManyToOne
	public Fiscalizador fiscalizadores;
	
	@ManyToOne 
	public Condutor condutores;
	
	@Enumerated(EnumType.STRING)
	public ExcluidoStatus exclusaoLogica;

	public Checklist() {
		this.exclusaoLogica = ExcluidoStatus.ATIVADO;
	}



	
}
