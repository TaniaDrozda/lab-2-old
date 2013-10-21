import java.io.IOException;
import java.util.concurrent.*;

public class Main {

    public static void main (String args[]){
        try {
            FileWriter.generate(100,"Data.bin");
            FileReader fr = new FileReader();
            fr.read();
            User[] users = new User[fr.userNumber];
            for(int i = 0; i < fr.userNumber; i++)
            {
                users[i] = new User();
            }
            for(int[] i : fr.friendship){
                users[i[0]].getFriends().add(users[i[1]]);
                users[i[1]].getFriends().add(users[i[0]]);
            System.out.println("Friends: " + i[0] + " " + i[1]);
            }
            ExecutorService executor = Executors.newFixedThreadPool(5);


            for (int[] i : fr.voting) {
                //System.out.println("Vote " + i[1]);
                executor.execute(new VotesTask(users[i[0]], i[1]));
            }

            //executor.awaitTermination(30, TimeUnit.SECONDS );
            executor.shutdown();


            for (int i = 0; i< fr.userNumber; i++)
            {
                System.out.println("User " + i  + " have " + users[i].getVotes() + " votes.");
            }
        //} catch (InterruptedException e) {
        //    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
