package server.model;

import client.ClientChatWindow;

import javax.swing.*;
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
    private List<ClientChatWindow> clientsList = new ArrayList<>();


    public ServerWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(W_POS_X, W_POS_Y);
        setSize(W_WIDTH, W_HEIGHT);
        setResizable(false);
        setTitle("Server window");
    }

    public void getMessage(String message){
        writeMessageToFile(message);
        chatInfo = readFromDataBase();
        refreshClientsViews();
    }
    public void writeMessageToFile (String message){
        try(FileWriter fw = new FileWriter("./src/database.txt", true)){
            fw.write(message + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void addClient(ClientChatWindow window){
        clientsList.add(window);
//        serverDialogueW.append(window.getNAME() +" connected to server. \n");
    }
    public void refreshClientsViews(){
        for(ClientChatWindow clientChatWindow: clientsList){
            clientChatWindow.refreshClientView();
        }
    }
    public void setServerOn(boolean serverStatus) {
        this.serverIsOn = serverStatus;
    }

    public StringBuilder getChatInfo() {
        return chatInfo;
    }
    public boolean getServerStatus() {
        return serverIsOn;
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
}
