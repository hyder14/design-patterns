package com.hyders.sorting;

import java.util.Arrays;

public interface Sortable {

    int[] sort(int[] unsortedArray);

    void setUnsortedArray(int[] originalArray);
    int[] getUnSortedArray();

    void setSortedArray(int[] sortedArray);
    int[] getSortedArray();

    void setName();
    String getName();

    void setNumOperations(long numOperations);
    long getNumOperations();

    String toString();

    default void printArray(int[] array){
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("\n");
    };

}
