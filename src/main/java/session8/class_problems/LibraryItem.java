import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class LibraryItemBase {
    protected String title;

    LibraryItemBase(String title) {
        this.title = title;
    }

    abstract int getBorrowingDays();

    abstract String getType();

    String getDueDate() {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        LocalDate dueDate = currentDate.plusDays(getBorrowingDays());

        return dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

class Book extends LibraryItemBase {

    Book(String title) {
        super(title);
    }

    @Override
    int getBorrowingDays() {
        return 14;
    }

    @Override
    String getType() {
        return "BOOK";
    }
}

class DVD extends LibraryItemBase {

    DVD(String title) {
        super(title);
    }

    @Override
    int getBorrowingDays() {
        return 7;
    }

    @Override
    String getType() {
        return "DVD";
    }
}

class Magazine extends LibraryItemBase {

    Magazine(String title) {
        super(title);
    }

    @Override
    int getBorrowingDays() {
        return 3;
    }

    @Override
    String getType() {
        return "MAGAZINE";
    }
}

public class LibraryItem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of borrowed items: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<LibraryItemBase> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nItem " + (i + 1));

            System.out.print("Enter item type (BOOK/DVD/MAGAZINE): ");
            String type = sc.nextLine();

            System.out.print("Enter item title: ");
            String title = sc.nextLine();

            if (type.equals("BOOK")) {
                items.add(new Book(title));
            }
            else if (type.equals("DVD")) {
                items.add(new DVD(title));
            }
            else if (type.equals("MAGAZINE")) {
                items.add(new Magazine(title));
            }
        }

        System.out.println("\n--- Due Dates ---");

        for (LibraryItemBase item : items) {
            System.out.println(
                item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}