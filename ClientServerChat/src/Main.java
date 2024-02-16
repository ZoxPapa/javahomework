import client.ClientChatWindow;
import server.controller.ServerControllerV1;
import server.model.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerControllerV1 controllerV1 = new ServerControllerV1();
        controllerV1.createW();
        ClientChatWindow clientChatWindow = new ClientChatWindow(controllerV1);
        ClientChatWindow clientChatWindow2 = new ClientChatWindow(controllerV1);
    }
}