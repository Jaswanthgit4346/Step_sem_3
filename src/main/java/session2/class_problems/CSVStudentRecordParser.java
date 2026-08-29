package session2.class_problems;

import java.util.Scanner;

public class CSVStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        System.out.println();
        System.out.println("======================================");
        System.out.println("       STUDENT RECORD");
        System.out.println("======================================");

        if (fields.length != 3) {

            System.out.println("Invalid Record");

        } else {

            String name = fields[0].trim();
            String rollNumber = fields[1].trim();
            String department = fields[2].trim();

            System.out.println("Name    : " + name);
            System.out.println("Roll No : " + rollNumber);
            System.out.println("Dept    : " + department);
        }

        System.out.println("======================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record (Name,RollNumber,Department): ");
        String csvLine = sc.nextLine();

        parseStudentRecord(csvLine);

        sc.close();
    }
}