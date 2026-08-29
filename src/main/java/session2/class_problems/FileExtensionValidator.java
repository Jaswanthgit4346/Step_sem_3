package session2.class_problems;

import java.util.Scanner;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {

        int dotPosition = filename.lastIndexOf('.');

        if (dotPosition == -1 || dotPosition == filename.length() - 1) {
            return "Rejected - invalid file type";
        }

        String extension = filename.substring(dotPosition + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {

            return "Accepted";

        } else {

            return "Rejected - invalid file type";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        String result = validateFileExtension(filename);

        System.out.println();
        System.out.println("======================================");
        System.out.println("       FILE EXTENSION VALIDATOR");
        System.out.println("======================================");
        System.out.println(result);
        System.out.println("======================================");

        sc.close();
    }
}