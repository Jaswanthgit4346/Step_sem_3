import java.util.Scanner;

class CompanyEmployee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        CompanyEmployee[] employees = new CompanyEmployee[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee " + (i + 1) + " name: ");
            String name = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees[i] = new CompanyEmployee(name, salary);
        }

        System.out.println("\nCompany Information:");
        CompanyEmployee.printCompanyInfo();

        sc.close();
    }
}