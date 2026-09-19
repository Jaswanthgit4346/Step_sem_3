import java.util.Scanner;

public class ShoppingCart {

    private final String cartId;
    private final double[] prices;
    private int itemCount;

    // Constructor
    public ShoppingCart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    // Add item price
    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    // Calculate total
    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }

        return total;
    }

    // Return number of items
    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart ID: ");
        String cartId = sc.nextLine();

        System.out.print("Enter maximum number of items: ");
        int maxItems = sc.nextInt();

        ShoppingCart cart = new ShoppingCart(cartId, maxItems);

        System.out.print("Enter number of items to add: ");
        int n = sc.nextInt();

        // Do not accept more items than the maximum capacity
        if (n > maxItems) {
            System.out.println("Only " + maxItems
                    + " items can be added.");
            n = maxItems;
        }

        for (int i = 0; i < n; i++) {

            System.out.print("Enter price of item " + (i + 1) + ": ");
            double price = sc.nextDouble();

            cart.addItem(price);
        }

        System.out.println("Item Count = " + cart.getItemCount());
        System.out.println("Total = " + cart.getTotal());

        sc.close();
    }
}