package com.ricardohernani.projeto_gpmo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardohernani.projeto_gpmo.domain.Paciente;
import com.ricardohernani.projeto_gpmo.repositories.PacienteRepository;

@SpringBootApplication
public class ProjetoGpmoApplication implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoGpmoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Paciente pcte1 = new Paciente(null, 12345678);
		Paciente pcte2 = new Paciente(null, 11223344);
		
		pacienteRepository.saveAll(Arrays.asList(pcte1, pcte2));
		
	}
	
	
}
