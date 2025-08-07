import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalRounds = 0;
        int totalScore = 0;
        String playAgain;

        System.out.println(" Welcome to the Number Guessing Game!");

        do {
            totalRounds++;
            int numberToGuess = rand.nextInt(100) + 1; 
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 7;
            int score = 0;

            System.out.println("\n Round " + totalRounds + " started!");
            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            while (guess != numberToGuess && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                if (sc.hasNextInt()) {
                    guess = sc.nextInt();
                    attempts++;

                    if (guess < 1 || guess > 100) {
                        System.out.println(" Please enter a number between 1 and 100.");
                        continue;
                    }

                    if (guess < numberToGuess) {
                        System.out.println(" Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        System.out.println(" Too high! Try again.");
                    } else {
                        System.out.println(" Correct! You guessed it in " + attempts + " attempts.");
                    }
                } else {
                    System.out.println(" Invalid input. Please enter a number.");
                    sc.next(); 
                }
            }

            if (guess == numberToGuess) {
                if (attempts <= 3) score = 100;
                else if (attempts <= 5) score = 70;
                else if (attempts <= 7) score = 50;
            } else {
                System.out.println(" You've run out of attempts. The number was: " + numberToGuess);
                score = 0;
            }

            totalScore += score;
            System.out.println(" Your score for this round: " + score);
            System.out.println(" Total Score so far: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            sc.nextLine(); 
            playAgain = sc.nextLine().toLowerCase();

        } while (playAgain.equals("yes") || playAgain.equals("y"));

        System.out.println("\n Game Over!");
        System.out.println(" Total Rounds Played: " + totalRounds);
        System.out.println(" Final Score: " + totalScore);
        System.out.println(" Thanks for playing!");

        sc.close();
    }
}