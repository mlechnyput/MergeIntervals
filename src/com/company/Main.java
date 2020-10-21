package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(3) + 2;
        int[][] array = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) array[i][j] = rand.nextInt(20);
                else array[i][j] = array[i][0] + rand.nextInt(20 - array[i][0]) + 1;
            }
        }
        System.out.println("Merge the intervals:");
        for (int i[] : array)
            System.out.println(Arrays.toString(i));

        merge(array);

    }

    public static void merge(int[][] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i][1] >= array[j][0] && array[j][1] > array[i][1] && array[i][0] < array[j][0]) {
                    array[i][1] = array[j][1];
                    array[j][0] = -1;
                    array[j][1] = -1;
                }
                if (array[i][0] <= array[j][0] && array[i][1] >= array[j][1]) {
                    array[j][0] = -1;
                    array[j][1] = -1;
                }
                if (array[j][0] <= array[i][0] && array[j][1] >= array[i][1]) {
                    array[i][0] = -1;
                    array[i][1] = -1;
                }
                if (array[j][1] >= array[i][0] && array[i][1] > array[j][1] && array[j][0] < array[i][0]) {
                    array[i][0] = array[j][0];
                    array[j][0] = -1;
                    array[j][1] = -1;
                }
            }
        }
        System.out.println("Result is:");
        for (int i[] : array) {
            if (!contains(i,-1))
            System.out.println(Arrays.toString(i));
        }
    }

    private static boolean contains(int[] i, int val) {
        for (int k=0;k< i.length;k++){
            if (i[k]==val)return true;
            break;
        }
        return false;
    }

}
