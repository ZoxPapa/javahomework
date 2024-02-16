package server.view;

import client.ClientChatWindow;
import server.model.ServerWindow;

import javax.swing.*;

public interface ServerView {
    JPanel addDialogueW();
    JPanel addButtons();
    void refreshDialogueW(String text);

    void setServerOn(boolean serverStatus);

    void addClient(ClientChatWindow clientChatW);
}
