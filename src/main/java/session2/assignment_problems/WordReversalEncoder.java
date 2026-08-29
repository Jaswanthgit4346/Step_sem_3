package session2.assignment_problems;

import java.util.Scanner;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reversedWord = new StringBuilder();

            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }

            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        String result = reverseEachWord(sentence);

        System.out.println();
        System.out.println("======================================");
        System.out.println("        WORD REVERSAL ENCODER");
        System.out.println("======================================");
        System.out.println("Original : " + sentence);
        System.out.println("Reversed : " + result);
        System.out.println("======================================");

        sc.close();
    }
}