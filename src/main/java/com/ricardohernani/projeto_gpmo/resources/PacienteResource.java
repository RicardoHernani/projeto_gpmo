package com.ricardohernani.projeto_gpmo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardohernani.projeto_gpmo.domain.Paciente;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Paciente> listar() {
		
		Paciente pcte1 = new Paciente(1, 12345678);
		Paciente pcte2 = new Paciente(2, 11001100);
		
		List<Paciente> lista = new ArrayList<>();
		lista.add(pcte1);
		lista.add(pcte2);
		
		return lista;
	}

}
