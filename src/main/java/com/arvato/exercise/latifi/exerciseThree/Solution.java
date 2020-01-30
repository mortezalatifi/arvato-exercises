package com.arvato.exercise.latifi.exerciseThree;

import org.springframework.stereotype.Service;

import java.util.List;

public class Solution {
    public static int getOptimalValue(int money, List<Flear> flears){
        int res = 0;

//        int i,j=0;
//        float max;
//
//        int flearsNumber = flears.size();
//
//        while (money > 0) {
//
//            max = 0;
//
//            for (i = 0; i < flearsNumber; i++) {
//                if (flears.get(i).getRating() / flears.get(i).getPrice() > max) {
//                    max = (flears.get(i).getRating() / flears.get(i).getPrice());
//                    j = i;
//                }
//            }
//
//            if (flears.get(j).getPrice() > money) {
//                res += money * max;
//                money = -1;
//            } else {
//                money -= flears.get(j).getPrice();
//                res += flears.get(j).getRating();
//                flears.get(j).setRating(0);
//            }
//        }

        int i, w;
        int n = flears.size();
        int W = money;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i<= n; i++) {
            for (w = 0; w<= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (flears.get(i-1).getPrice()<= w)
                    if (flears.get(i-1).getRating() + K[i - 1][(int) (w - flears.get(i-1).getPrice())] > K[i - 1][w])
                        K[i][w] = flears.get(i-1).getRating() + K[i - 1][(int) (w - flears.get(i-1).getPrice())];
                    else
                        K[i][w] = K[i - 1][w];
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        res =  K[n][W];

        return res;
    }

}
