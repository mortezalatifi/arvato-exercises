package com.arvato.exercise.latifi;

import com.arvato.exercise.latifi.exerciseOne.FileService;
import com.arvato.exercise.latifi.exerciseOne.ListComparatorService;
import com.arvato.exercise.latifi.exerciseThree.Flear;
import com.arvato.exercise.latifi.exerciseThree.Solution;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEx03 {

    @Test
    public void test() throws FileNotFoundException {

        // Test 01
        // money: 15, result: 15
        List<Flear> flears1 = new ArrayList<>();
        flears1.add(new Flear("Flear 1", 12, 4));
        flears1.add(new Flear("Flear 2", 1, 2));
        flears1.add(new Flear("Flear 3", 2, 2));
        flears1.add(new Flear("Flear 4", 1, 1));
        flears1.add(new Flear("Flear 5", 4, 10));

        assertEquals(15, Solution.getOptimalValue(15, flears1));

        // Test 02
        // money: 150, result: 23
        List<Flear> flears2 = new ArrayList<>();
        flears2.add(new Flear("Flear 1", 1, 9));
        flears2.add(new Flear("Flear 2", 56, 3));
        flears2.add(new Flear("Flear 3", 42, 6));
        flears2.add(new Flear("Flear 3", 78, 1));
        flears2.add(new Flear("Flear 3", 12, 5));

        assertEquals(23, Solution.getOptimalValue(150, flears2));

    }

}
