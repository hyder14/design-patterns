package com.hyders.sorting;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Test Driver class to test different sorting algorithms
 */
public class TestDriver {

    public static void testInsertionSort(int[] unsortedArray) {

        Sortable insertionSort = new InsertionSort();

        int[] sortedArray = insertionSort.sort(unsortedArray);

        System.out.println(insertionSort.toString());

    }


    public static void main(String args[]) {

        SecureRandom generator = new SecureRandom();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int size = sc.nextInt();
        int[] unsortedArray = new int[size];

        System.out.println("Enter an upper bound for the generated random numbers");
        int ubound = sc.nextInt();

        //populate unsorted array
        for (int i =0; i<unsortedArray.length; i++) {
            unsortedArray[i] = 10 + generator.nextInt(ubound);
        }
        //Run Insertion Sort Test
        TestDriver.testInsertionSort(unsortedArray);

    }


}



