import java.util.ArrayList;
import java.util.Scanner;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class Circle extends Plot {
    private double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    private double length;
    private double width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    private double base;
    private double height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Plot> plots = new ArrayList<>();

        System.out.print("Enter number of plots: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nPlot " + (i + 1));

            System.out.print("Enter shape (CIRCLE/RECTANGLE/TRIANGLE): ");
            String shape = sc.next();

            System.out.print("Enter owner name: ");
            String owner = sc.next();

            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    System.out.print("Enter radius: ");
                    double radius = sc.nextDouble();
                    plot = new Circle(owner, radius);
                    break;

                case "RECTANGLE":
                    System.out.print("Enter length: ");
                    double length = sc.nextDouble();

                    System.out.print("Enter width: ");
                    double width = sc.nextDouble();

                    plot = new Rectangle(owner, length, width);
                    break;

                case "TRIANGLE":
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();

                    System.out.print("Enter height: ");
                    double height = sc.nextDouble();

                    plot = new Triangle(owner, base, height);
                    break;

                default:
                    System.out.println("Invalid shape.");
                    i--;
                    continue;
            }

            plots.add(plot);
        }

        double totalArea = 0;

        System.out.println("\n--- Garden Plot Area Report ---");

        for (Plot plot : plots) {
            double area = plot.calculateArea();
            totalArea += area;

            System.out.printf(
                "%s (%s): %.2f%n",
                plot.owner,
                plot.getShape(),
                area
            );
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}