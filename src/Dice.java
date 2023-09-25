import java.util.SplittableRandom;

public class Dice {
    private int diceAmount;
    private int diceFaceAmount;

    public DiceThrow DiceThrow() {
        DiceThrow dt = new DiceThrow(this);
        return dt;
    }

    public Dice(int _diceAmount, int _diceFaceAmount) {
        diceAmount = _diceAmount;
        diceFaceAmount = _diceFaceAmount;
    }

    public class DiceThrow {
        public final int[] individualResults; // Final variables can not be changed! Therefor we dont need uneccassary functions like getSum(), getEns(), etc..
        public final int addedResult;
        public final boolean dieFacesEqual;
        public DiceThrow(Dice _dice) {
            individualResults = new int[_dice.diceAmount];
            for (int i = 0; i < diceAmount; i++) {
                individualResults[i] = new SplittableRandom().nextInt(1, diceFaceAmount+1);
            }
            addedResult = addResult(individualResults);
            dieFacesEqual = calculateDieFaceEqual(individualResults);
        }

        private int addResult(int[] resArray) {
            int addedRes = 0;
            for (int res : resArray) {
                addedRes += res;
            }
            return addedRes;
        }
        
        private boolean calculateDieFaceEqual(int[] resArray) {
            for (int i = 1; i < resArray.length; i++) {
                if (individualResults[i] != individualResults[i-1]) // Check if they are NOT equal!
                {
                    return false;
                }
            }
            return true;
        }
    }
}
