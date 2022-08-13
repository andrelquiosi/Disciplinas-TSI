/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula01;

/**
 *
 * @author André Luis Quiosi, TSI - UTFPR
 */
public class Calculadora extends javax.swing.JFrame {

    Double valor1, valor2;
    String sinal;

    /**
     * Creates new form NewJFrame
     */
    public Calculadora() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btn_sete = new javax.swing.JButton();
        btn_oito = new javax.swing.JButton();
        btn_nove = new javax.swing.JButton();
        btn_quatro = new javax.swing.JButton();
        btn_cinco = new javax.swing.JButton();
        btn_seis = new javax.swing.JButton();
        btn_um = new javax.swing.JButton();
        btn_dois = new javax.swing.JButton();
        btn_tres = new javax.swing.JButton();
        btn_zero = new javax.swing.JButton();
        btn_divisao = new javax.swing.JButton();
        btn_multiplicacao = new javax.swing.JButton();
        btn_menos = new javax.swing.JButton();
        btn_mais = new javax.swing.JButton();
        btn_igual = new javax.swing.JButton();
        txf_resultado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_ce = new javax.swing.JButton();
        btn_c = new javax.swing.JButton();
        btn_ponto = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");

        btn_sete.setText("7");
        btn_sete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seteActionPerformed(evt);
            }
        });

        btn_oito.setText("8");
        btn_oito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_oitoActionPerformed(evt);
            }
        });

        btn_nove.setText("9");
        btn_nove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_noveActionPerformed(evt);
            }
        });

        btn_quatro.setText("4");
        btn_quatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quatroActionPerformed(evt);
            }
        });

        btn_cinco.setText("5");
        btn_cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cincoActionPerformed(evt);
            }
        });

        btn_seis.setText("6");
        btn_seis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seisActionPerformed(evt);
            }
        });

        btn_um.setText("1");
        btn_um.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_umActionPerformed(evt);
            }
        });

        btn_dois.setText("2");
        btn_dois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doisActionPerformed(evt);
            }
        });

        btn_tres.setText("3");
        btn_tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tresActionPerformed(evt);
            }
        });

        btn_zero.setText("0");
        btn_zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_zeroActionPerformed(evt);
            }
        });

        btn_divisao.setText("/");
        btn_divisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_divisaoActionPerformed(evt);
            }
        });

        btn_multiplicacao.setText("*");
        btn_multiplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_multiplicacaoActionPerformed(evt);
            }
        });

        btn_menos.setText("-");
        btn_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menosActionPerformed(evt);
            }
        });

        btn_mais.setText("+");
        btn_mais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maisActionPerformed(evt);
            }
        });

        btn_igual.setText("=");
        btn_igual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_igualActionPerformed(evt);
            }
        });

        jLabel1.setText("Calculadora TSI");

        btn_ce.setText("CE");
        btn_ce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ceActionPerformed(evt);
            }
        });

        btn_c.setText("C");
        btn_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cActionPerformed(evt);
            }
        });

        btn_ponto.setText(".");
        btn_ponto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txf_resultado)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_quatro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_cinco)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_seis))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_sete)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_oito)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_nove)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_um)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_dois)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_tres))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_zero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ponto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_igual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_multiplicacao, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(btn_divisao, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(btn_menos, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(btn_mais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sete)
                            .addComponent(btn_oito)
                            .addComponent(btn_nove))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_quatro)
                            .addComponent(btn_cinco)
                            .addComponent(btn_seis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_um)
                            .addComponent(btn_dois)
                            .addComponent(btn_tres))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_zero)
                            .addComponent(btn_ponto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_divisao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_multiplicacao))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_ce)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_c)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_menos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_mais))
                            .addComponent(btn_igual, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seteActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "7");   // TODO add your handling code here:
    }//GEN-LAST:event_btn_seteActionPerformed

    private void btn_doisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doisActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "2");    // TODO add your handling code here:
    }//GEN-LAST:event_btn_doisActionPerformed

    private void btn_cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cincoActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "5");   // TODO add your handling code here:
    }//GEN-LAST:event_btn_cincoActionPerformed

    private void btn_menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menosActionPerformed
        valor1 = Double.parseDouble(txf_resultado.getText());
        txf_resultado.setText("");
        sinal = "menos";   // TODO add your handling code here:
    }//GEN-LAST:event_btn_menosActionPerformed

    private void btn_zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_zeroActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "0");        // TODO add your handling code here:
    }//GEN-LAST:event_btn_zeroActionPerformed

    private void btn_noveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_noveActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "9");    // TODO add your handling code here:
    }//GEN-LAST:event_btn_noveActionPerformed

    private void btn_divisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_divisaoActionPerformed
        valor1 = Double.parseDouble(txf_resultado.getText());
        txf_resultado.setText("");
        sinal = "divisao";          // TODO add your handling code here:
    }//GEN-LAST:event_btn_divisaoActionPerformed

    private void btn_multiplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_multiplicacaoActionPerformed
        valor1 = Double.parseDouble(txf_resultado.getText());
        txf_resultado.setText("");
        sinal = "multiplicacao";          // TODO add your handling code here:
    }//GEN-LAST:event_btn_multiplicacaoActionPerformed

    private void btn_oitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oitoActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "8");          // TODO add your handling code here:
    }//GEN-LAST:event_btn_oitoActionPerformed

    private void btn_quatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quatroActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "4");          // TODO add your handling code here:
    }//GEN-LAST:event_btn_quatroActionPerformed

    private void btn_seisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seisActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "6");          // TODO add your handling code here:
    }//GEN-LAST:event_btn_seisActionPerformed

    private void btn_umActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_umActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "1");          // TODO add your handling code here:
    }//GEN-LAST:event_btn_umActionPerformed

    private void btn_tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tresActionPerformed
        txf_resultado.setText(txf_resultado.getText() + "3");          // TODO add your handling code here:
    }//GEN-LAST:event_btn_tresActionPerformed

    private void btn_igualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_igualActionPerformed
        // TODO add your handling code here:
        valor2 = Double.parseDouble(txf_resultado.getText());

        if (sinal == "soma") {
            txf_resultado.setText(String.valueOf(valor1 + valor2));
        }
        if (sinal == "menos") {
            txf_resultado.setText(String.valueOf(valor1 - valor2));
        }
        if (sinal == "multiplicacao") {
            txf_resultado.setText(String.valueOf(valor1 * valor2));
        }
        if (sinal == "divisao") {
            txf_resultado.setText(String.valueOf(valor1 / valor2));
        }
    }//GEN-LAST:event_btn_igualActionPerformed

    private void btn_maisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_maisActionPerformed
        valor1 = Double.parseDouble(txf_resultado.getText());
        txf_resultado.setText("");
        sinal = "soma";

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_maisActionPerformed

    private void btn_pontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pontoActionPerformed
        txf_resultado.setText(txf_resultado.getText() + ".");          // TODO add your handling code here:
    }//GEN-LAST:event_btn_pontoActionPerformed

    private void btn_ceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ceActionPerformed
        txf_resultado.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ceActionPerformed

    private void btn_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cActionPerformed
        valor1 = null;
        valor2 = null;
        txf_resultado.setText("");
    }//GEN-LAST:event_btn_cActionPerformed

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
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_c;
    private javax.swing.JButton btn_ce;
    private javax.swing.JButton btn_cinco;
    private javax.swing.JButton btn_divisao;
    private javax.swing.JButton btn_dois;
    private javax.swing.JButton btn_igual;
    private javax.swing.JButton btn_mais;
    private javax.swing.JButton btn_menos;
    private javax.swing.JButton btn_multiplicacao;
    private javax.swing.JButton btn_nove;
    private javax.swing.JButton btn_oito;
    private javax.swing.JButton btn_ponto;
    private javax.swing.JButton btn_quatro;
    private javax.swing.JButton btn_seis;
    private javax.swing.JButton btn_sete;
    private javax.swing.JButton btn_tres;
    private javax.swing.JButton btn_um;
    private javax.swing.JButton btn_zero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txf_resultado;
    // End of variables declaration//GEN-END:variables
}
