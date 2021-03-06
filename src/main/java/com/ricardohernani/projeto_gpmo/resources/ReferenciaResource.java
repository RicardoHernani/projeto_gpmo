package com.ricardohernani.projeto_gpmo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardohernani.projeto_gpmo.domain.Referencia;
import com.ricardohernani.projeto_gpmo.services.ReferenciaService;

@RestController
@RequestMapping(value="/referencias")
public class ReferenciaResource {
		
	@Autowired
	private ReferenciaService service;	
		
	
	//Lista uma referencia pelo código(id)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Referencia> find(@PathVariable Integer id) {
		Referencia obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
}