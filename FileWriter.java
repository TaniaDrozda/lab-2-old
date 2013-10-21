import java.io.*;
import java.util.Random;

public class FileWriter
{
    private static String resetFile(String fileName) throws IOException
    {
        File f = new File(fileName);
        if (f.exists())
            f.delete();
        f.createNewFile();
        return (f.getAbsolutePath());
    }

    public static String generate(int userNumber, String fileName) throws IOException
    {
        String absPath = resetFile(fileName);
        DataOutputStream os = new DataOutputStream(new FileOutputStream(fileName));
        Random rand = new Random(System.currentTimeMillis());

        os.writeInt(userNumber);
        int friendshipNumber = rand.nextInt(1000);
        os.writeInt(friendshipNumber);

        for (int i = 0; i < friendshipNumber; i++)
        {
            os.writeInt(rand.nextInt(userNumber));
            os.writeInt(rand.nextInt(userNumber));
        }

        int votingNumber = rand.nextInt(1000);
        os.writeInt(votingNumber);

        for (int i = 0; i < votingNumber; i++)
        {
            os.writeInt(rand.nextInt(userNumber));
            os.writeInt(rand.nextInt(8));
        }

        os.close();

        return (absPath);
    }
}