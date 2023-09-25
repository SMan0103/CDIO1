
import java.util.Scanner;
public class Test {
    public static void main(String[] args) throws Exception {
        InitiateDiceTest();
        InitiateRoundTimeTest();
    }

    public static void InitiateRoundTimeTest() {
        Scanner scn = new Scanner(System.in);
        Player pl1 = new Player("pl1");
        Player pl2 = new Player("pl2");

        PlayRound.performaceTestMode = true;
        System.out.println("Performance test mode enabled. Please press enter twice to compelete a single round of play like normal, and measure performance.");
        PlayRound.playRound(new Player[]{pl1,pl2}, scn);
    
    }
    public static void RoundTestTimeCallback(long duration) {
        System.out.println();
        System.out.println("Time elapsed between dice throw and output of result: " + duration + " ms");
        System.out.println();
    }

    public static void InitiateDiceTest() {
        int _diceAmount = 2;
        int _diceFaceAmount = 6;
        Dice _dice = new Dice(_diceAmount, _diceFaceAmount);

        int[] frequencyCounter = new int[_diceFaceAmount];
        int[] frequencyCounterTotal = new int[_diceFaceAmount*_diceAmount];
        int frequencySameValue = 0;

        int amt_run = 1000;
        int amt_errors = 0;

        for (int i = 0; i < amt_run; i++) {
            Dice.DiceThrow dthrow = _dice.DiceThrow();
            
            // TEST THRESHOLD
            for (int a = 0; a < _diceAmount; a++) {
                boolean passRequirementThreshold = dthrow.individualResults[a]<_diceFaceAmount+1 && dthrow.individualResults[a]>0;
                System.out.println("Test die(" + a + ") face count threshold (1-" + _diceFaceAmount + "): " + dthrow.individualResults[a] + "=" +  ((passRequirementThreshold) ? "PASS" : "FAIL"));
                if (!passRequirementThreshold) {amt_errors++;};
            }
            
            // TEST ADDITION
            int total = 0;
            for (int a = 0; a < _diceAmount; a++) {
                total += dthrow.individualResults[a];
            }
            boolean passRequirementAddedResult = total == dthrow.addedResult;
            System.out.println("Test die addition: " + total +  "=" + dthrow.addedResult + "=" + (passRequirementAddedResult ? "PASS" : "FAIL"));
            if (!passRequirementAddedResult) {amt_errors++;};

            // TEST SAME VALUE
            boolean isSame = true;
            for (int a = 1; a < _diceAmount; a++) {
                isSame = (dthrow.individualResults[a] == dthrow.individualResults[a-1]);
                if (!isSame) {break;}
            }
            boolean passRequirementSame = isSame == dthrow.dieFacesEqual;
            System.out.println("Test same value: " + String.valueOf(isSame) + "=" + String.valueOf(dthrow.dieFacesEqual) + "=" + (passRequirementSame ? "PASS" : "FAIL"));
            System.out.println();
            if (!passRequirementSame) {amt_errors++;};

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

        System.out.println("\nTotal errors for (" + amt_run + ") rolls: " + amt_errors + "=" + (amt_errors == 0 ? "PASS" : "FAIL"));
    }
}