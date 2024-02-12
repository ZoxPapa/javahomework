package server;

import client.ClientChatWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerWindow extends JFrame {
    private final static int W_HEIGHT = 300;
    private final static int W_WIDTH = 500;
    private final static int W_POS_X = 750;
    private final static int W_POS_Y = 20;
    private StringBuilder chatInfo = readFromDataBase();
    private boolean serverIsOn = false;
    private JTextArea serverView;
    private List<ClientChatWindow> clientsList = new ArrayList<>();

    public ServerWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(W_POS_X, W_POS_Y);
        setSize(W_WIDTH, W_HEIGHT);
        setResizable(false);
        setTitle("Server window");
        add(addMessageView());
        add(addFooterButtons(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel addMessageView(){
        JPanel jPanel = new JPanel(new GridLayout(1, 1));
        serverView = new JTextArea("Let's server up");
        jPanel.add(serverView);
        return jPanel;
    }

    private JPanel addFooterButtons() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverIsOn = true;
                serverView.setText("Server is up \n \n" + getChatInfo());
            }
        });
        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverIsOn = false;
                serverView.setText("Server is down");
            }
        });
        jPanel.add(start);
        jPanel.add(stop);
        return jPanel;
    }


    public void getMessage(String message){
        writeMessageToFile(message);
        chatInfo = readFromDataBase();
            refreshViews();
    }
    public boolean getServerStatus() {
        return serverIsOn;
    }
    public StringBuilder getChatInfo() {
        return chatInfo;
    }
    private StringBuilder readFromDataBase() {
        StringBuilder sb = new StringBuilder();
        try(FileReader fr = new FileReader("./src/database.txt")){
            Scanner sc = new Scanner(fr);
            while(sc.hasNextLine()){
                sb.append(sc.nextLine()).append("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb;
    }
    private void writeMessageToFile (String message){
        try(FileWriter fw = new FileWriter("./src/database.txt", true)){
            fw.write(message + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addClient(ClientChatWindow window){
        clientsList.add(window);
        serverView.append(window.getNAME() +" connected to server. \n");
    }
    public void refreshViews(){
            serverView.setText(readFromDataBase().toString());
        for(ClientChatWindow clientChatWindow: clientsList){
            clientChatWindow.refreshClientView();
        }
    }

}
