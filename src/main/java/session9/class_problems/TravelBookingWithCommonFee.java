import java.util.ArrayList;
import java.util.Scanner;

abstract class TravelBooking {

    protected double distanceKm;

    private static final double BOOKING_FEE = 50;

    TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateBaseFare();

    abstract String getMode();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {

    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return distanceKm * 2;
    }

    @Override
    String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {

    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {

    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return 2500 + (distanceKm * 4);
    }

    @Override
    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingWithCommonFee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<TravelBooking> bookings = new ArrayList<>();

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nBooking " + (i + 1));

            System.out.print(
                "Enter mode (BUS/TRAIN/FLIGHT): "
            );
            String mode = sc.next();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            TravelBooking booking;

            switch (mode) {

                case "BUS":
                    booking = new BusBooking(distance);
                    break;

                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;

                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;

                default:
                    System.out.println("Invalid travel mode.");
                    i--;
                    continue;
            }

            bookings.add(booking);
        }

        System.out.println("\n--- Travel Booking Report ---");

        for (TravelBooking booking : bookings) {

            double total = booking.calculateTotal();

            System.out.printf(
                "%s: %.2f%n",
                booking.getMode(),
                total
            );
        }

        sc.close();
    }
}