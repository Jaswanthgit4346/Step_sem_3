
package main.java.session1.assignment_problems;

import java.util.Scanner;

public class MultiplicationTableGenerator {

    static void generateFirstValidTable(int[] candidates) {

        for (int i = 0; i < candidates.length; i++) {

            int number = candidates[i];

            if (number < 1) {
                System.out.println("Skipping invalid number: " + number);
                continue;
            }

            for (int j = 1; j <= 10; j++) {
                System.out.println(number + " x " + j + " = " + (number * j));
            }

            break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter candidate " + (i + 1) + ": ");
            candidates[i] = sc.nextInt();
        }

        generateFirstValidTable(candidates);

        sc.close();
    }
}

