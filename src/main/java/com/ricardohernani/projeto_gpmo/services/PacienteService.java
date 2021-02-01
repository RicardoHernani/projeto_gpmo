package com.ricardohernani.projeto_gpmo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.dto.PacienteDTO;
import com.ricardohernani.projeto_gpmo.repositories.PacienteRepository;
import com.ricardohernani.projeto_gpmo.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}
	
	public Paciente insert(Paciente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Paciente update(Paciente obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Paciente> findAll() {
		return repo.findAll();
	}
	
	public Page<Paciente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Paciente fromDTO(PacienteDTO objDto) {
		return new Paciente(objDto.getId(), objDto.getRegistro(), objDto.getData());
	}
		
}
