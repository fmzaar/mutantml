package com.example.Mutant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Mutant.entities.Mutant;

public interface MutantRepository extends BaseRepository<Mutant,Long>  {
	

	
}
