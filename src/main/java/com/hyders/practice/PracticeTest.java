package com.hyders.practice;

public class PracticeTest {

    static int fact(int n) {
        int result=1;
        if (n==0) {
            return result;
        }
        result = n*fact(n-1);


        return result;
    }

    public static void main(String[] args) {


        System.out.println(fact(6));

    }

    public int od(String od) {

        System.out.println(od);
        return od.length();
    }

    public int od(int it) {
        return it*2;
    }

}
