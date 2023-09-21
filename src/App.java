import java.util.SplittableRandom;

public class App {
    public static void main(String[] args) throws Exception {
       diceTest();
    }

    public static void diceTest() {
        
        Dice _dice_test = new Dice(1, 6);
        System.out.println("Testing dice:");
        for (int i = 0; i < 10; i++) {
            int[] dt = _dice_test.diceThrow();
            System.out.println("Dice throw {" + i + "} = " + dt[0]);
        }

        Dice _dice_addition_test = new Dice(2, 6);
        System.out.println("Testing dice addition system:");
        for (int i = 0; i < 10; i++) {
            int[] dt = _dice_addition_test.diceThrow();
            System.out.printf("Dice throw {%d} = Dice1:%d, Dice2:%d, Total:%d  %n", i, dt[1], dt[2], dt[0]);
        }
    }

    public static class Dice { 
        private int dice_amount;
        private int dice_face_amount;

        public int[] diceThrow() {// Dice throw will output as following array: [Total value of faces, Face1, Face2, etc...] eg: [11, 5, 6]
            int[] dice_throws = new int[dice_amount + 1];
            for (int i = 0; i < dice_amount; i++) {
                dice_throws[i+1] = new SplittableRandom().nextInt(0, dice_face_amount+1);
                dice_throws[0] += dice_throws[i+1];
            }
            return dice_throws;
        }

        public Dice(int _dice_amount, int _dice_face_amount) {
            dice_amount = _dice_amount;
            dice_face_amount = _dice_face_amount;
        }
    }


    public class player {
        private var player_name;

        public player(String player_name) {
            this.player_name = player_name;
        }
    }
}
