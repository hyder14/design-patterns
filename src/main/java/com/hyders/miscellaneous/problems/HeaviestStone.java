package com.hyders.miscellaneous.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem:  https://leetcode.com/problems/last-stone-weight/
 */
public class HeaviestStone {


    public static void main(String[] args) {


//        int[] stones = new int[]{2,7,4,1,8,1};

        int[] stones = new int[]{4,6,4,10};

        Arrays.sort(stones);

        int [] smashed = stones.clone();

        int smashedLength = stones.length;

        for(int i=0; i<smashedLength;i++){

            if (stones.length==1) {
                break;
            }

            int heaviestButOne = stones[smashedLength-2];
            int heaviest = stones[smashedLength-1];

            stones = clashAndUpdateStones(heaviestButOne,heaviest,stones);

            //Sort
            Arrays.sort(stones);

            smashedLength= stones.length;



        }

        if (stones.length==1) {
            System.out.println(stones[0]);

        }
    }

    private static int[] clashAndUpdateStones(int stone1, int stone2, int[] stones) {


        if (Math.abs(stone1-stone2)>=0) {
            int[] stonesIntermediate = new int[stones.length-1];
            Queue<Integer> integerQueue = new PriorityQueue();
//            integerQueue.addAll(Arrays.stream(stones).));

            stones = Arrays.stream(stones).filter(x-> (x!=stone1 && x!=stone2)).toArray();
            System.arraycopy(stones,0,stonesIntermediate,0,stones.length);
//            stonesIntermediate= Arrays.copyOf(stones,stones.length);
            stonesIntermediate[stones.length]=Math.abs(stone1-stone2);
            //filter 0
            stonesIntermediate = Arrays.stream(stonesIntermediate).filter(x-> x!=0).toArray();
            stones=stonesIntermediate;
        } else {

        }


        return stones;


    }

}
