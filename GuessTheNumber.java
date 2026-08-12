import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0, round = 0;
        String again;

        do {
            round++;
            int number = rand.nextInt(100) + 1;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + round + " ---");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + "/" + maxAttempts + " - Guess (1-100): ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("🎉 Correct! You got it in " + attempt + " attempt(s).");
                    score += Math.max(10 - attempt, 1);
                    guessedCorrectly = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was " + number + ".");
            }

            System.out.println("Score so far: " + score);
            System.out.print("Play again? (y/n): ");
            again = sc.next();

        } while (again.equalsIgnoreCase("y"));

        System.out.println("\nFinal Score: " + score + " after " + round + " round(s). Thanks for playing!");
        sc.close();
    }
}
