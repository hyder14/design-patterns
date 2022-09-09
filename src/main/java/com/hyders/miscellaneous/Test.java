package com.hyders.miscellaneous;

import java.util.*;

public class Test {

public static void showMessage() {
    System.out.println("this is :" + Test.class.getName());
}
    public static void
    main(String[] args) {
        //Test test = new Test();
        Test.showMessage();

        for (int i =1; i<=10; i++) {
            //Bitwise operation
            int result = i & 1;
            String msg = String.format("%s: %d", i, result);

            System.out.println(msg);

        }

        System.out.println("Reversing string jane doe");

        System.out.println(Test.reverseString("jane doe"));


        System.out.println("Getting sum for number 987654321");

        System.out.println(Test.getSum(987654321));

        System.out.println("Getting sum for number 987");

        System.out.println(Test.getSum(987));

        System.out.println("Getting sum for number 9");

        System.out.println(Test.getSum(9));

        System.out.println("Getting sum for number 54321");

        System.out.println(Test.getSum(54321));

        System.out.println("Drawing rectangle..");

        Test.drawRectangle(20,10);

        System.out.println("Getting max profit for stock sale..");

        int[] prices = new int[] {100, 180, 260, 310,
                40, 535, 695};
        //System.out.println(Test.calculateMaxProfit(prices));


        System.out.println("Getting next greater element..");


        System.out.println(Test.getNextGreaterElementSingle(prices,3));

        System.out.println(Test.getNextGreaterElementSingle(new int[]{5,4,3,5,6},4));

        Test.getNextGreaterElementArr(new int[]{32,23,12,15,18,29,33,55,66,35,77,99,100});

        System.out.println("Getting maximum difference for int array");
        System.out.println(Test.getMaxDifference(new int[]{32,23,12,15,18,29,33,55,66,35,77,99,100}));

        System.out.println("Getting maximum difference for int array");
        System.out.println(Test.getMaxDifference(new int[]{7, 9, 5, 6, 3, 2}));


        System.out.println("Getting sorted array");
        System.out.println(Test.getNLargestNumbers(new int[]{7, 9, 5, 6, 3, 2},3).toString());


    }


    /**
     * Calculate and return sum of two highest prime numbers for specified input array
     */
    public static int calculateSum(int[] input) {
        int countOfPrimes =0;

        Arrays.sort(input);

        int[] primes = new int[2];

        int max = 0;
        int secondMax = 0;
        for (int j = input.length -1; j>-1; j--) {
            if (isNumberAPrime(input[j])) {
                if (input[j] > max ) {
                    max = input[j];
                    countOfPrimes ++;
                    if (countOfPrimes==2) {
                        break;
                    }

                    primes[countOfPrimes] = input[j];

                }
                else if (countOfPrimes<2) {

                    if (input[j]>secondMax) {

                        secondMax = input[j];
                        countOfPrimes ++;
                        if (countOfPrimes==2) {
                            break;
                        }
                        primes[countOfPrimes] = input[j];

                    }

                }
            }

        }

        int sum = 0;

        if (primes[0] > 1) {
            for (int i =0; i<2;i++) {
                sum += primes[i];
            }
        }


        return sum;
    }



    public static boolean isNumberAPrime(int x) {
        boolean isPrime = true;
        double upperNumber = Math.ceil((double) (x/2));

        for (int i= 2; i<=upperNumber; i++) {

            if(x%i==0) {
                isPrime=false;
                break;
            }

        }
        return isPrime;
    }



    public static String reverseString(String charString) {
        StringBuilder sb = new StringBuilder();

        for (int i=charString.length()-1; i>=0; i--) {
            sb.append(charString.charAt(i));
        }

        return sb.toString();

    }


    public static int getSum(int number) {

        int sum = 0;
        if (number<10) {
            sum = number;
        } else {
            while(number>0){
                sum+= number%10;
                number=number/10;
            }
        }
        return sum;
    }

    public static void drawRectangle(int length, int width){


        for (int i=0;i<length;i++){
            System.out.print("=");
        }
        System.out.println("");
        for (int i=0;i<width;i++){
            System.out.print("=");
            for(int j=1;j<length-1;j++) {
                System.out.print("*");
            }
            System.out.print("=");
            System.out.println("");
        }
        for (int i=0;i<length;i++){
            System.out.print("=");

        }



    }

    public static void drawPyramid(){

    }


    public static int calculateMaxProfit(int[] prices) {

//        {100, 180, 260, 310, 40, 535, 695}

        int buyingPrice=0;
        int sellingPrice=0;

        int maxProfit = 0;

        List<Integer> profits = new ArrayList<>();
        int profit =0;
        int counter =0;
        for (int i=counter;i<prices.length-1;i++){

//            if ((i+1)%3==1){
                buyingPrice=prices[i];
                sellingPrice=prices[i+1];
                if (sellingPrice>buyingPrice) {
                        profit+=sellingPrice-buyingPrice;
                        i+=1;
                }

                if(prices.length-i<=1) {
                    profits.add(profit);
                    profit=0;
                    counter+=1;
                    i=counter;
                }
//               maxProfit = Math.max(sellingPrice-buyingPrice,maxProfit);
//            }
        }

        Collections.sort(profits);
        maxProfit=profits.get(profits.size()-1);

        return maxProfit;
    }


    /**
     * Given an array and element, the method will determine next greater element
     *
     */
    public static int getNextGreaterElementSingle(int[] arr, int index) {


        if (index==arr.length) {
            return -1;
        }

        for (int i = index+1;i<arr.length;i++) {

            if (arr[i]>arr[index]) {

                return arr[i];
            } else {
                continue;
            }

        }

        return -1;

    }

    public static void getNextGreaterElementArr(int[] arr) {

        for (int i=0;i<arr.length;i++){
            int retVal = -1;
            for (int j=i+1;j<arr.length;j++){

                if (arr[j]>arr[i]){

                    retVal = arr[j];
                    break;
                }
            }
            System.out.println(String.format("%1d" +"->" +"%10s",arr[i],retVal));
        }


    }


    public static int getMaxDifference(int[] arr) {

            int maxDiff=0;

            for (int i=0; i<arr.length; i++) {
                int element=arr[i];
                for (int j=i+1;j<arr.length;j++) {

                    if (arr[j]-element>maxDiff) {
                        maxDiff=arr[j]-element;
                    }

                }
            }

            return maxDiff;
    }


    /**
     * k largest or smallest elements
     */
    public static int[] getNLargestNumbers(int[] arr, int k) {

        if (k>arr.length) {
            return new int[]{-1};
        }

        int[] tempArr = new int[k];

        for (int l=0;l<k;l++){
            tempArr[l]=0;
        }
//{6,5,4,3,7}
        int[] copyArray = Arrays.copyOf(arr,arr.length);
        int counter=0;
        for (int j=0;j<arr.length;j++) {
            int elem = arr[j];
            int currentElemIndex=j;
            for (int i=0;i<arr.length;i++) {
                if (arr[i]<elem){
                    int lesserVal = arr[i];
                    arr[currentElemIndex]=lesserVal;
                    arr[i]=elem;
                    currentElemIndex=i;

                    if (i+1<arr.length && arr[i+1]<elem) {
                        lesserVal=arr[i+1];
                        arr[currentElemIndex]=lesserVal;
                        arr[i+1]=elem;
                        currentElemIndex=i+1;
                    }

                }
            }
            if (j>currentElemIndex) {
                j=currentElemIndex-1;
            }
        }

            return arr;


    }

}
