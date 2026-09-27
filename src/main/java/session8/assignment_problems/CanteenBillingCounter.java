import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();

    abstract String getType();
}

class Student extends Customer {

    Student(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {

    Staff(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {

    Guest(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10;
    }

    @Override
    String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bills: ");
        int n = sc.nextInt();

        HashMap<String, Function<Double, Customer>> factory =
                new HashMap<>();

        factory.put("STUDENT", Student::new);
        factory.put("STAFF", Staff::new);
        factory.put("GUEST", Guest::new);

        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nBill " + (i + 1));

            System.out.print(
                "Enter customer type (STUDENT/STAFF/GUEST): "
            );
            String type = sc.next();

            System.out.print("Enter bill amount: ");
            double amount = sc.nextDouble();

            Customer customer = factory.get(type).apply(amount);

            customers.add(customer);
        }

        double total = 0;

        System.out.println("\n--- Bill Details ---");

        for (Customer customer : customers) {

            double finalAmount = customer.calculateFinalAmount();

            total += finalAmount;

            System.out.printf(
                "%s: %.2f%n",
                customer.getType(),
                finalAmount
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}