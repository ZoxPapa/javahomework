import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) {
        File myFile = new File("src/result.txt");

    }
    static void writeResult (String resultString, File someFile){
        try {
            FileWriter myWriter = new FileWriter(someFile);
            myWriter.write(resultString);
            myWriter.close();
            System.out.println("Writing complete");
            Parsing.log.info("Writing complete.");
        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
            Parsing.log.warning("Error");
        }
    }
}
