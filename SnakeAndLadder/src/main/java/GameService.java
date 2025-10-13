import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class GameService {
    Queue<User> userQueue;
    DiceStrategy diceStrategy;
    Board board;
    public GameService(List<User> users,Board board,DiceStrategy diceStrategy){
        userQueue = new ArrayDeque<>(users);
        this.board = board;
        this.diceStrategy = diceStrategy;
    }

    public int startGame(){
        boolean isGameOver = board.isGameOver();
        User playingUser = null;
        while(!isGameOver && !userQueue.isEmpty()){
            playingUser = userQueue.poll();
            int nextMove = diceStrategy.getPosition();
            board.moveUserByXPoints(playingUser.id,nextMove);
            isGameOver = board.isGameOver();
            userQueue.add(playingUser);
        }
        return playingUser==null?-1:playingUser.id;
    }
}
