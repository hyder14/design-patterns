package com.hyders.mutability;

public class StringImmutabilityTest {



    public static void main (String args[]) {


        String x = new String("abc");


        String y = "abc";

        String z = "abc";

        String internMessg = String.format("Intern, x: %1s, y: %2s, z:%3s", x.intern(), y.intern(), z.intern());

        System.out.println("Intern: " + internMessg);


        System.out.println("x is equal to y:" + (x==y));

        System.out.println("y is equal to z:" + (y==z));

        System.out.println("x.equals(y):" + x.equals(y));


        System.out.println("Hashcode: y==z: " + (y.hashCode()==z.hashCode()));


    }
}
