package com.example.Mutant.HumanServiceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Mutant.entities.Human;
import com.example.Mutant.repositories.HumanRepository;



@SpringBootTest

public class HumanServiceImplTest {


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