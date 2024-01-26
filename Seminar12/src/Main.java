public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Actor bob = new Human("Bob");
        Actor max = new Human("Max");
        Actor alice = new Human("Alice");
        market.acceptToMarket(bob);
        market.acceptToMarket(max);
        market.acceptToMarket(alice);
        market.update();
    }
}