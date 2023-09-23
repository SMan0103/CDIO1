public class Test {
    public static void main(String[] args) throws Exception {
        InitiateTest();
    }

    public static void InitiateTest() {
        int _diceAmount = 2;
        int _diceFaceAmount = 6;
        Dice _dice = new Dice(_diceAmount, _diceFaceAmount);

        int[] frequencyCounter = new int[_diceFaceAmount];
        int[] frequencyCounterTotal = new int[_diceFaceAmount*_diceAmount];
        int frequencySameValue = 0;

        for (int i = 0; i < 1000; i++) {
            Dice.DiceThrow dthrow = _dice.DiceThrow();
            
            // TEST THRESHOLD
            for (int a = 0; a < _diceAmount; a++) {
                System.out.println("Test die(" + a + ") face count threshold (1-" + _diceFaceAmount + "): " + dthrow.individualResults[a] + "=" +  ((dthrow.individualResults[a]<_diceFaceAmount+1 && dthrow.individualResults[a]>0) ? "PASS" : "FAIL"));
            }
            
            // TEST ADDITION
            int total = 0;
            for (int a = 0; a < _diceAmount; a++) {
                total += dthrow.individualResults[a];
            }
            System.out.println("Test die addition: " + total +  "=" + dthrow.addedResult + "=" + (total == dthrow.addedResult ? "PASS" : "FAIL"));

            // TEST SAME VALUE
            boolean isSame = true;
            for (int a = 1; a < _diceAmount; a++) {
                isSame = (dthrow.individualResults[a] == dthrow.individualResults[a-1]);
                if (!isSame) {break;}
            }
            System.out.println("Test same value: " + String.valueOf(isSame) + "=" + String.valueOf(dthrow.dieFacesEqual) + "=" + (isSame == dthrow.dieFacesEqual ? "PASS" : "FAIL"));
            System.out.println();

            // ADD NUMBERS TO STATISTICS VARIABLES
            for (int a = 0; a < _diceAmount; a++) {
                frequencyCounter[dthrow.individualResults[a]-1] += 1;
            }
            frequencyCounterTotal[total-1] += 1;
            if (isSame) {frequencySameValue += 1;}

        }

        // LOG STATISTICS DATA
        for (int i = 0; i < _diceFaceAmount; i++) {
            System.out.println("Amount of (" + (i+1) + ") rolled: " + frequencyCounter[i]);
        }

        for (int i = 0; i < _diceFaceAmount*_diceAmount; i++) {
            System.out.println("Amount of added throws (" + (i+1) + ") rolled: " + frequencyCounterTotal[i]);
        }

        System.out.println("Amount of same values rolled: " + frequencySameValue);
    }
}