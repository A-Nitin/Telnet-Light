package rtmClient;

import Pages.Interface;
import javax.swing.JFrame;





public class Start implements Runnable{

//    Interface infa;
//    public Start(Interface infa){
//        this.infa=infa;
//    }
    
    @Override
    public void run() {
//        infa.screenmonitor=true;
        SetPassword frame1= new SetPassword();
        frame1.setSize(300,80); 				
        frame1.setLocation(500,300);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
    }
}
