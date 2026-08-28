package main.java.session1.class_problems;

import java.util.Scanner;

public class Palindrome {

    static void checkPalindrome(int number) {

        int originalNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        if (reversedNumber == originalNumber) {
            System.out.println("Is the number " + originalNumber + " a Palindrome? Yes");
        } else {
            System.out.println("Is the number " + originalNumber + " a Palindrome? No");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        checkPalindrome(number);

        sc.close();
    }
}
