/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.PessoaDAO;
import java.sql.SQLException;
import java.util.List;
import modelo.Pessoa;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PessoaForm extends javax.swing.JFrame {

    private PessoaDAO pessoaDao = new PessoaDAO();
    private List<Pessoa> pessoas;
    private Pessoa pessoaSelecionada;

    public PessoaForm() {
        initComponents();
        atualizarTabela();

        atualizarBotao(true);
        habilitarFormulario(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txf_Cep = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txf_bairro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txf_numero = new javax.swing.JTextField();
        btn_cadastrar = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_Salvar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Pessoa = new javax.swing.JTable();
        txf_Descricao = new javax.swing.JTextField();
        txf_Pesquisa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_Pesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Descri????o");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel2.setText("CEP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));
        getContentPane().add(txf_Cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 135, -1));

        jLabel3.setText("Bairro");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));
        getContentPane().add(txf_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 126, -1));

        jLabel4.setText("N??mero");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        txf_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_numeroActionPerformed(evt);
            }
        });
        getContentPane().add(txf_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 83, -1));

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        btn_Excluir.setText("Excluir");
        btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        btn_alterar.setText("Alterar");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        btn_Salvar.setText("Salvar");
        btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, -1, -1));

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));

        tabela_Pessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descri????o", "CEP", "Bairro", "N??mero"
            }
        ));
        jScrollPane1.setViewportView(tabela_Pessoa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 420, 110));
        getContentPane().add(txf_Descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 176, -1));
        getContentPane().add(txf_Pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 240, -1));

        jLabel5.setText("Texto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        btn_Pesquisar.setText("Pesquisar");
        btn_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Pesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        atualizarBotao(false);
        habilitarFormulario(true);
        txf_Descricao.requestFocus();
        pessoaSelecionada = null;


    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void habilitarFormulario(boolean status) {
        txf_Descricao.setEnabled(status);
        txf_Cep.setEnabled(status);
        txf_bairro.setEnabled(status);
        txf_numero.setEnabled(status);
    }

    private void atualizarBotao(boolean status) {
        btn_alterar.setEnabled(status);
        btn_Excluir.setEnabled(status);
        btn_Pesquisar.setEnabled(status);
        btn_cadastrar.setEnabled(status);
        btn_Cancelar.setEnabled(!status);
        btn_Salvar.setEnabled(!status);
    }

    private void atualizarTabela() {
        try {
            pessoas = pessoaDao.buscarPelaDescricao(txf_Pesquisa.getText());
            DefaultTableModel model = (DefaultTableModel) tabela_Pessoa.getModel();
            model.setNumRows(0);

            for (int i = 0; i < pessoas.size(); i++) {
                Pessoa pessoa = pessoas.get(i);
                model.addRow(new Object[]{pessoa.getDescricao(), pessoa.getCep(), pessoa.getBairro(), pessoa.getNumero(),});

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    private void txf_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_numeroActionPerformed

    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed

        int linha = tabela_Pessoa.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma pessoa", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }

        pessoaSelecionada = pessoas.get(linha);
        try {
            pessoaDao.remover(pessoaSelecionada.getCodigo());
            JOptionPane.showMessageDialog(null, "Pessoa excluida");
            atualizarTabela();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_btn_ExcluirActionPerformed

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        int linha = tabela_Pessoa.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma pessoa para altera????o", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        atualizarBotao(false);
        habilitarFormulario(true);

        pessoaSelecionada = pessoas.get(linha);
        txf_Descricao.setText(pessoaSelecionada.getDescricao());
        txf_bairro.setText(pessoaSelecionada.getBairro());

        txf_numero.setText(Integer.toString(pessoaSelecionada.getNumero()));
        txf_Cep.setText(pessoaSelecionada.getCep());


    }//GEN-LAST:event_btn_alterarActionPerformed

    private void btn_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarActionPerformed
        atualizarBotao(true);
        habilitarFormulario(false);
        
        String descricao = txf_Descricao.getText();
        String cep = txf_Cep.getText();
        String bairro = txf_bairro.getText();

        int numero = 0;

        try {
            numero = Integer.parseInt(txf_numero.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe um numero ", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (numero == 0) {
            JOptionPane.showMessageDialog(null, "Informe um numero ", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (descricao.length() == 0) {
            JOptionPane.showMessageDialog(null, "Informe um numero ", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (bairro.length() == 0) {
            JOptionPane.showMessageDialog(null, "Informe um numero ", "Aten????o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (pessoaSelecionada == null) {
            Pessoa pessoa = new Pessoa(descricao, cep, bairro, numero);

            try {
                pessoaDao.adicionar(pessoa);
                JOptionPane.showMessageDialog(null, "Pessoa Cadastrada");
                txf_Descricao.setText("");
                txf_Cep.setText("");
                txf_bairro.setText("");
                txf_numero.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro na hora de inserir os dados", "Erro", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            pessoaSelecionada.setDescricao(descricao);
            pessoaSelecionada.setBairro(bairro);
            pessoaSelecionada.setCep(cep);
            pessoaSelecionada.setNumero(numero);

            try {
                pessoaDao.alterar(pessoaSelecionada);
                JOptionPane.showMessageDialog(null, "Pessoa alterada");
                atualizarTabela();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        pessoaSelecionada = null;
    }//GEN-LAST:event_btn_SalvarActionPerformed

    private void btn_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesquisarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btn_PesquisarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
                atualizarBotao(true);
        habilitarFormulario(false);
    }//GEN-LAST:event_btn_CancelarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Excluir;
    private javax.swing.JButton btn_Pesquisar;
    private javax.swing.JButton btn_Salvar;
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_Pessoa;
    private javax.swing.JTextField txf_Cep;
    private javax.swing.JTextField txf_Descricao;
    private javax.swing.JTextField txf_Pesquisa;
    private javax.swing.JTextField txf_bairro;
    private javax.swing.JTextField txf_numero;
    // End of variables declaration//GEN-END:variables
}
