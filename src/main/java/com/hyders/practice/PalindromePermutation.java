package com.hyders.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation {




   /* Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    *
    * Tact Coa
    */


   public static boolean checkIfPermutationOfPalindrome(String string){


      char[] letters = string.replace(" ","").toCharArray();


      for(char c : letters) {

         System.out.println(c);
      }

      //Using a map to hold frequency of characters

      Map<Character,Integer> frequencyMap = new HashMap<>();

      for (char c: letters) {
         if (frequencyMap.containsKey(c) && frequencyMap.get(c)>0) {
            int currentValue = frequencyMap.get(c);
            frequencyMap.replace(c,currentValue+1);
         } else {
            frequencyMap.put(c,1);
         }
      }

      //check for even length
      if(letters.length%2==0){
         return checkifPalindrome(frequencyMap,true);
      } else {
         return checkifPalindrome(frequencyMap,false);
      }

   }


   public static boolean checkifPalindrome(Map<Character,Integer> frequencyMap, boolean checkForEven) {

      Set<Character> charSet = frequencyMap.keySet();

      boolean isPalindrome = true;

      int countOfOddCharacters = 0;

      for (char c: charSet) {
         if (frequencyMap.get(c)%2!=0 && checkForEven) {
            isPalindrome=false;
         } else if (frequencyMap.get(c)%2!=0) {
            System.out.println("Odd character: " + c);
               countOfOddCharacters++;
            if(countOfOddCharacters>=2) {
               return false;
            }
         }

      }

      return isPalindrome;

   }


   public static void main(String args[]) {

      System.out.println(checkIfPermutationOfPalindrome("Tact Coa"));

      System.out.println(checkIfPermutationOfPalindrome("appllmmnnddooaabbb") );

      System.out.println(checkIfPermutationOfPalindrome("civil"));

      System.out.println(checkIfPermutationOfPalindrome("livci "));

   }

}
