package com.arvato.exercise.latifi.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ListComparatorService {
    
    private Collection<String> findCommonsInTwoLists(Collection list1, Collection list2) {
        Collection<String> l1 = new ArrayList<>();
        l1.addAll(list1);
        l1.retainAll(list2);
        return l1;
    }

    private Collection<String> findDifferenceOfTwoLists(Collection list1, Collection list2) {
        Collection<String> l1 = new ArrayList<>();
        l1.addAll(list1);
        l1.removeAll(list2);
        return l1;
    }

    public JSONObject compareLists(Collection list1, Collection list2) {
        JSONObject comparisonResult = new JSONObject();

        comparisonResult.put(
                "onlyInList1",
                findDifferenceOfTwoLists(list1, list2)
                );

        comparisonResult.put(
                "onlyInList2",
                findDifferenceOfTwoLists(list2, list1)
        );

        comparisonResult.put(
                "inBothLists",
                findCommonsInTwoLists(list1, list2)
        );

        return comparisonResult;
    }
}
