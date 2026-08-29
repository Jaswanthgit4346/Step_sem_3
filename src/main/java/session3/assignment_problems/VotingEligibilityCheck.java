package session3.assignment_problems;
import java.util.Scanner;

public class VotingEligibilityCheck {

    static void checkVotingEligibility(int age) {
        boolean eligible = age >= 18;

        if (eligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        checkVotingEligibility(age);

        sc.close();
    }}

