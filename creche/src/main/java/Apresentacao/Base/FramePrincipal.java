package Apresentacao.Base;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Apresentacao.Features.Usuario.FrameLogin;
import Apresentacao.Features.Usuario.FrameMudarSenha;
import Apresentacao.Features.Cuidador.FrameGerenciadorCadastroCuidador;
import Apresentacao.Features.Crianca.FrameGerenciadorCadastroCrianca;
import Aplicacao.CriancaService;
import Aplicacao.CuidadorService;
import Aplicacao.LoginService;
import Aplicacao.RpcService;
import Aplicacao.TurmaService;
import Apresentacao.Features.Rpc.FrameGerenciadorCadastroRpc;
import Apresentacao.Features.Turma.FrameGerenciadorCadastroTurma;
import Dominio.Features.Crianca.ICriancaService;
import Dominio.Features.Cuidador.ICuidadorService;
import Dominio.Features.RPC.IRpcService;
import Dominio.Features.Turma.ITurmaService;
import Dominio.Features.Usuario.TipoUsuario;
import Dominio.Features.Usuario.Usuario;
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
import Dominio.Features.Crianca.ICriancaRepository;
import Dominio.Features.Cuidador.ICuidadorRepository;
import Dominio.Features.RPC.IRpcRepository;
import Dominio.Features.Turma.ITurmaRepository;
import Infraestrutura.Login.ILoginService;

public class FramePrincipal extends javax.swing.JFrame {

    private ICriancaRepository criancaRepositorio;
    private ICriancaService criancaService;

    private ICuidadorRepository cuidadorRepositorio;
    private ICuidadorService cuidadorService;

    private IRpcService rpcService;
    private IRpcRepository rpcRepositorio;

    private ITurmaService turmaService;
    private ITurmaRepository turmaRespositorio;

    private IConfiguracoesLogin configuracaoLogin;
    private ILoginService loginService;

    private static Usuario user;

    private FrameGerenciadorCadastroCrianca frameGerenciadorCadastroCrianca;
    private FrameMudarSenha frameMudarSenha;
    private FrameGerenciadorCadastroCuidador frameGerenciadorCadastroCuidador;
    private FrameGerenciadorCadastroRpc frameGerenciadorCadastroRpc;
    private FrameGerenciadorCadastroTurma frameGerenciadorCadastroTurma;
    private FrameLogin frameLogin;

    public FramePrincipal() {
        iniciarServicos();
        initComponents();
        iniciarFrames();
        menuContexto.setEnabled(false);
        menuAjuda.setEnabled(false);
        menuUsuario.setEnabled(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        adicionaTela(frameLogin, true);
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
            habilitarOperacoesGerente();
        } else if (user.getTipoUsuario() == TipoUsuario.CUIDADOR) {
            habilitarOperacoesCuidador();
        }
        jLabelUsuarioConectado.setText(user.getLogin() + ", " + user.getTipoUsuario());
    }

    private static void habilitarOperacoesGerente() {
        menuContexto.setEnabled(true);
        menuAjuda.setEnabled(true);
        menuUsuario.setEnabled(true);
    }

    private static void habilitarOperacoesCuidador() {
        menuUsuario.setEnabled(true);
        menuContexto.setEnabled(true);
        jMenuCrianca.setEnabled(true);
        jMenuCuidador.setEnabled(false);
        jMenuRpc.setEnabled(false);
        jMenuTurma.setEnabled(false);
    }

    public void iniciarFrames() {
        frameGerenciadorCadastroCrianca = new FrameGerenciadorCadastroCrianca(criancaService, rpcService, turmaService);
        frameMudarSenha = new FrameMudarSenha(user, loginService);
        frameGerenciadorCadastroCuidador = new FrameGerenciadorCadastroCuidador(cuidadorService);
        frameGerenciadorCadastroRpc = new FrameGerenciadorCadastroRpc(rpcService);
        frameGerenciadorCadastroTurma = new FrameGerenciadorCadastroTurma(cuidadorService, turmaService);
        frameLogin = new FrameLogin(loginService);
    }

