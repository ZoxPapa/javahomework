package market.interfaces;

import actors.Actor;

import java.util.List;

public interface MarkerBehaviour {
    void acceptToMarket(Actor actor);
    void releaseFromMarket(List<Actor> actors);
    void update();

}
