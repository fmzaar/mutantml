package com.example.Mutant.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Mutant.entities.Human;
import com.example.Mutant.entities.Mutant;
import com.example.Mutant.repositories.BaseRepository;
import com.example.Mutant.repositories.MutantRepository;



@Service
public class MutantServiceImplementation  extends BaseServiceImplementation<Mutant,Long> implements MutantService  {
	
	@Autowired
	private MutantRepository MutantRepository;
	
	public MutantServiceImplementation(BaseRepository<Mutant,Long> baseRepository) {
		super(baseRepository);
	}
	
	
	

	
	
	@Override
	@Transactional
	
	 public boolean isMutant(String[] dna) {
        char[][] dna1 = convertirToArreglo(dna);
        int diagonalPrincipal = diagonalPrincipal(dna1);
        int horizontal  = horizontal(dna1);
        int vertical = vertical(dna1);
        int diagonalSecundaria = diagonalSecundaria(dna1);
        int suma = diagonalPrincipal + horizontal + vertical + diagonalSecundaria;
        //System.out.println(suma);
        if(suma >= 2) {
        	 return true;
        }
        return false;
    }
    
	
	@Transactional
	
    public char[][] invArray(char[][] n) {	
        char aux;
        for (int i = 0; i < n.length; i++) {
            for(int j = 0; j < n.length/2; j++){
                aux = n[i][j];
                n[i][j] = n[i][n.length - 1 -j];
                n[i][n.length - 1 -j] = aux;
            }
        }
        return n;
    }

	@Transactional
    public  void mostrarArray(char[][] m){
        for (int i = 0; i < m.length; i++) {
            for(int j = 0; j < m.length; j++){
                System.out.print(m[i][j]);
            }
            System.out.println('\n');
        }
    }

	@Transactional
    public  int diagonalSecundaria(char[][] matriz) {
        //Calcula la altura y la anchura de la matriz introducida.
        Integer altura = matriz.length, anchura = matriz[0].length;

        int cont = 0;
        if ( altura == anchura ){
            matriz = invArray(matriz);
            cont = diagonalPrincipal(matriz);
            //mostrarArray(matriz);
        }else {
            System.out.println("The matrix is not square, then your adn is not mutant. ");
        }
        return cont;
    }

	
	@Transactional
    public  int horizontal(char[][] matriz) {
        // Calcula la altura y la anchura de la matriz introducida.
        Integer altura = matriz.length, anchura = matriz[0].length;
        ArrayList<Boolean> mutant = new ArrayList<Boolean>();
        int cont = 0;
        char first = matriz[0][0];
        if ( altura == anchura ){
        	for (int k = 0; k < 4; k++) {
        		
        		if (k==0){
        			first = 'A';
        		}
        		if (k==1){
        			first = 'C';
        		}
        		if (k==2){
        			first = 'G';
        		}
        		if (k==3){
        			first = 'T';
        		}
        		
	            for(int i = 0; i < matriz.length; i++){
	            	cont = 0;
	                for(int j = 0; j < matriz.length; j++){
	                    if(matriz[i][j]== first){
	                        first = matriz[i][j];
	                        cont = cont + 1;
	                        if(cont == 4){
	                            mutant.add(true);
	                        }
	                    }else {
	                    	cont=0;
	                    }
	                }
	            }
	         }
        }else {
            System.out.println("The matrix is not square, then your adn is not mutant. ");
        }
        return mutant.size();
    }

	@Transactional
	public int vertical(char[][] matriz) {
        // Calcula la altura y la anchura de la matriz introducida.
        Integer altura = matriz.length, anchura = matriz[0].length;
        ArrayList<Boolean> mutant = new ArrayList<Boolean>();
         int cont = 0;
        char first = matriz[0][0];
        if (altura == anchura){
        	
        	for (int k = 0; k < 4; k++){
        		
        		if (k==0){
        			first = 'C';
        		}
        		if (k==1){
        			first = 'T';
        		}
        		if (k==2){
        			first = 'G';
        		}
        		if (k==3){
        			first = 'A';
        		}
        	
	            for(int i = 0; i < matriz.length; i++){
	            	//System.out.println("Iteración columnas verticales "+i);
	            	cont = 0;
	                for(int j = 0; j < matriz.length; j++){
	                	//System.out.println("Iteración filas verticales "+j);
	                    if(matriz[j][i]==first){
	                        first = matriz[j][i];
	                        cont = cont + 1;
	                        //System.out.println(cont);
	                        if(cont == 4){
	                        	//System.out.println("Contador de verticales "+cont);
	                            mutant.add(true);
	                            
	                            
	                        }
	                    }else {
	                    	cont=0;
	                    }
	                }
	            }
        	}
        }else {
            System.out.println("The matrix is not square, then your adn is not mutant. ");
        }
       
        return mutant.size();
    }

	@Transactional
	public int diagonalPrincipal(char[][] matriz) {
        // Calcula la altura y la anchura de la matriz introducida.
        Integer altura = matriz.length, anchura = matriz[0].length;
        ArrayList<String> diagonalRow = new ArrayList<String>();
        ArrayList<Boolean> mutant = new ArrayList<Boolean>();

        if ( altura == anchura ){
            for (
                // Recorre los inicios de cada diagonal en los bordes de la matriz.
                    Integer diagonal = 1 - anchura; // Comienza con un número negativo.
                    diagonal <= altura - 1; // Mientras no llegue a la última diagonal.
                    diagonal += 1 // Avanza hasta el comienzo de la siguiente diagonal.
            ) {
                int cont = 0;
                for (
                    // Recorre cada una de las diagonales a partir del extremo superior izquierdo.
                        Integer vertical = Math.max(0, diagonal), horizontal = -Math.min(0, diagonal);
                        vertical < altura && horizontal < anchura; // Mientras no excedan los límites.
                        vertical += 1, horizontal += 1 // Avanza en diagonal incrementando ambos ejes.
                ) {
                    cont = cont + 1;
                    String charToString = String.valueOf(matriz[vertical][horizontal]);
                    diagonalRow.add(charToString);
                }
                if(cont >= 4){
                    int cont1 = 1;
                    int size = diagonalRow.size();
                    String first = diagonalRow.get(0);
                    for(int i = 1; i < size-1 ; i++) {
                        if(first.equals(diagonalRow.get(i))){
                            cont1 = cont1 + 1;
                            first = diagonalRow.get(i);
                            if(cont1 == 4){
                                mutant.add(true);
                            }
                        }else{
                            cont1 = 1;
                            first = diagonalRow.get(i);
                        }
                    }
                    diagonalRow.clear();
                }
            }
        }else {
            System.out.println("The matrix is not square, then your adn is not mutant. ");
        }
        return mutant.size();
    }
   
	@Transactional
	public char[][] convertirToArreglo(String[] dna){

        int tamanio = dna[0].length();

        char[][] charArray = new char[tamanio][tamanio];

        for (int i = 0; i < dna.length; i++) {
            for(int j = 0; j < tamanio; j++) {
                charArray[i][j] = dna[i].charAt(j);
            }
        }
        return charArray;
    }
	
	

	
	
	
	
    
    
}