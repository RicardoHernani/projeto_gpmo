package com.ricardohernani.projeto_gpmo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.ricardohernani.projeto_gpmo.domain.Procedimento;
import com.ricardohernani.projeto_gpmo.dto.ProcedimentoDTO;
import com.ricardohernani.projeto_gpmo.services.ProcedimentoService;

@RestController
@RequestMapping(value="/procedimentos")
public class ProcedimentoResource {
	
	@Autowired
	private ProcedimentoService service;	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Procedimento> find(@PathVariable Integer id) {
		Procedimento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Acrescentar um procedimento
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert( @RequestBody ProcedimentoDTO objDto) {
			Procedimento obj = service.fromDTO(objDto);
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		//Atualizar um procedimento
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> uptade (@RequestBody ProcedimentoDTO objDto, @PathVariable Integer id){
			Procedimento obj = service.fromDTO(objDto);
			obj.setId(id);
			obj =  service.update(obj);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		
		//Listando todos os procedimentos e implementação com DTO
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<ProcedimentoDTO>> findAll() {
			List<Procedimento> list = service.findAll();
			List<ProcedimentoDTO> listDto = list.stream().map(obj -> new ProcedimentoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}
		
		//Implementação da paginação o defaultValue="id" 
		@RequestMapping(value="/page", method=RequestMethod.GET)
		public ResponseEntity<Page<ProcedimentoDTO>> findPage(
				@RequestParam(value="page", defaultValue="0") Integer page,
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
				@RequestParam(value="orderBy", defaultValue="id") String orderBy,
				@RequestParam(value="direction", defaultValue="ASC") String direction) {
			Page<Procedimento> list = service.findPage(page, linesPerPage,orderBy, direction);
			Page<ProcedimentoDTO> listDto = list.map(obj -> new ProcedimentoDTO(obj));
			return ResponseEntity.ok().body(listDto);
		}

}
