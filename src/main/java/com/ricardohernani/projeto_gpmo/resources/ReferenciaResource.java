package com.ricardohernani.projeto_gpmo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardohernani.projeto_gpmo.domain.Referencia;

@RestController
@RequestMapping(value="/referencias")
public class ReferenciaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Referencia> listar() {
		
		Referencia ref1 = new Referencia(31102360, "ureterorrenolitotripsia Flexível", 41.67, 297.81);
		Referencia ref2 = new Referencia(31102077, "colocação de duplo J", 20.00, 112.56);
		
		List<Referencia> lista = new ArrayList<>();
		lista.add(ref1);
		lista.add(ref2);
		
		return lista;
	}

}
