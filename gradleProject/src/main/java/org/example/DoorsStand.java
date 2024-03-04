package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DoorsStand {

    Map<Integer, String> doors;
    private final String PRIZE = "Car";
    private final int doorWithCarNumber;
    public DoorsStand(){
        doors = new HashMap<>(3);
        int doorNumber = new Random().nextInt(3);
        this.doorWithCarNumber = doorNumber;
        for (int i = 0; i < 3; i++) {
            doors.put(i, "goat");
        }
        doors.put(doorNumber, PRIZE);
    }

    @Override
    public String toString() {
        return doors.toString();
    }

    public int getDoorWithCarNumber() {
        return doorWithCarNumber;
    }

    public String getPRIZE() {
        return PRIZE;
    }
}
