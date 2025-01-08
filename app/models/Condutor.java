package models;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Max;
import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;


@Entity
public class Condutor extends Model {

	@Required 
	public String nomeCondutor;
	@Email
	public String emailCondutor;
	@Required
	public String login;
	@Required 
	public String senha;
	@Required 
	public String contatoCondutor;
	
	public static String autenticar(String login, String senha) {
		Condutor c = Condutor.find("login = ?1 and senha = ?2", login, senha).first();
		if (c == null) {
			return null;
		} else {
			return c.login;
		}
	}
	}




