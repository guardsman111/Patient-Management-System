/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import GUIs.NewUser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import GUIProcesses.LoginPress;

/**
 *
 * @author Charlie Parsons
 */
public class Login extends javax.swing.JFrame {

    LoginPress lPress = new LoginPress();
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        jLabel5.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IDField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NoAccountBut = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        LoginBut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(225, 225, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        IDField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        IDField.setText("User ID");
        IDField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IDFieldMouseClicked(evt);
            }
        });
        IDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("User ID Number");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel4.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        jLabel4.setText("Charlie's Doctors Patient Manangement System");

        NoAccountBut.setBackground(new java.awt.Color(255, 51, 51));
        NoAccountBut.setForeground(new java.awt.Color(102, 102, 255));
        NoAccountBut.setText(" Not have an Account?");
        NoAccountBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoAccountButMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NoAccountButMousePressed(evt);
            }
        });

        PasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PasswordField.setText("People Suck");
        PasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordFieldMouseClicked(evt);
            }
        });

        LoginBut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LoginBut.setText("Login");
        LoginBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginButMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Incorrect User ID or Password!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NoAccountBut)
                    .addComponent(jLabel4))
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IDField, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(PasswordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(LoginBut))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LoginBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(NoAccountBut)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDFieldActionPerformed

    private void NoAccountButMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoAccountButMousePressed
        //NewUser NUFrame = new NewUser();
    }//GEN-LAST:event_NoAccountButMousePressed

    private void NoAccountButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoAccountButMouseClicked
        NewUser NUFrame = new NewUser();
        NUFrame.setVisible(true);
        System.out.println("pressed new user");
    }//GEN-LAST:event_NoAccountButMouseClicked

    private void LoginButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_LoginButMouseEntered

    private void LoginButMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButMousePressed
        // TODO add your handling code here:
        
        System.out.println("pressed Login");
        
        if (IDField.getText().charAt(0) == 'P'){
            if (lPress.Login(IDField.getText(),PasswordField.getText())){
                PatientHome PHome = new PatientHome();
                PHome.setCurrentPatientID(IDField.getText());
                this.setVisible(false);
            } else {
                jLabel5.setVisible(true);
            }
        }
        if (IDField.getText().charAt(0) == 'D'){
            if (lPress.Login(IDField.getText(),PasswordField.getText())){
                this.setVisible(false);
            } else {
                jLabel5.setVisible(true);
            }
        }
        if (IDField.getText().charAt(0) == 'S'){
            if (lPress.Login(IDField.getText(),PasswordField.getText())){
                SecretaryHome SHome = new SecretaryHome();
                this.setVisible(false);
            } else {
                jLabel5.setVisible(true);
            }
        }
        if (IDField.getText().charAt(0) == 'D'){
            if (lPress.Login(IDField.getText(),PasswordField.getText())){
                this.setVisible(false);
            } else {
                jLabel5.setVisible(true);
            }
        }
    }//GEN-LAST:event_LoginButMousePressed

    private void IDFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IDFieldMouseClicked
        IDField.setText("");
    }//GEN-LAST:event_IDFieldMouseClicked

    private void PasswordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordFieldMouseClicked
        PasswordField.setText("");
    }//GEN-LAST:event_PasswordFieldMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDField;
    private javax.swing.JButton LoginBut;
    private javax.swing.JLabel NoAccountBut;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
}
