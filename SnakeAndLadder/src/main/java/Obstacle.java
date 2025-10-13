public class Obstacle {
    public ObstacleType obstacleType;
    public int endIndex;
    public Obstacle(ObstacleType type,int endIndex){
        this.endIndex = endIndex;
        this.obstacleType = type;
    }
}
