import java.util.ArrayList;
import java.util.Scanner;

abstract class ElectricityConnection {
    protected int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class HomeConnection extends ElectricityConnection {

    HomeConnection(int units) {
        super(units);
    }

    @Override
    double calculateBill() {

        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5) + ((units - 100) * 7);
    }

    @Override
    String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {

    ShopConnection(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return (units * 8) + 100;
    }

    @Override
    String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {

    FactoryConnection(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return Math.max(units * 6, 1000);
    }

    @Override
    String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<ElectricityConnection> connections =
                new ArrayList<>();

        System.out.print("Enter number of connections: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nConnection " + (i + 1));

            System.out.print(
                "Enter type (HOME/SHOP/FACTORY): "
            );
            String type = sc.next();

            System.out.print("Enter units used: ");
            int units = sc.nextInt();

            ElectricityConnection connection;

            switch (type) {

                case "HOME":
                    connection = new HomeConnection(units);
                    break;

                case "SHOP":
                    connection = new ShopConnection(units);
                    break;

                case "FACTORY":
                    connection = new FactoryConnection(units);
                    break;

                default:
                    System.out.println("Invalid connection type.");
                    i--;
                    continue;
            }

            connections.add(connection);
        }

        double total = 0;

        System.out.println("\n--- Electricity Bill Report ---");

        for (ElectricityConnection connection : connections) {

            double bill = connection.calculateBill();
            total += bill;

            System.out.printf(
                "%s: %.2f%n",
                connection.getType(),
                bill
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}