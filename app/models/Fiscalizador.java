package models;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Fiscalizador extends Model{
		@Required
		public String nomeFiscalizador;
		@Email
		public String emailFiscalizador;
		@Required
		public String login;
		@Required
		public String senha;
		@Required 
		public String contatoFiscalizador;
		public Boolean sim;

		



}


