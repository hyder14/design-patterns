package com.hyders.miscellaneous.problems;

import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * The program prints half square pattern like:
 *
 * #####
 * ####
 * ###
 * ##
 * #
 *
 * Any character can be used
 *
 */
public class HalfSquare {

    private static String CHAR_TO_PRINT = "#";

    public static void main (String args[]){
        run();
    }


    public static void run(){


        int upperLimit = 10;
        String[][] chars = new String[upperLimit][upperLimit];

        for (int i=1; i<upperLimit+1; i++) {
            System.out.println(upperLimit+1-i);
            String padded[] = padCharacters(upperLimit+1-i);
            for (int j = 0; j<upperLimit+1-i; j++) {
                chars[i-1][j] = padded[j];
            }
        }
        printGrid(chars);
    }


    public static String[] padCharacters(int times) {

        String[] chars = new String[times];

        for (int i=0; i<times; i++) {
            chars[i] = (CHAR_TO_PRINT);
        }
        return chars;
    }

    public static void printGrid(String[][] charGrid) {

        int rows = charGrid[0].length;
        int columns = charGrid[1].length;

        for (int i=0; i<rows; i++) {

            int arrLength = Arrays.stream(charGrid[i]).filter(x->x!=null).collect(Collectors.toList()).size();

            for (int j=0; j<arrLength; j++) {
                String charAt = charGrid[i][j];
//                if (charAt!=null)
                System.out.print(charAt);
            }
            System.out.println();
        }
    }

}
