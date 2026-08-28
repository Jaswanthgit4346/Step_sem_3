
package main.java.session1.assigment_problems.level1;

import java.util.Scanner;

public class OddEvenChecker {

    static void checkOddEven(int number) {

        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        checkOddEven(number);

        sc.close();
    }
}

