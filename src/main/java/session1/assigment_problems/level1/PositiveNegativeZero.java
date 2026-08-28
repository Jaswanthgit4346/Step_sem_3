
package main.java.session1.assigment_problems.level1;

import java.util.Scanner;

public class PositiveNegativeZero {

    static void classifyNumber(int number) {

        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        classifyNumber(number);

        sc.close();
    }
}

