/*
 * To change this license header, choose License Headers in Pr            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }ject Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Crianca.ICriancaService;
import Dominio.Features.RPC.IRpcService;
import Dominio.Features.RPC.Rpc;
import Dominio.Features.Turma.ITurmaService;
import Dominio.Features.Turma.Turma;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class FrameCadastroCrianca extends javax.swing.JInternalFrame {

    private IRpcService serviceRpc;
    private ITurmaService serviceTurma;
    private ICriancaService serviceCrianca;
    private Crianca novaCrianca;
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public Crianca getNovaCrianca() throws ParseException {
        novaCrianca.setNome(jTextNomeCrianca.getText());
        novaCrianca.setRG(jTextRg.getText());
        novaCrianca.setDataNascimento(df.parse((String) jTextDataNascimento.getValue()));
        novaCrianca.setResponsavelPelaCrianca((Rpc) jCmbRpc.getSelectedItem());
        novaCrianca.setTurma((Turma) jCmbTurma.getSelectedItem());
        return novaCrianca;
    }

    public void setNovaCrianca(Crianca crianca) {
        this.novaCrianca = crianca;
        jTextNomeCrianca.setText(crianca.getNome());
        jTextRg.setText(crianca.getRG());
        jTextDataNascimento.setText(df.format(crianca.getDataNascimento()));
        jTextDataNascimento.setValue(df.format(crianca.getDataNascimento()));
        jCmbRpc.setSelectedItem(crianca.getResponsavelPelaCrianca());
        jCmbTurma.setSelectedItem(crianca.getTurma());
    }

    public FrameCadastroCrianca(IRpcService serviceRpc, ITurmaService serviceTurma, ICriancaService serviceCrianca) throws ParseException, SQLException {
        this.serviceRpc = serviceRpc;
        this.serviceCrianca = serviceCrianca;
        this.serviceTurma = serviceTurma;
        initComponents();
        AtualizarComboBox();
    }

    public void AtualizarComboBox() {
        try {
            Vector<Rpc> listaRPC = new Vector<>(serviceRpc.pegarTodos());
            Vector<Turma> listaTurma = new Vector<>(serviceTurma.pegarTodas());
            DefaultComboBoxModel modeloTurma = new DefaultComboBoxModel(listaTurma);
            DefaultComboBoxModel modeloRpc = new DefaultComboBoxModel(listaRPC);
            jCmbRpc.setModel(modeloRpc);
            jCmbTurma.setModel(modeloTurma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextNomeCrianca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextDataNascimento = new javax.swing.JFormattedTextField();
        jTextRg = new javax.swing.JTextField();
        jCmbRpc = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCmbTurma = new javax.swing.JComboBox<>();
        jBSalvar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();

        setTitle("Cadastrar Criança");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastrar Criança");

        jLabel2.setText("Nome Completo:");

        jLabel3.setText("Dat.Nascimento:");

        jLabel4.setText("RG:");

        jTextDataNascimento.setFormatterFactory(new javax.swing.JFormattedTextField.AbstractFormatterFactory() {
            public javax.swing.JFormattedTextField.AbstractFormatter
            getFormatter(javax.swing.JFormattedTextField jf) {
                try{
                    return new javax.swing.text.MaskFormatter("##/##/####");
                } catch (ParseException pe){
                    pe.printStackTrace();
                }
                return null;
            }
        });

        jCmbRpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbRpcActionPerformed(evt);
            }
        });

        jLabel5.setText("RPC:");

        jLabel6.setText("Turma:");

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBcancelar.setText("Cancelar");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCmbRpc, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(378, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextRg, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBcancelar)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextNomeCrianca)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNomeCrianca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCmbRpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBSalvar)
                            .addComponent(jBcancelar)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbRpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbRpcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCmbRpcActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        try {
            if (novaCrianca == null) {
                novaCrianca = new Crianca();
                serviceCrianca.adicionar(getNovaCrianca());
            } else {
                serviceCrianca.atualizar(getNovaCrianca());
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso, nome: " + novaCrianca.getNome());
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jBSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JComboBox<String> jCmbRpc;
    private javax.swing.JComboBox<String> jCmbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField jTextDataNascimento;
    private javax.swing.JTextField jTextNomeCrianca;
    private javax.swing.JTextField jTextRg;
    // End of variables declaration//GEN-END:variables
}
