import java.util.Scanner;

public class Locker {

    private final int lockerNumber;
    private String combination;

    // Constructor
    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    // Change combination only if old combination is correct
    public void changeCode(String currentCode, String newCode) {

        if (combination.equals(currentCode)) {
            combination = newCode;
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Code change rejected.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter locker number: ");
        int lockerNumber = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter current code: ");
        String combination = sc.nextLine();

        Locker locker = new Locker(lockerNumber, combination);

        System.out.print("Enter current code to change: ");
        String currentCode = sc.nextLine();

        System.out.print("Enter new code: ");
        String newCode = sc.nextLine();

        locker.changeCode(currentCode, newCode);

        System.out.print("Enter current code to change again: ");
        currentCode = sc.nextLine();

        System.out.print("Enter new code: ");
        newCode = sc.nextLine();

        locker.changeCode(currentCode, newCode);

        sc.close();
    }
}