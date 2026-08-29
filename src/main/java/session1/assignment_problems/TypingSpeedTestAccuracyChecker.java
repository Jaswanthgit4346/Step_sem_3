package session1.assignment_problems;

import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (double) matched / original.length() * 100;

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       TYPING ACCURACY REPORT");
        System.out.println("==============================================");

        if (firstMismatch == -1) {

            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, original.length(), accuracy);

        } else {

            char originalChar = original.charAt(firstMismatch);
            char typedChar = typed.charAt(firstMismatch);

            System.out.printf(
                    "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched,
                    original.length(),
                    accuracy,
                    firstMismatch + 1,
                    originalChar,
                    typedChar);
        }

        System.out.println("==============================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        if (original.length() != typed.length()) {
            System.out.println("Error: Both texts must have equal length.");
        } else {
            checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}