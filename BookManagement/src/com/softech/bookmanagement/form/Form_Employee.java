/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.form;

import com.softech.bookmanagement.helpers.DataValidator;
import com.softech.bookmanagement.helpers.DatabaseHelper;
import com.softech.bookmanagement.helpers.MessageDialogHelper;
import com.softech.bookmanagement.model.Employee;
import com.softech.bookmanagement.model.EmployeeDAO;
import com.softech.bookmanagement.model.SetImage;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Bae
 */
public class Form_Employee extends javax.swing.JPanel {
    DefaultTableModel tblModel;
    SetImage img = new SetImage();
    String imgFile ="";
    private JFrame mainFrame;
    public Form_Employee() {
        initComponents();
        initTable();
        loadTable();
        LoadRole();
        btnAdd.setSize(20, 20);
        new SetImage().setImageButton(btnAdd, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\add.png");
        btnUpdate.setSize(20, 20);
        new SetImage().setImageButton(btnUpdate, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\pencil.png");
        btnDelete.setSize(20, 20);
        new SetImage().setImageButton(btnDelete, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\bin.png");
    }

    private void initTable (){
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"EmployeeID","FullName","Phone","Address","Username","Role","Image"});
        tblEmplyee.setModel(tblModel); 
    }
    private void loadTable(){
        try{
            EmployeeDAO dao = new EmployeeDAO();
            List<Employee> list = dao.findAll();
            tblModel.setRowCount(0);
            for(Employee em:list){
                tblModel.addRow(new Object[]{
                    em.getUserID(),em.getFullName(),em.getPhone(),em.getAddress(),em.getUsername(),em.getRoleID(),em.getImage()
                });
            }
            tblModel.fireTableDataChanged();
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
        }
    }
    void LoadRole(){
        String sql = "Select RoleName from Role";
        cbRole.removeAllItems();
        try{
        PreparedStatement pstmt = DatabaseHelper.connectSQLServer().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cbRole.addItem(rs.getString("RoleName")); 
            }
            rs.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        panelBorder1 = new com.softech.bookmanagement.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblEmplyee = new com.softech.bookmanagement.swing.Table();
        panel2 = new javax.swing.JLayeredPane();
        txtUsername = new javax.swing.JTextField();
        cbRole = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel3 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        searchemp = new com.softech.bookmanagement.swing.SearchText();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(919, 751));

        txtId.setBackground(new java.awt.Color(242, 242, 242));
        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtId.setToolTipText("");
        txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(63, 43, 150));
        jLabel3.setText("Fullname");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(63, 43, 150));
        jLabel2.setText("Phone");

        txtPhone.setBackground(new java.awt.Color(242, 242, 242));
        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhone.setToolTipText("");
        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(63, 43, 150));
        jLabel5.setText("Address");

        txtAddress.setBackground(new java.awt.Color(242, 242, 242));
        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddress.setToolTipText("");
        txtAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 43, 150));
        jLabel8.setText("Employee ID");

        txtFullname.setBackground(new java.awt.Color(242, 242, 242));
        txtFullname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFullname.setToolTipText("");
        txtFullname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        panel.setLayer(txtId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(txtPhone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(txtAddress, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(txtFullname, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress)
                    .addComponent(txtPhone)
                    .addComponent(txtId)
                    .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Employee Management");

        tblEmplyee.setBackground(new java.awt.Color(242, 242, 242));
        tblEmplyee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeID", "Fullname", "Phone", "Address", "Username", "Role", "Image"
            }
        ));
        tblEmplyee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblEmplyee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmplyeeMouseClicked(evt);
            }
        });
        spTable.setViewportView(tblEmplyee);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spTable, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtUsername.setBackground(new java.awt.Color(242, 242, 242));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setToolTipText("");
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        cbRole.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbRole.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(63, 43, 150));
        jLabel4.setText("Role");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(63, 43, 150));
        jLabel9.setText("Username");

        panel2.setLayer(txtUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(cbRole, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername)
                    .addComponent(cbRole, 0, 258, Short.MAX_VALUE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );

        btnAdd.setBackground(new java.awt.Color(63, 43, 150));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("   ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(63, 43, 150));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("   UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(63, 43, 150));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("   DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        panel3.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnUpdate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/softech/bookmanagement/icon/search.png"))); // NOI18N

        searchemp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchempActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchemp, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(searchemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void setFieldEmpty(){
        txtId.setText("");
        txtFullname.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtUsername.setText("");    
    }
    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void tblEmplyeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmplyeeMouseClicked
        tblModel = (DefaultTableModel) tblEmplyee.getModel();
        int selectedrowindex = tblEmplyee.getSelectedRow();
        txtId.setText(tblModel.getValueAt(selectedrowindex, 0).toString());
        try
        {
            String sql = "Select * from [User] where UserID = ?";
            PreparedStatement pstmt1 =  DatabaseHelper.connectSQLServer().prepareStatement(sql);
            pstmt1.setString(1, txtId.getText());
            ResultSet rs1 = pstmt1.executeQuery();
            if (rs1.next()) {
                txtFullname.setText(rs1.getString("Fullname"));
                txtAddress.setText(rs1.getString("Address"));
                txtPhone.setText(rs1.getString("Phone"));
                txtUsername.setText(rs1.getString("Username"));
                cbRole.setSelectedItem(tblModel.getValueAt(selectedrowindex, 5).toString());
                if(rs1.getString("Image") != null)
                {
                    img.setImageLabel(lbImage, "image//" + rs1.getString("Image"));
                }
                else
                {
                    lbImage.setIcon(null);
                }
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_tblEmplyeeMouseClicked

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtId, sb," EmployeeId is not empty");
        DataValidator.validateEmpty(txtFullname, sb," EmployeeFullname is not empty");
        DataValidator.validateEmpty(txtPhone, sb," EmployeeFullname is not empty");
        DataValidator.validateEmpty(txtAddress, sb," EmployeeFullname is not empty");
        DataValidator.validateEmpty(txtUsername, sb," EmployeeFullname is not empty");
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        try{
            String RoleID = "";
            String getRoleID = "Select RoleID from [Role] where RoleName= ?";
            PreparedStatement pstmt2 =  DatabaseHelper.connectSQLServer().prepareStatement(getRoleID);
            pstmt2.setString(1, cbRole.getSelectedItem().toString());
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
              RoleID  = rs2.getString("RoleID");
            }
            Employee emp = new Employee();
            emp.setUserID(txtId.getText());
            emp.setFullName(txtFullname.getText());
            emp.setPhone(txtPhone.getText());
            emp.setAddress(txtAddress.getText());
            emp.setUsername(txtUsername.getText());
            emp.setPassword("bookshop");
//            emp.setStatus(1);
//            emp.setRoleID(cbRole.getSelectedItem().toString() == "admin"?"1":"2");
            emp.setRoleID(RoleID);
            System.out.println(emp.getFullName());
            EmployeeDAO empDAO = new EmployeeDAO();
            if(empDAO.insert(emp)){
                MessageDialogHelper.showMessageDialog(mainFrame,"Employee is saved in database","notification" );
            }else{
                MessageDialogHelper.showConfirmDialog(mainFrame,"Employee is save failed" , "notification");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame,e.getMessage(),"error" );
        }
        loadTable();
        setFieldEmpty();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtId, sb," EmployeeId is not empty");
        DataValidator.validateEmpty(txtFullname, sb," EmployeeFullname is not empty");
        DataValidator.validateEmpty(txtPhone, sb," EmployeeFullname is not empty");
        DataValidator.validateEmpty(txtAddress, sb," EmployeeFullname is not empty");
        DataValidator.validateEmpty(txtUsername, sb," EmployeeFullname is not empty");
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(mainFrame,sb.toString() ,"ERROR");
            return ;
        }
        
        if(MessageDialogHelper.showConfirmDialog(mainFrame,"are you sure?","Question") == JOptionPane.NO_OPTION){
            return;
        }
        
        try{
            String RoleID = "";
            String getRoleID = "Select RoleID from [Role] where RoleName= ?";
            PreparedStatement pstmt2 =  DatabaseHelper.connectSQLServer().prepareStatement(getRoleID);
            pstmt2.setString(1, cbRole.getSelectedItem().toString());
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
              RoleID  = rs2.getString("RoleID");
            }
            Employee emp = new Employee();
            emp.setUserID(txtId.getText());
            emp.setFullName(txtFullname.getText());
            emp.setPhone(txtPhone.getText());
            emp.setAddress(txtAddress.getText());
            emp.setUsername(txtUsername.getText());
