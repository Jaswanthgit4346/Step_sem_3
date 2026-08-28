
package main.java.session1.assignment_problems;

import java.util.Scanner;

public class NumberPyramid {

    static void printNumberPyramid(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        printNumberPyramid(n);

        sc.close();
    }
}

