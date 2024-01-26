import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarkerBehaviour{

    private List<Actor> queue;
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

    @Override
    public void takeOrders() {
        for (Actor actor:this.queue) {
            if(actor.isMakeOrder == false){
                System.out.println(actor.getName()+" make order");
                actor.isMakeOrder = true;
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor:this.queue) {
            if(actor.isMakeOrder = true){
                actor.isTakeOrder = true;
                actor.isMakeOrder = false;
                System.out.println(actor.getName()+" take order");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> actorsWithOrders = new ArrayList<>();
        for (Actor actor:this.queue) {
            if(actor.isTakeOrder = true){
                actorsWithOrders.add(actor);
                System.out.println(actor.getName()+" quit the queue");
            }
        }
        releaseFromMarket(actorsWithOrders);

    }
    @Override
    public void releaseFromMarket(List<Actor> actors) {
//        List<Actor>resultActorsList = this.queue;
        for(Actor actor: actors){
            if(this.queue.contains(actor)){
                queue.remove(actor);
                System.out.println(actor.getName() +" quit the market");
            }
        }
//        this.queue=resultActorsList;
    }
}
