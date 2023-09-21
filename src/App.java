

public class App {
    public static void main(String[] args) throws Exception {
       diceTest();
    }

    public static void diceTest() {
        
        Dice _dice_test = new Dice(1, 6);
        System.out.println("Testing dice:");
        for (int i = 0; i < 10; i++) {
            Dice.DiceThrow dt = _dice_test.diceThrow();
            System.out.println("Dice throw {" + i + "} = " + dt.individualResults[0]);
        }

        Dice _dice_addition_test = new Dice(2, 6);
        System.out.println("Testing dice addition system:");
        for (int i = 0; i < 10; i++) {
            Dice.DiceThrow dt = _dice_addition_test.diceThrow();
            System.out.printf("Dice throw {%d} = Dice1:%d, Dice2:%d, Total:%d  %n", i, dt.individualResults[0], dt.individualResults[1], dt.addedResult);
        }
    }

}
