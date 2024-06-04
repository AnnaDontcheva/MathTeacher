import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userName + "-answers.txt"))) {
            for (int i = 0; i < 5; i++) {
                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);
                int correctAnswer = num1 + num2;

                System.out.print("Question " + (i + 1) + ": " + num1 + " + " + num2 + " = ");
                int userAnswer = scanner.nextInt();

                boolean isCorrect = userAnswer == correctAnswer;

                writer.write("Question: " + num1 + " + " + num2 + " = " + correctAnswer + " " + isCorrect);
                writer.newLine();
            }
            System.out.println("Done! Answers saved in " + userName + "-answers.txt");
        } catch (IOException e) {
            System.err.println("Error!");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
