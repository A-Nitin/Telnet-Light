package rtmserver.chat;



import Pages.Interface;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Start implements Runnable{
    static String port = "3000";
    Interface infa;
    
    public Start(Interface infa){
        this.infa = infa;
        
    }
    
    public void initialize(String ip, int port){
        try{

                Socket sc = new Socket(ip,port);
                System.out.println("Connecting to the Server");
                //Authenticate class is responsible for security purposes
                Authenticate frame1= new Authenticate(sc);

                frame1.setSize(300,80);
                frame1.setLocation(500,300);
                frame1.setVisible(true);
        } catch (Exception ex){
                ex.printStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//        
//    }

    @Override
    public void run() {
        String ip = JOptionPane.showInputDialog("Please enter client ip");
        this.initialize(ip, Integer.parseInt(port));
        infa.screenmonitor=false;
    }
}



