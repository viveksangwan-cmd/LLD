import java.util.HashMap;
import java.util.List;

public class Board {
    int size;
    boolean gameOver;
    HashMap<Integer,Obstacle> obstacles;
    HashMap<Integer,Integer> userPositions;
    public Board(int size, HashMap<Integer,Obstacle> obstacles, List<User> users){
        this.obstacles = obstacles;
        this.size = size;
        this.gameOver = false;
        this.userPositions = new HashMap<>();
        users.forEach(user -> userPositions.put(user.id,0));
    }

    public boolean moveUserByXPoints(int userId,int points){
        int prevPosition = userPositions.get(userId);
        int nextPosition = prevPosition + points;
        if(obstacles.containsKey(nextPosition)) {
            Obstacle obstacle = obstacles.get(nextPosition);
            System.out.println("Got OBSTACLE "+obstacle.obstacleType.name().toUpperCase());
            nextPosition = obstacle.endIndex;
        }
        System.out.println("User "+userId+" got points "+points+" moved from "+prevPosition +" to "+nextPosition);
        userPositions.put(userId,nextPosition);
        if(nextPosition>=100) gameOver = true;
        return true;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
