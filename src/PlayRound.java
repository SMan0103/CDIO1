public class PlayRound {

    public static boolean playRound(Player player1, Player player2) { // returns true if game is over
        Dice dice = new Dice(2, 6);

        Player[] playerList = {player1, player2};

        for (Player _player: playerList) {
            System.out.println(_player.playerName + "'s turn.");
            var throwResults = dice.DiceThrow();
            System.out.println("Your throw was:");
            System.out.println("Dice 1: " + throwResults.individualResults[0]);
            System.out.println("Dice 2: " + throwResults.individualResults[1]);
            System.out.println("The sum of your throw is: " + throwResults.addedResult);
            _player.addScore(throwResults.addedResult);
            if (hasWon(_player)) {
                System.out.println(_player.playerName + " Has Won!");
                ScoreCounter.PrintScore(player1, player2);
                return true; // terminate game
            }
        }
        return false;
    
    }

    private static boolean hasWon(Player player) {
        return player.getScore() >= 40;
    }
}