package com.hyders.miscellaneous;

import org.springframework.boot.test.context.TestComponent;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private String originalString="abcde";
    private List<String> permutations=new ArrayList<>();


    public String getOriginalString() {
        return originalString;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public List<String> getPermutations() {
        return permutations;
    }

    public void setPermutations(List<String> permutations) {
        this.permutations = permutations;
    }


    public void computePermutations(String strPermutation, String prefix){

        synchronized (permutations) {

            if (strPermutation.length()==0) {
                getPermutations().add(prefix);
                return;
            } else  {
                for (int i=0;i<strPermutation.length();i++) {

                    String excludingPrefix = strPermutation.substring(0,i) + strPermutation.substring(i+1);

                    computePermutations(excludingPrefix,prefix + strPermutation.charAt(i));
                }
            }
        }
        setPermutations(permutations);
    }


    public static void main(String[] args) {

        String original = "abcde";

        Permutation permutationInstance = new Permutation();

        permutationInstance.setOriginalString(original);

        permutationInstance.computePermutations(permutationInstance.getOriginalString(),""); ;

        permutationInstance.getPermutations().forEach(System.out::println);
        System.out.println(permutationInstance.getPermutations().size());


    }


}
