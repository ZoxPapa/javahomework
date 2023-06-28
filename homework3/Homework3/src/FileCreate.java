import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {
        File myFile = new File("src/database.txt");
        try {
            if(myFile.createNewFile()){
                System.out.println("File is created");
            }else{
                System.out.println("File already exist.");
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

}
