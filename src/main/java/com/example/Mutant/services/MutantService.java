package com.example.Mutant.services;

import com.example.Mutant.entities.Human;
import com.example.Mutant.entities.Mutant;

public interface MutantService extends BaseService<Mutant,Long> {
	
	public boolean isMutant(String[] dna) throws Exception;
	
	
}


