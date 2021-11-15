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
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Bae
 */
public class Form_Book extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    SetImage img = new SetImage();

    String imgFile = "";

    public Form_Book() {
        initComponents();
        LoadCategory();
        LoadPublisher();
        initTable();
        LoadBook();
        btnAdd.setSize(20, 20);
        new SetImage().setImageButton(btnAdd, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\add.png");
        btnUpdate.setSize(20, 20);
        new SetImage().setImageButton(btnUpdate, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\pencil.png");
        btnDelete.setSize(20, 20);
        new SetImage().setImageButton(btnDelete, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\bin.png");
        btnClear.setSize(20, 20);
        new SetImage().setImageButton(btnClear, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\clear.png");
    }

    void initTable() {
        try {
            tblModel = new DefaultTableModel();
            tblModel.setColumnIdentifiers(new String[]{"ISBN", "Title", "Author", "Category", "Publisher", "Price", "Description", "Image"});
            tblBook.setModel(tblModel);
        } catch (Exception e) {
        }
    }

    private void LoadBook() {
        String sql = "Select * from Book";
        String Cat = "";
        String Pub = "";
        try {
            PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            tblModel.setRowCount(0);
            while (rs.next()) {
                String getCat = "Select CategoryName from Category where CategoryID = ? ";
                PreparedStatement psGetCat = DatabaseHelper.connectSQLServer().prepareStatement(getCat);
                psGetCat.setString(1, rs.getString("CategoryID"));
                ResultSet rsGetCat = psGetCat.executeQuery();
                while (rsGetCat.next()) {
                    Cat = rsGetCat.getString("CategoryName");
                }
                String getPub = "Select PublisherName from Publisher where PublisherID = ?";
                PreparedStatement psGetPub = DatabaseHelper.connectSQLServer().prepareStatement(getPub);
                psGetPub.setString(1, rs.getString("PublisherID"));
                ResultSet rsGetPub = psGetPub.executeQuery();
                while (rsGetPub.next()) {
                    Pub = rsGetPub.getString("PublisherName");
                }

                String[] row = new String[]{
                    rs.getString("ISBN"),
                    rs.getString("Title"),
                    rs.getString("Author"),
                    Cat,
                    Pub,
                    rs.getString("Price"),
                    rs.getString("Description"),
                    rs.getString("Image")
                };
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void LoadPublisher() {
        String sql = "Select PublisherName from Publisher";
        cbPublisher.removeAllItems();
        try {
            PreparedStatement pstmt = DatabaseHelper.connectSQLServer().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbPublisher.removeAllItems();
            while (rs.next()) {
                cbPublisher.addItem(rs.getString("PublisherName"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void LoadCategory() {
        String sql = "Select CategoryName from Category";
        cbCategory.removeAllItems();
        try {
            PreparedStatement pstmt = DatabaseHelper.connectSQLServer().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbCategory.removeAllItems();
            while (rs.next()) {
                cbCategory.addItem(rs.getString("CategoryName"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void SearchBook() {
        String sql = "Select * from Book where Title like '%?%' or Author like '%?%'";
        String Cat = "";
        String Pub = "";
        try {
            PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);
//            ps.setString(1, searchbook.toString());
//            ps.setString(2, searchbook.toString());
            ResultSet rs = ps.executeQuery();
            tblModel.setRowCount(0);
            while (rs.next()) {
                String getCat = "Select CategoryName from Category where CategoryID = ? ";
                PreparedStatement psGetCat = DatabaseHelper.connectSQLServer().prepareStatement(getCat);
                psGetCat.setString(1, rs.getString("CategoryID"));
                ResultSet rsGetCat = psGetCat.executeQuery();
                while (rsGetCat.next()) {
                    Cat = rsGetCat.getString("CategoryName");
                }
                String getPub = "Select PublisherName from Publisher where PublisherID = ?";
                PreparedStatement psGetPub = DatabaseHelper.connectSQLServer().prepareStatement(getPub);
                psGetPub.setString(1, rs.getString("PublisherID"));
                ResultSet rsGetPub = psGetPub.executeQuery();
                while (rsGetPub.next()) {
                    Pub = rsGetPub.getString("PublisherName");
                }

                String[] row = new String[]{
                    rs.getString("ISBN"),
                    rs.getString("Title"),
                    rs.getString("Author"),
                    Cat,
                    Pub,
                    rs.getString("Price"),
                    rs.getString("Description"),
                    rs.getString("Image")
                };
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        txtISBN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        panelBorder1 = new com.softech.bookmanagement.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblBook = new com.softech.bookmanagement.swing.Table();
        txtSearch = new com.softech.bookmanagement.swing.SeachTextField();
        jPanel5 = new javax.swing.JPanel();
        rbTitle = new javax.swing.JRadioButton();
        rbAuthtor = new javax.swing.JRadioButton();
        rbPublisher = new javax.swing.JRadioButton();
        panel2 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        cbPublisher = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        panel3 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        btnBrowser = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(919, 751));
        setRequestFocusEnabled(false);

        panel.setRequestFocusEnabled(false);

        txtISBN.setBackground(new java.awt.Color(242, 242, 242));
        txtISBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtISBN.setToolTipText("");
        txtISBN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(63, 43, 150));
        jLabel3.setText("ISBN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(63, 43, 150));
        jLabel2.setText("Title");

        txtTitle.setBackground(new java.awt.Color(242, 242, 242));
        txtTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitle.setToolTipText("");
        txtTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(63, 43, 150));
        jLabel5.setText("Author");

        txtAuthor.setBackground(new java.awt.Color(242, 242, 242));
        txtAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAuthor.setToolTipText("");
        txtAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(63, 43, 150));
        jLabel4.setText("Category");

        cbCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCategory.setBorder(null);

        panel.setLayer(txtISBN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(txtTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(txtAuthor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(cbCategory, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAuthor)
                    .addComponent(txtTitle)
                    .addComponent(txtISBN)
                    .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 197, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(878, 301));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Book Management");

        tblBook.setBackground(new java.awt.Color(242, 242, 242));
        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title", "Author", "Category", "Publisher", "Price", "Description", "Image"
            }
        ));
        tblBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        spTable.setViewportView(tblBook);

        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        rbTitle.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbTitle);
        rbTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbTitle.setText("Title");

        rbAuthtor.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbAuthtor);
        rbAuthtor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbAuthtor.setText("Author");

        rbPublisher.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbPublisher);
        rbPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbPublisher.setText("Publisher");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbTitle)
                .addGap(80, 80, 80)
                .addComponent(rbAuthtor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(rbPublisher)
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTitle)
                    .addComponent(rbAuthtor)
                    .addComponent(rbPublisher)))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(63, 43, 150));
        jLabel6.setText("Publisher");

        cbPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbPublisher.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 43, 150));
        jLabel7.setText("Price");

        txtPrice.setBackground(new java.awt.Color(242, 242, 242));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.setToolTipText("");
        txtPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(63, 43, 150)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 43, 150));
        jLabel8.setText("Desciption");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        panel2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(cbPublisher, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(txtPrice, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbPublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        btnBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/softech/bookmanagement/icon/open-folder.png"))); // NOI18N
        btnBrowser.setText("Browse");
        btnBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserActionPerformed(evt);
            }
        });

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
        btnUpdate.setText("  UPDATE");
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
        panel3.setLayer(btnAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnUpdate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel3.setLayer(btnDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
                        .addGap(34, 34, 34)
                        .addComponent(btnBrowser, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBrowser))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel3)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel2)
                        .addComponent(panel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked
        tblModel = (DefaultTableModel) tblBook.getModel();
        int selectedrowindex = tblBook.getSelectedRow();
        txtISBN.setText(tblModel.getValueAt(selectedrowindex, 0).toString());
        try {
            String sql = "Select * from Book where ISBN = ?";
            PreparedStatement pstmt1 = DatabaseHelper.connectSQLServer().prepareStatement(sql);
            pstmt1.setString(1, txtISBN.getText());
            ResultSet rs1 = pstmt1.executeQuery();
            if (rs1.next()) {
                txtTitle.setText(rs1.getString("Title"));
                txtAuthor.setText(rs1.getString("Author"));
                cbCategory.setSelectedItem(tblModel.getValueAt(selectedrowindex, 3).toString());
                cbPublisher.setSelectedItem(tblModel.getValueAt(selectedrowindex, 4).toString());
                txtPrice.setText(rs1.getString("Price"));
                txtDescription.setText(rs1.getString("Description"));
                if (rs1.getString("Image") != null) {
                    img.setImageLabel(lbImage, "image//" + rs1.getString("Image"));
                } else {
                    lbImage.setIcon(null);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_tblBookMouseClicked

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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String PublisherID = "";
        String CategoryID = "";
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtISBN, sb, " ISBN is not empty");
        DataValidator.validateEmpty(txtAuthor, sb, " Author is not empty");
        DataValidator.validateEmpty(txtTitle, sb, " Title is not empty");
        DataValidator.validateEmpty(txtPrice, sb, " Title is not empty");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(null, sb.toString(), "ERROR");
            return;
        }
        try {
            String getPublisher = "select PublisherID from Publisher where PublisherName=?";
            PreparedStatement pstmt1 = DatabaseHelper.connectSQLServer().prepareStatement(getPublisher);
            pstmt1.setString(1, cbPublisher.getSelectedItem().toString());
            ResultSet rs1 = pstmt1.executeQuery();
            while (rs1.next()) {
                PublisherID = rs1.getString("PublisherID");
            }
            String getCategory = "Select CategoryID from Category where CategoryName= ?";
            PreparedStatement pstmt2 = DatabaseHelper.connectSQLServer().prepareStatement(getCategory);
            pstmt2.setString(1, cbCategory.getSelectedItem().toString());
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
                CategoryID = rs2.getString("CategoryID");
            }

            Book book = new Book();
            book.setISBN(txtISBN.getText());
            book.setAuthor(txtAuthor.getText());
            book.setTitle(txtTitle.getText());
            book.setPublisherID(PublisherID);
            book.setCategoryID(CategoryID);
            book.setImage(imgFile);
            book.setPrice(Double.parseDouble(txtPrice.getText()));
            book.setDescription(txtDescription.getText());
//            if(!imgFile.equals("")){
//                
//            }
            BookDAO bookDAO = new BookDAO();
            bookDAO.InsertBook(book);
            initTable();
            LoadBook();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String PublisherID = "";
        String CategoryID = "";
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtISBN, sb, " ISBN is not empty");
        DataValidator.validateEmpty(txtAuthor, sb, " Author is not empty");
        DataValidator.validateEmpty(txtTitle, sb, " Title is not empty");
        DataValidator.validateEmpty(txtPrice, sb, " Title is not empty");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(null, sb.toString(), "ERROR");
            return;
        }
        try {
            String getPublisher = "select PublisherID from Publisher where PublisherName=?";
            PreparedStatement pstmt1 = DatabaseHelper.connectSQLServer().prepareStatement(getPublisher);
            pstmt1.setString(1, cbPublisher.getSelectedItem().toString());
            ResultSet rs1 = pstmt1.executeQuery();
            while (rs1.next()) {
                PublisherID = rs1.getString("PublisherID");
            }
            String getCategory = "Select CategoryID from Category where CategoryName= ?";
            PreparedStatement pstmt2 = DatabaseHelper.connectSQLServer().prepareStatement(getCategory);
            pstmt2.setString(1, cbCategory.getSelectedItem().toString());
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
                CategoryID = rs2.getString("CategoryID");
            }
            Book book = new Book();
            book.setISBN(txtISBN.getText());
            book.setAuthor(txtAuthor.getText());
            book.setTitle(txtTitle.getText());
            book.setPublisherID(PublisherID);
            book.setCategoryID(CategoryID);
            book.setPrice(Double.parseDouble(txtPrice.getText()));
            book.setDescription(txtDescription.getText());
            book.setImage(imgFile);
            BookDAO bookDAO = new BookDAO();
            bookDAO.UpdateBook(book);
            initTable();
            LoadBook();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtISBN, sb, " ISBN is not empty");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(null, sb.toString(), "ERROR");
            return;
        }
        BookDAO dao = new BookDAO();
        dao.DeleteBook(txtISBN.getText());
        initTable();
        LoadBook();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtISBN.setText("");
        txtAuthor.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtTitle.setText("");
        lbImage.setIcon(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (checkMouseOver(evt.getPoint())) {
            if (rbTitle.isSelected()) {
                String Cat = "";
                String Pub = "";
                try {
                    BookDAO dao = new BookDAO();
                    List<Book> list = dao.SearchByTitle(txtSearch.getText());
                    tblModel.setRowCount(0);
                    for (Book em : list) {
                        String getCat = "Select CategoryName from Category where CategoryID = ? ";
                        PreparedStatement psGetCat = DatabaseHelper.connectSQLServer().prepareStatement(getCat);
                        psGetCat.setString(1, em.getCategoryID());
                        ResultSet rsGetCat = psGetCat.executeQuery();
                        while (rsGetCat.next()) {
                            Cat = rsGetCat.getString("CategoryName");
                        }
                        String getPub = "Select PublisherName from Publisher where PublisherID = ?";
                        PreparedStatement psGetPub = DatabaseHelper.connectSQLServer().prepareStatement(getPub);
                        psGetPub.setString(1, em.getPublisherID());
                        ResultSet rsGetPub = psGetPub.executeQuery();
                        while (rsGetPub.next()) {
                            Pub = rsGetPub.getString("PublisherName");
                        }
                        tblModel.addRow(new Object[]{
                            em.getISBN(), em.getTitle(), em.getAuthor(), Cat, Pub, em.getPrice(), em.getDescription(), em.getImage()
                        });
                    }
                    tblModel.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                    MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
                }
            } else if (rbPublisher.isSelected()) {
                String Cat = "";
                String Pub = "";
                try {
                    BookDAO dao = new BookDAO();
                    List<Book> list = dao.SearchByPublisher(txtSearch.getText());
                    tblModel.setRowCount(0);
                    for (Book em : list) {
                        String getCat = "Select CategoryName from Category where CategoryID = ? ";
                        PreparedStatement psGetCat = DatabaseHelper.connectSQLServer().prepareStatement(getCat);
                        psGetCat.setString(1, em.getCategoryID());
                        ResultSet rsGetCat = psGetCat.executeQuery();
                        while (rsGetCat.next()) {
                            Cat = rsGetCat.getString("CategoryName");
                        }
                        String getPub = "Select PublisherName from Publisher where PublisherID = ?";
                        PreparedStatement psGetPub = DatabaseHelper.connectSQLServer().prepareStatement(getPub);
                        psGetPub.setString(1, em.getPublisherID());
                        ResultSet rsGetPub = psGetPub.executeQuery();
                        while (rsGetPub.next()) {
                            Pub = rsGetPub.getString("PublisherName");
                        }
                        tblModel.addRow(new Object[]{
                            em.getISBN(), em.getTitle(), em.getAuthor(), Cat, Pub, em.getPrice(), em.getDescription(), em.getImage()
                        });
                    }
                    tblModel.fireTableDataChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                    MessageDialogHelper.showErrorDialog(null, e.getMessage(), "error");
                }
            } else if (rbAuthtor.isSelected()) {
                String Cat = "";
                String Pub = "";
                try {
                    BookDAO dao = new BookDAO();
                    List<Book> list = dao.SearchByAuthor(txtSearch.getText());
                    tblModel.setRowCount(0);
                    for (Book em : list) {
                        String getCat = "Select CategoryName from Category where CategoryID = ? ";
                        PreparedStatement psGetCat = DatabaseHelper.connectSQLServer().prepareStatement(getCat);
                        psGetCat.setString(1, em.getCategoryID());
                        ResultSet rsGetCat = psGetCat.executeQuery();
                        while (rsGetCat.next()) {
                            Cat = rsGetCat.getString("CategoryName");
                        }
                        String getPub = "Select PublisherName from Publisher where PublisherID = ?";
                        PreparedStatement psGetPub = DatabaseHelper.connectSQLServer().prepareStatement(getPub);
                        psGetPub.setString(1, em.getPublisherID());
                        ResultSet rsGetPub = psGetPub.executeQuery();
                        while (rsGetPub.next()) {
                            Pub = rsGetPub.getString("PublisherName");
                        }
                        tblModel.addRow(new Object[]{
                            em.getISBN(), em.getTitle(), em.getAuthor(), Cat, Pub, em.getPrice(), em.getDescription(), em.getImage()
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowser;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbPublisher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JLayeredPane panel2;
    private javax.swing.JLayeredPane panel3;
    private com.softech.bookmanagement.swing.PanelBorder panelBorder1;
    private javax.swing.JRadioButton rbAuthtor;
    private javax.swing.JRadioButton rbPublisher;
    private javax.swing.JRadioButton rbTitle;
    private javax.swing.JScrollPane spTable;
    private com.softech.bookmanagement.swing.Table tblBook;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPrice;
    private com.softech.bookmanagement.swing.SeachTextField txtSearch;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
