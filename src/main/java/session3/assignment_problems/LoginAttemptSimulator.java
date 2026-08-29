
package session3.assignment_problems;

import java.util.Scanner;

public class LoginAttemptSimulator {

    static void simulateLogin(String correctCode, String[] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                break;
            }

            if (i == attempts.length - 1) {
                System.out.println("Access denied - all attempts used");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter correct access code: ");
        String correctCode = sc.nextLine();

        System.out.print("Enter number of attempts: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] attempts = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = sc.nextLine();
        }

        simulateLogin(correctCode, attempts);

        sc.close();
    }
}
