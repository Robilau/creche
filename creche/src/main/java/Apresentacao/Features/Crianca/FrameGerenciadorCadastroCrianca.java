/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao.Features.Crianca;

import Apresentacao.Base.FramePrincipal;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Crianca.ICriancaService;
import Dominio.Features.RPC.IRpcService;
import Dominio.Features.Turma.ITurmaService;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class FrameGerenciadorCadastroCrianca extends javax.swing.JInternalFrame {

    private ICriancaService serviceCrianca;
    private IRpcService serviceRpc;
    private ITurmaService serviceTurma;

    public FrameGerenciadorCadastroCrianca(ICriancaService service, IRpcService serviceRpc, ITurmaService serviceTurma) {
        this.serviceCrianca = service;
        this.serviceRpc = serviceRpc;
        this.serviceTurma = serviceTurma;
        initComponents();
        AtualizarLista();
    }

    public void AtualizarLista() {
        try {
            Vector<Crianca> lista = new Vector(serviceCrianca.pegarTodas());
            jListaCrianca.setListData(lista);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void setjPanelLista(boolean enabled) {
        this.jButtonCadastrar.setEnabled(enabled);
        this.jButtonEditar.setEnabled(enabled);
        this.jButtonExcluir.setEnabled(enabled);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaCrianca = new javax.swing.JList();
        jPanelOperacoes = new javax.swing.JPanel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonVisualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Icon registro = new ImageIcon("src/main/resources/Imagens/Registro.png");
        jLabel1 = new javax.swing.JLabel(registro);

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanelLista.setBorder(javax.swing.BorderFactory.createTitledBorder("Crianças"));

        jScrollPane1.setViewportView(jListaCrianca);

        javax.swing.GroupLayout jPanelListaLayout = new javax.swing.GroupLayout(jPanelLista);
        jPanelLista.setLayout(jPanelListaLayout);
        jPanelListaLayout.setHorizontalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );
        jPanelListaLayout.setVerticalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        jPanelOperacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Operações"));

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonVisualizar.setText("Visualiizar");
        jButtonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOperacoesLayout = new javax.swing.GroupLayout(jPanelOperacoes);
        jPanelOperacoes.setLayout(jPanelOperacoesLayout);
        jPanelOperacoesLayout.setHorizontalGroup(
            jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
            .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelOperacoesLayout.setVerticalGroup(
            jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                .addComponent(jButtonCadastrar)
                .addGap(2, 2, 2)
                .addComponent(jButtonEditar)
                .addGap(2, 2, 2)
                .addComponent(jButtonExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVisualizar))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelOperacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelOperacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        try {
            FrameCadastroCrianca telaCadastro = new FrameCadastroCrianca(serviceRpc, serviceTurma, serviceCrianca);
            FramePrincipal.adicionaTela(telaCadastro, false);
        } catch (ParseException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        try {
            if (jListaCrianca.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(null, "Selecione uma criança!");
            }else{
                FrameCadastroCrianca telaCadastro = new FrameCadastroCrianca(serviceRpc, serviceTurma, serviceCrianca);
                telaCadastro.setCrianca((Crianca) jListaCrianca.getSelectedValue());
                FramePrincipal.adicionaTela(telaCadastro, false);
            }            
        } catch (ParseException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            if (jListaCrianca.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(null, "Selecione uma criança!");
            } else {
                serviceCrianca.deletar((Crianca) jListaCrianca.getSelectedValue());
                AtualizarLista();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        AtualizarLista();
    }//GEN-LAST:event_formInternalFrameActivated

    private void jButtonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarActionPerformed
        if (jListaCrianca.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma criança!");
        }else{
            FrameInformacoesDetalhadasCrianca telaInformacoes = new FrameInformacoesDetalhadasCrianca();
            telaInformacoes.setCrianca((Crianca) jListaCrianca.getSelectedValue());
            FramePrincipal.adicionaTela(telaInformacoes, false);
        }
        
    }//GEN-LAST:event_jButtonVisualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonVisualizar;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JList jListaCrianca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JPanel jPanelOperacoes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
