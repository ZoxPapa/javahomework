import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Phonebook myBook = new Phonebook();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String name = sc.nextLine();
            String phoneNumber = sc.nextLine();
            if (myBook.contactIsNotExist(name)) {
                myBook.addContact(name, phoneNumber);
            } else {
                myBook.addPhoneNumber(name, phoneNumber);
            }
            myBook.printing();
        }

    }


}