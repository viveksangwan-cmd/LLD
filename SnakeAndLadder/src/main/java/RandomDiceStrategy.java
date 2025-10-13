import java.util.Random;

public class RandomDiceStrategy implements DiceStrategy{
    @Override
    public int getPosition() {
        Random random = new Random();
        return random.nextInt(7);
    }
}
