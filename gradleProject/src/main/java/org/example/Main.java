package org.example;
import lombok.*;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        System.out.println(playWithChange());

    }

    public static String playWithChange(){
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            Presenter presenter = new Presenter();
            if(presenter.startTheGame()){
                counter++;
            }
        }
        return "Win "+ counter + " from 1000.";
    }

    public static String playWithChangeOneGame(){
        Presenter presenter = new Presenter();
        presenter.startTheGameWithComments();
    }

}