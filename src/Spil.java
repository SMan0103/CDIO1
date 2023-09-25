import java.util.Scanner;

public class Spil {
    public static void main(String[] args) throws Exception {
        System.out.println("Players play in turns. Each player throws two, six sided dice. First player to 40 wins");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name for player 1");
        Player player1 = new Player(input.nextLine());
        System.out.println("Enter Name for player 2");
        Player player2 = new Player(input.nextLine());

        while (!PlayRound.playRound(new Player[]{player1, player2}, input)) {
            ScoreCounter.PrintScore(player1, player2);
            
        }

        input.close();
    }

}
