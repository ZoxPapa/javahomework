package server.controller;

import client.ClientChatWindow;


public interface ServerController {

    void getMessage(String message);
    boolean getServerStatus();
    void setServerOn(boolean b);
    void addClient(ClientChatWindow clientChatW);
    String getChatHistory();

}
