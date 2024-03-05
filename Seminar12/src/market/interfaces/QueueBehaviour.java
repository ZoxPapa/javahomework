package market.interfaces;

import actors.Actor;

public interface QueueBehaviour {
    void takeInQueue(Actor actor);
    void takeOrders();
    void giveOrders();
    void releaseFromQueue();
}
