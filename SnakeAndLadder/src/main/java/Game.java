import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game {
    static void main() {

        Scanner scanner = Utils.getScanner();

        System.out.println("What will be the board size : ");
        int boardSize = scanner.nextInt();


        System.out.println("What will be the no of obstacles : ");
        int obstaclesSize = scanner.nextInt();
        scanner.nextLine();

        List<Obstacle> obstacles = new ArrayList<>();
        for(int i=0;i<obstaclesSize;i++){

            System.out.println("Put entries for obstacle "+i);
            System.out.println("What will be the obstacle type Snake/Ladder : ");
            String obstacleType = scanner.nextLine().toUpperCase().trim();

            System.out.println("What will be the obstacle position : ");
            int obstaclePosition = scanner.nextInt();


            System.out.println("What will be the obstacle end position : ");
            int obstacleEndPosition = scanner.nextInt();
            scanner.nextLine();

            Obstacle currentObstacle = ObstacleFactory.getObstacle(obstacleType,obstaclePosition,obstacleEndPosition);
            if (currentObstacle==null){
                System.out.println("Invalid Inputs");
                System.exit(0);
            }
            obstacles.add(currentObstacle);
        }

        List<User> users = new ArrayList<>();
        users.add(new User(1));
        users.add(new User(2));

        Board board = new Board(100,obstacles,users);

        DiceStrategy diceStrategy = new RandomDiceStrategy();

        GameService gameService = new GameService(users,board,diceStrategy);

        gameService.startGame();
    }
}
