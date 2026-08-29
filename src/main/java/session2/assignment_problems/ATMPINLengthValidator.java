package session2.assignment_problems;

import java.util.Scanner;

public class ATMPINLengthValidator {

    public static void checkPinLength(String pin) {

        if (pin.length() != 4) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        System.out.println();
        System.out.println("======================================");
        System.out.println("         ATM PIN VALIDATOR");
        System.out.println("======================================");

        checkPinLength(pin);

        System.out.println("======================================");

        sc.close();
    }
}