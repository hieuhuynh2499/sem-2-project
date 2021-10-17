
package com.softech.bookmanagement.view;

import com.softech.bookmanagement.event.EventMenu;
import com.softech.bookmanagement.form.Form_Book;
import com.softech.bookmanagement.form.Form_CatAndPub;
import com.softech.bookmanagement.form.Form_Employee;
import com.softech.bookmanagement.form.Form_Invoice;
import com.softech.bookmanagement.form.Form_Profile;
import com.softech.bookmanagement.form.Form_Statistic;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
/**
 *
 * @author Nguyen Bae
 */
public class frmAdminManagement extends javax.swing.JFrame {

    private Form_Book book;
    private Form_Employee employee;
    private Form_CatAndPub catAndPub;
    private Form_Profile profile;
    private Form_Statistic statistic;
    private Form_Invoice invoice;
    public frmAdminManagement() {
        initComponents();
        init();
    }
    private void init(){
        setBackground(new Color(0,0,0,0));
        Form_Book book = new Form_Book();
        Form_Employee employee = new Form_Employee();
        Form_CatAndPub catAndPub = new Form_CatAndPub();
        Form_Profile profile = new Form_Profile();
        menu2.initMoving(this);
        menu2.addEventMenu(new EventMenu() {
            @Override
            public void selected(int index) {
                if(index == 0){
                    setForm(book);
                }
                else if(index == 1){
                    setForm(employee);
                }
                else if(index == 2){
                    setForm(invoice);
                }
                else if(index == 3){
                    setForm(catAndPub);
                }
                else if(index == 4){
                    setForm(statistic);
                }
                else if(index == 5){
                    setForm(profile);
                }
                else if(index == 6){
                    frmMainLogin login = new frmMainLogin();
                    login.setVisible(true);
                    dispose();
                }
            }
        });
        setForm(new Form_Book());
    }
    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel1 = new com.softech.bookmanagement.swing.MainPanel();
        header1 = new com.softech.bookmanagement.components.Header();
        mainPanel = new javax.swing.JPanel();
        menu2 = new com.softech.bookmanagement.components.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1210, 643));

        mainPanel1.setBackground(new java.awt.Color(242, 242, 242));

        mainPanel.setBackground(new java.awt.Color(242, 242, 242));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanel1Layout = new javax.swing.GroupLayout(mainPanel1);
        mainPanel1.setLayout(mainPanel1Layout);
        mainPanel1Layout.setHorizontalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel1Layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)))
        );
        mainPanel1Layout.setVerticalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
            .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmAdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdminManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.softech.bookmanagement.components.Header header1;
    private javax.swing.JPanel mainPanel;
    private com.softech.bookmanagement.swing.MainPanel mainPanel1;
    private com.softech.bookmanagement.components.Menu menu2;
    // End of variables declaration//GEN-END:variables
}
