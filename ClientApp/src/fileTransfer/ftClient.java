/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileTransfer;

import Pages.Interface;
import fileTransfer.MyFile;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static java.nio.file.Files.size;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
/**
 *
 * @author Nitin.A
 */
public class ftClient implements Runnable{
    static ArrayList<MyFile> myFiles = new ArrayList<>();
    private Interface infa;
    
    public ftClient(Interface infa){
        this.infa=infa;
        
    }
    
    @Override
    public void run(){
    
    int fileId = 0;
    
    JFrame jFrame = new JFrame("Server");
    jFrame.setSize(400,400);
    jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    JPanel jPanel = new JPanel();
    jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
    jPanel.setBackground(Color.WHITE);
    jPanel.setPreferredSize(new Dimension(300,100));
    JPanel j1panel = new JPanel();
    j1panel.setBackground(new Color(110,88,222));
    j1panel.setLayout(null);
    
    JScrollPane jScrollPane = new JScrollPane(jPanel);
    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    
    JLabel j1Title = new JLabel("File receiver");
    j1Title.setFont(new Font("Arial", Font.BOLD, 25));
    j1Title.setForeground(Color.WHITE);
    j1Title.setBounds(120,50,200,30);
    
    j1panel.add(j1Title);
    jFrame.add(j1panel);
    jFrame.add(jScrollPane);
    jFrame.setVisible(true);
    try{

    while(true){
            Socket socket = new Socket(infa.ipaddress,3000);
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            
            int fileNameLength = dataInputStream.readInt();
            
            if(fileNameLength > 0){
                byte[] fileNameBytes = new byte[fileNameLength];
                dataInputStream.readFully(fileNameBytes, 0, fileNameBytes.length );
                String fileName = new String(fileNameBytes);
                
                int fileContentLength = dataInputStream.readInt();
                
                if(fileContentLength > 0){
                    byte[] fileContentBytes = new byte[fileContentLength];
                    dataInputStream.readFully(fileContentBytes, 0, fileContentLength);
                    
                    JPanel jpFileRow = new JPanel();
                    jpFileRow.setLayout(new BoxLayout(jpFileRow,BoxLayout.Y_AXIS));
                    jpFileRow.setBackground(Color.WHITE);
                    jpFileRow.setAlignmentX(Component.CENTER_ALIGNMENT);
                    
                    JLabel j1FileName = new JLabel(fileName);
                    j1FileName.setFont(new Font("Arial", Font.BOLD,18));
                    j1FileName.setBackground(Color.WHITE);
                    j1FileName.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
                    
                    if (getFileExtension(fileName).equalsIgnoreCase("txt")) {
                        jpFileRow.setName(String.valueOf(fileId));
                        jpFileRow.addMouseListener(getMyMouseListener());
                        
                        jpFileRow.add(j1FileName);
                        jPanel.add(jpFileRow);
                        jFrame.validate();
                        
                    }
                    else {
                        jpFileRow.setName(String.valueOf(fileId));
                        jpFileRow.addMouseListener(getMyMouseListener());
                        
                        jpFileRow.add(j1FileName);
                        jPanel.add(jpFileRow);
                        
                        jFrame.validate();
                    }
                    myFiles.add(new MyFile(fileId,fileName,fileContentBytes,getFileExtension(fileName)));
                }   
            }
        }
    }
       catch(IOException ex){
            System.out.println(ex);;
        }
    
    }
    
    public static MouseListener getMyMouseListener(){
        return new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                JPanel jPanel = (JPanel)e.getSource();
                int fileId = Integer.parseInt(jPanel.getName());
              
                
                for(MyFile myFile: myFiles){
                    if(myFile.getId() == fileId){
                        JFrame jfPreview = createFrame(myFile.getName(),myFile.getData(), myFile.getFileExtension());
                        jfPreview.setVisible(true);
                        
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
    public static JFrame createFrame(String fileName, byte[] fileData, String fileExtension){
        JFrame jFrame = new JFrame("FileDownloader");
        jFrame.setSize(400,200);
                
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        
        JLabel j1Title = new JLabel("File Downloader");
        j1Title.setAlignmentX(Component.CENTER_ALIGNMENT);
        j1Title.setFont(new Font("Arial",Font.BOLD,15));
        j1Title.setBorder(new EmptyBorder(20,0,10,0));
        
        JLabel j1Prompt = new JLabel("Are you sure you want to download" + fileName);
        j1Prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        j1Prompt.setFont(new Font("Arial",Font.PLAIN,10));
        j1Prompt.setBorder(new EmptyBorder(20,0,10,0));
        
        JButton jbNo = new JButton("No");
        jbNo.setPreferredSize(new Dimension(100,30));
        jbNo.setFont(new Font("Arial",Font.BOLD,10));
        
        JButton jbYes = new JButton("Yes");
        jbYes.setPreferredSize(new Dimension(100,30));
        jbYes.setFont(new Font("Arial",Font.BOLD,10));
    
        JLabel j1FileContent = new JLabel();
        j1FileContent.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel jpButtons = new JPanel();
        jpButtons.setBorder((new EmptyBorder(20,0,10,0)));
        jpButtons.add(jbYes);
        jpButtons.add(jbNo);
        
        if(fileExtension.equalsIgnoreCase("txt")){
//            j1FileContent.setText("<html>" + new String(fileData) + "</html>");
        }
        else{
            j1FileContent.setIcon(new ImageIcon(fileData));
            
        }
        
        jbYes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                File fileToDownload = new File(fileName);
                
                try{
                    FileOutputStream fileOutputStream = new FileOutputStream(fileToDownload);
                    fileOutputStream.write(fileData);
                    fileOutputStream.close();
                    
                } catch (IOException error) {
                   error.printStackTrace() ;
                }
            }
            
        });
        
        jbNo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose(); 
            }
            
        });
        
        jPanel.add(j1Title);
        jPanel.add(j1Prompt);
        jPanel.add(j1FileContent);
        jPanel.add(jpButtons);
        
        jFrame.add(jPanel);
        
        return jFrame;
       
    }
    
    public static String getFileExtension(String fileName){
        int i = fileName.lastIndexOf('.');
        
        if(i>0){
            return fileName.substring(i+1);
        }else{
            return "No extension found";
        }
    }
}

