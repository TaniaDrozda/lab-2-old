import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private AtomicInteger votes = new AtomicInteger(0);
    private List<User> friends  = new ArrayList<User>();

    public User()
    {
    }

    public int getVotes()
    {
        return votes.get();
    }

    public List<User> getFriends()
    {
        return friends;
    }

    public void changeVotes(int delta)
    {
        votes.addAndGet(delta);
    }
}
