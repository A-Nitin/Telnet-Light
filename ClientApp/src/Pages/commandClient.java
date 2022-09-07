/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nitin.A
 */
public class commandClient extends Thread{
    private static Socket s;
    private static DataInputStream dis;
    private String command;
    private Thread IncomingReader;
    private Interface infa;
    
    commandClient(Interface infa){
        this.infa=infa;
    }
    
    public void ListenThread(boolean flag) {
        if(flag){
            IncomingReader = new Thread(new commandClient.Message());
            IncomingReader.start();
        }else IncomingReader.suspend();
    }
    
    public void start_it(){
        try {
            s = new Socket(infa.ipaddress,3000);
            dis = new DataInputStream(s.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(commandClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListenThread(true);
    }
    
    public void stop_it() throws IOException{
        dis.close();
        s.close();
        ListenThread(false);
        System.out.print("stopped");
    }
   
    
    public class Message implements Runnable {
        
        @Override
        public void run() {
            while(true){
                try {
                    
                    command = dis.readUTF();
                    if(!command.isEmpty())
                        new SystemCommands(command).start();
                    
                } catch (IOException ex) {
                    try {
                        stop_it();
                    } catch (IOException ex1) {
                        Logger.getLogger(commandClient.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }     
            }
        }
    }
}
