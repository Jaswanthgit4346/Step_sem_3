import java.util.Scanner;

public class PasswordChecker {

    private final String password;

    // Constructor
    public PasswordChecker(String password) {
        this.password = password;
    }

    // Return only the strength
    public String getStrength() {

        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        PasswordChecker checker = new PasswordChecker(password);

        System.out.println("Password Strength = " + checker.getStrength());

        sc.close();
    }
}