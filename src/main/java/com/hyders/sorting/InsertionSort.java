package com.hyders.sorting;

import java.util.Arrays;

public class InsertionSort implements Sortable{

    private String name;
    private long numOperations;

    private int[] originalArray;
    private int[] sortedArray;

    public InsertionSort(){
        setName();
    }

    public int[] sort(int[] unsortedArray) {
        setUnsortedArray(Arrays.copyOf(unsortedArray,unsortedArray.length));
        return this.sortArray(unsortedArray);
    }

    /**
     * Implementation of Insertion Sort Algorithm
     * @param unsorted
     */
    public int[] sortArray(int[] unsorted) {

        long numCount = 0;

        int length = unsorted.length;

        int[] sorted;

        for(int mNext = 1; mNext<length; mNext++) {

            numCount++;

            int insert = unsorted[mNext];

            int moveIndex = mNext;

            while (moveIndex>0 && unsorted[moveIndex-1]>insert) {
                unsorted[moveIndex] = unsorted[moveIndex-1];
                moveIndex--;
                numCount++;
            }
            unsorted[moveIndex]= insert;
        }

        this.setNumOperations(numCount);

        printArray(unsorted);
        //Copy into new array after sorting
        sorted =  Arrays.copyOf(unsorted,unsorted.length);

        setSortedArray(sorted);
        return sorted;
    }

    public void setName() {
        name = "Insertion Sort";
    }

    public String getName() {
        return name;
    }

    public void setUnsortedArray(int[] originalArray) {
        this.originalArray=originalArray;
    }

    public int[] getUnSortedArray() {
        return this.originalArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }

    public int[] getSortedArray() {
        return this.sortedArray;
    }

    public void setNumOperations(long numOperations) {
        this.numOperations = numOperations;
    }

    public long getNumOperations() {
        return numOperations;

    }

    public String getCommaSeparatedArray(int[] array) {
        //convert int array to String array
        String str = Arrays.toString(array);
        return str;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(
                "Algorithm : " +  getName() + "\n"
              + "Original Array : " + getCommaSeparatedArray(getUnSortedArray()) + "\n"
              + "Sorted Array : " + getCommaSeparatedArray(getSortedArray()) + "\n"
              + "Total Operations : " + getNumOperations()
        );

        return sb.toString();

    }
}
