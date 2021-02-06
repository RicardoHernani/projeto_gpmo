package com.ricardohernani.projeto_gpmo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.dto.PacienteDTO;
import com.ricardohernani.projeto_gpmo.dto.PacienteNewDTO;
import com.ricardohernani.projeto_gpmo.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService service;	
	
	//Lista um paciente
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Paciente> find(@PathVariable Integer id) {
		Paciente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Acrescentar um paciente
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PacienteNewDTO objDto) {
		Paciente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Atualizar um paciente
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> uptade (@Valid @RequestBody PacienteDTO objDto, @PathVariable Integer id){
		Paciente obj = service.fromDTO(objDto);
		obj.setId(id);
		obj =  service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	//Listando todos os pacientes e implementação com DTO
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<Paciente> list = service.findAll();
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	//Implementação da paginação o defaultValue="id" poderia ser por registro, data...
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PacienteDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="id") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Paciente> list = service.findPage(page, linesPerPage,orderBy, direction);
		Page<PacienteDTO> listDto = list.map(obj -> new PacienteDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
}
