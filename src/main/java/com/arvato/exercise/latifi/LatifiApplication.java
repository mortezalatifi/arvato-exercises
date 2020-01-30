/**
 * The latifi program implements an application that
 * solves the exercises of Arvato GMBH interview process.
 *
 * @author  Morteza Latifi Emami
 * @version 1.0
 * @since   29-01-2020
 */

package com.arvato.exercise.latifi;

import com.arvato.exercise.latifi.exerciseOne.FileService;
import com.arvato.exercise.latifi.exerciseOne.ListComparatorService;
import com.arvato.exercise.latifi.exerciseThree.Flear;
import com.arvato.exercise.latifi.exerciseThree.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@SpringBootApplication
public class LatifiApplication implements CommandLineRunner {

    @Autowired
    FileService fileService;

    @Autowired
    ListComparatorService listComparatorService;


    public static void main(String[] args) {
        SpringApplication.run(LatifiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Collection list1 = fileService.convertToList("arvato/List1.txt");
        Collection list2 = fileService.convertToList("arvato/List2.txt");

        System.out.println(
                listComparatorService.compareLists(list1, list2)
        );


        //Knapsack
        List<Flear> flears = new ArrayList<>();

        // money: 15, result: 15
        flears.add(new Flear("Flear 1", 12, 4));
        flears.add(new Flear("Flear 2", 1, 2));
        flears.add(new Flear("Flear 3", 2, 2));
        flears.add(new Flear("Flear 4", 1, 1));
        flears.add(new Flear("Flear 5", 4, 10));

        // money: 150, result: 150
//        flears.add(new Flear("Flear 1", 1, 50));
//        flears.add(new Flear("Flear 2", 56, 30));
//        flears.add(new Flear("Flear 3", 42, 20));
//        flears.add(new Flear("Flear 3", 78, 10));
//        flears.add(new Flear("Flear 3", 12, 50));

        // money: 5, result: 440
//        flears.add(new Flear("Flear 1", 1, 200));
//        flears.add(new Flear("Flear 2", 3, 240));
//        flears.add(new Flear("Flear 3", 2, 140));
//        flears.add(new Flear("Flear 3", 5, 150));

//        System.out.println("Knapsack test:");
//        System.out.println(
//                Solution.getOptimalValue(15, flears)
//        );
    }
}
