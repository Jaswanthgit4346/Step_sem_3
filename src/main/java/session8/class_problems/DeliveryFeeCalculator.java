import java.util.ArrayList;
import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    abstract String getType();
}

class StandardDelivery extends Delivery {

    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {

    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {

    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of delivery requests: ");
        int n = sc.nextInt();

        ArrayList<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nDelivery " + (i + 1));

            System.out.print(
                "Enter delivery type (STANDARD/EXPRESS/INTERNATIONAL): "
            );
            String type = sc.next();

            System.out.print("Enter weight in kg: ");
            double weight = sc.nextDouble();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            if (type.equals("STANDARD")) {

                deliveries.add(
                    new StandardDelivery(weight, distance)
                );

            } else if (type.equals("EXPRESS")) {

                deliveries.add(
                    new ExpressDelivery(weight, distance)
                );

            } else if (type.equals("INTERNATIONAL")) {

                System.out.print("Enter customs fee: ");
                double customsFee = sc.nextDouble();

                deliveries.add(
                    new InternationalDelivery(
                        weight,
                        distance,
                        customsFee
                    )
                );
            }
        }

        double total = 0;

        System.out.println("\n--- Delivery Results ---");

        for (Delivery delivery : deliveries) {

            double fee = delivery.calculateFee();

            total += fee;

            System.out.printf(
                "%s: %.2f%n",
                delivery.getType(),
                fee
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}