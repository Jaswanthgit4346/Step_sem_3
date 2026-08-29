package session1.class_problems;

import java.util.Scanner;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("           WELLNESS REPORT");
        System.out.println("==============================================");
        System.out.printf("%-8s %-12s %-13s %-8s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%-8d %-12.2f %-13.2f %-8.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    getBmiStatus(bmi));
        }

        System.out.println("==============================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter height (m): ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight (kg): ");
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);

        sc.close();
    }
}