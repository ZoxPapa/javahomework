import java.time.LocalDate;

public class Human {
    String name;
    String surname;
    LocalDate birthdate;
    Long phoneNumber;
    Character sex;

//    public Human(String name, String surname, Date birthdate, Integer phoneNumber, Character sex) {
//        this.name = name;
//        this.surname = surname;
//        this.birthdate = birthdate;
//        this.phoneNumber = phoneNumber;
//        this.sex = sex;
//    }

    @Override
    public String toString() {
        return name+" "+surname+" "+birthdate+" "+phoneNumber+" "+sex;
    }
}
