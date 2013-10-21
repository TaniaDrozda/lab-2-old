import java.util.ArrayList;
import java.util.List;

public class VotesTask implements Runnable{
    private int votes;
    private User user;
    public VotesTask(User user, int votes)
    {
         this.votes = votes;
         this.user = user;
    }


    @Override
    public void run() {
        user.changeVotes(votes);
        user.getFriends();
        for (User i : user.getFriends()) {
            i.changeVotes(votes/2);
        }

    }
}
