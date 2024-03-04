package org.example;
import lombok.*;


public class Main {


    public static void main(String[] args) {

//        Работоспособность одной игры с изменением выбора
            playWithChangeOneGame();

//        Статистика на 1000 игр с изменением выбора
        System.out.println(playGame(true));
        System.out.println(playGame(false));
    }

    public static String playGame(boolean flag){
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            Presenter presenter = new Presenter();
            if(presenter.startTheGame(flag)){
                counter++;
            }
        }
        return "Win "+ counter + " from 1000.";
    }

    public static void playWithChangeOneGame(){
        Presenter presenter = new Presenter();
        presenter.startTheGameWithComments();
    }

}