    public void iniciarServicos() {
        criancaRepositorio = new CriancaPostgresRepository();
        criancaService = new CriancaService(criancaRepositorio);

        rpcRepositorio = new RpcPostgresRepository();
        rpcService = new RpcService(rpcRepositorio);

        configuracaoLogin = new ConfiguracoesLogin();
        loginService = new LoginService(configuracaoLogin);

        turmaRespositorio = new TurmaPostgresRepository();
        turmaService = new TurmaService(turmaRespositorio);

        cuidadorRepositorio = new CuidadorPostgresRepository();
        cuidadorService = new CuidadorService(cuidadorRepositorio, configuracaoLogin);
    }

    public static void fecharTodosFrames() {
        JInternalFrame[] frames = jDesktopPane1.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.dispose();
        }
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
        Icon icaa = new ImageIcon("src/main/resources/Imagens/crianca.png");
        jLabel1 = new javax.swing.JLabel(icaa);
        jLabel2 = new javax.swing.JLabel();
        jLabelUsuarioConectado = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuContexto = new javax.swing.JMenu();
        jMenuCrianca = new javax.swing.JMenuItem();
        jMenuCuidador = new javax.swing.JMenuItem();
        jMenuRpc = new javax.swing.JMenuItem();
        jMenuTurma = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        jMenuSenha = new javax.swing.JMenuItem();
        jMenuLogout = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
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
                .addComponent(jLabelUsuarioConectado, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
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

        jMenuCrianca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuCrianca.setText("Criança");
        jMenuCrianca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCriancaActionPerformed(evt);
            }
        });
        menuContexto.add(jMenuCrianca);

        jMenuCuidador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuCuidador.setText("Cuidador");
        jMenuCuidador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCuidadorActionPerformed(evt);
            }
        });
        menuContexto.add(jMenuCuidador);

        jMenuRpc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuRpc.setText("Rpc");
        jMenuRpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRpcActionPerformed(evt);
            }
        });
        menuContexto.add(jMenuRpc);

        jMenuTurma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuTurma.setText("Turma");
        jMenuTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTurmaActionPerformed(evt);
            }
        });
        menuContexto.add(jMenuTurma);

        jMenuBar2.add(menuContexto);

        menuUsuario.setText("Usuario");

        jMenuSenha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuSenha.setText("Alterar Senha");
        jMenuSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSenhaActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuSenha);

        jMenuLogout.setText("Logout");
        jMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLogoutActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuLogout);

        jMenuBar2.add(menuUsuario);

        menuAjuda.setText("Ajuda");
        jMenuBar2.add(menuAjuda);

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

    private void jMenuCriancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCriancaActionPerformed
        fecharTodosFrames();
        if (user.getTipoUsuario() == TipoUsuario.CUIDADOR) {
            frameGerenciadorCadastroCrianca.setjPanelLista(false);
        }
        adicionaTela(frameGerenciadorCadastroCrianca, true);
    }//GEN-LAST:event_jMenuCriancaActionPerformed

    private void jMenuSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSenhaActionPerformed
        fecharTodosFrames();
        adicionaTela(frameMudarSenha, false);
    }//GEN-LAST:event_jMenuSenhaActionPerformed

    private void jMenuCuidadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCuidadorActionPerformed
        fecharTodosFrames();
        adicionaTela(frameGerenciadorCadastroCuidador, true);
    }//GEN-LAST:event_jMenuCuidadorActionPerformed

    private void jMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLogoutActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuLogoutActionPerformed

    private void jMenuRpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRpcActionPerformed
        fecharTodosFrames();
        adicionaTela(frameGerenciadorCadastroRpc, true);
    }//GEN-LAST:event_jMenuRpcActionPerformed

    private void jMenuTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTurmaActionPerformed
        fecharTodosFrames();
        adicionaTela(frameGerenciadorCadastroTurma, true);
    }//GEN-LAST:event_jMenuTurmaActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabelUsuarioConectado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private static javax.swing.JMenuItem jMenuCrianca;
    private static javax.swing.JMenuItem jMenuCuidador;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuLogout;
    private static javax.swing.JMenuItem jMenuRpc;
    private javax.swing.JMenuItem jMenuSenha;
    private static javax.swing.JMenuItem jMenuTurma;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JMenu menuAjuda;
    private static javax.swing.JMenu menuContexto;
    private static javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
