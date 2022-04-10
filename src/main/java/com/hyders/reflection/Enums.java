package com.hyders.reflection;

public class Enums {

    enum numberEnums {
        ONE, TWO, THREE, FOUR
    }

    /**
     * Iterate over enum constants using single enum value
     *
     * @param args
     */
    public static void main(String[] args) {
        numberEnums valueThree = numberEnums.THREE;

        numberEnums[] numberEnums =  valueThree.getClass().getEnumConstants();


        for (numberEnums numEnum : numberEnums) {
            System.out.println("number Enum " + numEnum);
        }

    }

}
