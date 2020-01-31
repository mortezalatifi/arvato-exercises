package com.arvato.exercise.latifi.exerciseThree;

import java.util.List;

/**
 * The Solution of the exercise 3 solved using an implementation of the knapsack problem
 */
public class Solution {

    /**
     * This methods calculates the optimal value of a specific number of products where
     * each product has a rating and a price and there is a limited amount of money to buy the products.
     * @param money This is the money available the buy the products
     * @param flears This is the list of available products
     * @return int This is the calculated optimal result
     */
    public static int getOptimalValue(int money, List<Flear> flears){
        int res = 0;

        if (flears == null || money <= 0 || flears.size() <= 0)
            return 0;

        /**
         * To solve this problem we need to create a matrix and make a 2D loop.
         * Though first we define the variables to work with in the matrix.
         */
        int i, j; // The for loop variable
        int n = flears.size(); // The size of flears, n for simplicity
        int M = money; // The available money, M for simplicity
        int K[][] = new int[n + 1][M + 1]; // The Matrix, a 2D Array

        // Calculating the matrix for the best result
        for (i = 0; i<= n; i++) {
            for (j = 0; j<= M; j++) {
                if (i == 0 || j == 0)
                    K[i][j] = 0;
                else if (flears.get(i-1).getPrice()<= j)
                    if (flears.get(i-1).getRating() + K[i - 1][(int) (j - flears.get(i-1).getPrice())] > K[i - 1][j])
                        K[i][j] = flears.get(i-1).getRating() + K[i - 1][(int) (j - flears.get(i-1).getPrice())];
                    else
                        K[i][j] = K[i - 1][j];
                else
                    K[i][j] = K[i - 1][j];
            }
        }

        res =  K[n][M];

        return res;
    }

}
