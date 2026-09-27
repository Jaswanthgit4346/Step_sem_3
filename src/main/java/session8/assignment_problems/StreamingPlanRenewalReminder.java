import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

abstract class StreamingPlan {
    protected String name;
    protected LocalDate startDate;

    StreamingPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate calculateRenewalDate();

    String getName() {
        return name;
    }
}

class BasicPlan extends StreamingPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends StreamingPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends StreamingPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subscriptions: ");
        int n = sc.nextInt();

        HashMap<String, Function<String[], StreamingPlan>> factory = new HashMap<>();

        factory.put("BASIC", data ->
                new BasicPlan(
                        data[0],
                        LocalDate.parse(data[1])
                ));

        factory.put("STANDARD", data ->
                new StandardPlan(
                        data[0],
                        LocalDate.parse(data[1])
                ));

        factory.put("PREMIUM", data ->
                new PremiumPlan(
                        data[0],
                        LocalDate.parse(data[1])
                ));

        ArrayList<StreamingPlan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nSubscription " + (i + 1));

            System.out.print(
                    "Enter plan type (BASIC/STANDARD/PREMIUM): "
            );
            String type = sc.next();

            System.out.print("Enter customer name: ");
            String name = sc.next();

            System.out.print("Enter start date (YYYY-MM-DD): ");
            String date = sc.next();

            String[] data = {name, date};

            StreamingPlan plan = factory.get(type).apply(data);

            plans.add(plan);
        }

        System.out.println("\n--- Renewal Details ---");

        for (StreamingPlan plan : plans) {

            LocalDate renewalDate =
                    plan.calculateRenewalDate();

            System.out.printf(
                    "%s: %s%n",
                    plan.getName(),
                    renewalDate
            );
        }

        sc.close();
    }
}