package com.arvato.exercise.latifi;

import com.arvato.exercise.latifi.exerciseOne.FileService;
import com.arvato.exercise.latifi.exerciseOne.ListComparatorService;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEx01 {

    @Autowired
    private FileService fileService;

    @Autowired
    private ListComparatorService listComparatorService;

    @Test
    public void test() throws FileNotFoundException {
        JSONObject expectedResult = new JSONObject();
        Collection list1 = new ArrayList();
        Collection list2 = new ArrayList();

        list1.add("word1");
        list1.add("word2");
        list1.add("word5");
        list1.add("word6");

        list2.add("word5");
        list2.add("word6");
        list2.add("word3");
        list2.add("word4");


        Assert.assertEquals(
                "{\"inBothLists\":[\"word5\",\"word6\"],\"onlyInList2\":[\"word3\",\"word4\"],\"onlyInList1\":[\"word1\",\"word2\"]}",
                listComparatorService.compareLists(list1, list2).toString()
        );

    }

}
