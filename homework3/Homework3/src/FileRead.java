import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) {
        File myFile = new File("src/database.txt");
        reader(myFile);
    }
    static String reader(File myFile){
        StringBuilder my_text = new StringBuilder();
        try {
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                my_text.append(myReader.nextLine());
                my_text.append("\n");
            }
//            System.out.println(my_text);
            myReader.close();

        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        return my_text.toString();
    }
}
