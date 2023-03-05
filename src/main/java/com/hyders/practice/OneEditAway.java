package com.hyders.practice;

public class OneEditAway {

/*    One Away: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are
    one edit (or zero edits) away.
    EXAMPLE
    pale, ple -> true
    pales, pale -> true
    pale, bale -> true
    pale, bake -> false*/



        public static boolean isOneEditAway(String string1, String string2) {

            boolean isOneAway = false;

            char[] string1Chars = string1.toCharArray();

            char[] string2Chars = string2.toCharArray();


            boolean isFirstLarger = string1.length()>string2.length();

            boolean stringsAreEqual = string1.length()==string2.length();

            boolean isOneEditRemoval = isFirstLarger?
                    isRemoval(string1,string2) :
                    (stringsAreEqual? false :
                    isRemoval(string2,string1)
                    );

            boolean isOneEditReplacement = string1.length() == string2.length()?
                                            isReplacement(string1,string2) : false;

            isOneAway = (isOneEditRemoval && !isOneEditReplacement)
                                    ||
                    (isOneEditReplacement && !isOneEditRemoval);


            return isOneAway;


        }


        public static boolean isRemoval(String largerString, String smallerString) {


            int removed=0;

            boolean isOneRemoved=false;

            for(char c: largerString.toCharArray()) {

                if (smallerString.indexOf (c)==-1) {
                    removed++;
                    isOneRemoved = (removed==1);
                }

            }

            return isOneRemoved;
        }

        public static boolean isReplacement(String firstString, String secondString) {

            boolean isOneReplaced=false;

            int replaced=0;

            for (int i=0; i<firstString.length() ; i++ ) {

                int currentIndex = i;
                char c = firstString.charAt(i);

                if (secondString.charAt(currentIndex)!=c) {
                    replaced++;
                    isOneReplaced=(replaced==1);
                }

            }

            return isOneReplaced;

        }



        public static void main (String[] args) {

            System.out.println(isOneEditAway("pale", "ple"));
            System.out.println(isOneEditAway("pale", "bale"));
            System.out.println(isOneEditAway("pale", "bake"));
            System.out.println(isOneEditAway("steeper", "stbeker"));

        }

}
