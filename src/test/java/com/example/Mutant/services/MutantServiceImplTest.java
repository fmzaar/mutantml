package com.example.Mutant.services;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Mutant.entities.Mutant;
import com.example.Mutant.repositories.MutantRepository;

@SpringBootTest
public class MutantServiceImplTest {
	
	@MockBean
	private MutantRepository mutantRepository;
	@Autowired
	private MutantServiceImplementation mutantService;
	
	
	@Test
	void findMutantsService() throws Exception {
		
		Mutant mutant = new Mutant();
		String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACAG","GCGTCA","TCACTG"};
		mutant.setDna(dna);
	
		List<Mutant> mutantes = new ArrayList();
		mutantes.add(mutant);
		
		when(mutantRepository.findAll()).thenReturn(mutantes);
		
		assertEquals(mutantes,mutantService.findAll());
		
		
		
	}
	

}
