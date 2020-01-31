package com.arvato.exercise.latifi;

import com.arvato.exercise.latifi.exerciseOne.FileService;
import com.arvato.exercise.latifi.exerciseOne.ListComparatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A test class to test the exercise 01.
 * To test this exercise the values of the exercise are being tested.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEx01 {

    @Autowired
    private ListComparatorService listComparatorService;

    /**
     * This method simply tests the result of the compareList from the ListComparatorService class.
     */
    @Test
    public void test() {
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();

        list1.add("word1");
        list1.add("word2");
        list1.add("word5");
        list1.add("word6");

        list2.add("word5");
        list2.add("word6");
        list2.add("word3");
        list2.add("word4");

        String expectedResult = "{" +
                "\"inBothLists\":[\"word5\",\"word6\"]," +
                "\"onlyInList2\":[\"word3\",\"word4\"]," +
                "\"onlyInList1\":[\"word1\",\"word2\"]}";

        // Testing with valid data
        Assert.assertEquals(
                expectedResult,
                listComparatorService.compareLists(list1, list2).toString()
        );

    }

}
