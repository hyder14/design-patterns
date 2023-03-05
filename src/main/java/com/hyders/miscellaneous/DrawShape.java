package com.hyders.miscellaneous;

public class DrawShape {

    public static void main(String[] args) {

        String displayChar = "/";

        String shape[][] = new String[10][10];

        for (int i=0;i<10;i++) {
            for(int j=0;j<10; j++) {
                int numOfSpaces = 10-(i+1);

                int leftSpace =  (numOfSpaces / 2);

                int rightSpace = numOfSpaces-leftSpace;

                if (j<=leftSpace) {
                    //put space characer
                    shape[i][j]=" ";
                    //j=6
                    //leftSpace=4;
                    //rightSpace=5;
                } else if(j>leftSpace && rightSpace+j<10) {
                    //put display character
                    shape[i][j]=displayChar;
                } else if(10-j<=rightSpace) {
                    shape[i][j]=" ";
                }
            }
        }

        printShape(shape);


    }

    private static void printShape(String[][] shape) {

        for(int i=0;i< shape.length; i++) {
            for (int j=0; j<shape[0].length;j++) {
                System.out.print(shape[i][j]);
            }
            System.out.println("\n");
        }
    }
}
