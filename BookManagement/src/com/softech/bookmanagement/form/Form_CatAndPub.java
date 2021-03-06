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
import java.awt.Point;
import java.awt.geom.Ellipse2D;
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
public class Form_CatAndPub extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    SetImage img = new SetImage();
    String imgFile = "";
    private JFrame mainFrame;

    public Form_CatAndPub() {
        initComponents();
        initTableCate();
        loadTableCate();
        initTablePub();
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
        btnClear.setSize(20, 20);
        new SetImage().setImageButton(btnClear, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\clear.png");
        rbCategory.setSelected(true);
    }

    private void initTableCate() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"CategoryId", "CategoryName"});
        tblCategory.setModel(tblModel);
    }

    private void loadTableCate() {
        try {
            CategoryDAO dao = new CategoryDAO();
            List<Category> list = dao.findAll();
            tblModel.setRowCount(0);
            for (Category em : list) {
                tblModel.addRow(new Object[]{
                    em.getCategoryId(), em.getCategoryName()
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
        }
    }

    private void initTablePub() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"PublisherID", "PublisherName", "PublisherPhone", "PublisherPhone", "PublisheEmail", "Image"});
        tblPublisher.setModel(tblModel);
    }

    private void loadTablePub() {
        try {
            PublisherDAO dao = new PublisherDAO();
            List<Publisher> list = dao.findAll();
            tblModel.setRowCount(0);
            for (Publisher em : list) {
                tblModel.addRow(new Object[]{
                    em.getID(), em.getPushlisherNameString(), em.getPhone(), em.getAddress(), em.getEmail(), em.getImage()
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
        }
    }

    public boolean checkMouseOver(Point mouse) {
        int width = txtSearch.getWidth();
        int height = txtSearch.getHeight();
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        Point point = new Point(width - height + 3, marginButton);
        Ellipse2D.Double circle = new Ellipse2D.Double(point.x, point.y, buttonSize, buttonSize);
        return circle.contains(mouse);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        txtSearch = new com.softech.bookmanagement.swing.SeachTextField();
        jPanel2 = new javax.swing.JPanel();
        rbCategory = new javax.swing.JRadioButton();
        rbPublisher = new javax.swing.JRadioButton();
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
        lbPublicName = new javax.swing.JLabel();
        panel3 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        btnBrowser = new javax.swing.JButton();
        btnAddPub = new javax.swing.JButton();
        btnUpdatePub = new javax.swing.JButton();
        btnDeletePub = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

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

        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        rbCategory.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbCategory);
        rbCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbCategory.setText("Category");

        rbPublisher.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbPublisher);
        rbPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbPublisher.setText("Publisher");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCategory)
                .addGap(70, 70, 70)
                .addComponent(rbPublisher)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCategory)
                    .addComponent(rbPublisher)))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
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

        lbPublicName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPublicName.setForeground(new java.awt.Color(63, 43, 150));
        lbPublicName.setText("Publisher Name");

        panel2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherPhone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherAddress, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPublisherName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(lbPublicName, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                            .addComponent(lbPublicName))
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
                .addComponent(lbPublicName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnClear.setBackground(new java.awt.Color(63, 43, 150));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("   CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        panel3.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnBrowser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnAddPub, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnUpdatePub, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnDeletePub, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnClear, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                    .addComponent(btnDeletePub, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(btnAddPub, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdatePub, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletePub, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrowser)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
        try {
            String sql = "Select * from Publisher where PublisherID = ?";
            PreparedStatement pstmt1 = DatabaseHelper.connectSQLServer().prepareStatement(sql);
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
                if (rs1.getString("Image") != null) {
                    img.setImageLabel(lbImage, "image//" + rs1.getString("Image"));
                } else {
                    lbImage.setIcon(null);
                }
            }
        } catch (Exception ex) {
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
                    JOptionPane.showMessageDialog(mainFrame, "?????nh d???ng file h??nh ??u??i ph???i l?? GIF, JPG, PNG !");
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
        DataValidator.validateEmpty(txtPublisherId, sb, " PublisherId is not empty");
        DataValidator.validateEmpty(txtPublisherName, sb, " PublisherName is not empty");
        DataValidator.validateEmpty(txtPublisherEmail, sb, " PublisherEmail is not empty");
        DataValidator.validateEmpty(txtPublisherAddress, sb, " PublisherAddress is not empty");
        DataValidator.validateEmpty(txtPublisherPhone, sb, " PublisherPhone is not empty");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(mainFrame, sb.toString(), "ERROR");
            return;
        }
        try {
            Publisher publisher = new Publisher();
            publisher.setID(txtPublisherId.getText());
            publisher.setPushlisherNameString(txtPublisherName.getText());
            publisher.setEmail(txtPublisherEmail.getText());
            publisher.setAddress(txtPublisherAddress.getText());
            publisher.setPhone(txtPublisherPhone.getText());
            publisher.setImage(imgFile);
            PublisherDAO puclisherDAO = new PublisherDAO();
            puclisherDAO.insert(publisher);
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame, e.getMessage(), "error");
        }
        initTablePub();
        loadTablePub();
    }//GEN-LAST:event_btnAddPubActionPerformed

    private void btnUpdatePubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePubActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtPublisherId, sb, " PublisherId is not empty");
        DataValidator.validateEmpty(txtPublisherName, sb, " PublisherName is not empty");
        DataValidator.validateEmpty(txtPublisherEmail, sb, " PublisherEmail is not empty");
        DataValidator.validateEmpty(txtPublisherAddress, sb, " PublisherAddress is not empty");
        DataValidator.validateEmpty(txtPublisherPhone, sb, " PublisherPhone is not empty");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(null, sb.toString(), "ERROR");
            return;
        }
        try {
            Publisher publisher = new Publisher();
            publisher.setID(txtPublisherId.getText());
            publisher.setPushlisherNameString(txtPublisherName.getText());
            publisher.setEmail(txtPublisherEmail.getText());
            publisher.setAddress(txtPublisherAddress.getText());
            publisher.setPhone(txtPublisherPhone.getText());
            publisher.setImage(imgFile);
            PublisherDAO puclisherDAO = new PublisherDAO();
            puclisherDAO.update(publisher);
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame, e.getMessage(), "error");
        }
        initTablePub();
        loadTablePub();
    }//GEN-LAST:event_btnUpdatePubActionPerformed

    private void btnDeletePubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePubActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(null, sb.toString(), "ERROR");
            return;
        }

        if (MessageDialogHelper.showConfirmDialog(null, "are you sure", "question") == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            PublisherDAO publisherDAO = new PublisherDAO();
            if (publisherDAO.delete(txtPublisherId.getText())) {
                MessageDialogHelper.showMessageDialog(mainFrame, "Publisher is delete success", "notification");
            } else {
                MessageDialogHelper.showConfirmDialog(mainFrame, "Publisher is delete failed", "notification");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame, e.getMessage(), "error");
        }
        initTablePub();
        loadTablePub();
    }//GEN-LAST:event_btnDeletePubActionPerformed

    private void btnAddCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCatActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtCategoryId, sb, " Category is not empty");
        DataValidator.validateEmpty(txtCategoryName, sb, " CategoryName is not empty");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(mainFrame, sb.toString(), "ERROR");
            return;
        }
        try {
            Category cate = new Category();
            cate.setCategoryId(txtCategoryId.getText());
            cate.setCategoryName(txtCategoryName.getText());
            CategoryDAO cateDAO = new CategoryDAO();
            if (cateDAO.insert(cate)) {
                MessageDialogHelper.showMessageDialog(mainFrame, "Category is saved in database", "notification");
            } else {
                MessageDialogHelper.showConfirmDialog(mainFrame, "Category is save failed", "notification");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame, e.getMessage(), "error");
        }
        initTableCate();
        loadTableCate();
    }//GEN-LAST:event_btnAddCatActionPerformed

    private void btnUpdateCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCatActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtCategoryId, sb, " Category is not empty");
        DataValidator.validateEmpty(txtCategoryName, sb, " CategoryName is not empty");

        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(mainFrame, sb.toString(), "ERROR");
            return;
        }
        try {
            Category cate = new Category();
            cate.setCategoryId(txtCategoryId.getText());
            cate.setCategoryName(txtCategoryName.getText());
            CategoryDAO cateDAO = new CategoryDAO();
            if (cateDAO.update(cate)) {
                MessageDialogHelper.showMessageDialog(mainFrame, "Category is saved in database", "notification");
            } else {
                MessageDialogHelper.showConfirmDialog(mainFrame, "Category is save failed", "notification");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame, e.getMessage(), "error");
        }
        initTableCate();
        loadTableCate();
    }//GEN-LAST:event_btnUpdateCatActionPerformed

    private void btnDeleteCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCatActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(mainFrame, sb.toString(), "ERROR");
            return;
        }

        if (MessageDialogHelper.showConfirmDialog(mainFrame, "are you sure", "question") == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            CategoryDAO cateDAO = new CategoryDAO();
            if (cateDAO.delete(txtCategoryId.getText())) {
                MessageDialogHelper.showMessageDialog(mainFrame, "Employee is delete success", "notification");
            } else {
                MessageDialogHelper.showConfirmDialog(mainFrame, "Employee is delete failed", "notification");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainFrame, e.getMessage(), "error");
        }
        initTableCate();
        loadTableCate();
    }//GEN-LAST:event_btnDeleteCatActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtCategoryId.setText("");
        txtCategoryName.setText("");
        txtPublisherName.setText("");
        txtPublisherAddress.setText("");
        txtPublisherEmail.setText("");
        txtPublisherId.setText("");
        txtPublisherPhone.setText("");
        lbImage.setIcon(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (checkMouseOver(evt.getPoint())) {
            if (rbCategory.isSelected()) {
                initTableCate();
                try {
                    CategoryDAO dao = new CategoryDAO();
                    List<Category> list = dao.SearchByCatName(txtSearch.getText());
                    tblModel.setRowCount(0);
                    for (Category em : list) {
                        tblModel.addRow(new Object[]{
                            em.getCategoryId(), em.getCategoryName()
                        });
                    }
                    tblModel.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                    MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
                }
            } else if (rbPublisher.isSelected()) {
                initTablePub();
                try {
                    PublisherDAO dao = new PublisherDAO();
                    List<Publisher> list = dao.SearchByPubName(txtSearch.getText());
                    tblModel.setRowCount(0);
                    for (Publisher em : list) {
                        tblModel.addRow(new Object[]{
                            em.getID(), em.getPushlisherNameString(), em.getPhone(), em.getAddress(), em.getEmail(), em.getImage()
                        });
                    }
                    tblModel.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                    MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
                }
            }
        }
    }//GEN-LAST:event_txtSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCat;
    private javax.swing.JButton btnAddPub;
    private javax.swing.JButton btnBrowser;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteCat;
    private javax.swing.JButton btnDeletePub;
    private javax.swing.JButton btnUpdateCat;
    private javax.swing.JButton btnUpdatePub;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbPublicName;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JLayeredPane panel2;
    private javax.swing.JLayeredPane panel3;
    private com.softech.bookmanagement.swing.PanelBorder panelBorder1;
    private javax.swing.JRadioButton rbCategory;
    private javax.swing.JRadioButton rbPublisher;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private com.softech.bookmanagement.swing.Table tblCategory;
    private com.softech.bookmanagement.swing.Table tblPublisher;
    private javax.swing.JTextField txtCategoryId;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextField txtPublisherAddress;
    private javax.swing.JTextField txtPublisherEmail;
    private javax.swing.JTextField txtPublisherId;
    private javax.swing.JTextField txtPublisherName;
    private javax.swing.JTextField txtPublisherPhone;
    private com.softech.bookmanagement.swing.SeachTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
