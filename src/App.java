import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        while (!PlayRound.playRound(player1, player2)) {
            System.out.println("Press Enter to play next round!");
            ScoreCounter.PrintScore(player1, player2);
            input.nextLine(); // Wait for next line
            
        }

        input.close();
    }

}
