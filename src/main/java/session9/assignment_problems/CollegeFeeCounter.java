import java.util.ArrayList;
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    protected static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    String getName() {
        return name;
    }
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 40000;
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {

    ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 20000;
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print(
                "Enter type (DAY_SCHOLAR/HOSTELLER/SCHOLAR): "
            );
            String type = sc.next();

            System.out.print("Enter student name: ");
            String name = sc.next();

            Student student;

            switch (type) {

                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;

                default:
                    System.out.println("Invalid student type.");
                    i--;
                    continue;
            }

            students.add(student);
        }

        double totalCollected = 0;

        System.out.println("\n--- College Fee Report ---");

        for (Student student : students) {

            double fee = student.calculateFee();

            if (student instanceof BusUser) {
                fee += ((BusUser) student).getTransportFee();
            }

            totalCollected += fee;

            System.out.printf(
                "%s: %.2f%n",
                student.getName(),
                fee
            );
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );

        sc.close();
    }
}