package com.example.Mutant.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Mutant.entities.Human;
import com.example.Mutant.repositories.BaseRepository;

@Service
public class HumanServiceImplementation extends BaseServiceImplementation<Human,Long> implements HumanService  {
	
	@Autowired
	private com.example.Mutant.repositories.HumanRepository HumanRepository;
	
	public HumanServiceImplementation(BaseRepository<Human,Long> baseRepository) {
		super(baseRepository);
	}
	
	
	@Transactional
	public Human saveHuman(Human entity) throws Exception {
	try {
		entity = baseRepository.save(entity);
		return entity;
			} catch(Exception e) {
			throw new Exception(e.getMessage());
			
}
	
	
	
	}
	
	

	
	


}