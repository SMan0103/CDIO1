import java.util.SplittableRandom;

public class App {
    public static void main(String[] args) throws Exception {
       diceTest();
    }

    public static void diceTest() {
        System.out.println("Testing dice:");
        for (int i = 0; i < 10; i++) {
            int dt = diceThrow();
            System.out.println(dt);
        }
    }

    public static int diceThrow() {
        int n = new SplittableRandom().nextInt(0, 7);
        return n;
    }
}
