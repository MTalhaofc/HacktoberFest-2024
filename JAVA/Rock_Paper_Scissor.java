import java.util.Scanner;
import java.util.Random;

public class Rock_Paper_Scissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice (Rock, Paper, Scissors): ");
        
        String playerChoice = scanner.nextLine();
        playerChoice = playerChoice.substring(0, 1).toUpperCase() + playerChoice.substring(1).toLowerCase(); // Normalize input
        
        if (!playerChoice.equals("Rock") && !playerChoice.equals("Paper") && !playerChoice.equals("Scissors")) {
            System.out.println("Invalid choice! Please choose Rock, Paper, or Scissors.");
        } else {
            int computerChoiceIndex = random.nextInt(3);
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chose: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                       (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                       (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }

        scanner.close();
    }
}
