package com.example.Mutant.Integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Mutant.MutantApplication;
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
	
	void testFindMutants() throws Exception{
		
		
		
		
		
	}
	
	
	

}
