import java.util.ArrayList;
import java.util.Scanner;

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    @Override
    String getType() {
        return "BUS";
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        double baseFare = 1.50 + (0.20 * distance);
        return baseFare * peakHourFactor;
    }

    @Override
    String getType() {
        return "METRO";
    }
}

public class TransportFareCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of passengers: ");
        int n = sc.nextInt();

        ArrayList<Transport> transports = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nPassenger " + (i + 1));

            System.out.print("Enter transport type (BUS/TRAIN/METRO): ");
            String type = sc.next();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            if (type.equalsIgnoreCase("BUS")) {

                transports.add(new Bus(distance));

            } else if (type.equalsIgnoreCase("TRAIN")) {

                transports.add(new Train(distance));

            } else if (type.equalsIgnoreCase("METRO")) {

                System.out.print("Enter peak hour factor: ");
                double factor = sc.nextDouble();

                transports.add(new Metro(distance, factor));
            }
        }

        double total = 0;

        System.out.println("\n--- Transport Fare Results ---");

        for (Transport transport : transports) {

            double fare = transport.calculateFare();

            total += fare;

            System.out.printf(
                "%s: %.2f%n",
                transport.getType(),
                fare
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}