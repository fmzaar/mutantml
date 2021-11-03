package com.example.Mutant.Integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Mutant.MutantApplication;
import com.example.Mutant.entities.Mutant;
import com.example.Mutant.repositories.MutantRepository;




@SpringBootTest(classes= MutantApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations="classpath:application-test.properties")
public class MutantControllerIntegration {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MutantRepository mutantRepository;

	@Test
	void testFindMutants() throws Exception{

		Mutant mutant = new Mutant();

		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCCA","TCACTG"};
		mutant.setDna(dna);
		Long id = (long) 1;
		mutant.setId(id);
		//String json = "["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCCA","TCACTG"]";

		mutantRepository.save(mutant);

		mockMvc.perform(get("/api/v1/mutants")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("[0].id",is(id.intValue())));
		//.andExpect(jsonPath("[0].dna",is(json)));


	}


}