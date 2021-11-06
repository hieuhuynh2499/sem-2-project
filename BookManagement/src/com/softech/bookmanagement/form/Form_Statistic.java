package com.softech.bookmanagement.form;
import com.softech.bookmanagement.helpers.DatabaseHelper;
import static com.softech.bookmanagement.model.BookDAO.ps;
import com.softech.bookmanagement.model.Order;
import com.softech.bookmanagement.model.SetImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Bae
 */
public class Form_Statistic extends javax.swing.JPanel {
    DefaultTableModel tblModel;
    SetImage img = new SetImage();

    public Form_Statistic() {
        initComponents();
        initTable();
        btnLoad.setSize(20, 20);
        new SetImage().setImageButton(btnLoad, "..\\BookManagement\\src\\com\\softech\\bookmanagement\\icon\\report.png");
    }
    void initTable(){
        try{
            tblModel = new DefaultTableModel();
            tblModel.setColumnIdentifiers(new String[]{"InvoiceID","EmployeeName","CreateDate","Total"});
            tblStatistic.setModel(tblModel);
        }catch (Exception e){
        }
    }
    public void ListOrderbyDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String StartDate = dateFormat.format(dtpkStart.getDate());
        String EndDate = dateFormat.format(dtpkEnd.getDate());
        String sql = "select OrderID, UserID,CreateDate, Total from [Order] where CreateDate between ? and ?";
        String Employee = "";
        try{
        PreparedStatement pstmt = DatabaseHelper.connectSQLServer().prepareStatement(sql);
        pstmt.setString(1, StartDate);
        pstmt.setString(2, EndDate);
        ResultSet rs = pstmt.executeQuery();
        tblModel.setRowCount(0);
            while (rs.next()) {
                String getEmployee= "Select Fullname from [User] where UserID = ? ";
                PreparedStatement psGetEmp = DatabaseHelper.connectSQLServer().prepareStatement(getEmployee);
                psGetEmp.setString(1, rs.getString("UserID"));
                ResultSet rsGetEmp = psGetEmp.executeQuery();
                while(rsGetEmp.next()){
                    Employee = rsGetEmp.getString("Fullname");
                }
                String[] row = new String[]{
                    rs.getString("OrderID"),
                    Employee,
                    rs.getString("CreateDate"),
                    rs.getString("Total")
                };
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void LoadEmp(){
        List<String> UserID = new ArrayList<String>();
        List<String> UserCount = new ArrayList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String StartDate = dateFormat.format(dtpkStart.getDate());
        String EndDate = dateFormat.format(dtpkEnd.getDate());
        String sql = "Select distinct UserID from [Order] where CreateDate between ? and ?";
        String Employee = "";
        String Image = "";
        try{
        PreparedStatement pstmt = DatabaseHelper.connectSQLServer().prepareStatement(sql);
        pstmt.setString(1, StartDate);
        pstmt.setString(2, EndDate);
        ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
//                String[] User = new String[]{
//                    rs.getString("UserID"),
//                };
                UserID.add(rs.getString("UserID"));
            }
        if(UserID.size() == 0){
            
        }
        else if (UserID.size() == 1){
             String getEmployee= "Select Fullname from [User] where UserID = ? ";
                PreparedStatement psGetEmp = DatabaseHelper.connectSQLServer().prepareStatement(getEmployee);
                psGetEmp.setString(1, UserID.get(0));
                ResultSet rsGetEmp = psGetEmp.executeQuery();
                while (rsGetEmp.next()) {
                     Employee = rsGetEmp.getString("Fullname");
                }
                lbEmployee.setText(Employee);
             String getImage= "Select Image from [User] where UserID = ? ";
                PreparedStatement psGetImg = DatabaseHelper.connectSQLServer().prepareStatement(getImage);
                psGetImg.setString(1, UserID.get(0));
                ResultSet rsGetImg = psGetImg.executeQuery();
                while(rsGetImg.next()){
                    Image = rsGetImg.getString("Image");
                }
                img.setImageLabel(lbImage, "image//" + Image);
        }
        else{
            for(int i = 0; i< UserID.size();i++){
                String sqlCount = "Select count(*) as Count from [Order] where UserID = ? and CreateDate between ? and ?";
                PreparedStatement psGetCount = DatabaseHelper.connectSQLServer().prepareStatement(sqlCount);
                psGetCount.setString(1, UserID.get(i));
                psGetCount.setString(2, StartDate);
                psGetCount.setString(3, EndDate);
                ResultSet rsGetCount = psGetCount.executeQuery();
                while (rsGetCount.next()) {
                    UserCount.add(rsGetCount.getString("Count"));
                }
            } 
            int max =Integer.parseInt(UserCount.get(0));
            int index = 0;
            for(int j = 0; j < UserCount.size(); j++){
                if(max < Integer.parseInt(UserCount.get(j))){
                    max = Integer.parseInt(UserCount.get(j));
                }
            }
            for(int z = 0 ; z< UserCount.size();z++){
                if(Integer.parseInt(UserCount.get(z)) == max){
                    index = z;
                }
            }
            String getEmployee= "Select Fullname from [User] where UserID = ? ";
                PreparedStatement psGetEmp = DatabaseHelper.connectSQLServer().prepareStatement(getEmployee);
                psGetEmp.setString(1, UserID.get(index));
                ResultSet rsGetEmp = psGetEmp.executeQuery();
                while(rsGetEmp.next()){
                    Employee = rsGetEmp.getString("Fullname");
                }
                lbEmployee.setText(Employee);
             String getImage= "Select Image from [User] where UserID = ? ";
                PreparedStatement psGetImg = DatabaseHelper.connectSQLServer().prepareStatement(getImage);
                psGetImg.setString(1, UserID.get(index));
                ResultSet rsGetImg = psGetImg.executeQuery();
                while(rsGetImg.next()){
                    Image = rsGetImg.getString("Image");
                }
                img.setImageLabel(lbImage, "image//" + Image);
        }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtpkStart = new com.toedter.calendar.JDateChooser();
        dtpkEnd = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelBorder1 = new com.softech.bookmanagement.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblStatistic = new com.softech.bookmanagement.swing.Table();
        llbTotal = new javax.swing.JLabel();
        btnLoad = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbTotalInv = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbEmployee = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(919, 751));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(63, 43, 150));
        jLabel3.setText("To Date");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 43, 150));
        jLabel8.setText("From Date");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(63, 43, 150));
        jLabel4.setText("Total Revenue: ");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Revenue Statistics");

        tblStatistic.setBackground(new java.awt.Color(242, 242, 242));
        tblStatistic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Employee Name", "Create Date", "Total Price"
            }
        ));
        tblStatistic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spTable.setViewportView(tblStatistic);

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
                    .addComponent(spTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        llbTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        btnLoad.setBackground(new java.awt.Color(63, 43, 150));
        btnLoad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoad.setForeground(new java.awt.Color(255, 255, 255));
        btnLoad.setText("   LOAD");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(63, 43, 150));
        jLabel5.setText("Total Invoice: ");

        lbTotalInv.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(63, 43, 150));
        jLabel6.setText("Excellent Employee");

        lbEmployee.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dtpkStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dtpkEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(llbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(lbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbTotalInv, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(dtpkStart, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtpkEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(llbTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotalInv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        ListOrderbyDate();
        LoadEmp();
        double Total = 0;
        for(int i = 0; i < tblModel.getRowCount(); i++){
            Total += Double.parseDouble(tblModel.getValueAt(i, 3).toString());
        }
        llbTotal.setText(String.valueOf(Total) + "$");
        lbTotalInv.setText(String.valueOf(tblModel.getRowCount()));
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private com.toedter.calendar.JDateChooser dtpkEnd;
    private com.toedter.calendar.JDateChooser dtpkStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbEmployee;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbTotalInv;
    private javax.swing.JLabel llbTotal;
    private com.softech.bookmanagement.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private com.softech.bookmanagement.swing.Table tblStatistic;
    // End of variables declaration//GEN-END:variables
}
