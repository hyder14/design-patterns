package com.hyders.practice.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiogonalDifference {



    public static int diagonalDifference(List<List<Integer>> listArr){

        int sumRightDiog = 0;
        int sumLeftDiag = 0;
        for(int i=0; i<listArr.size(); i++) {

                List<Integer> list = listArr.get(i);

                sumLeftDiag+= list.get(i);

                sumRightDiog+= list.get(list.size()-1-i);

        }


    return Math.abs(sumLeftDiag-sumRightDiog);



    }




    public static void main (String args[]) {


        List<Integer> l1 =Arrays.asList(5,2,3);
        List<Integer> l2 =Arrays.asList(4,5,6);
        List<Integer> l3 =Arrays.asList(7,8,9);


        List<List<Integer>> listArray = Arrays.asList(l1,l2,l3);

        System.out.println(listArray);
        System.out.println(diagonalDifference(listArray));




    }


}
