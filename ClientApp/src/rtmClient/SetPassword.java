package rtmClient;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class SetPassword extends JFrame implements ActionListener{
	static String port="3000";
	JButton submit;
	JPanel panel;
	JLabel label1,label2;
	JTextField text1,text2;
	String value1;
	String value2;
	JLabel label;
	
   SetPassword(){
        setTitle("Set Password");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        panel = new JPanel();
        text1 = new JTextField();
        submit = new JButton("ok");
        panel.add(text1);
        panel.add(submit);
        
        text1.setBounds(10,10,200,30);
        submit.setBounds(220,10,55,30);
        text1.setBorder(BorderFactory.createLineBorder(new Color(110,88,222), 2));
        add(panel);
        panel.setBackground(new Color(54,33,89));
        panel.setBounds(0,0,300,200);
        panel.setVisible(true);
        panel.setLayout(null);
               
        submit.addActionListener(this);
  
	}
	
    public void actionPerformed(ActionEvent ae){
        value1=text1.getText();
        if(value1.isEmpty()){
            setTitle("Set Password-Empty!!");
        }
        else{
            dispose();
            new InitConnection(Integer.parseInt(port),value1);
        }
    }

    public String getValue1(){

            return value1;
    }


    public static void main(String[] args){

        SetPassword frame= new SetPassword();
        frame.setSize(300,85); 				
        frame.setLocation(500,300);
        frame.setVisible(true);

    }

}
