package com.arvato.exercise.latifi;

import com.arvato.exercise.latifi.exerciseThree.Flear;
import com.arvato.exercise.latifi.exerciseThree.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * A test class to test the exercise 03.
 * To test this exercise the value of some Knapsack examples on the internet are used.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEx03 {

    /**
     * This methos test the getOptimalValue of the Solution class with two different sets of values!
     */
    @Test
    public void test() {

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

        // Test 03
        // money: 67, result: 20
        List<Flear> flears3 = new ArrayList<>();
        flears3.add(new Flear("Flear 1", 13, 1));
        flears3.add(new Flear("Flear 1", 26, 2));
        flears3.add(new Flear("Flear 1", 20, 3));
        flears3.add(new Flear("Flear 1", 18, 4));
        flears3.add(new Flear("Flear 1", 32, 5));
        flears3.add(new Flear("Flear 1", 17, 6));
        flears3.add(new Flear("Flear 1", 29, 7));
        flears3.add(new Flear("Flear 1", 26, 8));
        flears3.add(new Flear("Flear 1", 30, 9));
        flears3.add(new Flear("Flear 1", 27, 10));

        assertEquals(20, Solution.getOptimalValue(67, flears3));

    }

}
