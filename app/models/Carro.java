package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Carro extends Model {
	
	@Required
	public String nomeCarro;
	@Required 
	public String placaCarro;
	@Required 
	public String anoCarro;
	
}
