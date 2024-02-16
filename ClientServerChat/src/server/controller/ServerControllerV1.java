package server.controller;

import client.ClientChatWindow;
import server.model.ServerWindow;
import server.view.ServerUI;
import server.view.ServerView;

import java.awt.*;

public class ServerControllerV1 implements ServerController {
    ServerWindow serverW;
    ServerView serverView;

    public ServerControllerV1() {
        this.serverW = new ServerWindow();
        this.serverView = new ServerUI(this);
    }

    public void createW(){
        serverW.add(serverView.addDialogueW());
        serverW.add(serverView.addButtons(), BorderLayout.SOUTH);
        serverW.setVisible(true);
    }
    @Override
    public void getMessage(String message) {
        serverW.getMessage(message);
        serverView.refreshDialogueW(getChatHistory());
    }

    @Override
    public boolean getServerStatus() {
        return serverW.getServerStatus();
    }

    @Override
    public String getChatHistory(){
        return serverW.getChatInfo().toString();
    }

    @Override
    public void setServerOn(boolean serverStatus){
        serverW.setServerOn(serverStatus);
        serverView.setServerOn(serverStatus);
    }

    @Override
    public void addClient(ClientChatWindow clientChatW) {
        serverW.addClient(clientChatW);
        serverView.addClient(clientChatW);
    }
}
