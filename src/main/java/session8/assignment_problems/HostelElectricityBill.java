import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

abstract class Room {
    protected int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class SingleRoom extends Room {

    SingleRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8;
    }

    @Override
    String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6) / occupants;
    }

    @Override
    String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {

    ACRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return (units * 10) + 200;
    }

    @Override
    String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();

        HashMap<String, Function<int[], Room>> factory = new HashMap<>();

        factory.put("SINGLE", data -> new SingleRoom(data[0]));
        factory.put("SHARED", data -> new SharedRoom(data[0], data[1]));
        factory.put("AC", data -> new ACRoom(data[0]));

        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nRoom " + (i + 1));

            System.out.print("Enter room type (SINGLE/SHARED/AC): ");
            String type = sc.next();

            System.out.print("Enter electricity units: ");
            int units = sc.nextInt();

            int occupants = 0;

            if (type.equals("SHARED")) {
                System.out.print("Enter number of occupants: ");
                occupants = sc.nextInt();
            }

            int[] data = {units, occupants};

            Room room = factory.get(type).apply(data);
            rooms.add(room);
        }

        double total = 0;

        System.out.println("\n--- Electricity Bill Details ---");

        for (Room room : rooms) {

            double bill = room.calculateBill();

            total += bill;

            System.out.printf("%s: %.2f%n", room.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}