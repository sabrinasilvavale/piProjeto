package controllers;

import models.Fiscalizador;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

public class Logins extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void logar(String username, String senha) {
	//	String fiscalizadorLogado = Fiscalizador.autenticar(username, senha);
		Fiscalizador f = Fiscalizador.find("login = ?1 and senha = ?2", username, senha).first();
		if (f == null) {
			//USUARIO NAO ENCONTRADO NO BANCO
			flash.error("Credenciais inválidas");
			form();
		} else {
			//SOMENTE USUARIO QUE FORAM ENCONTRADOS NO BANCO
			session.put("fiscalizadorLogado", f);
			session.put("fiscalizador.nome", f.nomeFiscalizador);
			session.put("fiscalizador.id", f.id);
		Checklists.formulario();
		}
	}
	
	public static void sair() {
		session.clear();
		flash.success("Você saiu do sistema");
		form();
	}

}