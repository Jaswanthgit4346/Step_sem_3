import java.util.Scanner;
class Course_Credit_Management {
     String code;
    String title;
    int credits;
    int labCredits;

    public Course_Credit_Management(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course_Credit_Management(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter theory course code: ");
        String code1 = sc.nextLine();

        System.out.print("Enter theory course title: ");
        String title1 = sc.nextLine();

        System.out.print("Enter theory course credits: ");
        int credits1 = sc.nextInt();
        sc.nextLine();

        Course_Credit_Management theoryCourse = new Course_Credit_Management(code1, title1, credits1);

        System.out.print("Enter lab course code: ");
        String code2 = sc.nextLine();

        System.out.print("Enter lab course title: ");
        String title2 = sc.nextLine();

        System.out.print("Enter lab course credits: ");
        int credits2 = sc.nextInt();

        System.out.print("Enter lab credits: ");
        int labCredits = sc.nextInt();

        Course_Credit_Management labCourse = new Course_Credit_Management(code2, title2, credits2, labCredits);

        System.out.println("\nCourse Details:");
        System.out.println(theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());

        sc.close();
    }
}
    

