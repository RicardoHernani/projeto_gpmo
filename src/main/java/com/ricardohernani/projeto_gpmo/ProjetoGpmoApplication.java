package com.ricardohernani.projeto_gpmo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.domain.Procedimento;
import com.ricardohernani.projeto_gpmo.domain.Referencia;
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

		Referencia ref1 = new Referencia(31102360, "Ureterorrenolitotripsia flexível", 41.67, 297.83);
		Referencia ref2 = new Referencia(31102077, "Colocação de duplo J", 20.00, 112.56);
		Referencia ref3 = new Referencia(30908027, "Fístula arteriovenosa", 27.78, 195.07);
		Referencia ref4 = new Referencia(30202094, "Palatoplastia com enxerto ósseo", 33.33, 717.27);
		
		
		Paciente pcte1 = new Paciente(null, 32144881, new java.sql.Date(sdf.parse("29/12/2020").getTime()));
		Paciente pcte2 = new Paciente(null, 12345678, new java.sql.Date(sdf.parse("23/01/2021").getTime()));
		
		Procedimento proc1 = new Procedimento(null, TipoProcedimento.PRINCIPAL, PremioProcedimento.DINHEIRO, pcte1, ref1);
		Procedimento proc2 = new Procedimento(null, TipoProcedimento.SECUNDARIO, PremioProcedimento.DINHEIRO, pcte1, ref2);
		Procedimento proc3 = new Procedimento(null, TipoProcedimento.PRINCIPAL, PremioProcedimento.DINHEIRO, pcte1, ref2);
		Procedimento proc4 = new Procedimento(null, TipoProcedimento.PRINCIPAL, PremioProcedimento.TAREFA_BASICA, pcte2, ref3);
		
		pcte1.getProcedimentos().addAll(Arrays.asList(proc1, proc2, proc3));
		pcte2.getProcedimentos().addAll(Arrays.asList(proc4));
		
		
		referenciaRepository.saveAll(Arrays.asList(ref1, ref2, ref3, ref4));
		pacienteRepository.saveAll(Arrays.asList(pcte1, pcte2));
		procedimentoRepository.saveAll(Arrays.asList(proc1,proc2,proc3,proc4));
				
	}

}
