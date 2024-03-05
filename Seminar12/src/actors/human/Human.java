package actors.human;

import actors.Actor;

public class Human extends Actor {

    public Human(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    //Перенес геттеры и сеттеры в класс actors.Actor, для соблюдения приципа инверсии зависимостей


}
