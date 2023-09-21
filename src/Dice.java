import java.util.SplittableRandom;

public class Dice {
    private int dice_amount;
    private int dice_face_amount;

    public DiceThrow diceThrow() {// Dice throw will output as following array: [Total value of faces, Face1, Face2, etc...] eg: [11, 5, 6]
        DiceThrow dt = new DiceThrow(this);
        return dt;
    }

    public Dice(int _dice_amount, int _dice_face_amount) {
        dice_amount = _dice_amount;
        dice_face_amount = _dice_face_amount;
    }

    public class DiceThrow {
        public int[] individualResults;
        public int addedResult;
        public DiceThrow(Dice _dice) {
            individualResults = new int[_dice.dice_amount];
            addedResult = 0;

            for (int i = 0; i < dice_amount; i++) {
                individualResults[i] = new SplittableRandom().nextInt(0, dice_face_amount+1);
                addedResult += individualResults[i];
            }
        }
    }
}
