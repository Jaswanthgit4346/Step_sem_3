import java.util.Scanner;

public class AttendanceSheet {

    private final String[] students;
    private int presentCount;

    // Constructor
    public AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        presentCount = 0;
    }

    // Mark a student present
    public void markPresent(String name) {

        // Check if student is already present
        if (isPresent(name)) {
            return;
        }

        // Add student if space is available
        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    // Return number of present students
    public int getPresentCount() {
        return presentCount;
    }

    // Check whether a student is present
    public boolean isPresent(String name) {

        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum class size: ");
        int maxStudents = sc.nextInt();

        sc.nextLine();

        AttendanceSheet attendance = new AttendanceSheet(maxStudents);

        System.out.print("Enter number of students to mark present: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            attendance.markPresent(name);
        }

        System.out.println("Present Count = " + attendance.getPresentCount());

        System.out.print("Enter name to check: ");
        String name = sc.nextLine();

        if (attendance.isPresent(name)) {
            System.out.println(name + " is present.");
        } else {
            System.out.println(name + " is not present.");
        }

        sc.close();
    }
}