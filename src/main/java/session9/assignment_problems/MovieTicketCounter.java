import java.util.ArrayList;
import java.util.Scanner;

abstract class Ticket {
    protected int count;

    protected static final double CONVENIENCE_FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double calculateTotal() {
        return (getPrice() + CONVENIENCE_FEE) * count;
    }

    abstract String getSeatType();
}

class RegularTicket extends Ticket {

    RegularTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 150;
    }

    @Override
    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {

    PremiumTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 250;
    }

    @Override
    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {

    ReclinerTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 400;
    }

    @Override
    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<>();

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nBooking " + (i + 1));

            System.out.print(
                "Enter seat type (REGULAR/PREMIUM/RECLINER): "
            );
            String seat = sc.next();

            System.out.print("Enter number of tickets: ");
            int count = sc.nextInt();

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;

                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;

                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;

                default:
                    System.out.println("Invalid seat type.");
                    i--;
                    continue;
            }

            tickets.add(ticket);
        }

        double total = 0;

        System.out.println("\n--- Movie Ticket Report ---");

        for (Ticket ticket : tickets) {

            double amount = ticket.calculateTotal();
            total += amount;

            System.out.printf(
                "%s: %.2f%n",
                ticket.getSeatType(),
                amount
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}