import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ui();
        String[] data = userInput().split(" ");
        if (!dataQtyCheck(data)){
            System.exit(0);
        }
        Human man = myParsing(data);
        if(verification(man)){
            writeInfo(man);
        }else{
            System.out.println("You are not added to database.");
        }
    }
    static void ui(){
        System.out.println("""
                Please input your data in one line, separate with space:\s
                 name,\s
                 surname,\s
                 birthday(DD.MM.YYYY),\s
                 phone number (89001112233),\s
                 sex(m, f)""");
    }

    static String userInput(){
            try(Scanner sc = new Scanner(System.in)){
                return sc.nextLine();
            }
    }
    static boolean dataQtyCheck(String[] data){
        if(data.length > 5 ){
            System.out.println("Error. You input more data then needed");
            return false;
        } else if (data.length <5 ) {
            System.out.println("Error. You input less data then needed");
            return false;
        }
        return true;
    }
    static Human myParsing (String[]data){
        Human man = new Human();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        man.name = data[0];
        man.surname = data[1];
        try {
            man.birthdate = LocalDate.parse(data[2], formatter);
        }catch (DateTimeParseException e) {
            System.out.println("Wrong format of birthday. \nYou need to do like this: DD.MM.YYYY");
        }
        try {
            man.phoneNumber = Long.parseLong(data[3]);
        }catch (NumberFormatException e) {
            System.out.println("Wrong format of phone number \nYou need to do like this: 89001112233");
        }
        try {
            Character sex = data[4].charAt(0);
            if (sex.equals('f')  || sex.equals('m')) {
                man.sex = sex;
                }else {
                throw new Exception();
                }
            } catch (Exception e){
            System.out.println("Wrong format of sex.");
        }
        return man;
    }
    static boolean verification (Human man) {
        try {
            if (man.name != null &&
                    man.surname != null &&
                    man.birthdate != null &&
                    man.phoneNumber != null &&
                    man.sex != null) {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }

    static void writeInfo (Human human) {
        try ( FileWriter fw = new FileWriter("src/"+human.surname+".txt", true)){
            fw.write("<"+human.name+">"+"<"+human.surname+">"+"<"+human.birthdate.toString()+">"+"<"+human.phoneNumber.toString()+">"+"<"+human.sex.toString()+">\n");
        }catch (IOException e){
            System.out.println("Error" + e);
        }
    }
}