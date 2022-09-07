package myChat.chat;


import Pages.Interface;
import java.awt.Color;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class theClient extends javax.swing.JFrame {

    private String username, address = "localhost";

    private Boolean isConnected = false;

    private Socket theSocket;
    private BufferedReader theReader;
    private PrintWriter theWriter;

    
    public void ListenThread() {
        Thread IncomingReader = new Thread(new Message());
        IncomingReader.start();
    }

    public void userAdd(String data) {
        users.add(data);
    }

    public void userRemove(String data) {
        sentMessage.append(data + " is now offline.\n");
    }

    public void writeUsers() {
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);
        for (String token : tempList) {

        }
    }

    public void sendDisconnect() {
        String bye = (username + ": :Disconnect");
        try {
            theWriter.println(bye);
            theWriter.flush();
        } catch (Exception e) {
            sentMessage.append("You're not connected.\n");
        }
    }

    public void Disconnect() {
        try {
            sentMessage.append("Disconnected.\n");
            theSocket.close();
        } catch (Exception ex) {

        }
        isConnected = false;
    }
    
    public theClient(Interface Infa) {
        initComponents();
        setLocation(1170,300);
        infa=Infa;
        username = infa.getName();
        client_Name.setText(username);
        
    }
	
    private void disConnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disConnectMouseClicked
        connect.setIcon(new ImageIcon(getClass().getResource("/Home/images/icons8_connected_32px.png")));
        sendDisconnect();
        Disconnect();
    }//GEN-LAST:event_disConnectMouseClicked

    private void SendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendMouseClicked
        
        switch (Message.getText()) {
            case "Your messages":
                Message.setText("Type your message here");
                Message.requestFocus();
                break;
            case "Client name":
                break;
            case "Input yuor name":
                break;
            default:
              try {
                theWriter.println(username + " : " + Message.getText() + ":" + "Chat");
                theWriter.flush();
            } catch (Exception ex) {
                sentMessage.append("You're not connected. \n");
            }
            Message.setText("");
            Message.requestFocus();

        }

        Message.setText("Your messages");
        Message.requestFocus();
    }//GEN-LAST:event_SendMouseClicked

    private void MessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MessageKeyPressed

        if (Message.getText().equals("Your messages"))
            Message.setText("");
    }//GEN-LAST:event_MessageKeyPressed

    private void disConnectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disConnectMouseExited
        disconnect_Panel.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_disConnectMouseExited

    private void MessageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MessageKeyReleased
        switch (client_Name.getText()) {
            case "":
                client_Name.setText("client name");
                break;
            default:
                String name = client_Name.getText();
                String result = name.substring(0, 1).toUpperCase() + name.substring(1);
                client_Name.setText(result);
       
        }
    }//GEN-LAST:event_MessageKeyReleased

    private void disConnectMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disConnectMouseMoved
        disconnect_Panel.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_disConnectMouseMoved

    private void connectMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectMouseMoved
        connect_Panel.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_connectMouseMoved

    private void connectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectMouseExited
        connect_Panel.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_connectMouseExited

    private void connectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectMouseClicked
  
        if (isConnected == false) {

            try {
                theSocket = new Socket(address, 3000);
                InputStreamReader streamreader = new InputStreamReader(theSocket.getInputStream());
                theReader = new BufferedReader(streamreader);
                theWriter = new PrintWriter(theSocket.getOutputStream());
                theWriter.println(username + ": has connected :Connect");
                theWriter.flush();
                isConnected = true;
                connect.setIcon(new ImageIcon(getClass().getResource("/Home/images/icons8_connected_32px_1.png")));

            } catch (Exception ex) {
                sentMessage.append("Cannot Connect! Try Again. \n");
                connect.setIcon(new ImageIcon(getClass().getResource("/Home/images/icons8_connected_32px.png")));

            }
            ListenThread();

        } else if (isConnected == true) {
            sentMessage.append("You are connected. \n");
        } 
    }//GEN-LAST:event_connectMouseClicked

    private void SendMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendMousePressed
        Send.setIcon(new ImageIcon(getClass().getResource("/Home/images/icons8_send_letter_32px_1.png")));
    }//GEN-LAST:event_SendMousePressed

    private void SendMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendMouseReleased
        Send.setIcon(new ImageIcon(getClass().getResource("/Home/images/icons8_send_letter_32px.png")));
    }//GEN-LAST:event_SendMouseReleased

    private void close_labelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseMoved
        close_Panel.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_close_labelMouseMoved

    private void close_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseClicked
        infa.client_started=false;
        dispose();
    }//GEN-LAST:event_close_labelMouseClicked

    private void close_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseExited
        close_Panel.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_close_labelMouseExited

    private void minMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseMoved
        min_Panel.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_minMouseMoved

    private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
        setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_minMouseClicked

    private void minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseExited
        min_Panel.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_minMouseExited

    private void header_panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header_panelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_header_panelMouseDragged

    private void header_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header_panelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_header_panelMousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Message;
    private javax.swing.JLabel Send;
    private javax.swing.JLabel client_Name;
    private javax.swing.JPanel clientname_panel;
    private javax.swing.JPanel close_Panel;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel connect;
    private javax.swing.JPanel connect_Panel;
    private javax.swing.JLabel disConnect;
    private javax.swing.JPanel disconnect_Panel;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel min;
    private javax.swing.JPanel min_Panel;
    private javax.swing.JPanel send_Panel;
    private javax.swing.JTextArea sentMessage;
    // End of variables declaration//GEN-END:variables
 public class Message implements Runnable {

        @Override
        public void run() {
            String[] data;
            String stream;

            try {
                while (!(stream = theReader.readLine()).equals(null)) {
                    data = stream.split(":");

                    switch (data[2]) {
                        case "Chat":
                            sentMessage.append(data[0] + ":" + data[1] + "\n");
                            sentMessage.setCaretPosition(sentMessage.getDocument().getLength());
                            break;
                        case "Connnect":
                            sentMessage.removeAll();
                            userAdd(data[0]);
                            break;
                        case "Disconnect":
                            userRemove(data[0]);
                            break;
                        case "Done":
                            writeUsers();
                            users.clear();
                    }
                }
            } catch (Exception ex) {
            }
        }
    }
}
