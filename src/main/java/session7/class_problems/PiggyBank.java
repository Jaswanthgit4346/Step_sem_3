import java.util.Scanner;
public class PiggyBank {
    private double balance;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Withdrawal rejected.");
            return;
        }

        if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Piggy Bank ID: ");
        String id = sc.nextLine();

        PiggyBank pb = new PiggyBank(id);

        System.out.print("Enter deposit amount: ");
        double depositAmount = sc.nextDouble();
        pb.deposit(depositAmount);

        System.out.println("Savings = " + pb.getBalance());

        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = sc.nextDouble();
        pb.withdraw(withdrawalAmount);

        System.out.println("Savings = " + pb.getBalance());

        sc.close();
    }
}