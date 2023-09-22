public class PlayRound {

    public static void playRound(Player player1, Player player2) {
        Dice dice = new Dice(2, 6);

        System.out.println("Player ones turn.");
        var throwResultsPlayerOne = dice.DiceThrow();
        System.out.println("Your throw was:");
        System.out.println("Dice 1: " + throwResultsPlayerOne.individualResults[0]);
        System.out.println("Dice 2: " + throwResultsPlayerOne.individualResults[1]);
        System.out.println("The sum of your throw is: " + throwResultsPlayerOne.addedResult);

        System.out.println("Player two's turn.");
        var throwResultsPlayerTwo = dice.DiceThrow();
        System.out.println("Your throw was:");
        System.out.println("Dice 1: " + throwResultsPlayerTwo.individualResults[0]);
        System.out.println("Dice 2: " + throwResultsPlayerTwo.individualResults[1]);
        System.out.println("The sum of your throw is: " + throwResultsPlayerTwo.addedResult);
    }
}