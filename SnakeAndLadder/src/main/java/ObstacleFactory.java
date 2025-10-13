public class ObstacleFactory {

    public static Obstacle getObstacle(String obstacleType,int startingPosition,int endPosition){
        ObstacleType obstacle = ObstacleType.valueOf(obstacleType);
        switch(obstacle){
            case LADDER -> {
                return new Obstacle(ObstacleType.LADDER,startingPosition,endPosition);
            }
            case SNAKE -> {
                return new Obstacle(ObstacleType.SNAKE,startingPosition,endPosition);
            }
            default -> {
                return null;
            }
        }
    }
}
