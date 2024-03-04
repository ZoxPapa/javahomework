package org.example;


public class Presenter {
    private final Service service;
    public Presenter(){
        service = new Service();
    }
    public boolean startTheGameWithComments(){
        System.out.println(service.getDoorsStand());
        do{
            System.out.println("Choose your door : ");
            service.getPlayerChoice();
        }
        while (service.playerChoice <0 || service.playerChoice > 2);
        service.getHostChoice();
        System.out.println("Player choose: "+ (service.playerChoice +1));
        System.out.println("Host open: " + (service.hostChoice+1));
        service.switchPlayerDoor();
        System.out.println("Now player change door to " + (service.playerChoice+1));
        if (service.checkWin()) {
            System.out.println("Win");
        } else {
            System.out.println("Lose");
        }
        return service.checkWin();
    }
    public boolean startTheGame(boolean flag){
        service.getPlayerRandomChoice();
        service.getHostChoice();
        if(flag)service.switchPlayerDoor();
        return service.checkWin();
    }

}
