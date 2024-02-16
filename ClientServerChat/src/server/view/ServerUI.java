package server.view;

import client.ClientChatWindow;
import server.controller.ServerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerUI implements ServerView{
    private JTextArea serverDialogueW;
    private final ServerController serverController;

    public ServerUI(ServerController serverController) {
        this.serverController = serverController;
    }
    @Override
    public JPanel addDialogueW() {
        JPanel jPanel = new JPanel(new GridLayout(1, 1));
        serverDialogueW = new JTextArea("Let's server up");
        jPanel.add(serverDialogueW);
        return jPanel;
    }

    @Override
    public JPanel addButtons() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.setServerOn(true);
            }
        });
        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.setServerOn(false);
            }
        });
        jPanel.add(start);
        jPanel.add(stop);
        return jPanel;
    }

    @Override
    public void refreshDialogueW(String text) {
        serverDialogueW.setText(text);
    }

    @Override
    public void setServerOn(boolean serverStatus) {
        if(serverStatus) serverDialogueW.setText("Server is up \n \n" + serverController.getChatHistory());
        else serverDialogueW.setText("Server is down");
    }

    @Override
    public void addClient(ClientChatWindow clientChatW) {
        serverDialogueW.append(clientChatW.getNAME() +" connected to server. \n");
    }

}
