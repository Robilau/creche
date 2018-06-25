package Apresentacao;

import Aplicacao.CriancaService;
import Aplicacao.CuidadorService;
import Aplicacao.LoginService;
import Aplicacao.RpcService;
import Aplicacao.TurmaService;
import Dominio.Features.Crianca.ICriancaPostgresRepository;
import Dominio.Features.Crianca.ICriancaService;
import Dominio.Features.Cuidador.ICuidadorPostgresRepository;
import Dominio.Features.Cuidador.ICuidadorService;
import Dominio.Features.RPC.IRpcPostgresRepository;
import Dominio.Features.RPC.IRpcService;
import Dominio.Features.Turma.ITurmaPostgresRepository;
import Dominio.Features.Turma.ITurmaService;
import Dominio.TipoUsuario;
import Dominio.Usuario;
import Infraestrutura.CriancaPostgresRepository;
import Infraestrutura.CuidadorPostgresRepository;
import Infraestrutura.Login.ConfiguracoesLogin;
import Infraestrutura.Login.IConfiguracoesLogin;
import Infraestrutura.RpcPostgresRepository;
import Infraestrutura.TurmaPostgresRepository;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FramePrincipal extends javax.swing.JFrame {

    private ICriancaPostgresRepository criancaRepositorio;
    private ICriancaService criancaService;

    private ICuidadorPostgresRepository cuidadorRepositorio;
    private ICuidadorService cuidadorService;

    private IRpcService rpcService;
    private IRpcPostgresRepository rpcRepositorio;
    
    private ITurmaService turmaService;
    private ITurmaPostgresRepository turmaRespositorio;
    
    private IConfiguracoesLogin configuracaoLogin;
    private LoginService loginService;

    private static Usuario user;

    public FramePrincipal() {
        criancaRepositorio = new CriancaPostgresRepository();
        criancaService = new CriancaService(criancaRepositorio);

        cuidadorRepositorio = new CuidadorPostgresRepository();
        cuidadorService = new CuidadorService(cuidadorRepositorio);

        rpcRepositorio = new RpcPostgresRepository();
        rpcService = new RpcService(rpcRepositorio);

        configuracaoLogin = new ConfiguracoesLogin();
        loginService = new LoginService(configuracaoLogin);
        
        turmaRespositorio = new TurmaPostgresRepository();
        turmaService = new TurmaService(turmaRespositorio);
        
        initComponents();
        menuContexto.setEnabled(false);
        menuAjuda.setEnabled(false);
        menuUsuario.setEnabled(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JInternalFrame FrameInicio = new FrameInicio();
        JInternalFrame FrameLogin = new FrameLogin(loginService);
        adicionaTela(FrameInicio, true);
        adicionaTela(FrameLogin, true);
    }

    public static void adicionaTela(JInternalFrame frame, boolean isMaximumm) {
        jDesktopPane1.add(frame);
        frame.setVisible(true);
        jDesktopPane1.setSelectedFrame(frame);
        try {
            frame.setMaximum(isMaximumm);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setUsuarioConectado(Usuario user) {
        FramePrincipal.user = user;
        if (user.getTipoUsuario() == TipoUsuario.GERENTE) {
            menuContexto.setEnabled(true);
            menuAjuda.setEnabled(true);
            menuUsuario.setEnabled(true);
        } else {
            //restrições para cuidador
        }

        jLabelUsuarioConectado.setText(user.getNome() + ", " + user.getTipoUsuario());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabelUsuarioConectado = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuContexto = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        jLabel2.setText("Usuário conectado: ");

        jLabelUsuarioConectado.setText("          ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUsuarioConectado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelUsuarioConectado)))
        );

        menuContexto.setText("Contexto");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setText("Cadastrar Criança");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuContexto.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem4.setText("Cadastrar Cuidador");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuContexto.add(jMenuItem4);

        jMenuBar2.add(menuContexto);

        menuAjuda.setText("Ajuda");
        jMenuBar2.add(menuAjuda);

        menuUsuario.setText("Usuario");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setText("Alterar Senha");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuItem3);

        jMenuBar2.add(menuUsuario);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        adicionaTela(new FrameMenuCadastroCrianca(criancaService, rpcService, turmaService), true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        adicionaTela(new FrameMudarSenha(), false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        adicionaTela(new FrameMenuCadastroCuidador(cuidadorService), true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabelUsuarioConectado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JMenu menuAjuda;
    private static javax.swing.JMenu menuContexto;
    private static javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
