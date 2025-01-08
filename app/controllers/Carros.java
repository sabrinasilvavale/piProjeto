package controllers;

import models.Carro;
import models.Condutor;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Carros extends Controller{
	
	public static void formulario() {
		render();
	}
	public static void salvar(@Valid Carro carroObj) {
		if(validation.hasErrors()){
			validation.keep();
			formulario();
		}


    	carroObj.save();
    	Logins.form();
		
	}
}
