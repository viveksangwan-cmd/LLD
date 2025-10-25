import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    public int  userId;
    public String username;
    public String contactNumber;
    public int spamReportedCounter;
    public boolean isPrime;
    public boolean isSpam;
    public User(String username,String contactNumber,Boolean isPrime){
        this.userId = idGenerator.getAndIncrement();
        this.username = username;
        this.contactNumber = contactNumber;
        this.isPrime = isPrime;
        this.spamReportedCounter = 0;
        this.isSpam = false;
    }

    public User(){
        this.userId = idGenerator.getAndIncrement();
    }

}
