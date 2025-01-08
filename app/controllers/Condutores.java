package controllers;

import models.Condutor;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Condutores extends Controller{
	
	
	public static void formulario() {
		render();
	}
    public static void salvar(@Valid Condutor condutorObj) {
		if(validation.hasErrors()){
			validation.keep();
			formulario();
		}


    	condutorObj.save();
		Logins.form();
	}

}
