package com.example.Mutant.controllers;


import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mutant.entities.Human;
import com.example.Mutant.entities.Mutant;
import com.example.Mutant.services.HumanServiceImplementation;
import com.example.Mutant.services.MutantServiceImplementation;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/mutants") 
public class MutantController  extends BaseControllerImplementation<Mutant,MutantServiceImplementation>{

	@Autowired
	HumanServiceImplementation hservice;
	
    @PostMapping("/ismutant")
    public ResponseEntity<?> isMutant( @RequestBody Mutant mutant){

     
    	try {
        	  
        	String[] dna= mutant.getDna();
        	 
        	 boolean resultado =servicio.isMutant(dna); 
        	 
        	 if(resultado) {
        		 
        		 if(validacion(dna)) {
        		
        		 servicio.save(mutant);
        		 
        		 return ResponseEntity.status(HttpStatus.OK).body("Es mutante!!!!");
        		 }else {
        			 throw new Exception();
        			  
        		 }
        		 
        		 
        	 }else {
        		 
        		 if(validacion(dna)) {
        		Human h = new Human(dna);
        		hservice.saveHuman(h);
        		 
        		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Es humano!!!!.):");
        		 }else {
        			 throw new Exception();
        			 
        		 }
        		  }
         
         }catch(Exception e) {
             return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"El adn ya existe\"}");
         }
    } 
    
    
    
    
    @PostMapping("/stats")
    public ResponseEntity<?> stats(){
        try {
            List<Human> humanos = hservice.findAll();
            List<Mutant> mutantes = servicio.findAll();
            
            //System.out.println(humanos.get(0).getDnaH()[0]);

            float cantM = mutantes.size();
            float cantH = humanos.size();

            float ratio = cantM / cantH;

            return ResponseEntity.status(HttpStatus.OK).body(
            		"{\n\"count_mutant_dna\":"+ cantM +", \n\"count_human_dna\":"+ cantH + ", \n\"ratio\":" + ratio +"\n}"
                    );
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No es mutante.):\"}");
        }

    }
    
    
    public boolean validacion(String[] dna) {
    	
      
    try {
    		if(servicio.isMutant(dna)) {
    	   
    			List<Mutant> mutantes = servicio.findAll();
       	 
	       		for(int i=0;i<mutantes.size();i++) {
	
	       			String[] s = mutantes.get(i).getDna();
	       			
	       			if(Arrays.deepEquals(dna, s)) {
	       				
	       				return false;	
	       			}		
	       		}
	    	 }else {
	    		 
	    		 List<Human> humanos = hservice.findAll();
	
	    		 for(int i=0;i<humanos.size();i++) {
	
	        			String[] s = humanos.get(i).getDnaH();
	        			
	        			if(Arrays.deepEquals(dna, s)) {
	        				
	        				return false;	
	        			}
	    		 }
	    	 }
		
		return true;
	    	}catch(Exception e){
	    		
	    		return false;
	    		
	    	}
		
	    }
    
 }
	


