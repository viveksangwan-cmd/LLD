public class Obstacle {
    public ObstacleType obstacleType;
    public int startIndex;
    public int endIndex;
    public Obstacle(ObstacleType type,int startIndex,int endIndex){
        this.endIndex = endIndex;
        this.obstacleType = type;
        this.startIndex = startIndex;
    }
}
