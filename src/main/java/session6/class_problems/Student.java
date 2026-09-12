import java.util.Scanner;

class Student {
    String name;
    double attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student " + (i + 1) + " name: ");
            String name = sc.nextLine();

            System.out.print("Enter attendance: ");
            double attendance = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(name, attendance);
        }

        System.out.println("\nCollege Information:");
        Student.printCollegeInfo();

        sc.close();
    }
}