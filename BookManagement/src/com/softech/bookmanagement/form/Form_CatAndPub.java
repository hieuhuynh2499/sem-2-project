package com.softech.bookmanagement.form;

import com.softech.bookmanagement.helpers.DataValidator;
import com.softech.bookmanagement.helpers.DatabaseHelper;
import com.softech.bookmanagement.helpers.MessageDialogHelper;
import com.softech.bookmanagement.model.Book;
import com.softech.bookmanagement.model.BookDAO;
import com.softech.bookmanagement.model.Category;
import com.softech.bookmanagement.model.CategoryDAO;
import com.softech.bookmanagement.model.Employee;
import com.softech.bookmanagement.model.EmployeeDAO;
import com.softech.bookmanagement.model.Publisher;
import com.softech.bookmanagement.model.PublisherDAO;
import com.softech.bookmanagement.model.SetImage;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Bae
 */
public class Form_CatAndPub extends javax.swing.JPanel {
    private DefaultTableModel tblModel;
    SetImage img = new SetImage();
    String imgFile ="";
    
    public Form_CatAndPub() {
        initComponents();
        initTableCate ();
        loadTableCate();
        initTablePub ();
        loadTablePub();
        btnAddPub.setSize(20, 20);
        new SetImage().setImageButton(btnAddPub, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\add.png");
        btnUpdatePub.setSize(20, 20);
        new SetImage().setImageButton(btnUpdatePub, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\pencil.png");
        btnDeletePub.setSize(20, 20);
        new SetImage().setImageButton(btnDeletePub, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\bin.png");
        btnAddCat.setSize(20, 20);
        new SetImage().setImageButton(btnAddCat, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\add.png");
        btnUpdateCat.setSize(20, 20);
        new SetImage().setImageButton(btnUpdateCat, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\pencil.png");
        btnDeleteCat.setSize(20, 20);
        new SetImage().setImageButton(btnDeleteCat, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\bin.png");
    }

    private void initTableCate (){
         tblModel = new DefaultTableModel();
         tblModel.setColumnIdentifiers(new String[]{"CategoryId","CategoryName"});
         tblCategory.setModel(tblModel); 
    }
    private void loadTableCate(){
        try{
            CategoryDAO dao = new CategoryDAO();
            List<Category> list = dao.findAll();
            tblModel.setRowCount(0);
            for(Category em:list){
                tblModel.addRow(new Object[]{
                    em.getCategoryId(),em.getCategoryName()
                });
            }
            tblModel.fireTableDataChanged();
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
        }
    }
    private void initTablePub (){
         tblModel = new DefaultTableModel();
         tblModel.setColumnIdentifiers(new String[]{"PublisherID","PublisherName","PublisherPhone","PublisherPhone","PublisheEmail","Image"});
         tblPublisher.setModel(tblModel); 
    }
    private void loadTablePub(){
        try{
            PublisherDAO dao = new PublisherDAO();
            List<Publisher> list = dao.findAll();
            tblModel.setRowCount(0);
            for(Publisher em:list){
                tblModel.addRow(new Object[]{
                   em.getID(),em.getPushlisherNameString(),em.getPhone(),em.getAddress(),em.getEmail(),em.getImage()
                });
            }
            tblModel.fireTableDataChanged();
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        txtCategoryName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCategoryId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAddCat = new javax.swing.JButton();
        btnUpdateCat = new javax.swing.JButton();
        btnDeleteCat = new javax.swing.JButton();
        panelBorder1 = new com.softech.bookmanagement.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblCategory = new com.softech.bookmanagement.swing.Table();
        spTable1 = new javax.swing.JScrollPane();
        tblPublisher = new com.softech.bookmanagement.swing.Table();
        panel2 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPublisherPhone = new javax.swing.JTextField();
        txtPublisherId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPublisherAddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPublisherEmail = new javax.swing.JTextField();
        txtPublisherName = new javax.swing.JTextField();
        txtPublicName = new javax.swing.JLabel();
        panel3 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        btnBrowser = new javax.swing.JButton();
        btnAddPub = new javax.swing.JButton();
        btnUpdatePub = new javax.swing.JButton();
        btnDeletePub = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        searchcat = new com.softech.bookmanagement.swing.SearchText();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(919, 751));

        panel.setPreferredSize(new java.awt.Dimension(279, 252));
        panel.setRequestFocusEnabled(false);

        txtCategoryName.setBackground(new java.awt.Color(242, 242, 242));
        txtCategoryName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCategoryName.setToolTipText("");
        txtCategoryName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(63, 43, 150));
        jLabel3.setText("Category Name");

        txtCategoryId.setBackground(new java.awt.Color(242, 242, 242));
        txtCategoryId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCategoryId.setToolTipText("");
        txtCategoryId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(63, 43, 150));
        jLabel4.setText("Category Id");

        btnAddCat.setBackground(new java.awt.Color(63, 43, 150));
        btnAddCat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddCat.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCat.setText("     ADD");
        btnAddCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCatActionPerformed(evt);
            }
        });

        btnUpdateCat.setBackground(new java.awt.Color(63, 43, 150));
        btnUpdateCat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateCat.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCat.setText("   UPDATE");
        btnUpdateCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCatActionPerformed(evt);
            }
        });

        btnDeleteCat.setBackground(new java.awt.Color(63, 43, 150));
        btnDeleteCat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteCat.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCat.setText("    DELETE");
        btnDeleteCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCatActionPerformed(evt);
            }
        });

        panel.setLayer(txtCategoryName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(txtCategoryId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(btnAddCat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(btnUpdateCat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(btnDeleteCat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCategoryId)
                    .addComponent(txtCategoryName)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnAddCat, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(btnUpdateCat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(btnDeleteCat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddCat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateCat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteCat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Category and Publisher Management");

        tblCategory.setBackground(new java.awt.Color(242, 242, 242));
        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Name"
            }
        ));
        tblCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        spTable.setViewportView(tblCategory);

        tblPublisher.setBackground(new java.awt.Color(242, 242, 242));
        tblPublisher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Publisher Name", "Publisher Phone", "Publisher Address", "Publisher Email", "Image"
            }
        ));
        tblPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPublisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPublisherMouseClicked(evt);
            }
        });
        spTable1.setViewportView(tblPublisher);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel2.setPreferredSize(new java.awt.Dimension(278, 282));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(63, 43, 150));
        jLabel6.setText("Publisher Id");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 43, 150));
        jLabel7.setText("Publisher Phone");

        txtPublisherPhone.setBackground(new java.awt.Color(242, 242, 242));
        txtPublisherPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisherPhone.setToolTipText("");
        txtPublisherPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        txtPublisherId.setBackground(new java.awt.Color(242, 242, 242));
        txtPublisherId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisherId.setToolTipText("");
        txtPublisherId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));
        txtPublisherId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherIdActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 43, 150));
        jLabel8.setText("Publisher Address");

        txtPublisherAddress.setBackground(new java.awt.Color(242, 242, 242));
        txtPublisherAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisherAddress.setToolTipText("");
        txtPublisherAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(63, 43, 150));
        jLabel9.setText("Publisher Email");

        txtPublisherEmail.setBackground(new java.awt.Color(242, 242, 242));
        txtPublisherEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisherEmail.setToolTipText("");
        txtPublisherEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        txtPublisherName.setBackground(new java.awt.Color(242, 242, 242));
        txtPublisherName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisherName.setToolTipText("");
        txtPublisherName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));
        txtPublisherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherNameActionPerformed(evt);
            }
        });

        txtPublicName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPublicName.setForeground(new java.awt.Color(63, 43, 150));
        txtPublicName.setText("Publisher Name");

        panel2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherPhone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherAddress, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublicName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPublisherId)
                    .addComponent(txtPublisherPhone)
                    .addComponent(txtPublisherAddress)
                    .addComponent(txtPublisherEmail)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(txtPublicName))
                        .addGap(0, 136, Short.MAX_VALUE))
                    .addComponent(txtPublisherName, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPublisherId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPublicName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPublisherName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPublisherPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPublisherAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPublisherEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        panel3.setPreferredSize(new java.awt.Dimension(298, 282));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        );

        btnBrowser.setText("Browse");
        btnBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserActionPerformed(evt);
            }
        });

        btnAddPub.setBackground(new java.awt.Color(63, 43, 150));
        btnAddPub.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddPub.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPub.setText("   ADD");
        btnAddPub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPubActionPerformed(evt);
            }
        });

        btnUpdatePub.setBackground(new java.awt.Color(63, 43, 150));
        btnUpdatePub.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdatePub.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePub.setText("   UPDATE");
        btnUpdatePub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePubActionPerformed(evt);
            }
        });

        btnDeletePub.setBackground(new java.awt.Color(63, 43, 150));
        btnDeletePub.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeletePub.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletePub.setText("   DELETE");
        btnDeletePub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePubActionPerformed(evt);
            }
        });

        panel3.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnBrowser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnAddPub, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnUpdatePub, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnDeletePub, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnBrowser, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPub, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(btnUpdatePub, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(btnDeletePub, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrowser))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAddPub, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdatePub, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletePub, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/softech/bookmanagement/icon/search.png"))); // NOI18N

        searchcat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchcat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(searchcat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPublisherIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherIdActionPerformed

    private void txtPublisherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherNameActionPerformed

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked
        tblModel = (DefaultTableModel) tblCategory.getModel();
        int selectedrowindex = tblCategory.getSelectedRow();
        txtCategoryId.setText(tblModel.getValueAt(selectedrowindex, 0).toString());
        txtCategoryName.setText(tblModel.getValueAt(selectedrowindex, 1).toString());
    }//GEN-LAST:event_tblCategoryMouseClicked

    private void tblPublisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPublisherMouseClicked
        tblModel = (DefaultTableModel) tblPublisher.getModel();
        int selectedrowindex = tblPublisher.getSelectedRow();
        txtPublisherId.setText(tblModel.getValueAt(selectedrowindex, 0).toString());
        try{
        String sql = "Select * from Publisher where PublisherID = ?";
        PreparedStatement pstmt1 =  DatabaseHelper.connectSQLServer().prepareStatement(sql);
            pstmt1.setString(1, txtPublisherId.getText());
            ResultSet rs1 = pstmt1.executeQuery();
            if (rs1.next()) {
                String Name = rs1.getString("PublisherName");
                 txtPublisherName.setText(Name);
                String Phone = rs1.getString("Phone");
                txtPublisherPhone.setText(Phone);
                String Address = rs1.getString("Address");
                txtPublisherAddress.setText(Address);
                String Email = rs1.getString("Email");
                txtPublisherEmail.setText(Email);
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
    }//GEN-LAST:event_tblPublisherMouseClicked

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
//            txtHinh.setText(imgFile);
            img.setImageLabel(lbImage, "image//" + imgFile);
        }
    }//GEN-LAST:event_btnBrowserActionPerformed

    private void btnAddPubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPubActionPerformed
        // TODO add your handling code here:
         StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtPublisherId, sb," PublisherId is not empty");
        DataValidator.validateEmpty(txtPublisherName, sb," PublisherName is not empty");
        DataValidator.validateEmpty(txtPublisherEmail, sb," PublisherEmail is not empty");
         DataValidator.validateEmpty(txtPublisherAddress, sb," PublisherAddress is not empty");
         DataValidator.validateEmpty(txtPublisherPhone, sb," PublisherPhone is not empty");
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        try{
            Publisher publisher = new Publisher();
            publisher.setID(txtPublisherId.getText());
            publisher.setPushlisherNameString(txtPublisherName.getText());
            publisher.setEmail(txtPublisherEmail.getText());
            publisher.setAddress(txtPublisherAddress.getText());
            publisher.setPhone(txtPublisherPhone.getText());
            publisher.setImage(imgFile);
            PublisherDAO puclisherDAO = new PublisherDAO();
            puclisherDAO.insert(publisher);
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null,e.getMessage(), "error");
        }
        initTablePub();
        loadTablePub();
    }//GEN-LAST:event_btnAddPubActionPerformed

    private void btnUpdatePubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePubActionPerformed
        // TODO add your handling code here:
         StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtPublisherId, sb," PublisherId is not empty");
        DataValidator.validateEmpty(txtPublisherName, sb," PublisherName is not empty");
        DataValidator.validateEmpty(txtPublisherEmail, sb," PublisherEmail is not empty");
         DataValidator.validateEmpty(txtPublisherAddress, sb," PublisherAddress is not empty");
         DataValidator.validateEmpty(txtPublisherPhone, sb," PublisherPhone is not empty");
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        try{
            Publisher publisher = new Publisher();
            publisher.setID(txtPublisherId.getText());
            publisher.setPushlisherNameString(txtPublisherName.getText());
            publisher.setEmail(txtPublisherEmail.getText());
            publisher.setAddress(txtPublisherAddress.getText());
            publisher.setPhone(txtPublisherPhone.getText());
            publisher.setImage(imgFile);
            PublisherDAO puclisherDAO = new PublisherDAO();
            puclisherDAO.update(publisher);
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null,e.getMessage(), "error");
        }
        initTablePub();
        loadTablePub();
    }//GEN-LAST:event_btnUpdatePubActionPerformed

    private void btnDeletePubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePubActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        
        if(MessageDialogHelper.showConfirmDialog(null,"are you sure","question") == JOptionPane.NO_OPTION){
            return;
        }
        
        try{
            PublisherDAO publisherDAO = new PublisherDAO();
            if(publisherDAO.delete(txtPublisherId.getText())){
                MessageDialogHelper.showMessageDialog(null,"Publisher is delete success", "notification");
            }else{
                MessageDialogHelper.showConfirmDialog(null, "Publisher is delete failed", "notification");
            } 
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null,e.getMessage(), "error");
        }
        initTablePub();
        loadTablePub();
    }//GEN-LAST:event_btnDeletePubActionPerformed

    private void btnAddCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCatActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtCategoryId, sb," Category is not empty");
        DataValidator.validateEmpty(txtCategoryName, sb," CategoryName is not empty");
  
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        try{
            Category cate = new Category();
           cate.setCategoryId(txtCategoryId.getText());
           cate.setCategoryName(txtCategoryName.getText());
            CategoryDAO cateDAO = new CategoryDAO();
            if(cateDAO.insert(cate)){
                MessageDialogHelper.showMessageDialog(null,"Category is saved in database", "notification");
            }else{
                MessageDialogHelper.showConfirmDialog(null, "Category is save failed", "notification");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null,e.getMessage(), "error");
        }
        initTableCate();
        loadTableCate();
    }//GEN-LAST:event_btnAddCatActionPerformed

    private void btnUpdateCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCatActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtCategoryId, sb," Category is not empty");
        DataValidator.validateEmpty(txtCategoryName, sb," CategoryName is not empty");
  
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        try{
            Category cate = new Category();
           cate.setCategoryId(txtCategoryId.getText());
           cate.setCategoryName(txtCategoryName.getText());
            CategoryDAO cateDAO = new CategoryDAO();
            if(cateDAO.update(cate)){
                MessageDialogHelper.showMessageDialog(null,"Category is saved in database", "notification");
            }else{
                MessageDialogHelper.showConfirmDialog(null, "Category is save failed", "notification");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null,e.getMessage(), "error");
        }
        initTableCate();
        loadTableCate();
    }//GEN-LAST:event_btnUpdateCatActionPerformed

    private void btnDeleteCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCatActionPerformed
        // TODO add your handling code here:
         StringBuilder sb = new StringBuilder();
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(null, sb.toString(),"ERROR");
            return ;
        }
        
        if(MessageDialogHelper.showConfirmDialog(null,"are you sure","question") == JOptionPane.NO_OPTION){
            return;
        }
        
        try{
            CategoryDAO cateDAO = new CategoryDAO();
            if(cateDAO.delete(txtCategoryId.getText())){
                MessageDialogHelper.showMessageDialog(null,"Employee is delete success", "notification");
            }else{
                MessageDialogHelper.showConfirmDialog(null, "Employee is delete failed", "notification");
            } 
        }catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null,e.getMessage(), "error");
        }
        initTableCate();
        loadTableCate();
    }//GEN-LAST:event_btnDeleteCatActionPerformed

    private void searchcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchcatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCat;
    private javax.swing.JButton btnAddPub;
    private javax.swing.JButton btnBrowser;
    private javax.swing.JButton btnDeleteCat;
    private javax.swing.JButton btnDeletePub;
    private javax.swing.JButton btnUpdateCat;
    private javax.swing.JButton btnUpdatePub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JLayeredPane panel2;
    private javax.swing.JLayeredPane panel3;
    private com.softech.bookmanagement.swing.PanelBorder panelBorder1;
    private com.softech.bookmanagement.swing.SearchText searchcat;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private com.softech.bookmanagement.swing.Table tblCategory;
    private com.softech.bookmanagement.swing.Table tblPublisher;
    private javax.swing.JTextField txtCategoryId;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JLabel txtPublicName;
    private javax.swing.JTextField txtPublisherAddress;
    private javax.swing.JTextField txtPublisherEmail;
    private javax.swing.JTextField txtPublisherId;
    private javax.swing.JTextField txtPublisherName;
    private javax.swing.JTextField txtPublisherPhone;
    // End of variables declaration//GEN-END:variables
}
