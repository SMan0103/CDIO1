import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class PlayRound {
    public static boolean performaceTestMode = false; // This is the variable we change when we want to enable performance logging to Test.java
    public static boolean playRound(Player[] playerList, Scanner scanner) { // returns true if game is over
        Dice dice = new Dice(2, 6);

        for (Player _player: playerList) {
            System.out.println();
            System.out.println(_player.playerName + "'s turn.");
            System.out.println("Press Enter to play next round!");
            scanner.nextLine(); // Wait for next line

            Instant beforeThrow = Instant.now();
            var throwResults = dice.DiceThrow();   
            System.out.println("Your throw was:");
            System.out.println("Dice 1: " + throwResults.individualResults[0]);
            System.out.println("Dice 2: " + throwResults.individualResults[1]);
            System.out.println("The sum of your throw is: " + throwResults.addedResult);
            if (performaceTestMode) {
                Instant afterThrow = Instant.now();
                Duration duration = Duration.between( beforeThrow , afterThrow );
                Test.RoundTestTimeCallback(duration.toMillis());
            }
            
            _player.addScore(throwResults.addedResult);
            if (hasWon(_player)) {
                System.out.println(_player.playerName + " Has Won!");
                ScoreCounter.PrintScore(playerList);
                return true; // terminate game
            }
           
        }
        return false;
    
    }

    private static boolean hasWon(Player player) {
        return player.getScore() >= 40;
    }
}