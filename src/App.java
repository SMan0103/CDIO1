

public class App {
    public static void main(String[] args) throws Exception {
       DiceTest();
    }

    public static void DiceTest() {
        
        Dice _diceTest = new Dice(1, 6);
        System.out.println("Testing dice:");
        for (int i = 0; i < 10; i++) {
            Dice.DiceThrow dt = _diceTest.DiceThrow();
            System.out.println("Dice throw {" + i + "} = " + dt.individualResults[0]);
        }

        Dice _diceAdditionTest = new Dice(2, 6);
        System.out.println("Testing dice addition system:");
        for (int i = 0; i < 10; i++) {
            Dice.DiceThrow dt = _diceAdditionTest.DiceThrow();
            System.out.printf("Dice throw {%d} = Dice1:%d, Dice2:%d, Total:%d  %n", i, dt.individualResults[0], dt.individualResults[1], dt.addedResult);
        }
    }

}
