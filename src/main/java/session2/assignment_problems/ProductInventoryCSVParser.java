package session2.assignment_problems;

import java.util.Scanner;

public class ProductInventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        System.out.println();
        System.out.println("======================================");
        System.out.println("      PRODUCT INVENTORY RECORD");
        System.out.println("======================================");

        if (fields.length != 3) {

            System.out.println("Invalid Record");

        } else {

            String product = fields[0].trim();
            String sku = fields[1].trim();
            String quantity = fields[2].trim();

            System.out.println("Product : " + product);
            System.out.println("SKU     : " + sku);
            System.out.println("Qty     : " + quantity);
        }

        System.out.println("======================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter inventory record (Product,SKU,Quantity): ");
        String csvLine = sc.nextLine();

        parseInventoryRecord(csvLine);

        sc.close();
    }
}