import java.util.ArrayList;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
    abstract String getType();

    double calculateInsurance() {
        return 0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40 + (10 * weight);
    }

    @Override
    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 80 + (15 * weight);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Parcel> parcels = new ArrayList<>();

        System.out.print("Enter number of parcels: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nParcel " + (i + 1));

            System.out.print("Enter type (STANDARD/EXPRESS/FRAGILE): ");
            String type = sc.next();

            System.out.print("Enter weight in kg: ");
            double weight = sc.nextDouble();

            System.out.print("Enter declared value: ");
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, declaredValue);
            }
            else if (type.equals("EXPRESS")) {
                parcel = new ExpressParcel(weight, declaredValue);
            }
            else if (type.equals("FRAGILE")) {
                parcel = new FragileParcel(weight, declaredValue);
            }
            else {
                System.out.println("Invalid parcel type.");
                i--;
                continue;
            }

            parcels.add(parcel);
        }

        double grandTotal = 0;

        System.out.println("\n--- Parcel Shipping Report ---");

        for (Parcel parcel : parcels) {

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            grandTotal = grandTotal + total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                parcel.getType(),
                charge,
                insurance,
                total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}