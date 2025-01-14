package all_projects.Number_Guessing_Game;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        System.out.println("Welcome to the Enhanced Number Guessing Game!");

        do {

            System.out.println("\nSelect Difficulty Level:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-200)");
            System.out.print("Enter your choice (1/2/3): ");
            int difficulty = scanner.nextInt();

            int maxRange = switch (difficulty) {
                case 1 -> 50;
                case 2 -> 100;
                case 3 -> 200;
                default -> {
                    System.out.println("Invalid choice. Defaulting to Medium (1-100).");
                    yield 100;
                }
            };

            int randomNumber = new Random().nextInt(maxRange) + 1;
            int attempts = 0;
            int score = 100; // Start score
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI've picked a random number between 1 and " + maxRange + ". Try to guess it!");


            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                score -= 5;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("\nCongratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                }
            }


            System.out.println("You guessed the number in " + attempts + " attempts.");
            System.out.println("Your score: " + score + " points.");


            System.out.print("\nWould you like to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nThanks for playing! Goodbye!");
        scanner.close();
    }
}

