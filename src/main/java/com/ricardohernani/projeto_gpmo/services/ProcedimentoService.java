package com.ricardohernani.projeto_gpmo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.domain.Procedimento;
import com.ricardohernani.projeto_gpmo.dto.ProcedimentoDTO;
import com.ricardohernani.projeto_gpmo.repositories.ProcedimentoRepository;
import com.ricardohernani.projeto_gpmo.services.exceptions.ObjectNotFoundException;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository repo;
	
	public Procedimento find(Integer id) {
		Optional<Procedimento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Procedimento.class.getName()));
	}
	
	
	public Procedimento insert(Procedimento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Procedimento update(Procedimento obj) {
		Procedimento newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Procedimento> findAll() {
		return repo.findAll();
	}
	
	public Page<Procedimento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Procedimento fromDTO(ProcedimentoDTO objDto) {
		return new Procedimento(objDto.getId(), objDto.getTipo(), objDto.getPremio(), objDto.getPacientes(), objDto.getReferencias());
	}
	
	private void updateData(Procedimento newObj, Procedimento obj) {
		newObj.setTipo(obj.getTipo());
		newObj.setPremio(obj.getPremio());
		
	}
}
