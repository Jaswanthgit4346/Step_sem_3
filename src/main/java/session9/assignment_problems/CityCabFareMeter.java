import java.util.ArrayList;
import java.util.Scanner;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateBaseFare();

    abstract String getType();

    double calculateFare() {
        double fare = calculateBaseFare();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

class MiniCab extends Cab {

    MiniCab(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 10;
    }

    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {

    SedanCab(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 14;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightService {

    SUVCab(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 18;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SUV";
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Cab> cabs = new ArrayList<>();
        ArrayList<String> times = new ArrayList<>();

        System.out.print("Enter number of trips: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nTrip " + (i + 1));

            System.out.print("Enter cab type (MINI/SEDAN/SUV): ");
            String type = sc.next();

            System.out.print("Enter distance in km: ");
            double km = sc.nextDouble();

            System.out.print("Enter time (DAY/NIGHT): ");
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new MiniCab(km);
            }
            else if (type.equals("SEDAN")) {
                cab = new SedanCab(km);
            }
            else if (type.equals("SUV")) {
                cab = new SUVCab(km);
            }
            else {
                System.out.println("Invalid cab type.");
                i--;
                continue;
            }

            cabs.add(cab);
            times.add(time);
        }

        double total = 0;

        System.out.println("\n--- City Cab Fare Report ---");

        for (int i = 0; i < cabs.size(); i++) {

            Cab cab = cabs.get(i);
            String time = times.get(i);

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {

                System.out.println(
                    cab.getType() + ": night service not available"
                );

                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightCharge(fare);
            }

            total = total + fare;

            System.out.printf(
                "%s: %.2f%n",
                cab.getType(),
                fare
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}