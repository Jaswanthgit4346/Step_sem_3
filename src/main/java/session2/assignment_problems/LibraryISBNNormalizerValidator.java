package session2.assignment_problems;

import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    public static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code.toUpperCase();
        }

        String publisherCode = code.substring(0, 3).toUpperCase();
        String remaining = code.substring(3);

        return publisherCode + remaining;
    }

    public static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < code.length(); i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(publisherCode)
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter library code: ");
        String rawCode = sc.nextLine();

        String normalizedCode = normalizeCode(rawCode);
        String result = validateAndFormat(normalizedCode);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       LIBRARY ISBN VALIDATOR");
        System.out.println("==============================================");
        System.out.println(result);
        System.out.println("==============================================");

        sc.close();
    }
}