package com.hyders.miscellaneous;


import org.junit.Assert;
import org.junit.Test;

import com.hyders.miscellaneous.Permutation;


public class PermutationTest {


    @Test
    public void assertNumberOfPermutations(){

        Permutation testPermutation = new Permutation();

        testPermutation.computePermutations("abcde","");

        Assert.assertEquals(testPermutation.getPermutations().size(),120);


    }
}
