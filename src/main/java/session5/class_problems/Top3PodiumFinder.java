import java.util.Arrays;
import java.util.Scanner;

public class Top3PodiumFinder {

    static int[] findTopThreeScores(int[] scores) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {

            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[] {first, second, third};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();

        if (n < 3) {
            System.out.println("At least 3 scores are required.");
            sc.close();
            return;
        }

        int[] scores = new int[n];

        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int[] topThree = findTopThreeScores(scores);

        System.out.println("Top 3 scores: " + Arrays.toString(topThree));

        sc.close();
    }
}