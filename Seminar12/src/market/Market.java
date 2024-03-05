package market;

import actors.Actor;
import market.interfaces.MarkerBehaviour;
import market.interfaces.QueueBehaviour;

import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarkerBehaviour {

    private final List<Actor> queue;
    public Market() {
        this.queue = new ArrayList<Actor>();
    }
    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " come to market");
        takeInQueue(actor);
        actor.setMakeOrder(false);
        actor.setTakeOrder(false);
    }


    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        this.queue.add(actor);
        System.out.println(actor.getName() + " stand in queue");
    }
//Изменены обращения к полям класса actor. Вместо обращения напрямую к полям используются геттеры и сеттеры.
    @Override
    public void takeOrders() {
        for (Actor actor:this.queue) {
            if(!actor.isMakeOrder()){
                System.out.println(actor.getName()+" make order");
                actor.setMakeOrder(true);
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor:this.queue) {
            if(actor.isMakeOrder()){
                actor.setTakeOrder(true);
                actor.setMakeOrder(false);
                System.out.println(actor.getName()+" take order");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> actorsWithOrders = new ArrayList<>();
        for (Actor actor:this.queue) {
            if(actor.isTakeOrder()){
                actorsWithOrders.add(actor);
                System.out.println(actor.getName()+" quit the queue");
            }
        }
        releaseFromMarket(actorsWithOrders);

    }
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor: actors){
            if(this.queue.contains(actor)){
                queue.remove(actor);
                System.out.println(actor.getName() +" quit the market");
            }
        }
    }
}
