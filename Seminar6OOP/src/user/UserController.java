package user;

import java.util.List;

public interface UserController<S extends User> {
    public <T extends User> T create(String name, int age);
    public <T extends User> void sendToConsole(List<T> usersList);
}
