import java.util.ArrayList;
import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();

    abstract String getType();
}

class MCQ extends Question {

    MCQ(String questionText, String correctAnswer,
        String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }

    @Override
    String getType() {
        return "MCQ";
    }
}

class TrueFalse extends Question {

    TrueFalse(String questionText, String correctAnswer,
              String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }

    @Override
    String getType() {
        return "TF";
    }
}

class Essay extends Question {

    Essay(String questionText, String correctAnswer,
          String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    @Override
    String getType() {
        return "ESSAY";
    }
}

public class QuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("\nQuestion " + (i + 1));

            System.out.print("Enter question type (MCQ/TF/ESSAY): ");
            String type = sc.nextLine();

            System.out.print("Enter question: ");
            String questionText = sc.nextLine();

            System.out.print("Enter correct answer: ");
            String correctAnswer = sc.nextLine();

            System.out.print("Enter student answer: ");
            String studentAnswer = sc.nextLine();

            System.out.print("Enter points: ");
            double points = sc.nextDouble();
            sc.nextLine();

            if (type.equalsIgnoreCase("MCQ")) {

                questions.add(
                    new MCQ(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    )
                );

            } else if (type.equalsIgnoreCase("TF")) {

                questions.add(
                    new TrueFalse(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    )
                );

            } else if (type.equalsIgnoreCase("ESSAY")) {

                questions.add(
                    new Essay(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    )
                );
            }
        }

        double totalScore = 0;

        System.out.println("\n--- Grading Results ---");

        for (Question question : questions) {

            double score = question.calculateScore();

            totalScore += score;

            System.out.printf(
                "%s: %.2f%n",
                question.getType(),
                score
            );
        }

        System.out.printf(
            "Total Score: %.2f%n",
            totalScore
        );

        sc.close();
    }
}