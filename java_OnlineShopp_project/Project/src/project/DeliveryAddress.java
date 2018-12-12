/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import static project.MainPage11.logger;

/**
 *
 * @author Void
 */
public class DeliveryAddress extends javax.swing.JFrame {

    /**
     * Creates new form DeliveryAddress
     */
    public DeliveryAddress(String logger, int bill, String date) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        BillingDB.insertIntoBillingDB(logger, bill, date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        finalize = new javax.swing.JButton();
        closeButton1 = new javax.swing.JButton();
        usernameField1 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 77, 64)));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Enter Delivery Address");

        finalize.setBackground(new java.awt.Color(0, 77, 64));
        finalize.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        finalize.setForeground(new java.awt.Color(255, 255, 255));
        finalize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Vote_24px_1.png"))); // NOI18N
        finalize.setText("Finalize");
        finalize.setBorder(null);
        finalize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        finalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizeActionPerformed(evt);
            }
        });

        closeButton1.setBackground(new java.awt.Color(0, 77, 64));
        closeButton1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        closeButton1.setForeground(new java.awt.Color(255, 255, 255));
        closeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Cancel_24px_1.png"))); // NOI18N
        closeButton1.setText("Close");
        closeButton1.setBorder(null);
        closeButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton1ActionPerformed(evt);
            }
        });

        usernameField1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        usernameField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 77, 64)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(usernameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(156, 156, 156))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(closeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finalize, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel13)
                .addGap(39, 39, 39)
                .addComponent(usernameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalize, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 290));

        jPanel13.setBackground(new java.awt.Color(245, 206, 60));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Notification");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void finalizeActionPerformed(java.awt.event.ActionEvent evt) { 
                                try{
                    sendMessageToCustomers(logger);
                }
                catch(MessagingException ex){}
        this.dispose();
        DefaultTableModel dt = (DefaultTableModel) MainPage11.cartItemTable.getModel();
        dt.setRowCount(0);

        MainPage11.billLabel.setText("0");
        ProductInformation.cartItem.clear();
        ProductInformation.shoppingCart.clear();
        JFrame ps = new Processing();
        ps.setVisible(true);

    }                                        

    private void closeButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        this.dispose();
    }
    
        public void sendMessageToCustomers(String username) throws MessagingException{
   
        
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/bbs.db");
            String check = "SELECT username, email FROM userinfo where username=?";
            PreparedStatement ps = con.prepareStatement(check);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               ForgotPassword.Send("iskalinovfarukh","abstractions",rs.getString("email"),"Thank you for your purchase!","Dear, "+rs.getString("username")+"!"+"\nThank you for your purchase.\nBest regards, GLASSMAN men's store.");
               
           }
             ps.execute();
             con.close();
            System.out.println("SEND");
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify                     
    private javax.swing.JButton closeButton1;
    private javax.swing.JButton finalize;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField usernameField1;
    // End of variables declaration                   
}
