import java.io.*;

public class FileReader {
    public int userNumber;
    public int friendshipNumber;
    public int friendship[][];
    public int votingNumber;
    public int voting[][];

    private String inputFileName;

    public FileReader() throws IOException
    {
        this("Data.bin");
    }

    public FileReader(String inputFileName) throws IOException
    {
        File f = new File(inputFileName);
        if (!f.exists())
            throw new FileNotFoundException("File " + inputFileName + " does not exist");
        this.inputFileName = inputFileName;
    }

    public void read() throws IOException
    {
        DataInputStream is = new DataInputStream(new FileInputStream(this.inputFileName));

        userNumber = is.readInt();
        friendshipNumber = is.readInt();
        friendship = new int[friendshipNumber][2];
        for (int i = 0; i < friendshipNumber; i++)
        {
            friendship[i][0] = is.readInt();
            friendship[i][1] = is.readInt();
        }

        votingNumber = is.readInt();
        voting = new int[votingNumber][2];
        for (int i = 0; i < votingNumber; i++)
        {
            voting[i][0] = is.readInt();
            voting[i][1] = is.readInt();
        }

    }
}
