package session1.assignment_problems;

import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {

        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (int i = 0; i < words.length; i++) {

            int length = words[i].length();

            if (length <= 4) {
                shortCount++;
            } else if (length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("       WORD LENGTH PROFILE");
        System.out.println("======================================");

        System.out.println("Short  : " + shortCount);
        System.out.println("Medium : " + mediumCount);
        System.out.println("Long   : " + longCount);

        System.out.println("======================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        if (review.trim().isEmpty()) {
            System.out.println("Review cannot be empty.");
        } else {
            classifyWordLengths(review);
        }

        sc.close();
    }
}