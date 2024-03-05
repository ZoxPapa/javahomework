package actors;

public abstract class Actor implements ActorBehaviour {
    protected String name;

    private boolean isMakeOrder;

    private boolean isTakeOrder;
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    public void setTakeOrder(boolean takeOrder) {
        isTakeOrder = takeOrder;
    }

    public Actor(String name) {
        this.name = name;
    }

    public abstract String getName();
}
