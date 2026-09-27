import java.util.ArrayList;
import java.util.Scanner;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class CardPayment extends Payment {

    CardPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount + (amount * 0.02);
    }

    @Override
    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {

    WalletPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount + (amount * 0.01);
    }

    @Override
    String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {

    BankTransfer(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount;
    }

    @Override
    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        ArrayList<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nTransaction " + (i + 1));

            System.out.print("Enter payment type (CARD/WALLET/BANKTRANSFER): ");
            String type = sc.next();

            System.out.print("Enter transaction amount: ");
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments.add(new CardPayment(amount));
            } 
            else if (type.equals("WALLET")) {
                payments.add(new WalletPayment(amount));
            } 
            else if (type.equals("BANKTRANSFER")) {
                payments.add(new BankTransfer(amount));
            }
        }

        double total = 0;

        System.out.println("\n--- Payment Results ---");

        for (Payment payment : payments) {

            double adjustedAmount = payment.calculateAmount();

            total += adjustedAmount;

            System.out.printf(
                "%s: %.2f%n",
                payment.getType(),
                adjustedAmount
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}