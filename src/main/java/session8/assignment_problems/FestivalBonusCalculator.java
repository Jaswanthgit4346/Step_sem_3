import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();

    String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {

    Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        HashMap<String, Function<String[], Employee>> factory = new HashMap<>();

        factory.put("FULLTIME",
                data -> new FullTimeEmployee(data[0], Double.parseDouble(data[1])));

        factory.put("PARTTIME",
                data -> new PartTimeEmployee(data[0], Double.parseDouble(data[1])));

        factory.put("INTERN",
                data -> new Intern(data[0], Double.parseDouble(data[1])));

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter employee type (FULLTIME/PARTTIME/INTERN): ");
            String type = sc.next();

            System.out.print("Enter employee name: ");
            String name = sc.next();

            System.out.print("Enter monthly salary: ");
            double salary = sc.nextDouble();

            String[] data = {name, String.valueOf(salary)};

            Employee employee = factory.get(type).apply(data);

            employees.add(employee);
        }

        double totalBonus = 0;

        System.out.println("\n--- Festival Bonus Details ---");

        for (Employee employee : employees) {

            double bonus = employee.calculateBonus();

            totalBonus += bonus;

            System.out.printf("%s: %.2f%n",
                    employee.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}