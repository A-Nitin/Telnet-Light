/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nitin.A
 */
public class SystemCommands extends Thread {
    private String command;
    Process p;
    public SystemCommands(String command){
        this.command=command;
    }
    
    @Override
    public void run(){
        try {
            p = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \""+command+"\"");
            
            String s;
            System.out.println(p.getOutputStream());
            BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));
            
            s=stdInput.readLine();
            while(s!=null){
                System.out.println(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(SystemCommands.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
