package com.ricardohernani.projeto_gpmo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.domain.Procedimento;
import com.ricardohernani.projeto_gpmo.domain.enums.PremioProcedimento;
import com.ricardohernani.projeto_gpmo.domain.enums.TipoProcedimento;
import com.ricardohernani.projeto_gpmo.repositories.PacienteRepository;
import com.ricardohernani.projeto_gpmo.repositories.ProcedimentoRepository;
import com.ricardohernani.projeto_gpmo.repositories.ReferenciaRepository;



@SpringBootApplication
public class ProjetoGpmoApplication implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	@Autowired
	private ReferenciaRepository referenciaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoGpmoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		Paciente pcte1 = new Paciente(null, 32144881);
		Paciente pcte2 = new Paciente(null, 12345678);
		
		Procedimento proc1 = new Procedimento(null, new java.sql.Date(sdf.parse("29/12/2020").getTime()), TipoProcedimento.PRINCIPAL, PremioProcedimento.DINHEIRO, pcte1);
		Procedimento proc2 = new Procedimento(null, new java.sql.Date(sdf.parse("29/12/2020").getTime()), TipoProcedimento.SECUNDARIO, PremioProcedimento.DINHEIRO, pcte1);
		Procedimento proc3 = new Procedimento(null, new java.sql.Date(sdf.parse("29/12/2020").getTime()), TipoProcedimento.PRINCIPAL, PremioProcedimento.DINHEIRO, pcte1);
		Procedimento proc4 = new Procedimento(null, new java.sql.Date(sdf.parse("23/01/2021").getTime()), TipoProcedimento.PRINCIPAL, PremioProcedimento.TAREFA_BASICA, pcte2);
		
		pcte1.getProcedimentos().addAll(Arrays.asList(proc1, proc2, proc3));
		pcte2.getProcedimentos().addAll(Arrays.asList(proc4));
		
		pacienteRepository.saveAll(Arrays.asList(pcte1, pcte2));
		procedimentoRepository.saveAll(Arrays.asList(proc1,proc2,proc3,proc4));
		
		
	}
	
	
}
