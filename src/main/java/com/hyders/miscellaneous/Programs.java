package com.hyders.miscellaneous;

public class Programs {


    public static boolean isAPalindrome(String string) {
        boolean isPalindrome = true;
        int stringLength = string.length();
        for (int i=0; i < stringLength ; i++) {
            if(string.charAt(i)!=string.charAt(stringLength-i-1)) {
                isPalindrome = false;
                break;
            }


        }
        return isPalindrome;
    }




    public static void main(String[] args) {

        String testStr = "aabbaa";
        System.out.println("The string is a palindrome: " + isAPalindrome(testStr));

    }


}
