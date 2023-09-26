package Spil;

public class ScoreCounter {
    public static void PrintScore(Player[] playerList){
        for (Player _player: playerList) {
            System.out.println(_player.playerName +", Your score is " + _player.getScore());
        }
    }
}

