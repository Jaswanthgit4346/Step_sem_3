import java.util.ArrayList;
import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return (getPower() * hours) / 1000;
    }
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {

    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }

    String getType() {
        return "AC";
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }

    String getType() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Appliance> appliances = new ArrayList<>();
        ArrayList<Boolean> saverList = new ArrayList<>();

        System.out.print("Enter number of appliances: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nAppliance " + (i + 1));

            System.out.print("Enter appliance (FRIDGE/AC/TV/WASHER): ");
            String type = sc.next();

            System.out.print("Enter hours used: ");
            double hours = sc.nextDouble();

            System.out.print("Enter SAVER if required, otherwise NO: ");
            String saver = sc.next();

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            }
            else if (type.equals("AC")) {
                appliance = new AC(hours);
            }
            else if (type.equals("TV")) {
                appliance = new TV(hours);
            }
            else if (type.equals("WASHER")) {
                appliance = new Washer(hours);
            }
            else {
                System.out.println("Invalid appliance.");
                i--;
                continue;
            }

            appliances.add(appliance);
            saverList.add(saver.equals("SAVER"));
        }

        double totalCost = 0;

        System.out.println("\n--- Home Appliance Energy Report ---");

        for (int i = 0; i < appliances.size(); i++) {

            Appliance appliance = appliances.get(i);
            boolean saverRequested = saverList.get(i);

            if (saverRequested && !(appliance instanceof SaverMode)) {

                System.out.println(
                    appliance.getType() + ": saver mode not supported"
                );

                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested) {
                SaverMode saver = (SaverMode) appliance;
                units = saver.applySaver(units);
            }

            double cost = units * 8;

            totalCost = totalCost + cost;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getType(),
                units,
                cost
            );
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}