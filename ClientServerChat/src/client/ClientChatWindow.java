package client;

import server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientChatWindow extends JFrame {
    static int several_w_pos = 0;
    private final static int W_HEIGHT = 300;
    private final static int W_WIDTH = 500;
    private final static int W_POS_X = 20;
    private final static int W_POS_Y = 40;
    private final ServerWindow serverWindow;
    private boolean isLogIn = false;
    private JTextField clientTextField;
    private JTextArea clientView;
    private String NAME;


    public ClientChatWindow(ServerWindow serverWindow){
    setDefaultCloseOperation(HIDE_ON_CLOSE);
    setLocation(W_POS_X + several_w_pos, W_POS_Y+ several_w_pos);
    setSize(W_WIDTH, W_HEIGHT);
    several_w_pos+=40;
    setResizable(false);
    setTitle("Client Chat");
    this.serverWindow = serverWindow;
    add(addHeaderFields(), BorderLayout.NORTH);
    add(addFooterFields(), BorderLayout.SOUTH);

    setVisible(true);
    }

    private JPanel addHeaderFields(){
        JPanel headerPanel = new JPanel(new GridLayout(2, 3));
        JTextField ipAddress = new JTextField("IP address");
        JTextField port = new JTextField("Port");
        JLabel stub = new JLabel("");
        JTextField name = new JTextField("DefaultName");
        JPasswordField password = new JPasswordField("password");
        JButton login = new JButton("LogIn");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NAME = name.getText();
                if(serverWindow.getServerStatus()) {
                    logIn(headerPanel);
                }else{
                    stub.setText("Server is off");
                }
            }
        });
        headerPanel.add(ipAddress);
        headerPanel.add(port);
        headerPanel.add(stub);
        headerPanel.add(name);
        headerPanel.add(password);
        headerPanel.add(login);
        return headerPanel;

    }

    private JPanel addFooterFields(){
        JPanel footerPanel = new JPanel(new GridBagLayout());
        clientTextField = new JTextField("");
        clientTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    sendMessage();
                }
            }
        });
        GridBagConstraints field = new GridBagConstraints();
        field.fill = GridBagConstraints.HORIZONTAL;
        field.weightx = 0.6f; //можно указать любое значение - не понял почему
        JButton send = new JButton("Send");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        footerPanel.add(clientTextField, field);
        footerPanel.add(send);
        return footerPanel;

    }

    private void sendMessage() {
        if(isLogIn && serverWindow.getServerStatus()) {
            serverWindow.getMessage(NAME+": " + clientTextField.getText());
            clientTextField.setText("");
        }
    }

    private void logIn(JPanel headerPanel){
        headerPanel.setVisible(false);
        JPanel jPanel = new JPanel(new GridLayout(1, 1));
        clientView = new JTextArea(readFromDataBase().toString());
        jPanel.add(clientView);
        jPanel.setVisible(true);
        this.add(jPanel);
        this.isLogIn = true;

        serverWindow.addClient(this);
    }

    private StringBuilder readFromDataBase() {
        return serverWindow.getChatInfo();
    }

    public void refreshClientView() {
        this.clientView.setText(readFromDataBase().toString());
    }

    public String getNAME(){
        return NAME;
    }
}
