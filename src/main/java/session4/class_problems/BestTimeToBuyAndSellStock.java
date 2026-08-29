package session4.class_problems;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    public static void maxProfit(int[] prices) {

        int minPrice = prices[0];
        int buyDay = 0;

        int maxProfit = 0;
        int sellDay = 0;

        for (int i = 1; i < prices.length; i++) {

            // Find the lowest price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                buyDay = i;
            }

            // Calculate today's profit
            int profit = prices[i] - minPrice;

            // Update maximum profit
            if (profit > maxProfit) {
                maxProfit = profit;
                sellDay = i;
            }
        }

        System.out.println("Buy Day   : " + (buyDay + 1));
        System.out.println("Buy Price : " + minPrice);

        if (maxProfit > 0) {
            System.out.println("Sell Day  : " + (sellDay + 1));
            System.out.println("Sell Price: " + prices[sellDay]);
        } else {
            System.out.println("No profitable transaction");
        }

        System.out.println("Max Profit: " + maxProfit);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        maxProfit(prices);

        sc.close();
    }
}