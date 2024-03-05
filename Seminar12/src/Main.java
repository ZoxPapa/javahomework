import actors.Actor;
import actors.human.Human;
import market.Market;

public class Main {
    public static void main(String[] args) {
        //добавлена структура проекта, пересмотрены модификаты доступа к полям классов
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