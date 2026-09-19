import java.util.Scanner;

public class Quiz_Score_Board {
    private final boolean[] answers;
    private int answerCount;
    private int score;

    public Quiz_Score_Board(int totalQuestions) {
        answers = new boolean[totalQuestions];
        answerCount = 0;
        score = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (answerCount < answers.length) {
            answers[answerCount] = isCorrect;
            answerCount++;

            if (isCorrect) {
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int totalQuestions = sc.nextInt();

        Quiz_Score_Board scoreBoard = new Quiz_Score_Board(totalQuestions);

        for (int i = 0; i < totalQuestions; i++) {
            System.out.print("Enter result for question " + (i + 1)
                    + " (true/false): ");
            boolean result = sc.nextBoolean();

            scoreBoard.recordAnswer(result);
        }

        System.out.println("Final Score = " + scoreBoard.getScore());

        sc.close();
    }
}