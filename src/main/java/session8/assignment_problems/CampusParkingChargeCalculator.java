import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();

    abstract String getType();
}

class Bike extends Vehicle {

    Bike(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return hours * 10;
    }

    @Override
    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {

    Car(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        if (hours == 1) {
            return 30;
        }

        return 30 + (hours - 1) * 20;
    }

    @Override
    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {

    Truck(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        double charge = hours * 50;

        if (charge < 100) {
            return 100;
        }

        return charge;
    }

    @Override
    String getType() {
        return "TRUCK";
    }
}

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of parked vehicles: ");
        int n = sc.nextInt();

        HashMap<String, Function<Integer, Vehicle>> factory =
                new HashMap<>();

        factory.put("BIKE", Bike::new);
        factory.put("CAR", Car::new);
        factory.put("TRUCK", Truck::new);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nVehicle " + (i + 1));

            System.out.print(
                "Enter vehicle type (BIKE/CAR/TRUCK): "
            );
            String type = sc.next();

            System.out.print("Enter number of hours parked: ");
            int hours = sc.nextInt();

            Vehicle vehicle = factory.get(type).apply(hours);

            vehicles.add(vehicle);
        }

        double total = 0;

        System.out.println("\n--- Parking Charge Details ---");

        for (Vehicle vehicle : vehicles) {

            double charge = vehicle.calculateCharge();

            total += charge;

            System.out.printf(
                "%s: %.2f%n",
                vehicle.getType(),
                charge
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}