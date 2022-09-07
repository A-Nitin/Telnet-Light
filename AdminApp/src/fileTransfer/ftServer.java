/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileTransfer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Nitin.A
 */
public class ftServer extends JFrame implements Runnable{
    
    private JLabel title,display;
    private JPanel button,main;
    private JButton send;
    private JButton choose;
    ServerSocket serverSocket;
    Socket socket;
    
    public ftServer(){
        final File[] fileToSend = new File[1];
        main = new JPanel();
        main.setBackground(Color.WHITE);
        
        setTitle("NetMon FT");
        setSize(280,350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        title = new JLabel("File sender");
        title.setFont(new Font("Arial",Font.BOLD,25));
        title.setBounds(75,20,200,30);
        title.setForeground(new Color(110,88,222));
        main.add(title);
        
        display = new JLabel("Choose a file");
        display.setFont(new Font("Arial",Font.PLAIN,12));
        display.setBorder(BorderFactory.createLineBorder(new Color(110,88,222), 2));
        display.setBounds(34,70,200,30);
        display.setForeground(new Color(54,33,89));
        
                
        main.add(display);
        button = new JPanel();
        button.setBackground(Color.WHITE);
        
        send = new JButton("Send");
        choose = new JButton("choose");

        button.add(send);
        button.add(choose);
        main.add(button);
        button.setBounds(50,150,200,100);
        button.setLayout(null);
        send.setBounds(0,0,175,30);
        choose.setBounds(0,50,175,30);
        
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfilechooser = new JFileChooser();
                jfilechooser.setDialogTitle("Choose a file to send");
                
                if(jfilechooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    fileToSend[0] = jfilechooser.getSelectedFile();
                    display.setText("The file you want to send is "+fileToSend[0].getName());
                }
            }
        });
 
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileToSend[0]==null){
                    display.setText("please choose a file first");
                }
                else{
                    try{
                        FileInputStream fis = new FileInputStream(fileToSend[0].getAbsolutePath());

                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        
                        String fileName = fileToSend[0].getName();
                        byte[] fileNameBytes = fileName.getBytes();
                        
                        byte[] fileContentBytes =new byte[(int) fileToSend[0].length()];
                        fis.read(fileContentBytes);
                        
                        dos.writeInt(fileNameBytes.length);
                        dos.write(fileNameBytes);
                        
                        dos.writeInt(fileContentBytes.length);
                        dos.write(fileContentBytes);
                                                
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }                   
                }
            }
        });
        
        add(main);
        main.setBounds(0,0,450,450);
        main.setLayout(null); 
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(3000);
            socket = serverSocket.accept();
        } catch (Exception ex) {
           
        }
    }
}
