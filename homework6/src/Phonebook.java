import java.util.*;

public class Phonebook {
    Map<String, List<String>> db = new HashMap<>();


    void addContact (String contactName, String phoneNumber){
        List<String> phones = new ArrayList<>();
        phones.add(phoneNumber);
        db.put(contactName, phones);
    }

    void  addPhoneNumber (String contactName, String phoneNumber){
        db.get(contactName).add(phoneNumber);
    }

    boolean contactIsNotExist (String contactName){
        if(db.containsKey(contactName)) return false;
        return true;
    }
    void printing (){
        for(Map.Entry items: db.entrySet()){
            System.out.println(items);
        }
    }

}
