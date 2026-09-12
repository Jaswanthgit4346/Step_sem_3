import java.util.Scanner;

class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();

        BookInventory[] books = new BookInventory[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter book title: ");
            String title = sc.nextLine();

            System.out.print("Enter author: ");
            String author = sc.nextLine();

            System.out.print("Enter copies available: ");
            int copies = sc.nextInt();
            sc.nextLine();

            books[i] = new BookInventory(title, author, copies);
        }

        System.out.println("\nLibrary Inventory:");

        for (BookInventory book : books) {
            book.printEntry();
        }

        sc.close();
    }
}