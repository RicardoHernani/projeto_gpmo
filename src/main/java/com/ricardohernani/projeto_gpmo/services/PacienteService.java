package com.ricardohernani.projeto_gpmo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.domain.Procedimento;
import com.ricardohernani.projeto_gpmo.domain.Referencia;
import com.ricardohernani.projeto_gpmo.domain.enums.PremioProcedimento;
import com.ricardohernani.projeto_gpmo.domain.enums.TipoProcedimento;
import com.ricardohernani.projeto_gpmo.dto.PacienteDTO;
import com.ricardohernani.projeto_gpmo.dto.PacienteNewDTO;
import com.ricardohernani.projeto_gpmo.repositories.PacienteRepository;
import com.ricardohernani.projeto_gpmo.repositories.ProcedimentoRepository;
import com.ricardohernani.projeto_gpmo.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}
	
	@Transactional
	public Paciente insert(Paciente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		procedimentoRepository.saveAll(obj.getProcedimentos());  //Coloquei saveAll ao invés de save
		return obj;
	}
	
	public Paciente update(Paciente obj) {
		Paciente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
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
	
	public Paciente fromDTO(PacienteNewDTO objDto) {
		Paciente pc = new Paciente(null, objDto.getRegistro(), objDto.getData());
		Referencia re = new Referencia(objDto.getCodigo(), null, null, null);
		Procedimento pro = new Procedimento(null, TipoProcedimento.toEnum(objDto.getTipo()), PremioProcedimento.toEnum(objDto.getPremio()), pc, re); 
		
		pc.getProcedimentos().add(pro);
		return pc;
	}
	
	private void updateData(Paciente newObj, Paciente obj) {
		newObj.setRegistro(obj.getRegistro());
		newObj.setData(obj.getData());
		
	}
		
}
