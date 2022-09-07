/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import myChat.chat.theClient;
import rtmClient.Start;
import fileTransfer.ftClient;

/**
 *
 * @author Nitin.A
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */

    private boolean menu_pressed = false;
    private boolean[] selected = new boolean[6];
    private boolean[] over = new boolean[6];
    private JPanel[] panels,panels_word;
    private String username;
    public String ipaddress;
    private boolean menu_clicked=false;
    public boolean server_started=false;
    public boolean client_started=false;
    private int xMouse;
    private int yMouse;
    private commandClient cc;
    public boolean fileTransfer=false;
    public boolean screenmonitor=false;
    
    
    public Interface(String ipaddress,String Username) {
        initComponents();
        username = Username.substring(0, 1).toUpperCase() + Username.substring(1);
        profile_label.setText(username);
        this.ipaddress=ipaddress;
        changePanel(1);
        initialise();
    }

    public String getName(){
        return(username);
    }
    
    public void initialise(){
        for(int i=0;i<6;i++){
            selected[i] = false;
            over[i] = false;
        }
        panels = new JPanel[]{profile_icon,home_icon,cmd_icon,chat_icon,ss_icon,rtm_icon};
        panels_word = new JPanel[]{profile,home,cmd,chat,ss,rtm};
        selected[1]=true;
        Logo_panel.setVisible(false);
        main_panel.setLayout(null);
    }
    
    public void changePanel(int panelNo){
        String content = "<html>";
        switch(panelNo){
            case 0:
                heading_label.setText("Profile");
                content += "<span>View your <span style=\"color:rgb(85,65,118);"
                        + "font-size:20pt;font-weight:bold\">profile</span> "
                        + " .</span>";
                miancontent_label.setText(content);
                leftBtn.setVisible(false);
                rightBtn.setVisible(false);
                break;
            case 1:
                heading_label.setText("Home");
                content += "<span>Our <span style=\"color:rgb(85,65,118);"
                        + "font-size:20pt;font-weight:bold\">NetMon app</span> "
                        + "is one of the<br>best app in current.</span>";
                miancontent_label.setText(content);
                heading_username.setText(username);
                leftBtn.setVisible(false);
                rightBtn.setVisible(false);
                break;
            case 2:
                heading_label.setText("Command");
                content += "<span>Admin can remotely execute <span style=\"color:rgb(85,65,118);"
                        + "font-size:20pt;font-weight:bold\">windows command</span> on your pc."
                        + "</span></html>";
                miancontent_label.setText(content);
                leftBtn.setVisible(true);
                leftBtn.setBounds(40,150,100,40);
                leftBtn_label.setText("Accept");
                rightBtn.setVisible(false);
                break;
            case 3:
                heading_label.setText("Chat");
                content += "<span>A <span style=\"color:rgb(85,65,118);"
                        + "font-size:20pt;font-weight:bold\">popup</span> "
                        + "will appear when the connection is made with the server.</span>";
                miancontent_label.setText(content);
                leftBtn.setVisible(true);
                leftBtn.setBounds(40,150,100,40);
                leftBtn_label.setText("Chat Now");
                rightBtn.setVisible(false);
                break;
            case 4:
                heading_label.setText("FIle Transfer");
                content += "<span>Here you will <span style=\"color:rgb(85,65,118);"
                        + "font-size:20pt;font-weight:bold\">recieve files</span> "
                        + "from admin.</span>";
                miancontent_label.setText(content);
                leftBtn.setVisible(true);
                leftBtn_label.setText("Recieve File");
                rightBtn.setVisible(false);
                break;
            case 5:
            heading_label.setText("Remote Desktop Control");
            content += "<span>After creating <span style=\"color:rgb(85,65,118);"
                    + "font-size:20pt;font-weight:bold\">security pin</span> "
                    + "send it to the admin through chat.</span>";
            miancontent_label.setText(content);
            leftBtn.setVisible(true);
            leftBtn.setBounds(40,150,100,40);
            leftBtn_label.setText("start");
            rightBtn.setVisible(false);
            break;
        }
    }
    
    public void downMenuSelection(int i){
        if(selected[i]){
            panels[i].setBackground(new Color(85,65,118)); 
            panels_word[i].setBackground(new Color(85,65,118)); 
        }
        else{
            if(over[i]) {
                panels_word[i].setBackground(new Color(70,52,102)); 
                panels[i].setBackground(new Color(70,52,102));
            }
            
            else {
                panels_word[i].setBackground(new Color(64,43,100)); 
                panels[i].setBackground(new Color(64,43,100));
            }
        }
    }
    
    public void downMenuDeselection(int i){
        int j =0;
        while(j<=5){
            if(j!=i){
                panels[j].setBackground(new Color(64,43,100));
                panels_word[j].setBackground(new Color(64,43,100));
                selected[j]=false;
            }
            j++;
        }
    }
    
    public void clicked(int i){
        selected[i]=true;
        downMenuDeselection(i);
        downMenuSelection(i);
        changePanel(i);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_panel = new javax.swing.JPanel();
        menuicon_panel = new javax.swing.JPanel();
        rtm_icon = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        home_icon = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        profile_icon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chat_icon = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ss_icon = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        menulabel_panel = new javax.swing.JPanel();
        menu_label = new javax.swing.JLabel();
        Logo_panel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmd_icon = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        heading_panel = new javax.swing.JPanel();
        heading_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        heading_username = new javax.swing.JLabel();
        heading_label3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        main_panel = new javax.swing.JPanel();
        miancontent_label = new javax.swing.JLabel();
        leftBtn = new javax.swing.JPanel();
        leftBtn_label = new javax.swing.JLabel();
        rightBtn = new javax.swing.JPanel();
        rightBtn_label = new javax.swing.JLabel();
        header_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        close_label = new javax.swing.JLabel();
        min_label = new javax.swing.JLabel();
        menu_panel = new javax.swing.JPanel();
        rtm = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        profile = new javax.swing.JPanel();
        profile_label = new javax.swing.JLabel();
        chat = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        ss = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        cmd = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg_panel.setBackground(new java.awt.Color(102, 255, 153));
        bg_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));

        menuicon_panel.setBackground(new java.awt.Color(54, 33, 89));
        menuicon_panel.setPreferredSize(new java.awt.Dimension(288, 330));
        menuicon_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rtm_icon.setBackground(new java.awt.Color(64, 43, 100));
        rtm_icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rtm_iconMouseMoved(evt);
            }
        });
        rtm_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rtm_iconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rtm_iconMouseExited(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_system_task_15px.png"))); // NOI18N

        javax.swing.GroupLayout rtm_iconLayout = new javax.swing.GroupLayout(rtm_icon);
        rtm_icon.setLayout(rtm_iconLayout);
        rtm_iconLayout.setHorizontalGroup(
            rtm_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rtm_iconLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rtm_iconLayout.setVerticalGroup(
            rtm_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuicon_panel.add(rtm_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 60, 40));

        home_icon.setBackground(new java.awt.Color(85, 65, 118));
        home_icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                home_iconMouseMoved(evt);
            }
        });
        home_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_iconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home_iconMouseExited(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_home_15px_5.png"))); // NOI18N

        javax.swing.GroupLayout home_iconLayout = new javax.swing.GroupLayout(home_icon);
        home_icon.setLayout(home_iconLayout);
        home_iconLayout.setHorizontalGroup(
            home_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_iconLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        home_iconLayout.setVerticalGroup(
            home_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuicon_panel.add(home_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 60, 40));

        profile_icon.setBackground(new java.awt.Color(64, 43, 100));
        profile_icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                profile_iconMouseMoved(evt);
            }
        });
        profile_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profile_iconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_iconMouseExited(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_user_15px_2.png"))); // NOI18N

        javax.swing.GroupLayout profile_iconLayout = new javax.swing.GroupLayout(profile_icon);
        profile_icon.setLayout(profile_iconLayout);
        profile_iconLayout.setHorizontalGroup(
            profile_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_iconLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profile_iconLayout.setVerticalGroup(
            profile_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuicon_panel.add(profile_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 60, 40));

        chat_icon.setBackground(new java.awt.Color(64, 43, 100));
        chat_icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chat_iconMouseMoved(evt);
            }
        });
        chat_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chat_iconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chat_iconMouseExited(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_chat_15px.png"))); // NOI18N

        javax.swing.GroupLayout chat_iconLayout = new javax.swing.GroupLayout(chat_icon);
        chat_icon.setLayout(chat_iconLayout);
        chat_iconLayout.setHorizontalGroup(
            chat_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chat_iconLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        chat_iconLayout.setVerticalGroup(
            chat_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuicon_panel.add(chat_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 60, 40));

        ss_icon.setBackground(new java.awt.Color(64, 43, 100));
        ss_icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ss_iconMouseMoved(evt);
            }
        });
        ss_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ss_iconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ss_iconMouseExited(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_screensharing_15px_3.png"))); // NOI18N

        javax.swing.GroupLayout ss_iconLayout = new javax.swing.GroupLayout(ss_icon);
        ss_icon.setLayout(ss_iconLayout);
        ss_iconLayout.setHorizontalGroup(
            ss_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ss_iconLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        ss_iconLayout.setVerticalGroup(
            ss_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuicon_panel.add(ss_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 60, 40));

        menulabel_panel.setBackground(new java.awt.Color(54, 33, 89));
        menulabel_panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                menulabel_panelMouseMoved(evt);
            }
        });
        menulabel_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menulabel_panelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menulabel_panelMouseExited(evt);
            }
        });

        menu_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_menu_15px_1.png"))); // NOI18N

        javax.swing.GroupLayout menulabel_panelLayout = new javax.swing.GroupLayout(menulabel_panel);
        menulabel_panel.setLayout(menulabel_panelLayout);
        menulabel_panelLayout.setHorizontalGroup(
            menulabel_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menulabel_panelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(menu_label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menulabel_panelLayout.setVerticalGroup(
            menulabel_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_label, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuicon_panel.add(menulabel_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        Logo_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        Logo_panel.setOpaque(false);
        Logo_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("NM");
        Logo_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        menuicon_panel.add(Logo_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 40, 40));

        cmd_icon.setBackground(new java.awt.Color(64, 43, 100));
        cmd_icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmd_iconMouseMoved(evt);
            }
        });
        cmd_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmd_iconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmd_iconMouseExited(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_command_15px.png"))); // NOI18N

        javax.swing.GroupLayout cmd_iconLayout = new javax.swing.GroupLayout(cmd_icon);
        cmd_icon.setLayout(cmd_iconLayout);
        cmd_iconLayout.setHorizontalGroup(
            cmd_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmd_iconLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        cmd_iconLayout.setVerticalGroup(
            cmd_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuicon_panel.add(cmd_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 60, 40));

        heading_panel.setBackground(new java.awt.Color(110, 88, 222));
        heading_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading_label.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        heading_label.setForeground(new java.awt.Color(213, 213, 213));
        heading_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        heading_label.setText("Home");
        heading_panel.add(heading_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 250, 30));

        jPanel3.setBackground(new java.awt.Color(110, 88, 222));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading_username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        heading_username.setForeground(new java.awt.Color(213, 213, 213));
        heading_username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        heading_username.setText("PROFILE");
        jPanel3.add(heading_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 150, 30));

        heading_label3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        heading_label3.setForeground(new java.awt.Color(213, 213, 213));
        heading_label3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        heading_label3.setText("Welcome");
        jPanel3.add(heading_label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(213, 213, 213));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Thanks for using our app.");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 220, 20));

        heading_panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 240, 50));
        heading_panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 260, 10));

        main_panel.setBackground(new java.awt.Color(255, 255, 255));

        miancontent_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        miancontent_label.setForeground(new java.awt.Color(54, 33, 89));
        miancontent_label.setText("content here!");

        leftBtn.setBackground(new java.awt.Color(255, 255, 255));
        leftBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        leftBtn_label.setBackground(new java.awt.Color(255, 255, 255));
        leftBtn_label.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        leftBtn_label.setForeground(new java.awt.Color(54, 33, 89));
        leftBtn_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftBtn_label.setText("btn");
        leftBtn_label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                leftBtn_labelMouseMoved(evt);
            }
        });
        leftBtn_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftBtn_labelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leftBtn_labelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout leftBtnLayout = new javax.swing.GroupLayout(leftBtn);
        leftBtn.setLayout(leftBtnLayout);
        leftBtnLayout.setHorizontalGroup(
            leftBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftBtn_label, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        leftBtnLayout.setVerticalGroup(
            leftBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftBtn_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        rightBtn.setBackground(new java.awt.Color(255, 255, 255));
        rightBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        rightBtn_label.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        rightBtn_label.setForeground(new java.awt.Color(54, 33, 89));
        rightBtn_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rightBtn_label.setText("btn");
        rightBtn_label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rightBtn_labelMouseMoved(evt);
            }
        });
        rightBtn_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightBtn_labelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rightBtn_labelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout rightBtnLayout = new javax.swing.GroupLayout(rightBtn);
        rightBtn.setLayout(rightBtnLayout);
        rightBtnLayout.setHorizontalGroup(
            rightBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightBtn_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        rightBtnLayout.setVerticalGroup(
            rightBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightBtn_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(main_panelLayout.createSequentialGroup()
                        .addComponent(leftBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(miancontent_label, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(miancontent_label, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        header_panel.setBackground(new java.awt.Color(255, 255, 255));
        header_panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                header_panelMouseDragged(evt);
            }
        });
        header_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header_panelMousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Network");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 60, 50));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_network_20px.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 20, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Computer");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MIT,2021");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 40, 40));

        close_label.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        close_label.setForeground(new java.awt.Color(172, 161, 229));
        close_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_label.setText("X");
        close_label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                close_labelMouseMoved(evt);
            }
        });
        close_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_labelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_labelMouseExited(evt);
            }
        });

        min_label.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        min_label.setForeground(new java.awt.Color(172, 161, 229));
        min_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        min_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/images/icons8_subtract_24px.png"))); // NOI18N
        min_label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                min_labelMouseMoved(evt);
            }
        });
        min_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                min_labelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                min_labelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(min_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(close_label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(min_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(close_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menu_panel.setBackground(new java.awt.Color(54, 33, 89));
        menu_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rtm.setBackground(new java.awt.Color(64, 43, 100));
        rtm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rtmMouseMoved(evt);
            }
        });
        rtm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rtmMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rtmMouseExited(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Remote Task monitoring");

        javax.swing.GroupLayout rtmLayout = new javax.swing.GroupLayout(rtm);
        rtm.setLayout(rtmLayout);
        rtmLayout.setHorizontalGroup(
            rtmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rtmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        rtmLayout.setVerticalGroup(
            rtmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rtmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_panel.add(rtm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 40));

        home.setBackground(new java.awt.Color(85, 65, 118));
        home.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                homeMouseMoved(evt);
            }
        });
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Home");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_panel.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 40));

        profile.setBackground(new java.awt.Color(64, 43, 100));
        profile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                profileMouseMoved(evt);
            }
        });
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileMouseExited(evt);
            }
        });

        profile_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profile_label.setForeground(new java.awt.Color(204, 204, 204));
        profile_label.setText("Profile");

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile_label, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_panel.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 40));

        chat.setBackground(new java.awt.Color(64, 43, 100));
        chat.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chatMouseMoved(evt);
            }
        });
        chat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chatMouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Chat");

        javax.swing.GroupLayout chatLayout = new javax.swing.GroupLayout(chat);
        chat.setLayout(chatLayout);
        chatLayout.setHorizontalGroup(
            chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        chatLayout.setVerticalGroup(
            chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_panel.add(chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 40));

        ss.setBackground(new java.awt.Color(64, 43, 100));
        ss.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ssMouseMoved(evt);
            }
        });
        ss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ssMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ssMouseExited(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("File Transfer");

        javax.swing.GroupLayout ssLayout = new javax.swing.GroupLayout(ss);
        ss.setLayout(ssLayout);
        ssLayout.setHorizontalGroup(
            ssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        ssLayout.setVerticalGroup(
            ssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_panel.add(ss, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 40));
        menu_panel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 92, 150, 10));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("NetMon");
        menu_panel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        cmd.setBackground(new java.awt.Color(64, 43, 100));
        cmd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdMouseMoved(evt);
            }
        });
        cmd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdMouseExited(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("Command");

        javax.swing.GroupLayout cmdLayout = new javax.swing.GroupLayout(cmd);
        cmd.setLayout(cmdLayout);
        cmdLayout.setHorizontalGroup(
            cmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        cmdLayout.setVerticalGroup(
            cmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_panel.add(cmd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 40));

        javax.swing.GroupLayout bg_panelLayout = new javax.swing.GroupLayout(bg_panel);
        bg_panel.setLayout(bg_panelLayout);
        bg_panelLayout.setHorizontalGroup(
            bg_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panelLayout.createSequentialGroup()
                .addComponent(menuicon_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bg_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heading_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        bg_panelLayout.setVerticalGroup(
            bg_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_panelLayout.createSequentialGroup()
                .addComponent(header_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(heading_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menuicon_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rtm_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtm_iconMouseExited
        over[5]=false;
        downMenuSelection(5);
    }//GEN-LAST:event_rtm_iconMouseExited

    private void profile_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_iconMouseExited
        over[0]=false;
        downMenuSelection(0);
    }//GEN-LAST:event_profile_iconMouseExited

    private void chat_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chat_iconMouseExited
        over[3]=false;
        downMenuSelection(3);
    }//GEN-LAST:event_chat_iconMouseExited

    private void ss_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ss_iconMouseExited
        over[4]=false;
        downMenuSelection(4);
    }//GEN-LAST:event_ss_iconMouseExited

    private void profile_iconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_iconMouseMoved
        over[0]=true;
        downMenuSelection(0);
    }//GEN-LAST:event_profile_iconMouseMoved

    private void rtm_iconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtm_iconMouseMoved
        over[5]=true;
        downMenuSelection(5);
    }//GEN-LAST:event_rtm_iconMouseMoved

    private void chat_iconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chat_iconMouseMoved
        over[3]=true;
        downMenuSelection(3);
    }//GEN-LAST:event_chat_iconMouseMoved

    private void ss_iconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ss_iconMouseMoved
        over[4]=true;
        downMenuSelection(4);
    }//GEN-LAST:event_ss_iconMouseMoved

    private void profile_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_iconMouseClicked
        clicked(0);
    }//GEN-LAST:event_profile_iconMouseClicked

    private void rtm_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtm_iconMouseClicked
        clicked(5);
    }//GEN-LAST:event_rtm_iconMouseClicked

    private void chat_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chat_iconMouseClicked
        clicked(3);
    }//GEN-LAST:event_chat_iconMouseClicked

    private void ss_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ss_iconMouseClicked
        clicked(4);
    }//GEN-LAST:event_ss_iconMouseClicked

    private void close_labelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseMoved
        close_label.setForeground(new Color(110,88,222));
    }//GEN-LAST:event_close_labelMouseMoved

    private void close_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseExited
        close_label.setForeground(new Color(149,137,208));
    }//GEN-LAST:event_close_labelMouseExited

    private void close_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_close_labelMouseClicked

    private void rtmMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtmMouseMoved
        over[5]=true;
        downMenuSelection(5);
    }//GEN-LAST:event_rtmMouseMoved

    private void rtmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtmMouseClicked
        clicked(5);
    }//GEN-LAST:event_rtmMouseClicked

    private void rtmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtmMouseExited
        over[5]=false;
        downMenuSelection(5);
    }//GEN-LAST:event_rtmMouseExited

    private void homeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseMoved
        over[1]=true;
        downMenuSelection(1);
    }//GEN-LAST:event_homeMouseMoved

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        clicked(1);
    }//GEN-LAST:event_homeMouseClicked

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
        over[1]=false;
        downMenuSelection(1);
    }//GEN-LAST:event_homeMouseExited

    private void profileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseMoved
        over[0]=true;
        downMenuSelection(0);
    }//GEN-LAST:event_profileMouseMoved

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        clicked(0);
    }//GEN-LAST:event_profileMouseClicked

    private void profileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseExited
        over[0]=false;
        downMenuSelection(0);
    }//GEN-LAST:event_profileMouseExited

    private void chatMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatMouseMoved
        over[3]=true;
        downMenuSelection(3);
    }//GEN-LAST:event_chatMouseMoved

    private void chatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatMouseClicked
        clicked(3);
    }//GEN-LAST:event_chatMouseClicked

    private void chatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatMouseExited
        over[3]=false;
        downMenuSelection(3);
    }//GEN-LAST:event_chatMouseExited

    private void ssMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssMouseMoved
        over[4]=true;
        downMenuSelection(4);
    }//GEN-LAST:event_ssMouseMoved

    private void ssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssMouseClicked
        clicked(4);
    }//GEN-LAST:event_ssMouseClicked

    private void ssMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssMouseExited
        over[4]=false;
        downMenuSelection(4);
    }//GEN-LAST:event_ssMouseExited

    private void menulabel_panelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulabel_panelMouseMoved
        menulabel_panel.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_menulabel_panelMouseMoved

    private void menulabel_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulabel_panelMouseExited
        menulabel_panel.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_menulabel_panelMouseExited

    private void menulabel_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulabel_panelMouseClicked
        if(menu_clicked)  {  
            menu_panel.setVisible(true);
            Logo_panel.setVisible(false);
            menu_clicked = false;
        }
        else {
            menu_panel.setVisible(false);
            Logo_panel.setVisible(true);
            menu_clicked = true;
        }
    }//GEN-LAST:event_menulabel_panelMouseClicked

    private void home_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_iconMouseExited
        over[1]=false;
        downMenuSelection(1);
    }//GEN-LAST:event_home_iconMouseExited

    private void home_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_iconMouseClicked
        clicked(1);
    }//GEN-LAST:event_home_iconMouseClicked

    private void home_iconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_iconMouseMoved
        over[1]=true;
        downMenuSelection(1);
    }//GEN-LAST:event_home_iconMouseMoved

    private void leftBtn_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftBtn_labelMouseExited
        leftBtn.setBackground(new Color(255,255,255));
        leftBtn_label.setForeground(new Color(54,33,89));
    }//GEN-LAST:event_leftBtn_labelMouseExited

    private void leftBtn_labelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftBtn_labelMouseMoved
        switch(leftBtn_label.getText()){
            case "Chat Now":
                if(client_started)
                    leftBtn.setEnabled(false);
                else{
                    leftBtn.setEnabled(true);
                    leftBtn.setBackground(new Color(54,33,89));
                    leftBtn_label.setForeground(new Color(255,255,255));
                }
            break;
            case "Accept":
                    leftBtn.setBackground(new Color(54,33,89));
                    leftBtn_label.setForeground(new Color(255,255,255));
            break;
            case "Quit":
                    leftBtn.setBackground(new Color(54,33,89));
                    leftBtn_label.setForeground(new Color(255,255,255));
            break;
            case "start":
                    if(screenmonitor)
                    leftBtn.setEnabled(false);
                else{
                    leftBtn.setEnabled(true);
                    leftBtn.setBackground(new Color(54,33,89));
                    leftBtn_label.setForeground(new Color(255,255,255));
                }
            break;
            case "Recieve File":
//                    if(screenmonitor)
//                    leftBtn.setEnabled(false);
//                else{
                    leftBtn.setEnabled(true);
                    leftBtn.setBackground(new Color(54,33,89));
                    leftBtn_label.setForeground(new Color(255,255,255));
//                }
            break;
        }
    }//GEN-LAST:event_leftBtn_labelMouseMoved

    private void leftBtn_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftBtn_labelMouseClicked

        switch(leftBtn_label.getText()){
            case "Chat Now":
                if(!client_started){
                    client_started=true;
                    new theClient(this).setVisible(true);
                }
            break;
            case "Accept":
                {
                cc = new commandClient(this);
                cc.start();
                cc.start_it();
                }
                leftBtn_label.setText("Quit");
            break;    
            case "Quit":
            {
                leftBtn_label.setText("Accept");
                try {
                    cc.stop_it();
                    cc.stop(); 
                } catch (IOException ex) {

                }
            }
            break;
            case "start":
                screenmonitor=true;
                Thread t1 = new Thread(new Start());
                t1.start();
                screenmonitor=false;
                
            break;
            case "Recieve File":
                ftClient fs = new ftClient(this);
                Thread t = new Thread(fs);
                t.start();
        }
    }//GEN-LAST:event_leftBtn_labelMouseClicked

    private void rightBtn_labelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightBtn_labelMouseMoved
        
    }//GEN-LAST:event_rightBtn_labelMouseMoved

    private void rightBtn_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightBtn_labelMouseClicked
        
    }//GEN-LAST:event_rightBtn_labelMouseClicked

    private void rightBtn_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightBtn_labelMouseExited
        
    }//GEN-LAST:event_rightBtn_labelMouseExited

    private void min_labelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_labelMouseMoved
        min_label.setIcon(new ImageIcon(getClass().getResource("/Home/images/icons8_subtract_24px_1.png")));
    }//GEN-LAST:event_min_labelMouseMoved

    private void min_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_labelMouseClicked
        setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_min_labelMouseClicked

    private void min_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_labelMouseExited
        min_label.setIcon(new ImageIcon(getClass().getResource("/Home/images/icons8_subtract_24px.png")));
    }//GEN-LAST:event_min_labelMouseExited

    private void header_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header_panelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_header_panelMousePressed

    private void header_panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header_panelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse-menu_panel.getWidth()-menuicon_panel.getWidth(),y-yMouse);
    }//GEN-LAST:event_header_panelMouseDragged

    private void cmd_iconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_iconMouseMoved
        over[2]=true;
        downMenuSelection(2);
    }//GEN-LAST:event_cmd_iconMouseMoved

    private void cmd_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_iconMouseClicked
        clicked(2);
    }//GEN-LAST:event_cmd_iconMouseClicked

    private void cmd_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_iconMouseExited
        over[2]=false;
        downMenuSelection(2);       
    }//GEN-LAST:event_cmd_iconMouseExited

    private void cmdMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseMoved
        over[2]=true;
        downMenuSelection(2);
    }//GEN-LAST:event_cmdMouseMoved

    private void cmdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseClicked
        clicked(2);
    }//GEN-LAST:event_cmdMouseClicked

    private void cmdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseExited
        over[2]=false;
        downMenuSelection(2);
    }//GEN-LAST:event_cmdMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface("234234","muhilan").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Logo_panel;
    private javax.swing.JPanel bg_panel;
    private javax.swing.JPanel chat;
    private javax.swing.JPanel chat_icon;
    private javax.swing.JLabel close_label;
    private javax.swing.JPanel cmd;
    private javax.swing.JPanel cmd_icon;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel heading_label;
    private javax.swing.JLabel heading_label3;
    private javax.swing.JPanel heading_panel;
    private javax.swing.JLabel heading_username;
    private javax.swing.JPanel home;
    private javax.swing.JPanel home_icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel leftBtn;
    private javax.swing.JLabel leftBtn_label;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel menu_label;
    private javax.swing.JPanel menu_panel;
    private javax.swing.JPanel menuicon_panel;
    private javax.swing.JPanel menulabel_panel;
    private javax.swing.JLabel miancontent_label;
    private javax.swing.JLabel min_label;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel profile_icon;
    private javax.swing.JLabel profile_label;
    private javax.swing.JPanel rightBtn;
    private javax.swing.JLabel rightBtn_label;
    private javax.swing.JPanel rtm;
    private javax.swing.JPanel rtm_icon;
    private javax.swing.JPanel ss;
    private javax.swing.JPanel ss_icon;
    // End of variables declaration//GEN-END:variables
}
