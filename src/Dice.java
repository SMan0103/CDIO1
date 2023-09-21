import java.util.SplittableRandom;

public class Dice {
    private int diceAmount;
    private int diceFaceAmount;

    public DiceThrow DiceThrow() {// Dice throw will output as following array: [Total value of faces, Face1, Face2, etc...] eg: [11, 5, 6]
        DiceThrow dt = new DiceThrow(this);
        return dt;
    }

    public Dice(int _diceAmount, int _diceFaceAmount) {
        diceAmount = _diceAmount;
        diceFaceAmount = _diceFaceAmount;
    }

    public class DiceThrow {
        public int[] individualResults;
        public int addedResult;
        public DiceThrow(Dice _dice) {
            individualResults = new int[_dice.diceAmount];
            addedResult = 0;

            for (int i = 0; i < diceAmount; i++) {
                individualResults[i] = new SplittableRandom().nextInt(0, diceFaceAmount+1);
                addedResult += individualResults[i];
            }
        }
    }
}
