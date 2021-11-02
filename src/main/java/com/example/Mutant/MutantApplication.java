package com.example.Mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Mutant.services.MutantServiceImplementation;

import lombok.ToString;

@SpringBootApplication
public class MutantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantApplication.class, args);
		
		//String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACAG","GCGTCA","TCACTG"};
       // System.out.println(MutantServiceImplementation.isMutant(dna));
		
		
        
        /*String[] dna0 = {"ATGCGA","CAGTGC","TTATTT","AGACAG","GCGTCA","TCACTG"};
		
		{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		
		
		char[][] dna = new char[dna0.length][dna0.length];
		 	
for(int i = 0; i < dna0.length ; i++) {
	
	for(int j=0 ;j< dna.length; j++) {
		for(int k=0 ;k < dna[j].length; k++ ) {
		
			
			dna[j][k] =dna0[i].charAt(dna0.length); 
		}     
}
	
}


mostrarArray(dna);

}
	public static void mostrarArray(char[][] m){
        for (int i = 0; i < m.length; i++) {
            for(int j = 0; j < m.length; j++){
                System.out.print(m[i][j]);
            }
            System.out.println('\n');
        }*/
    
	
	}
}