//            emp.setStatus(1);
//            emp.setRoleID(cbRole.getSelectedItem().toString() == "admin"?"1":"2");
            emp.setRoleID(RoleID);
            EmployeeDAO empDAO = new EmployeeDAO();
            if(empDAO.update(emp)){
                MessageDialogHelper.showMessageDialog(mainFrame,"Employee is update success", "notification");
            }else{
                MessageDialogHelper.showConfirmDialog(mainFrame, "Employee is update failed", "notification");
            }
            setFieldEmpty();
            
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame,e.getMessage(), "error");
        }
        loadTable();
        setFieldEmpty();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        StringBuilder sb = new StringBuilder();
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(mainFrame, sb.toString(),"ERROR");
            return ;
        }
        
        if(MessageDialogHelper.showConfirmDialog(mainFrame,"are you sure","question") == JOptionPane.NO_OPTION){
            return;
        }
        
        try{
            EmployeeDAO empDAO = new EmployeeDAO();
            if(empDAO.delete(txtId.getText())){
                MessageDialogHelper.showMessageDialog(mainFrame,"Employee is delete success", "notification");
            }else{
                MessageDialogHelper.showConfirmDialog(mainFrame, "Employee is delete failed", "notification");
            }
             setFieldEmpty();
            
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame,e.getMessage(), "error");
        }
        loadTable();
        setFieldEmpty();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void searchempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchempActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JLayeredPane panel2;
    private javax.swing.JLayeredPane panel3;
    private com.softech.bookmanagement.swing.PanelBorder panelBorder1;
    private com.softech.bookmanagement.swing.SearchText searchemp;
    private javax.swing.JScrollPane spTable;
    private com.softech.bookmanagement.swing.Table tblEmplyee;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
