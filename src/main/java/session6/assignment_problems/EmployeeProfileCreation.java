import java.util.Scanner;

class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter permanent employee ID: ");
        String id1 = sc.nextLine();

        System.out.print("Enter permanent employee name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter permanent employee salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        EmployeeProfile permanentEmployee =
                new EmployeeProfile(id1, name1, salary);

        System.out.print("Enter intern employee ID: ");
        String id2 = sc.nextLine();

        System.out.print("Enter intern employee name: ");
        String name2 = sc.nextLine();

        EmployeeProfile internEmployee =
                new EmployeeProfile(id2, name2);

        System.out.println("\nEmployee Profiles:");
        permanentEmployee.printProfile();
        internEmployee.printProfile();

        sc.close();
    }
}