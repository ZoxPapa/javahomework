import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Parsing {
    static Logger log;

    public static void main(String[] args) {
        myLoggerOn();
        File myFile = new File("src/database.txt");
        String text = FileRead.reader(myFile);
        String [] myArray = tryToParse(text);
        String myResult = formResult(myArray);
//        System.out.println(myResult);
        File resultFile = new File("src/resultFile.txt");
        FileWrite.writeResult(myResult, resultFile);
        myLoggerOff();
        }

    private static void myLoggerOff(){
        for (Handler someHandler: log.getHandlers()){
            someHandler.close();
        }
    }

    static String[] tryToParse (String stringText){
        stringText = stringText.replace("\\","")
                                .replace("\"", "")
                                .replace("+", "")
                                .replace(",", "")
                                .replace("\n", "")
                                .replace("{фамилия", "")
                                .replace("оценка", "")
                                .replace("предмет", "")
                                .replace("},", "")
                                .replace("[", "")
                                .replace("]", "")
                                .replace("}", "");
//        System.out.println(stringText);
        String[] myArray = stringText.split(" :");
        myArray[0] = myArray[0].substring(1);
        return myArray;
    }

    static String formResult (String[] array){
        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < array.length; i++) {
        for(String s: array){
            String [] oneCase = s.split(":");
            String surname = oneCase[0];
            String grade = oneCase[1];
            String subject = oneCase[2];
            result.append(String.format("Student %s got %s in %s \n", surname, grade, subject));
        }
        return result.toString();
    }

    static void myLoggerOn (){
        log = Logger.getAnonymousLogger();
        FileHandler myHandler = null;
        try {
            myHandler = new FileHandler("src/log.txt", true);
            log.addHandler(myHandler);
        }catch (IOException e){
            e.printStackTrace();
        }
        SimpleFormatter myFormatter = new SimpleFormatter();
        myHandler.setFormatter(myFormatter);
    }
}
