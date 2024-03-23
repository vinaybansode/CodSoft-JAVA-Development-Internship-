package Task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int i;
        int k=8; //Number of attempts
        int min=1;
        int max=100;
        int rounds=0;
        int score=0;
        boolean playAgain=true;

        while(playAgain) {
            int randomNum=random.nextInt(max-min+1)+min;
            for (i = 0; i < k; i++)
            {
                // int randomNum=random.nextInt(max-min+1)+max;
                System.out.println("Guess a number between 1 to 100: ");
                int guessNumber = scanner.nextInt();

                if (guessNumber > randomNum) {
                    System.out.println("Number is too high");
                } else if (guessNumber < randomNum) {
                    System.out.println("Number is too low");
                } else if (guessNumber == randomNum) {
                    System.out.println("Congralutaions! You guessed the correct number.");
                    score += 1;
                    break;
                }
                else {
                    System.out.println("Invalid Choice");
                }
            }

            if (i>=k) {
                // System.out.println("You have exhausted "+ k +" trials.");
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + randomNum);
            }

            rounds += 1;

            System.out.println("Do you want to play again? (Yes/No): ");
            String playAgainInput=scanner.next();
            playAgain=playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.printf("\n Game Over!\nRounds Played: %d\nScore: %d\n", rounds, score);
        scanner.close();
    }
}
