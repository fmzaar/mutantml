package com.example.Mutant.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Mutant.entities.Human;
import com.example.Mutant.entities.Mutant;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;



@SpringBootTest

public class HumanRepositoryTest {
	
	
	@Autowired
	 HumanRepository humanRepository;
	
	@Autowired
	private EntityManager em;
	
	@Test	
	void testFindHumans() {
		
		try {

			Human human = new Human();
			
			String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACAG","GCGTCA","TCACTG"};
			human.setId(null);
			human.setDnaH(dna);
		
			List<Human> humans = new ArrayList();
			humans.add(human);
			
			//System.out.println(humans.get(0).getDnaH()[0]);
			
			em.merge(human);
			em.flush();
				
			assertEquals(humans,humanRepository.findAll());
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
		
	}
	
	
	

}
