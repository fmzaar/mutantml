package com.example.Mutant.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Mutant.entities.Mutant;
import com.example.Mutant.services.MutantServiceImplementation;


@SpringBootTest
public class MutantRepositoryTest {
	
	
	@Autowired
	 MutantRepository mutantRepository;
	
	@Autowired
	private EntityManager em;
	
	@Test
	void testFindMutants() {
		
		try {

			Mutant mutant = new Mutant();
			String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCCA","TCACTG"};
			mutant.setDna(dna);
		
			List<Mutant> mutantes = new ArrayList();
			mutantes.add(mutant);
		
			em.persist(mutant);
			em.flush();
				
			assertEquals(mutantes,mutantRepository.findAll());
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
		
	}
	
	
}
	
