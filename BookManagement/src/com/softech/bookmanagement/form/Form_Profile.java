package com.softech.bookmanagement.form;

import com.softech.bookmanagement.helpers.DataValidator;
import com.softech.bookmanagement.helpers.DatabaseHelper;
import com.softech.bookmanagement.helpers.MessageDialogHelper;
import com.softech.bookmanagement.model.SetImage;
import com.softech.bookmanagement.model.User;
import com.softech.bookmanagement.model.UserDAO;
import com.softech.bookmanagement.view.frmMainLogin;
import java.awt.Color;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nguyen Bae
 */
public class Form_Profile extends javax.swing.JPanel {
    String getusername ="";
    SetImage img = new SetImage();
    String imgFile ="";
    public Form_Profile(String username) {
        initComponents();
        LoadProfile(username);
        getusername = username;
    }
    void LoadProfile(String username){
        lbImage.setSize(168, 235);
        String sql = "Select * from [User] where Username= ?";
        try{
            PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);
//            frmMainLogin login = new frmMainLogin();
//            ps.setString(1, login.txtUsername.toString());
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();    
            if(rs.next()){
                txtUsername.setText(rs.getString("Username"));
                txtFullname.setText(rs.getString("Fullname"));
                txtPhone.setText(rs.getString("Phone"));
                txtAddress.setText(rs.getString("Address"));
                System.out.println(rs.getString("Image"));
                img.setImageLabel(lbImage, "image//" + rs.getString("Image"));
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        txtISBN3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTitle3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtAuthor6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtAuthor7 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnAdd3 = new keeptoo.KButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnSavePass = new keeptoo.KButton();
        txtNewPass = new javax.swing.JPasswordField();
        txtOldPass = new javax.swing.JPasswordField();
        txtConfirmPass = new javax.swing.JPasswordField();
        lbMessage = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        btnBrowser = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtFullname = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnSaveInfo = new keeptoo.KButton();
        txtUsername = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(242, 242, 242));

        txtISBN3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtISBN3.setToolTipText("");
        txtISBN3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(63, 43, 150));
        jLabel16.setText("Fullname");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(63, 43, 150));
        jLabel17.setText("Phone");

        txtTitle3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitle3.setToolTipText("");
        txtTitle3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));
        txtTitle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitle3ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(63, 43, 150));
        jLabel18.setText("Address");

        txtAuthor6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAuthor6.setToolTipText("");
        txtAuthor6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(127, 127, 127));
        jLabel19.setText("Profile Management");

        txtAuthor7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAuthor7.setToolTipText("");
        txtAuthor7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(63, 43, 150));
        jLabel20.setText("Email");

        btnAdd3.setText("ADD");
        btnAdd3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAdd3.setkEndColor(new java.awt.Color(168, 192, 255));
        btnAdd3.setkHoverEndColor(new java.awt.Color(63, 43, 150));
        btnAdd3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAdd3.setkHoverStartColor(new java.awt.Color(168, 192, 255));
        btnAdd3.setkStartColor(new java.awt.Color(63, 43, 150));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtAuthor6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(txtTitle3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtISBN3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(txtAuthor7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtISBN3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAuthor6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAuthor7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(919, 620));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(63, 43, 150));
        jLabel31.setText("Old Password");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(63, 43, 150));
        jLabel32.setText("New Password");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(63, 43, 150));
        jLabel33.setText("Confirm Password");

        jLabel34.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(127, 127, 127));
        jLabel34.setText("Change Password");

        btnSavePass.setText("SAVE CHANGE");
        btnSavePass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSavePass.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSavePass.setkEndColor(new java.awt.Color(168, 192, 255));
        btnSavePass.setkHoverEndColor(new java.awt.Color(63, 43, 150));
        btnSavePass.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSavePass.setkHoverStartColor(new java.awt.Color(168, 192, 255));
        btnSavePass.setkSelectedColor(new java.awt.Color(63, 43, 150));
        btnSavePass.setkStartColor(new java.awt.Color(63, 43, 150));
        btnSavePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePassActionPerformed(evt);
            }
        });

        txtNewPass.setBackground(new java.awt.Color(242, 242, 242));
        txtNewPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        txtOldPass.setBackground(new java.awt.Color(242, 242, 242));
        txtOldPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        txtConfirmPass.setBackground(new java.awt.Color(242, 242, 242));
        txtConfirmPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        lbMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(63, 43, 150));

        jLayeredPane3.setLayer(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel32, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel33, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnSavePass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(txtNewPass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(txtOldPass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(txtConfirmPass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(lbMessage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel34)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33)
                            .addComponent(jLabel32)
                            .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(btnSavePass, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel34)
                .addGap(26, 26, 26)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSavePass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lbMessage)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbImage.setMinimumSize(new java.awt.Dimension(168, 235));
        lbImage.setPreferredSize(new java.awt.Dimension(168, 235));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnBrowser.setText("Browser");
        btnBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnBrowser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnBrowser, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBrowser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtFullname.setBackground(new java.awt.Color(242, 242, 242));
        txtFullname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFullname.setToolTipText("");
        txtFullname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(63, 43, 150));
        jLabel21.setText("Fullname");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(63, 43, 150));
        jLabel22.setText("Phone");

        txtPhone.setBackground(new java.awt.Color(242, 242, 242));
        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhone.setToolTipText("");
        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(63, 43, 150));
        jLabel23.setText("Address");

        txtAddress.setBackground(new java.awt.Color(242, 242, 242));
        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddress.setToolTipText("");
        txtAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(127, 127, 127));
        jLabel24.setText("Profile Management");

        btnSaveInfo.setText("SAVE CHANGE");
        btnSaveInfo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaveInfo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSaveInfo.setkEndColor(new java.awt.Color(168, 192, 255));
        btnSaveInfo.setkHoverEndColor(new java.awt.Color(63, 43, 150));
        btnSaveInfo.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSaveInfo.setkHoverStartColor(new java.awt.Color(168, 192, 255));
        btnSaveInfo.setkSelectedColor(new java.awt.Color(63, 43, 150));
        btnSaveInfo.setkStartColor(new java.awt.Color(63, 43, 150));
        btnSaveInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInfoActionPerformed(evt);
            }
        });

        txtUsername.setBackground(new java.awt.Color(242, 242, 242));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setToolTipText("");
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(63, 43, 150));
        jLabel25.setText("Username");

        jLayeredPane1.setLayer(txtFullname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtPhone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtAddress, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnSaveInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnSaveInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSaveInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane2)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTitle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitle3ActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void btnSaveInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInfoActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtFullname, sb," FullName is empty");
        DataValidator.validateEmpty(txtUsername, sb," UserName is empty");
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        try{
            String UserID = "";
            String getUserID = "Select UserID from [User] where Username= ?";
            PreparedStatement pstmt2 =  DatabaseHelper.connectSQLServer().prepareStatement(getUserID);
            pstmt2.setString(1, getusername);
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
              UserID  = rs2.getString("UserID");
            }
            User user = new User();
            user.setUsername(txtUsername.getText());
            user.setFullname(txtFullname.getText());
            user.setPhone(txtPhone.getText());
            user.setAddress(txtAddress.getText());
            user.setImage(imgFile);
            user.setUserid(UserID);
            UserDAO dao = new UserDAO();
            dao.UpdateInfo(user);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveInfoActionPerformed

    private void btnSavePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePassActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtOldPass, sb,"Old Pass is empty");
        DataValidator.validateEmpty(txtNewPass, sb,"New Pass is empty");
        DataValidator.validateEmpty(txtConfirmPass, sb,"Confirm Pass is empty");
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        try{
            String UserID = "";
            String Password = "";
            String getUserID = "Select UserID from [User] where Username= ?";
            PreparedStatement pstmt2 =  DatabaseHelper.connectSQLServer().prepareStatement(getUserID);
            pstmt2.setString(1, getusername);
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
              UserID  = rs2.getString("UserID");
            }
            String getPassword = "Select Password from [User] where Username= ?";
            PreparedStatement psPass =  DatabaseHelper.connectSQLServer().prepareStatement(getPassword);
            psPass.setString(1, getusername);
            ResultSet rsPass = psPass.executeQuery();
            while (rsPass.next()) {
              Password  = rsPass.getString("Password");
            }
            String oldPassword = new String(txtOldPass.getPassword());
            String newPassword = new String(txtNewPass.getPassword());
            String confirmPassword = new String(txtConfirmPass.getPassword());
            System.out.println(oldPassword + " " + Password);
            if(!oldPassword.equals(Password)){
                lbMessage.setText("Incorrect Old Password!!!");
                lbMessage.setForeground(Color.red);
            }
            else if(!confirmPassword.equals(newPassword)){
                lbMessage.setText("Confirm password doesn't match!!!");
                lbMessage.setForeground(Color.red);     
            }
            else{
                User user = new User();
                user.setPassword(newPassword);
                user.setUserid(UserID);
                UserDAO dao = new UserDAO();
                dao.UpdatePassword(user);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnSavePassActionPerformed

    private void btnBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowserActionPerformed
        JFileChooser fileChooser = new JFileChooser("image");
        FileFilter filter = new FileNameExtensionFilter("*.Images", "gjf", "jpg", "png");
        fileChooser.addChoosableFileFilter(filter);
   
        fileChooser.setMultiSelectionEnabled(false);

        int action = fileChooser.showOpenDialog(this);
        if (action == JFileChooser.APPROVE_OPTION) {
            while (true) {
                if (!fileChooser.getSelectedFile().getName().matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)")) {
                    JOptionPane.showMessageDialog(null, "Định dạng file hình đuôi phải là GIF, JPG, PNG !");
                    return;
                } else {
                    break;
                }
            }
            File selectedFile = fileChooser.getSelectedFile();
            String Path = selectedFile.getAbsolutePath();
            imgFile = fileChooser.getSelectedFile().getName();
            img.setImageLabel(lbImage, "image//" + imgFile);
        }
    }//GEN-LAST:event_btnBrowserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnAdd3;
    private javax.swing.JButton btnBrowser;
    private keeptoo.KButton btnSaveInfo;
    private keeptoo.KButton btnSavePass;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAuthor6;
    private javax.swing.JTextField txtAuthor7;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtISBN3;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtOldPass;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtTitle3;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
