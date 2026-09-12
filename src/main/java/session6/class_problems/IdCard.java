import java.util.Scanner;

class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter books initially issued: ");
        int books = sc.nextInt();

        IdCard ravi = new IdCard(name, books);

        IdCard duplicate = ravi;

        System.out.print("Enter new books issued: ");
        duplicate.booksIssued = sc.nextInt();

        IdCard separate = new IdCard(name, duplicate.booksIssued);

        System.out.println("\nLibrary Card Details:");
        System.out.println("Books issued via first variable: " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));

        sc.close();
    }
}