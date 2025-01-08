package controllers;

import models.Condutor;
import models.Fiscalizador;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Fiscalizadores extends Controller{

	
	public static void formulario() {
		render();
	}
	public static void salvar(@Valid Fiscalizador fiscalizadorObj) {

		if(validation.hasErrors()){
			validation.keep();
			formulario();
		}

    	fiscalizadorObj.save();
    	Logins.form();
    	
    
	}
	

}

