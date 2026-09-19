import java.util.Scanner;

public class NameTag {

    private final String firstName;
    private final String lastName;

    // Constructor
    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastName = parts[1];
    }

    // Returns nickname
    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        NameTag tag = new NameTag(fullName);

        System.out.println("Nickname = " + tag.getNickname());

        sc.close();
    }
}