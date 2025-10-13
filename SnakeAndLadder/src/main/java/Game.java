import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    static void main() {
        HashMap<Integer,Obstacle> obstacles = new HashMap<>();
        obstacles.put(7,new Obstacle(ObstacleType.LADDER,20));
        obstacles.put(27,new Obstacle(ObstacleType.LADDER,84));
        obstacles.put(86,new Obstacle(ObstacleType.SNAKE,20));

        List<User> users = new ArrayList<>();
        users.add(new User(1));
        users.add(new User(2));

        Board board = new Board(100,obstacles,users);

        DiceStrategy diceStrategy = new RandomDiceStrategy();

        GameService gameService = new GameService(users,board,diceStrategy);

        gameService.startGame();
    }
}
