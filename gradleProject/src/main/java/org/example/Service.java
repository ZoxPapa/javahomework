package org.example;


import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Service {
    DoorsStand doorsStand = new DoorsStand();
    int hostChoice;
    Random random = new Random();
    int playerChoice;

    private int getRandomDoorNumber(){
        return random.nextInt(4);
    }

    public void getPlayerChoice(){
        Scanner sc = new Scanner(System.in);
        this.playerChoice = sc.nextInt()-1;
    }
    public void getPlayerRandomChoice(){
        this.playerChoice = random.nextInt(3);
    }
    public void getHostChoice(){
        for(Map.Entry entry: doorsStand.doors.entrySet()){
            if(!entry.getKey().equals(playerChoice) &&
                    entry.getValue().equals("goat")){
                hostChoice = (int)entry.getKey();
            }
        }
    }
    public void switchPlayerDoor(){
        for(Map.Entry entry: doorsStand.doors.entrySet()){
            if(!entry.getKey().equals(playerChoice) && !entry.getKey().equals(hostChoice)){
                playerChoice =  (int)entry.getKey();
                return;
            }
        }
    }
    public boolean checkWin(){
        return doorsStand.doors.get(playerChoice).equals(doorsStand.getPRIZE());
    }

}
