/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Aluno
 */
public class FrameLogin extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrameLogin
     */
    public FrameLogin() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jTextUser = new javax.swing.JTextField();
        jTextSenha = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOGIN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTextUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextUser.setForeground(new java.awt.Color(204, 204, 204));
        jTextUser.setText("Usuário");
        jTextUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextUserFocusGained(evt);
            }
        });

        jTextSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextSenha.setForeground(new java.awt.Color(204, 204, 204));
        jTextSenha.setText("Senha");
        jTextSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextSenhaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextUser, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
            .addComponent(jTextSenha)
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(525, Short.MAX_VALUE)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextSenhaFocusGained
        jTextSenha.setText("");
        jTextSenha.setForeground(Color.black);
    }//GEN-LAST:event_jTextSenhaFocusGained

    private void jTextUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextUserFocusGained
        jTextUser.setText("");
        jTextUser.setForeground(Color.black);
    }//GEN-LAST:event_jTextUserFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JTextField jTextSenha;
    private javax.swing.JTextField jTextUser;
    // End of variables declaration//GEN-END:variables
}
