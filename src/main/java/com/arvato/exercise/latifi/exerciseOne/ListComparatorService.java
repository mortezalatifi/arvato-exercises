package com.arvato.exercise.latifi.exerciseOne;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <h1>Compare lists</h1>
 * The ListComparatorService is a service class that compares list.
 * It has only one public method named compareLists that compares two lists and
 * returns the desired result as JSON. The desired result is as follow:
 *      - The names only in list1
 *      - The names only in list2
 *      - The names in both lists
 */
@Service
public class ListComparatorService {

    /**
     * This method is a helper and simply gets two lists and
     * returns a list of common values of the lists.
     * @param list1
     * @param list2
     * @return resList (list of commons)
     */
    private Collection<String> findCommonsInTwoLists(Collection list1, Collection list2) {
        Collection<String> resList = new ArrayList<>();
        resList.addAll(list1);
        resList.retainAll(list2);
        return resList;
    }

    /**
     * This method is a helper and simply gets two lists and
     * returns a list of different values of the lists.
     * @param list1
     * @param list2
     * @return resList (list of differences)
     */
    private Collection<String> findDifferenceOfTwoLists(Collection list1, Collection list2) {
        Collection<String> resList = new ArrayList<>();
        resList.addAll(list1);
        resList.removeAll(list2);
        return resList;
    }

    /**
     * This method compares two lists and returns the desired result as a JSON.
     * The JSON result must contain the followings:
     *      - onlyInList1
     *      - onlyInList2
     *      - inBothLists
     * @param list1
     * @param list2
     * @return comparisonResult (JSON)
     */
    public JSONObject compareLists(Collection list1, Collection list2) {

        // Throwing exception if one of the lists is null
        if (list1 == null || list2 == null)
            throw new IllegalArgumentException("The lists cannot be null!");

        // Create the result JSON object
        JSONObject comparisonResult = new JSONObject();

        // Finding onlyInList1 using the helper method findDifferenceOfTwoLists
        comparisonResult.put(
                "onlyInList1",
                findDifferenceOfTwoLists(list1, list2)
                );

        // Finding onlyInList2 using the helper method findDifferenceOfTwoLists
        comparisonResult.put(
                "onlyInList2",
                findDifferenceOfTwoLists(list2, list1)
        );

        // Finding inBothLists using the helper method findCommonsInTwoLists
        comparisonResult.put(
                "inBothLists",
                findCommonsInTwoLists(list1, list2)
        );

        return comparisonResult;
    }
}
