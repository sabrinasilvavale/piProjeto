package controllers;

import java.util.Collections;

import java.util.Date;
import java.util.List;

import models.Carro;
import models.Checklist;
import models.Condutor;
import models.ExcluidoStatus;
import models.Fiscalizador; 
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Checklists extends Controller {

	public static void form() {

		List<Carro> carros = Carro.findAll();
		render(carros);

	}

	public static void formulario() {
		List<Carro> carros = Carro.findAll();

		List<Fiscalizador> fiscalizadores = Fiscalizador.findAll();

		List<Condutor> condutores = Condutor.findAll();
		render(carros, condutores, fiscalizadores);
	}

	public static void salvar( @Valid Checklist checklistObj) {
		
		if(validation.hasErrors()){
			validation.keep();
			flash.error("Falha ao salvar o produto");
			Cache.set("checklistObj",checklistObj);
			formulario();
		}


		checklistObj.save();
		checklistObj.exclusaoLogica = ExcluidoStatus.ATIVADO;
		checklistObj.dataChecklist = new Date();
		listagem(null);

	}

	public static void listagem(String termo) {
		List<Checklist> checkListObj = Collections.EMPTY_LIST;
		if (termo == null) {
			checkListObj = Checklist.find("exclusaoLogica = ?1", ExcluidoStatus.ATIVADO).fetch();
		} else {
			checkListObj = Checklist.find("lower(fiscalizadores.nomeFiscalizador) like ?1 AND exclusaoLogica = ?2",
					"%" + termo.toLowerCase() + "%", ExcluidoStatus.ATIVADO).fetch();
		}
		render(checkListObj, termo);

	}

	public static void remover(Long id) {
		Checklist checklistRemoveObj = Checklist.findById(id);
		checklistRemoveObj.exclusaoLogica = ExcluidoStatus.DESATIVADO;
		checklistRemoveObj.save();
		listagem(null);
	}

	public static void editar(Long id) {
		Checklist checklistEditarObj = Checklist.findById(id);
		List<Carro> carros = Carro.findAll();
		List<Fiscalizador> fiscalizadores = Fiscalizador.findAll();
		List<Condutor> condutores = Condutor.findAll();
		renderTemplate("Checklists/formulario.html", checklistEditarObj, carros, fiscalizadores, condutores);

	}

}
