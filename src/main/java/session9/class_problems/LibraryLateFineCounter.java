import java.util.ArrayList;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {

    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {

    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return Math.min(daysLate * 5, 50);
    }
}

class Magazine extends LibraryItem {

    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<LibraryItem> items = new ArrayList<>();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nItem " + (i + 1));

            System.out.print(
                "Enter type (BOOK/DVD/MAGAZINE): "
            );
            String type = sc.next();

            System.out.print("Enter title: ");
            String title = sc.next();

            System.out.print("Enter days late: ");
            int daysLate = sc.nextInt();

            LibraryItem item;

            switch (type) {

                case "BOOK":
                    item = new Book(title, daysLate);
                    break;

                case "DVD":
                    item = new DVD(title, daysLate);
                    break;

                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;

                default:
                    System.out.println("Invalid item type.");
                    i--;
                    continue;
            }

            items.add(item);
        }

        double totalFines = 0;

        System.out.println("\n--- Library Late Fine Report ---");

        for (LibraryItem item : items) {

            double fine = item.calculateFine();
            totalFines += fine;

            System.out.printf(
                "%s: %.2f%n",
                item.title,
                fine
            );
        }

        System.out.printf(
            "Total Fines: %.2f%n",
            totalFines
        );

        sc.close();
    }
}