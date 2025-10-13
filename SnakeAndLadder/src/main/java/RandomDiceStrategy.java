import java.util.Random;

public class RandomDiceStrategy implements DiceStrategy{
    @Override
    public int getPosition() {
        Random random = new Random();
        return 1+random.nextInt(7);
    }
}
