package main.java.session1.class_problems;

import java.util.Scanner;

public class ArmstrongNumber {

    static void checkArmstrong(int number) {

        int originalNumber = number;
        int temp = number;
        int digits = 0;
        int sum = 0;

        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }

        temp = number;

        while (temp != 0) {
            int digit = temp % 10;

            int power = 1;
            for (int i = 1; i <= digits; i++) {
                power = power * digit;
            }

            sum = sum + power;
            temp = temp / 10;
        }

        if (sum == originalNumber) {
            System.out.println("Is the number " + originalNumber
                    + " an Armstrong number? Yes");
        } else {
            System.out.println("Is the number " + originalNumber
                    + " an Armstrong number? No");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        checkArmstrong(number);

        sc.close();
    }
}