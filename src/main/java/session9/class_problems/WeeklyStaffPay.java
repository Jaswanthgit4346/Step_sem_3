import java.util.ArrayList;
import java.util.Scanner;

abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Intern extends Staff {
    private double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Staff> staffList = new ArrayList<>();

        System.out.print("Enter number of staff members: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nStaff " + (i + 1));

            System.out.print(
                "Enter type (FULLTIME/HOURLY/INTERN): "
            );
            String type = sc.next();

            System.out.print("Enter name: ");
            String name = sc.next();

            Staff staff;

            switch (type) {

                case "FULLTIME":
                    System.out.print("Enter weekly salary: ");
                    double salary = sc.nextDouble();

                    staff = new FullTimeStaff(name, salary);
                    break;

                case "HOURLY":
                    System.out.print("Enter hours worked: ");
                    double hours = sc.nextDouble();

                    System.out.print("Enter hourly rate: ");
                    double rate = sc.nextDouble();

                    staff = new HourlyStaff(name, hours, rate);
                    break;

                case "INTERN":
                    System.out.print("Enter stipend: ");
                    double stipend = sc.nextDouble();

                    staff = new Intern(name, stipend);
                    break;

                default:
                    System.out.println("Invalid staff type.");
                    i--;
                    continue;
            }

            staffList.add(staff);
        }

        double totalPayroll = 0;

        System.out.println("\n--- Weekly Staff Pay ---");

        for (Staff staff : staffList) {

            double pay = staff.calculatePay();
            totalPayroll += pay;

            System.out.printf(
                "%s: %.2f%n",
                staff.name,
                pay
            );
        }

        System.out.printf(
            "Total Payroll: %.2f%n",
            totalPayroll
        );

        sc.close();
    }
}