package com.hyders.miscellaneous.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularArrayRotation {


    public CircularArrayRotation(){

    }

    public List<Integer> rotateByShiftingListElements(List<Integer> a, int k, List<Integer> queries) {


        List<Integer> clonedList = new ArrayList<>(a);

        for (int i=0; i<k; i++) {

            int temp = clonedList.get(a.size()-1);
            for (int j=0; j<a.size()-1;j++) {

                int temp1=a.get(j);
                clonedList.set(j+1,temp1);
            }

            clonedList.set(0,temp);

        }

        return putInSpecifiedQueries(clonedList,queries);

    }



    /**
     * An efficient algorithm
     * Credit: https://www.geeksforgeeks.org/circular-array/
     * Result: Has not worked faultlessly
     * @param a
     * @param k
     * @param queries
     * @return
     */
    public List<Integer> rotateEfficiently(List<Integer> a, int k, List<Integer> queries) {

        List<Integer> newList = new ArrayList<>(a);
        int counter=0;
        int size = a.size();
        for (int count=k;count<k+size;count++) {
            newList.set(counter++, a.get(count%size));
        }

        return putInSpecifiedQueries(newList,queries);
    }


    private List<Integer> putInSpecifiedQueries(List<Integer> rotatedList, List<Integer> queries) {

        List<Integer> organizedListAsPerQuery = new ArrayList<>(rotatedList);

        for (int i: queries) {
            organizedListAsPerQuery.set(i, rotatedList.get(i));
        }

        return organizedListAsPerQuery;
    }

    public List<Integer> rotate(List<Integer> a, int k, List<Integer> queries) {

//        int[] arrAfterRotation = new int[a.size()];

        List<Integer> arrAfterRotation = new ArrayList<>(a);

        List<Integer> lastArrAfterRotation = new ArrayList<>(a);

        //Set the last one after rotation equal to provided array at initialization
        lastArrAfterRotation = a;

        for(int i=0; i<k; i++) {
            arrAfterRotation.set(0,lastArrAfterRotation.get(lastArrAfterRotation.size()-1));
            int counter=1;
            for (int elem=1; elem<lastArrAfterRotation.size();elem++ ) {
                arrAfterRotation.set(counter++, lastArrAfterRotation.get(elem-1));
            }
            List<Integer> tempList = new ArrayList<>(arrAfterRotation);
            lastArrAfterRotation= tempList;
        }
        printList(lastArrAfterRotation);

        List<Integer> returnList = new ArrayList<>(lastArrAfterRotation);

        for (int i : queries) {
            returnList.set(i,lastArrAfterRotation.get(i));
        }

        return returnList;

    }


    /**
     *
     * @param intArray
     * @param numRotate
     */
    public void rotate(int[] intArray, int numRotate){

        int[] arrAfterRotation = new int[intArray.length];

        int[] lastArrAfterRotation = new int[intArray.length];

        //Set the last one after rotation equal to provided array at initialization
        lastArrAfterRotation = intArray;

        for(int i=0; i<numRotate; i++) {
            arrAfterRotation[0]=lastArrAfterRotation[lastArrAfterRotation.length-1];
            int counter=1;
            for (int elem=1; elem<lastArrAfterRotation.length;elem++ ) {
                arrAfterRotation[counter++]= lastArrAfterRotation[elem-1];
            }
            lastArrAfterRotation=Arrays.copyOf(arrAfterRotation,arrAfterRotation.length);
        }
        printArray(lastArrAfterRotation);
    }


    private void printArray(int[] arr) {
        Arrays.stream(arr).forEach(System.out:: println);
    }

    private void printList(List<Integer> list) {
        System.out.println("Printing list..");
        list.stream().forEach(System.out:: print);
    }


    public static void main(String[] args) {
        CircularArrayRotation circularArrayRotation= new CircularArrayRotation();

        List<Integer> inputList = Arrays.asList(5,4,2,10);
        List<Integer>queries = Arrays.asList(0,1,2,3);
        circularArrayRotation.rotate(inputList,2,queries);
        circularArrayRotation.rotate(inputList,3,queries);

//        circularArrayRotation.printList(circularArrayRotation.rotateEfficiently(inputList,3, queries));

        circularArrayRotation.printList(circularArrayRotation.rotateByShiftingListElements(inputList,3, queries));

    }

    //[2,3,5]-> [5,2,3] -> [3,5,2]

    //[5,4,2,10] -> [10,5,4,2]-> [2,10,5,4]



}
