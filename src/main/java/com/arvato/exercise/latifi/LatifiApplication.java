/**
 * The latifi program implements an application that
 * solves the exercises of Arvato GMBH interview process.
 *
 * @author  Morteza Latifi Emami
 * @version 1.0
 * @since   29-01-2020
 */

package com.arvato.exercise.latifi;

import com.arvato.exercise.latifi.services.ListComparatorService;
import com.arvato.exercise.latifi.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;


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
    }
}
