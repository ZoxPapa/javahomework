import client.ClientChatWindow;
import server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        ClientChatWindow clientChatWindow = new ClientChatWindow(serverWindow);
        ClientChatWindow clientChatWindow2 = new ClientChatWindow(serverWindow);
    }
}