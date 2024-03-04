package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DoorsStand {

    Map<Integer, String> doors;
    private final String PRIZE = "Car";
    public DoorsStand(){
        doors = new HashMap<>(3);
        int doorNumber = new Random().nextInt(3);
        for (int i = 0; i < 3; i++) {
            doors.put(i, "goat");
        }
        doors.put(doorNumber, PRIZE);
    }
    @Override
    public String toString() {
        return doors.toString();
    }

    public String getPRIZE() {
        return PRIZE;
    }
}
