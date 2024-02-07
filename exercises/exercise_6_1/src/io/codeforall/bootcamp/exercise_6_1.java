package io.codeforall.bootcamp;

public class exercise_6_1 {
public static void main (String[] args) {
    int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};
    int sum = 999999;
    int compare;
    int num1 = 0;
    int num2= 0;

    for (int i= 0; i < myArray.length-1; i++) { // while length is true, count 1
        compare = myArray[i] - myArray[i + 1];
        compare = Math.abs(compare);

        if (compare < sum) {
            sum = compare;
            num1 = myArray[i];
            num2 = myArray[i + 1];
        }
        ;
    }
    System.out.println("the smallest neighbors are " + num1 + " and " + num2);
}}
